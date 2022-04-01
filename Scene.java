
import java.util.ArrayList;
public class Scene {

    public Camera camera;
    public ArrayList<Sphere> spheres;
    public ArrayList<Light> lights;
    public ArrayList<Plan> planes;

    public Scene(ArrayList<Sphere> s, Camera c, ArrayList<Light> l, ArrayList<Plan> p){
        spheres=s;
        lights=l;
        camera=c;
        planes=p;
    }
    
}
