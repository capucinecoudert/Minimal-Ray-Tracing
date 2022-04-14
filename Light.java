public class Light {
    // Defines a light by its source/origin and its intensity (i.e, its color)

    public Color intensity;
    public Point origin;

    public Light(Point o, Color i){
        intensity=i;
        origin=o;
    }
}
