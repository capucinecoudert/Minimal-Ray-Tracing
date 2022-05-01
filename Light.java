public class Light {
    // Defines a light by its source/origin and its intensity (i.e, its color)

    public ColorFloat intensity;
    public Point origin;

    public Light(Point o, ColorFloat i){
        this.origin=o;
        this.intensity=i;
        
    }
}
