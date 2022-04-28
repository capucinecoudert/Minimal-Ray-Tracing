public class Material {
    /*
        Defines a material as an element having a coeficient of reflection, a power of speculation, 
        a color of diffusion and a specular color.
    */

    double reflectionCoeff; // reflection coefficient of the material
    double specularPower; // specular Power of the material
    ColorFloat diffusionColor; // the diffusion color of the material

    public Material(double r, double p,ColorFloat d){
        this.reflectionCoeff= r;
        this.specularPower=p;
        this.diffusionColor=d;
    }
}
