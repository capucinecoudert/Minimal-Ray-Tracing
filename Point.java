public class Point{
    // X coordinate of the point.
    public double x;
    //Y coordinate of the point.
    public double y;
    //Z coordinate of the point.
    public double z;

    /**
     * Creates an instance of this class with the specified coordinates.
     * @param x X cordinate of the point.
     * @param y Y cordinate of the point.
     * @param z Z cordinate of the point.
     */
    public Point(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point add(Vector v1){
        return new Point(this.x+v1.x, this.y+v1.y, this.z+v1.z);
    }

    public Point substract(Point v1){
        return new Point(this.x-v1.x, this.y-v1.y, this.z-v1.z);
    }

    public double distance(Point p) {
        return Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2) + Math.pow(z - p.z, 2));
    }

}