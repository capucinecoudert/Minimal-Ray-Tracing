
import java.util.ArrayList;
public class Scene {

    public int height;
    public int width;
    public ArrayList<Sphere> spheres;
    public ArrayList<Light> lights;

    public Scene(ArrayList<Sphere> s, int w, int h){
        spheres=s;
        lights=new ArrayList<Light>();
        height=h;
        width=w;

         // Left light
         lights.add(new Light(
            new Point(0.0, 200.0, -100.0),     // Origin
            new Color(2.0, 2.0, 2.0)           // Intensity
        ));

        // Light behind the camera
        lights.add(new Light(
            new Point(640.0, 240.0, -10000.0), // Origin
            new Color(0.4, 0.4, 0.5)           // Intensity
        ));
        
        // Light behind the white sphere.
        lights.add(new Light(
            new Point(640.0, 240.0, 100.0),   // Origin
            new Color(0.2, 0.2, 0.5)          // Intensity
        ));
    }
    
}
