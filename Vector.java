public class Vector {
    // X component of the vector.
    public double x;
    // Y component of the vector.
    public double y;
    //Z coordinate of the point.
    public double z;

    /**
     * Creates an instance of this class with the specified coordinates.
     * @param x X coordinate of the point
     * @param y Y coordinate of the point
     * @param z Z coordinate of the point
     */
    public Vector(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Creates a vector with initial point at p1 and end point at p2
     * @param p1 Initial point of the vector.
     * @param p2 End point of the vector.
     */
    public Vector(Point p1, Point p2){
        this.x = p2.x - p1.x;
        this.y = p2.y - p1.y;
        this.z = p2.z - p1.z;
    }

    /**
     * @return norm of the vector.
     */
    public double norm(){
        return Math.sqrt(x * x + y * y + z * z);
    }

    /**
     * Normalizes the vector.
     */
    public void normalize(){
        double n = norm();
        if (n == 0) {
            throw new ArithmeticException("Can not normalize vector " + "since norm is 0.");
        }
        x /= n;
        y /= n;
        z /= n;
    }

    /**
     * Calculates the end point of vector v with initial point at p.
     * @param p Initial point of the vector.
     * @param v Vector.
     * @return End point of the vector.
     */
    public static Point add(Point p, Vector v){
        return new Point(p.x + v.x, p.y + v.y, p.z + v.z);
    }

    /**
     * Adds two vectors.
     * @param v1 A vector.
     * @param v2 Another vector.
     * @return Sum of the two vectors.
     */
    public static Vector add(Vector v1, Vector v2){
        return new Vector(v1.x + v2.x, v1.y + v2.y, v1.z + v2.z);
    }

    /**
     * Subtracts vector v2 from vector v1.
     * @param v1 A vector.
     * @param v2 Another vector.
     * @return Difference of the two vectors.
     */
    public static Vector subtract (Vector v1, Vector v2){
        return new Vector(v1.x - v2.x, v1.y - v2.y, v1.z - v2.z);
    }

    /**
     * Multiplies a vector v with a scalar c.
     * @param c A scalar.
     * @param v A vector.
     * @return The result of the vector multiplied with the scalar.
     */
    public static Vector multiply(double c, Vector v){
        return new Vector(c * v.x, c * v.y, c * v.z);
    }

    /**
     * Calculates the dot product of vectors v1 and v2.
     * @param v1 A vector.
     * @param v2 Another vector.
     * @return The dot product of the two vectors.
     */
    public static double dotProduct(Vector v1, Vector v2){
        return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z;
    }
}
