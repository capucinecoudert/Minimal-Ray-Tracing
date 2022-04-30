
public class Plan {
    
    private final static double EPSILON = 0.00001;
    public  Point origin;
    public Vector normalVector;
    public Vector vX;
    public Vector vY;

    public Plan (Point origin, Vector vX, Vector vY){
        this.origin=origin;
        this.vX= vX;
        this.vY=vY;
        normalVector=vX.crossProduct(vY);
    }
    
    public Point intersectRayPlane(Ray ray){
        double denom = normalVector.dotProduct(ray.direction); 
        if (denom < EPSILON) { 
            return null;
        }else{
            Vector rayPlane = new Vector(origin, ray.origin); 
            double t = rayPlane.dotProduct(normalVector)/(denom); 
            Point p =  origin.add(rayPlane.add(ray.direction.multiply(t)));
        return p;
        }
    }
}
