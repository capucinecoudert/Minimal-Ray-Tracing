import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.util.*;
import javax.imageio.ImageIO;

public class RayRendering {
    public Scene scene;
    public Camera camera;

    public static void main(String[] args) throws IOException  // ?? ici je dois recup les infos de l'interface, i.e, liste des spheres
    {
        //Scene scene = new Scene(mettre array list des spheres, 800, 600);
        //createImage(scene);
    }


    public ColorInt computeColor(Ray ray, Scene scene){
        Color pixelColor= new Color(0,0,0);
        double distance= Double.POSITIVE_INFINITY;
        Sphere object= null;

        // first compute if the ray hits a sphere
        
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
            double facingRatio= lightRay.direction.dotProduct(normalVector);

        }
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



    public  void createImage(Scene scene){ 
        ColorInt[][] img= new ColorInt[scene.camera.resolutionX][scene.camera.resolutionY];

        // boucle dans laquelle tu calcules la couleur pour chaque rayon de la camera correspondant à un pixel

        Ray rayPixel;
        // ici on fait tout le calcul pour un Rayon, i.e. pixel
        for(int y = 0 ; y<= scene.camera.resolutionY; y++){
            for(int x=0; x<= scene.camera.resolutionX; x++){
                rayPixel= new Ray(scene.camera.originCamera, new Vector(scene.camera.originCamera, new Point(x,y, scene.camera.centreImg.z));
                img[x][y] = computeColor(rayPixel, scene);
            }
        }

        // chaque couleur transformer en colorInt et add to img
        // transformes le array de couleur en un bmp file via BufferedImg
        BufferedImage image = new BufferedImage(scene.camera.resolutionX, scene.camera.resolutionY, BufferedImage.TYPE_INT_RGB); // j'ai trouvé ce bout de code pour créer une buffered img
        for (int y = 0; y < scene.camera.resolutionY; y++) {
           for (int x = 0; x < scene.camera.resolutionX; x++) {
              int rgb = img[y][x].red;
              rgb = (rgb << 8) + img[y][x].green; 
              rgb = (rgb << 8) + img[y][x].blue;
              image.setRGB(x, y, rgb);
           }
        }
        File outputFile = new File("/output.bmp");
        ImageIO.write(image, "bmp", outputFile);
    }
    
}
