import java.io.IOException;
import java.util.*;
 class Main {
    
    public static void main(String[] args) throws IOException {
        // 1 sphère blanche
        ArrayList<Sphere> spheres = new ArrayList<Sphere>();

        Material white= new Material(1.0, 60, new Color(1.0, 1.0, 1.0),new Color(1.0, 1.0, 1.0) );
        Material red= new Material(1.0, 60, new Color(1.0, 0, 0),new Color(1.0, 0, 0) );
        
        spheres.add(new Sphere(new Point(0, 0, 500.0), 100.0, white ));
        spheres.add(new Sphere(new Point(150, 0, 400.0), 30.0, red ));
        // la lumière
        ArrayList<Light> lights= new ArrayList<Light>();
        // Light behind the camera
        lights.add(new Light(new Point(640.0, 240.0, -10000.0), new Color(0.4, 0.4, 0.5)));

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

        // lancer fenetre interface
        //Scene scene = new Scene(mettre array list des spheres, 800, 600);
        //ray rendering (sphere ...)
        //createImage(scene);
    }
    
}
