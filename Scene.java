
import java.util.ArrayList;
// a scene is defined by its camera, the spheres and lights it contains
public class Scene {

    public Camera camera;
    public ArrayList<Sphere> spheres; 
    public ArrayList<Light> lights;

    public Scene(ArrayList<Sphere> s, Camera c, ArrayList<Light> l ){
        this.spheres=s;
        this.lights=l;
        this.camera=c;
    }
}
