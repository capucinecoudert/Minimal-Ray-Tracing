import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class RayRendering {
    public Scene scene;

    public RayRendering(Scene s){
        scene=s;
    }

    public Color intersectRay(Ray ray, Scene scene){
        Color pixelColor= new Color(1,0.2,0.5);
        double distance= Double.POSITIVE_INFINITY;
        Sphere object= null;
        

        // first compute if the ray hits a sphere
            for(Sphere s : scene.spheres){
                HitResult result= hitObject(ray, s);
                if(result.hit && result.distance<distance){
                    object=s;
                    distance=result.distance;
                }
            }
            // if not exit
            if(object==null){
                return new Color(0,0,0);
            }else{
                return object.material.specularColor;
            }
        /*
            // Compute the point where the ray intersected the object.
            Point intersectPoint= ray.origin.add(ray.direction.multiply(distance));

            // Calculate a vector normal to the surface of the object at the point of intersection of the ray and the object.
            Vector normalVector = new Vector(object.center, intersectPoint);

            // Normalize the normal vector.
            normalVector.normalize();
    
            // PB d'ombre ect :  // Lambertian coeffecient // Blinn-Phong specular term

            for(Light l : scene.lights){
                Ray lightRay= new Ray(intersectPoint, new Vector(intersectPoint, l.origin));
                double lightDistance= lightRay.direction.norm();
                boolean hidden=false;

                // je verifie que la lumière ne rencontre pas d'autres sphères avant
                for( Sphere s : scene.spheres){
                    HitResult obstacle = hitObject(lightRay, s, lightDistance);
                    if(obstacle.hit){
                        hidden=true;
                    }
                }
                // si ma lumière rencontre cette sphère en premier 
                if(hidden==false){
                    //double facingRatio= lightRay.direction.dotProduct(normalVector);
                    pixelColor= new Color(1, 1, 1);

                } 
            }
        return pixelColor; 
        */
    }


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



    public  void createImage()throws IOException { 
        ColorInt[][] img= new ColorInt[scene.camera.resolutionX][scene.camera.resolutionY];
        // boucle dans laquelle tu calcules la couleur pour chaque rayon de la camera correspondant à un pixel
        Color pixelColor;
        Ray rayPixel;

        // ici on fait tout le calcul pour un Rayon, i.e. pixel
        for(int y = 0 ; y< scene.camera.resolutionY; y++){
            for(int x=0; x< scene.camera.resolutionX; x++){
                rayPixel= scene.camera.getRay(x,y);
                pixelColor=intersectRay(rayPixel, scene) ; 
                img[x][y] = pixelColor.colorToInt();
            }
        }

        // chaque couleur transformer en colorInt et add to img
        // transformes le array de couleur en un bmp file via BufferedImg
        BufferedImage image = new BufferedImage(scene.camera.resolutionX, scene.camera.resolutionY, BufferedImage.TYPE_INT_RGB); // j'ai trouvé ce bout de code pour créer une buffered img
        for (int y = 0; y < scene.camera.resolutionY; y++) {
           for (int x = 0; x < scene.camera.resolutionX ; x++) {
              int rgb = img[x][y].red;
              rgb = (rgb << 8) + img[x][y].green; 
              rgb = (rgb << 8) + img[x][y].blue;
              image.setRGB(x, y, rgb);
           }
        }
        File outputFile = new File("C:\\Users\\coude\\Documents\\output.bmp\\");
        ImageIO.write(image, "bmp", outputFile);
    }
    
}
