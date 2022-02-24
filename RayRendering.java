import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class RayRendering {
    private static final int CAMERA_POSITION = -1000;
    public Scene scene;

    public static void main(String[] args) throws IOException  // ?? ici je dois recup les infos de l'interface, i.e, liste des spheres
    {
        Scene scene = new Scene(// mettre des array list la, 800, 600);
        createImage(scene);
    }



    public Color computeColor(){
        Color pixelColor;
        // ici on fait tout le calcul 



    }


    public static void createImage(Scene scene){ // j'ai trouvé ce bout de code pour créer une buffered img
        ColorInt[][] img= new ColorInt[scene.width][scene.height];




        BufferedImage image = new BufferedImage(scene.width, scene.height, BufferedImage.TYPE_INT_RGB); 
        for (int y = 0; y < scene.height; y++) {
           for (int x = 0; x < scene.width; x++) {
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
