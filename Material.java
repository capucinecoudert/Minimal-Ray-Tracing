public class Material {
    double reflectionCoeff;
    double specularPower;
    Color specularColor;
    Point emma;
    Color diffusionColor;

    public Material(double r, double p, Color s, Color d){
        reflectionCoeff=r;
        specularPower=p;
        specularColor=s;
        diffusionColor=d;
    }



    
}
