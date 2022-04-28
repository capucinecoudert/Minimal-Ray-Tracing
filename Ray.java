public class Ray {
    //Defines a ray as an object with a point of origin and a vector of direction.
    public Point origin;
    public Vector direction;

    public Ray(Point p, Vector v){
        this.origin=p;
        this.direction=v;
    }

    // Returns the distance between a point p and the origin of the ray.
    public double distancePoint(Point p){
        Vector v= new Vector(origin, p);
        Vector crossP = v.crossProduct(direction);

        return crossP.norm()/direction.norm();
    }
}
