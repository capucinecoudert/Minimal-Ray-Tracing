public class HitResult {
    /*
        Defines an element having a distance and a boolean.
        This class is used to know if a ray has hitten a sphere or not
        if yes, HitResult contains the distance between the point of intersection and the origin of the ray and the boolean true
        if no,  HitResult contains the distance null and the boolean false
    */
    double distance;
    boolean hit;

    public HitResult(double d, boolean h){
        this.distance=d;
        this.hit=h;
    }
}
