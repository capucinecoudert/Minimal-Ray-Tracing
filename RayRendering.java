import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class RayRendering {
    public Scene scene;
    public Camera camera;

    public static void main(String[] args) throws IOException  // ?? ici je dois recup les infos de l'interface, i.e, liste des spheres
    {
        //Scene scene = new Scene(mettre array list des spheres, 800, 600);
        //createImage(scene);
    }



    public Color computeColor(Ray ray, Scene scene){
        Color pixelColor;
        

    }

    public Ray 

    public static void createImage(Scene scene){ 
        ColorInt[][] img= new ColorInt[scene.camera.resolutionX][scene.camera.resolutionY];

        // boucle dans laquelle tu calcules la couleur pour chaque rayon de la camera correspondant à un pixel

        Ray rayPixel;
        // ici on fait tout le calcul pour un Rayon, i.e. pixel
        for(int y = 0 ; y<= scene.camera.resolutionY; y++){
            for(int x=0; x<= scene.camera.resolutionX; x++){


                rayPixel= new Ray(scene.camera.originCamera, new Vector(scene.camera.originCamera, new Point(x,y, scene.camera.centreImg.z));
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
