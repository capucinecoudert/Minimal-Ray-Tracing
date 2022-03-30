public class Color {
    public double red;
    public double blue;
    public double green;

    public Color(double r, double g, double b){
        red=r;
        green=g;
        blue=b;
    }

    public ColorInt colorToInt(){  // comme ça si la valeur est au dessus de 255, on prend 255 
        int b=(int) Math.min(blue * 255, 255);
        int g=(int) Math.min(green * 255, 255);
        int r=(int) Math.min(red * 255, 255);
        return new ColorInt(r, g,b);
    }

    public Color multiply(Color c){
        return new Color(this.red*c.red, this.green*c.green, this.blue*c.blue);
    }
    public Color multiply(double d){
        return new Color(this.red*d, this.green*d, this.blue*d);
    }
    public Color add(Color c){
        return new Color(this.red+c.red, this.green+c.green, this.blue+c.blue);
    }


    // add a SRGB encode function for  Gamma correction


    
}
