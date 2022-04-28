public class Vector {
    public double x;
    public double y;
    public double z;

    /*
        Creates an instance of this class with the specified coordinates.
        X coordinate of the point
        Y coordinate of the point
        Z coordinate of the point
    */

    public Vector(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    //Creates a vector with initial point at p1 and end point at p2
    public Vector(Point p1, Point p2){
        this.x = p2.x - p1.x;
        this.y = p2.y - p1.y;
        this.z = p2.z - p1.z;
    }

    //Returns the norm of the vector.  
    public double norm(){
        return Math.sqrt(x * x + y * y + z * z);
    }

    // Normalizes the vector.
    public void normalize(){
        double n = norm();
        if (n == 0) {
            throw new ArithmeticException("Can not normalize vector " + "since norm is 0.");
        }
        x /= n;
        y /= n;
        z /= n;
    }

    //Calculates the end point of vector v with initial point at p.
    public Point add(Point p){
        return new Point(p.x + this.x, p.y + this.y, p.z + this.z);
    }

    //Adds two vectors.
    public  Vector add(Vector v2){
        return new Vector(this.x + v2.x, this.y + v2.y, this.z + v2.z);
    }

    //Subtracts vector v2 from vector v1.
    public Vector subtract ( Vector v2){
        return new Vector(this.x - v2.x, this.y - v2.y, this.z - v2.z);
    }

    //Multiplies a vector v with a scalar c.
    public Vector multiply(double c){
        return new Vector(c * this.x, c * this.y, c * this.z);
    }

    //Divides a vector by a scalar c.
    public Vector divide(double c){
        return new Vector( this.x/c , this.y/c , this.z/c );
    }

    //Calculates the dot product of vectors v1 and v2.
    public double dotProduct( Vector v2){
        return this.x * v2.x + this.y * v2.y + this.z * v2.z;
    }

    //Calculates the cross product of vectors v1 and v2.
    public Vector crossProduct( Vector v2){
        double x=  this.y*v2.z- this.z*v2.y;
        double y= this.z*v2.x- this.x*v2.z;
        double z= this.x*v2.y- this.y*v2.x;
        return new Vector(x, y,z );
    }
}
