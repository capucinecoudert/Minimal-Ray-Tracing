public class Sphere extends Hitable {
    
    public Point center;
    public double radius;
    public Material material;

    public Sphere(Point c, double r, Material m){
        center=c;
        radius=r;
        material=m;
    }
    
}
