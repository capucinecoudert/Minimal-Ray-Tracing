public class MaterialBlack extends Material {
    
    public MaterialBlack(){
        reflectionCoeff = 1.0;
        specularPower = 60;
        specularColor = new Color(1.0, 1.0, 1.0);
        diffusionColor = new Color(0.01, 0.01, 0.01);
    }
}