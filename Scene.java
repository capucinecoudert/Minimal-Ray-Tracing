
import java.util.ArrayList;
public class Scene {

    public Camera camera;
    public ArrayList<Sphere> spheres;
    public ArrayList<Light> lights;

    public Scene(ArrayList<Sphere> s, Camera c, ArrayList<Light> l){
        spheres=s;
        lights=l;
        camera=c;
    }
    
}
