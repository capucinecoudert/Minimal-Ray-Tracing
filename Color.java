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


    // add a SRGB encode function for  Gamma correction


    
}
