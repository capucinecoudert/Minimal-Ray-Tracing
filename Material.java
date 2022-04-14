public class Material {
    /*
        Defines a material as an element having a coeficient of reflection, a power of speculation, 
        a color of diffusion and a specular color.
    */

    double reflectionCoeff;
    double specularPower;
    Color specularColor; //not used
    Color diffusionColor;

    public Material(double r, double p, Color s, Color d){
        reflectionCoeff=r;
        specularPower=p;
        specularColor=s;
        diffusionColor=d;
    }

    // voir pour les materiaux de l'interface --> sinon error
    public Material(){}
}
