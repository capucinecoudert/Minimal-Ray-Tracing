import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.JButton;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;

public class InterfaceBasic extends JFrame implements ActionListener {

    JButton b ;
    JLabel image;

    public InterfaceBasic(){
        super("Minimal Ray Tracing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1050, 1000);
        this.setLayout(null);

        this.b= new JButton("START");
        this.b.setBounds(20, 20, 200, 50);
        this.b.addActionListener(this);
        this.add(this.b);

        this.image = new JLabel();
        this.image.setBounds(20, 100, 800, 600);
        this.add(this.image);


        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        try { 
            launchRayRendering();

            BufferedImage myPicture = ImageIO.read(new File("C:\\Users\\coude\\Documents\\output.bmp\\"));
            ImageIcon imgIc = new ImageIcon(myPicture);
            this.image.setIcon(imgIc);
        } catch (IOException a) {
            a.printStackTrace();
        }
    }

    public static void launchRayRendering() throws IOException{
        // 1 sphère blanche
        ArrayList<Sphere> spheres = new ArrayList<Sphere>();

        Material white= new Material(0.0, 1.0, new ColorFloat(0.98, 0.45, 0.46) );
        Material red= new Material(0.5, 0.5, new ColorFloat(1.0, 0, 0) );
        Material metal = new Material(1.0, 0.0, new ColorFloat(1.0, 0, 0) );

        spheres.add(new Sphere(new Point(0, 0, 500.0), 100.0, white ));
        spheres.add(new Sphere(new Point(150, 0, 400.0), 30.0, red ));
        spheres.add(new Sphere(new Point(100, -100, 400.0), 40.0, metal ));
        
        // la lumière
        ArrayList<Light> lights= new ArrayList<Light>();
        // Light behind the camera
        lights.add(new Light(new Point(250, 0, 300), new ColorFloat(0.4, 0.4, 0))); // lumiere cote droit jaune
        lights.add(new Light(new Point(0, 200, 0), new ColorFloat(0.6, 0.6, 0.6))); // lumiere face grise
         
    
        // créer la caméra
        Point pointOrigin= new Point(0,0,0);
        int distanceFocale= 100;
        Vector vX= new Vector(new Point(0, 0, 0), new Point(80, 0, 0));
        int rX= 800;
        Vector vY= new Vector(new Point(0, 0, 0), new Point(0, 60, 0));
        int rY= 600;
        Camera cam = new Camera(pointOrigin, distanceFocale, vX, rX, vY, rY);

        Scene scene = new Scene(spheres, cam , lights);
        RayRendering r = new RayRendering(scene);

        r.createImage();
    }


    
}
