
public class Plan {
    private final static double EPSILON = 0.00001;
    Point origin;
    Vector normalVector;

    public Plan(Point origin, Vector normalVector){
        this.origin=origin;
        this.normalVector=normalVector;
    }
    
    public boolean intersectRayPlane(Ray ray){
        double denom = normalVector.dotProduct(ray.direction); 
        if (denom > EPSILON) { 
            Vector rayPlane = new Vector(origin, ray.origin); 
            double t = rayPlane.dotProduct(normalVector)/(denom); 
        return (t >= 0); 
    } 
    return false; 
    }
}
