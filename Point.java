public class Point{
    // X coordinate of the point.
    public double x;
    //Y coordinate of the point.
    public double y;
    //Z coordinate of the point.
    public double z;

    // Creates an instance of this class with the specified coordinates.

    public Point(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Adds a vector to a point and returns a new point.
    public Point add(Vector v1){
        return new Point(this.x+v1.x, this.y+v1.y, this.z+v1.z);
    }

    // Substracts a point v1 to a point and returns a new point.
    public Point substract(Point v1){
        return new Point(this.x-v1.x, this.y-v1.y, this.z-v1.z);
    }

    // Returns the distance between the point p and the point.
    public double distance(Point p) {
        return Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2) + Math.pow(z - p.z, 2));
    }

}