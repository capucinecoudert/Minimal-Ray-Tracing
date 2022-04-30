import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.lang.System;

public class RayRendering {
    // Creates an object RayRendering containing a scene and the limit number of reflection of a ray.
    
    public Scene scene;
    public int maxReflectionGeneration = 10; // defining the maximum number of times a ray can be reflected 

    public RayRendering(Scene s){
        this.scene=s;
    }

    //this method returns the color of the pixel if the given ray hits an object of the sphere
    public ColorFloat intersectRay(Ray ray, Scene scene, int generation){
        ColorFloat backgroundColor= new ColorFloat(0,0,0);
        double distance= Double.POSITIVE_INFINITY;
        Sphere object= null;
        
        // Computes if the ray hits a sphere of the scene
        for(Sphere s : scene.spheres){
            HitResult result= hitObject(ray, s);
            if(result.hit && result.distance<distance){ // if yes, returns the color of the pixel
                object=s;
                distance=result.distance;
                backgroundColor=computeColor(ray, object, scene, distance, generation);
            }
        }
        return backgroundColor;
    }

    //this method compute the color of the pixel for a given ray and  the nearest sphere it hits
    public ColorFloat computeColor(Ray ray, Sphere sphere, Scene scene, double distance, int generation){
        ColorFloat pixelColor= new ColorFloat(0,0,0);
        // Compute the point where the ray intersected the object.
        Point intersectPoint= ray.origin.add(ray.direction.multiply(distance));
        // Calculate a vector normal to the surface of the object at the point of intersection of the ray and the object.
        Vector normalVector = new Vector(sphere.center, intersectPoint);
        // Normalize the normal vector.
        normalVector.normalize();

        for(Light l : scene.lights){
            // Creates the light ray between the point of intersection on the sphere and the origin of the light 
            Ray lightRay= new Ray(intersectPoint, new Vector(intersectPoint, l.origin));
            //normalizes the light ray
            lightRay.direction.normalize();
            boolean hidden=false;

            // Checks that the lightRay doesn't hit nearer spheres
            for(Sphere s : scene.spheres){
                HitResult obstacle =  hitObject(lightRay, s);
                if(obstacle.hit){
                    hidden=true;
                }
            }

            // if the light ray hits this sphere first, then it computes the color of the pixel 
            if(hidden==false){
                // Manages the diffusion of the material
                double facingRatio= Math.max(0,lightRay.direction.dotProduct(normalVector));
                ColorFloat facingColor =sphere.material.diffusionColor.multiply(facingRatio).multiply(sphere.material.specularPower);
                ColorFloat lightedColor = facingColor.multiply(l.intensity);
                ColorFloat reflectedColor = new ColorFloat(0,0,0);

                // Manages the reflection between the spheres  
                if( generation <= maxReflectionGeneration && sphere.material.reflectionCoeff >0){
                    double lambda = -2*normalVector.dotProduct(ray.direction);
                    Vector reflectedVector = normalVector.multiply(lambda).add(ray.direction);
                    Ray reflectedRay = new Ray(intersectPoint, reflectedVector);
                    reflectedColor= intersectRay(reflectedRay, scene, generation+1);
                }
                pixelColor = pixelColor.add(lightedColor).add(reflectedColor.multiply(sphere.material.reflectionCoeff));
            } 
        }
        return pixelColor; // returns the color of the pixel of the img
    }

    // Check if the given ray hits or not the given sphere
    public HitResult hitObject(Ray ray, Sphere sphere){
        Vector l = new Vector(ray.origin, sphere.center);
        double tCA =  l.dotProduct(ray.direction);
        double dl= l.norm();
        if (tCA < 0){
            return new HitResult(0, false);
        }
        double d = ray.distancePoint(sphere.center);
        if (d> sphere.radius){
            return new HitResult(0, false);
        }
        double a =  Math.sqrt(sphere.radius*sphere.radius - d*d);
        double c =  Math.sqrt(dl*dl - d*d);
        return new HitResult(c-a, true);
    }

    // Creates the final image as a BMP file
    public  void createImage()throws IOException { 
        ColorInt[][] img= new ColorInt[scene.camera.resolutionX][scene.camera.resolutionY];
        ColorFloat pixelColor;
        Ray rayPixel;

        // this loop computes for each point(x,y) on the plane of the image, the color of this pixel
        for(int y = 0 ; y< scene.camera.resolutionY; y++){
            for(int x=0; x< scene.camera.resolutionX; x++){
                rayPixel= scene.camera.getRay(x,y); //the ray between this pixel and the origin of the camera 
                pixelColor=intersectRay(rayPixel, scene, 0) ; //finds the color of the pixel 
                img[x][y] = pixelColor.colorToInt(); // add this color as a ColorInt to the img[][] array
            }
        }

        // this loop transforms the img[][] to a BMP file
        BufferedImage image = new BufferedImage(scene.camera.resolutionX, scene.camera.resolutionY, BufferedImage.TYPE_INT_RGB); // j'ai trouvé ce bout de code pour créer une buffered img
        for (int y = 0; y < scene.camera.resolutionY; y++) {
           for (int x = 0; x < scene.camera.resolutionX ; x++) {
              int rgb = img[x][y].red;
              rgb = (rgb << 8) + img[x][y].green; 
              rgb = (rgb << 8) + img[x][y].blue;
              image.setRGB(x, scene.camera.resolutionY -1 -y, rgb);
           }
        }
        String path =System.getProperty("user.dir") +"\\output.bmp";
        File outputFile = new File(path); // here, we can write the path we want
        ImageIO.write(image, "bmp", outputFile);
    }   
}