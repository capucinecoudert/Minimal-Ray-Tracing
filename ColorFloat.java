public class ColorFloat {
    public double red;
    public double blue;
    public double green;

    /* 
        a color is defined by three parameters red, blue and green. Each value is between 0 and 1.  
        it allows us to multiply and add color easily
    */

    public ColorFloat(double r, double g, double b){
        this.red=r;
        this.green=g;
        this.blue=b;
    }

    /* this method multiplies 2 colors*/
    public ColorFloat multiply(ColorFloat c){
        return new ColorFloat(this.red*c.red, this.green*c.green, this.blue*c.blue);
    }

    /* this method multiplies a color and a double*/
    public ColorFloat multiply(double d){
        return new ColorFloat(this.red*d, this.green*d, this.blue*d);
    }

     /* this method adds 2 colors*/
    public ColorFloat add(ColorFloat c){
        return new ColorFloat(this.red+c.red, this.green+c.green, this.blue+c.blue);
    }

    /* 
        This method returns the 0-1 components of ColorFloat as 0-255 RGB components as ColorInt.
        It can't return a component larger than 255.
    */
    public ColorInt colorToInt(){  
        int b=(int) Math.min(blue * 255, 255);
        int g=(int) Math.min(green * 255, 255);
        int r=(int) Math.min(red * 255, 255);
        return new ColorInt(r, g,b);
    }
}
