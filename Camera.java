public class Camera {
    public int resolutionX;
    public int resolutionY;
    public int focalDistance;
    public Point centreImg;
    public Point originCamera;
    public Vector extentX;
    public Vector extentY;

    public Camera(Point c, int d, Vector vX, int rX, Vector vY, int rY){ 
        focalDistance=d;
        centreImg=c;
        resolutionX= rX;
        resolutionY= rY;
        extentX=vX;
        extentY=vY;
        Vector normal = vX.crossProduct(vY);
        normal.normalize();
        originCamera= centreImg.add(normal.multiply(-focalDistance));
    }

    public Ray getRay(int x, int y){
        double percentX= ((double) x)/resolutionX;
        double percentY= ((double) y)/resolutionY;

        Vector vecX = extentX.multiply(percentX-0.5);
        Vector vecY = extentY.multiply(percentY-0.5);
        
        Point pixel = centreImg.add(vecX).add(vecY);
        Vector rayVector= new Vector(originCamera, pixel);
        rayVector.normalize();

        return new Ray(originCamera, rayVector); 
    }


}
