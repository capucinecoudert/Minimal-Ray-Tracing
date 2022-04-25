public class Material {
    /*
        Defines a material as an element having a coeficient of reflection, a power of speculation, 
        a color of diffusion and a specular color.
    */

    double reflectionCoeff;
    double specularPower;
    Color diffusionColor;

    public Material(double r, double p,Color d){
        reflectionCoeff=r;
        specularPower=p;
        diffusionColor=d;
    }
}
