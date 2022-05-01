 public class ColorInt{

    // the ColorInt Class contains 3 components Red, Green, Blue between 0-255.
    
    public int red;
    public int green;
    public int blue;

    public ColorInt(int r, int g, int b){
        this.red=r;
        this.green=g;
        this.blue=b;
    }

    public ColorFloat intToColor(){
        double r= Math.min( this.red/255, 1);
        double g= Math.min(this.green/255, 1);
        double b= Math.min(this.blue/255, 1);
        return new ColorFloat(r, g, b);
    }
}