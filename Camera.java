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
        originCamera= normal.multiply(focalDistance).add(centreImg);
    }

    public Ray computeRay(double percentX, double percentY){
        Point pixel= new Point(centreImg.x+ extentX.norm()*percentX, centreImg.x+ extentX.norm()*percentY, centreImg.z);
        Vector vecX = extentX.multiply(percentX);
        Vector vecY = extentY.multiply(percentY);
        Point pixel = vecX.add(centreImg).add(vecY);
        Vector rayVector= new Vector(originCamera, pixel);
        return new Ray(originCamera, rayVector);
    }


}
