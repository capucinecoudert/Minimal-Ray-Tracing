public class Camera {

    /*a camera takes as parameters : 
     - a point which is the center of the image that the camera is forming
     - an integer which is the focal distance
     - 2 vectors extentX and extentY which are defining the plane of the image, the norms of those vectors are defining the size of the final image
     - 2 int resolutionX and resolutionY which are the resolution of each side of the plane of the image 
     - the origin of the camera which is defined as the point situed at the focal distance from the normal of the plane of the image

     Example : the norm of the vector vX is 100 but its resolution is 800, same thing for Vy
     then the image form will have a width and height of 100 but containing 640000 pixels.

    */

    public int resolutionX;
    public int resolutionY;
    public int focalDistance;
    public Point centreImg;
    public Point originCamera;
    public Vector extentX;
    public Vector extentY;



    public Camera(Point c, int d, Vector vX, int rX, Vector vY, int rY){ 
        this.focalDistance=d;
        this.centreImg=c;
        this.resolutionX= rX;
        this.resolutionY= rY;
        this. extentX=vX;
        this.extentY=vY;
        Vector normal = vX.crossProduct(vY);
        normal.normalize();
        this.originCamera= centreImg.add(normal.multiply(-this.focalDistance));
    }

    /*  the method getRay() takes 2 integers as parameters. 
        x is a number between 1 and resolutionX
        y is a number between 1 and resolutionY
        the method compute the 3D point to which it corresponds on the plan of the image.
        it returns a new ray between the origin of the camera and this point.

    */

    public Ray getRay(int x, int y){
        double percentX= ((double) x)/this.resolutionX;
        double percentY= ((double) y)/this.resolutionY;

        Vector vecX = extentX.multiply(percentX-0.5);
        Vector vecY = extentY.multiply(percentY-0.5);
        
        Point pixel = centreImg.add(vecX).add(vecY);
        Vector rayVector= new Vector(this.originCamera, pixel);
        rayVector.normalize();

        return new Ray(originCamera, rayVector); 
    }


}
