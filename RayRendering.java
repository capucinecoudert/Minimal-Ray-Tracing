import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class RayRendering {
    public Scene scene;

    public RayRendering(Scene s){
        scene=s;
    }

    public ColorInt computeColor(Ray ray, Scene scene){
        Color pixelColor= new Color(0,0,0);
        double distance= Double.POSITIVE_INFINITY;
        Sphere object= null;
        

        // first compute if the ray hits a sphere
        do{
            for(Sphere s : scene.spheres){
                HitResult result= hitObject(ray, s, distance);
                if(result.hit && result.distance<distance){
                    object=s;
                    distance=result.distance;
                }
            }
            // if not exit
            if(object==null){
                pixelColor= new Color(0,0,0);
                break;
            }
        
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
        }while(object!=null);
        return pixelColor.colorToInt(); 
    }


    public HitResult hitObject(Ray ray, Sphere sphere, double distance){
        Vector l = new Vector(ray.origin, sphere.center);
        double lSize= l.norm();
        double tCA=  l.dotProduct(ray.direction);

        if (tCA < 0){
            return new HitResult(0, false);
        }
         
        double d = Math.sqrt(lSize*lSize - tCA*tCA);
        if (d<0){
            return new HitResult(0, false);
        }

        double tCH= Math.sqrt(d*d- sphere.radius*sphere.radius);
        double t0= tCA-tCH;
        double t1= tCA+tCH;

        if (t0 > 0.1 && t0 < distance) {
            return new HitResult(t0, true);
        }

        if (t1 > 0.1 && t1 < distance) {
            return new HitResult(t1, true);
        }

        return new HitResult(distance, false);
    }



    public  void createImage()throws IOException { 
        ColorInt[][] img= new ColorInt[scene.camera.resolutionY][scene.camera.resolutionX];

        // boucle dans laquelle tu calcules la couleur pour chaque rayon de la camera correspondant à un pixel

        Ray rayPixel;
        // ici on fait tout le calcul pour un Rayon, i.e. pixel
        for(int y = 0 ; y< scene.camera.resolutionY; y++){
            for(int x=0; x< scene.camera.resolutionX; x++){
                rayPixel= new Ray(scene.camera.originCamera, new Vector(scene.camera.originCamera, new Point(x,y, scene.camera.centreImg.z)));
                img[y][x] = computeColor(rayPixel, scene);
            }
        }

        // chaque couleur transformer en colorInt et add to img
        // transformes le array de couleur en un bmp file via BufferedImg
        BufferedImage image = new BufferedImage(scene.camera.resolutionY, scene.camera.resolutionX, BufferedImage.TYPE_INT_RGB); // j'ai trouvé ce bout de code pour créer une buffered img
        for (int y = 0; y < scene.camera.resolutionY; y++) {
           for (int x = 0; x < scene.camera.resolutionX ; x++) {
              int rgb = img[y][x].red;
              rgb = (rgb << 8) + img[y][x].green; 
              rgb = (rgb << 8) + img[y][x].blue;
              image.setRGB(y, x, rgb);
           }
        }
        File outputFile = new File("C:\\Users\\coude\\Documents\\output.bmp\\");
        ImageIO.write(image, "bmp", outputFile);
    }
    
}
