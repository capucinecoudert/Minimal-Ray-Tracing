public class Ray {

    public Point origin;
    public Vector direction;

    public Ray(Point p, Vector v){
        origin=p;
        direction=v;
    }
    
    public double distancePoint(Point p){
        Vector v= new Vector(origin, p);
        Vector crossP = v.crossProduct(direction);

        return crossP.norm()/direction.norm();
    }
}
