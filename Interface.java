import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Interface implements ActionListener {
    // 
         //attributes for the camera's definition
         public JTextField Jresolutionx;
         public JTextField Jresolutiony;
         public JTextField JfocalDistance;
         public JTextField JcentreImgX; // on a besoin de 3 points cordonnées pour créer le point le centre de l'image
         public JTextField JcentreImgY;
         public JTextField JcentreImgZ;
         public JTextField JextentXx;// on a besoin de 3 coordonnées pour le vecteur exentent x
         public JTextField JextentXy;
         public JTextField JextentXz;
         public JTextField JextentYx; //on a besoin de 3 coordonnées pour le vecteur exentent x
         public JTextField JextentYy;
         public JTextField JextentYz;
         public JButton ValidateCamera; //bouton pour valider la caméra
         //on branche les écoueteurs pour la caméra
         //ValidateCamera.addActionListener(this);

         // attributes for the lights definition
         public JTextField origin1x; // we need 3 coordinates to define the location of the first light
         public JTextField origin1y;
         public JTextField origin1z;
         public JTextField Red1; // We need the red-grren-blue combination to define the color of the light
         public JTextField Green1;
         public JTextField Blue1;
         public JButton ValidateLight1;
         
         
        //Attributes for the spheres definition
        public String[] Materials1 = {"Black", "Blue", "Cyan", "Green", "Magenta","Red","White","Yellow"}; //Attributes for the first sphere
        public JTextField radius1;
        public JTextField sphere1x; 
        public JTextField sphere1y;
        public JTextField sphere1z;
        public JButton ValidateSphere1;

       

    public Interface (){

        
        ValidateCamera.addActionListener(this);
        ValidateLight1.addActionListener(this);
        ValidateSphere1.addActionListener(this);
        //String[] Menu = {"Definition of the camera", "Definition of the lights", "Definition of the spheres"};
       // String Menu2 = (String) JOptionPane.showInputDialog(null,"Select the objects you want to define", "Deinition of the parameters", JOptionPane.QUESTION_MESSAGE,null,Menu,null);


        //creation of the camera's definition pan
        JLabel Resolution = new JLabel("Resolution(x,y)=");
        JLabel FocalDistance = new JLabel("focal distance =");
        JLabel Centre = new JLabel("Centre of the image (x,y,z)=");
        JLabel Vectorx = new JLabel(" Vector Extent x (x,t,z)=");
        JLabel Vectory = new JLabel(" Vector Extent y (x,t,z)=");

        JPanel CameraDefinition= new JPanel();
        CameraDefinition.setLayout(null);
        CameraDefinition.setBounds(0,0,300,200);
        CameraDefinition.setVisible(true);

        CameraDefinition.add(Resolution);
        CameraDefinition.add(FocalDistance);
        CameraDefinition.add(Centre);
        CameraDefinition.add(Vectorx);
        CameraDefinition.add(Vectory);
        CameraDefinition.add(Jresolutionx);
        CameraDefinition.add(Jresolutiony);
        CameraDefinition.add(JfocalDistance);
        CameraDefinition.add(JcentreImgX);
        CameraDefinition.add(JcentreImgY);
        CameraDefinition.add(JcentreImgZ);
        CameraDefinition.add(JextentXy);
        CameraDefinition.add(JextentXy);
        CameraDefinition.add(JextentXz);
        CameraDefinition.add(JextentYx);
        CameraDefinition.add(JextentYy);
        CameraDefinition.add(JextentYz);
        CameraDefinition.add(ValidateCamera);


        Resolution.setBounds(10, 10, 50 ,15);
        FocalDistance.setBounds(10, 40, 50 ,15);
        Centre.setBounds(10, 70, 50 ,15);
        Vectorx.setBounds(10, 100, 50 ,15);
        Vectory.setBounds(10, 130, 50 ,15);
        Jresolutionx.setBounds(10,10,20,20);
        Jresolutiony.setBounds(10, 10, 20 ,20);
        JfocalDistance.setBounds(10, 40, 20 ,20);
        JcentreImgX.setBounds(10, 70, 20 ,20);
        JcentreImgY.setBounds(10, 70, 20 ,20);
        JcentreImgZ.setBounds(10, 70, 20 ,20);
        JextentXx.setBounds(10, 100, 20 ,20);
        JextentXy.setBounds(10,100,20,20);
        JextentXz.setBounds(10, 100, 20,20);
        JextentYx.setBounds(10, 130, 20 ,20);
        JextentYy.setBounds(10, 130, 20 ,20);
        JextentYz.setBounds(10, 130, 20 ,20);
        ValidateCamera.setBounds(10,200,100,40);

        //creation of the light's definition pan
        JPanel LightDefinition= new JPanel();

        JLabel Light1 = new JLabel("Light1 1");
        JLabel OriginSphere1 = new JLabel(" Origin of the first light(x,y,z) =");
        JLabel RGBcode1 = new JLabel("RGB Code of the first light (Red, Green, Blue)=");
        
        
        LightDefinition.setLayout(null);
        LightDefinition.setBounds(300,200,300,300);
        LightDefinition.setVisible(true);

        LightDefinition.add(Light1);
        LightDefinition.add(OriginSphere1);
        LightDefinition.add(RGBcode1);
        LightDefinition.add(origin1x);
        LightDefinition.add(origin1y);
        LightDefinition.add(origin1z);
        LightDefinition.add(Red1);
        LightDefinition.add(Green1);
        LightDefinition.add(Blue1);
        LightDefinition.add(ValidateLight1);

        Light1.setBounds(50,10,50,50);
        OriginSphere1.setBounds(10,30, 50, 50);
        origin1x.setBounds(100, 30,20,20);
        origin1y.setBounds(110,30,20,20);
        origin1z.setBounds(130,30,20,20);
        RGBcode1.setBounds(10,50,50,50);
        Red1.setBounds(100, 50, 20, 20);
        Green1.setBounds(110, 50, 20, 20);
        Blue1.setBounds(130, 50, 20, 20);
        ValidateLight1.setBounds(30,90,50,50);

        //creation of the sphere's definition pan

        JPanel SphereDefinition= new JPanel();
        SphereDefinition.setLayout(null);
        SphereDefinition.setBounds(300,0,300,500);
        SphereDefinition.setVisible(true);


        JLabel Sphere1 = new JLabel("Sphere 1");
        JLabel Radius1 = new JLabel("Radius of the 1st sphere");
        JLabel centre1 = new JLabel("Centre of the 1st Sphere");
        
        SphereDefinition.add(Sphere1);
        SphereDefinition.add(Radius1);
        SphereDefinition.add(centre1);
        SphereDefinition.add(radius1);
        SphereDefinition.add(sphere1x);
        SphereDefinition.add(sphere1y);
        SphereDefinition.add(sphere1z);
        SphereDefinition.add(ValidateSphere1);


        Sphere1.setBounds(50,10,50,50);
        Radius1.setBounds(10, 30, 50, 50);
        radius1.setBounds(10,30,20,20);
        centre1.setBounds(10,60,50,50);
        sphere1x.setBounds(100, 60, 20, 20);
        sphere1y.setBounds(110, 60, 20, 20);
        sphere1z.setBounds(130, 60, 20, 20);
        ValidateSphere1.setBounds(20,90,50,20);
           

        final JComboBox<String> material = new JComboBox<String>(Materials1);
        material.setVisible(true);
        SphereDefinition.add(material);
    }
    // choix  de la sphere : radius, materiau, centre avec bouton Add et Remove
    // a cote affichage de la scene 2D 
    // bouton calculer img
    // zone pour afficher bmp file
    // blablaba
    }
    
    
    public void actionPerformed (ActionEvent e){
        if((e.getSource()== ValidateCamera)&&(verifINT(Jresolutionx.getText()))&&(verifINT(Jresolutiony.getText()))&&(verifINT(JfocalDistance.getText()))&&(verifDOUBLE(JextentXy.getText()))&&(verifDOUBLE(JextentXx.getText()))&&(verifDOUBLE(JextentXz.getText()))&&(verifDOUBLE(JextentYx.getText()))&&((verifDOUBLE(JextentYy.getText())))&&(verifDOUBLE(JextentYz.getText()))&&(verifDOUBLE(JcentreImgX.getText()))&&(verifDOUBLE(JcentreImgY.getText()))&&(verifDOUBLE(JcentreImgZ.getText()))){
            int resolutionX = Integer.parseInt(Jresolutionx.getText()) ;
            Jresolutionx.setText("");
            int resolutionY = Integer.parseInt(Jresolutiony.getText());
            Jresolutiony.setText("");
            int focalDistance= Integer.parseInt(JfocalDistance.getText());
            JfocalDistance.setText("");
            Point centreImg = new Point (Double.parseDouble(JcentreImgX.getText()),Double.parseDouble(JcentreImgY.getText()), Double.parseDouble(JcentreImgZ.getText()) );
            JcentreImgX.setText("");
            JcentreImgY.setText("");
            JcentreImgZ.setText("");
            Vector extentX = new Vector (Double.parseDouble(JextentXx.getText()),Double.parseDouble(JextentXy.getText()), Double.parseDouble(JextentXz.getText()) );
            JextentXx.setText("");
            JextentXy.setText("");
            JextentXz.setText("");
            Vector extentY = new Vector (Double.parseDouble(JextentYx.getText()),Double.parseDouble(JextentYy.getText()), Double.parseDouble(JextentYz.getText()) );
            Camera c = new Camera(centreImg,focalDistance,extentX,resolutionX, extentY,resolutionY);
            Jresolutionx.setText("");
            Jresolutiony.setText("");
            JfocalDistance.setText("");
            JcentreImgX.setText("");
            JcentreImgY.setText("");
            JcentreImgZ.setText("");
            JextentXx.setText("");
            JextentXy.setText("");
            JextentXz.setText("");
            JextentYx.setText("");
            JextentYy.setText("");
            JextentYz.setText("");
            JextentYx.setText("");
            JextentYy.setText("");
            JextentYz.setText("");
            
            //Camera c= new Camera(resolutionX, d);

        }
        if ((e.getSource()==ValidateLight1)&&(verifINT(Red1.getText()))&&(verifINT(Green1.getText()))&&verifINT(Blue1.getText())&&(verifDOUBLE(origin1x.getText()))&&(verifDOUBLE(origin1y.getText()))&&(verifDOUBLE(origin1z.getText()))){
            Point origin1 = new Point (Double.parseDouble(origin1x.getText()),Double.parseDouble(origin1y.getText()), Double.parseDouble(origin1z.getText()));
            Color i1= new Color (Integer.parseInt(Red1.getText()),Integer.parseInt(Green1.getText()),Integer.parseInt(Blue1.getText()));
            Light FirstLight = new Light(origin1, i1);
            //We delete the informations written the informations written in the JtextField
            Red1.setText("");
            Green1.setText("");
            Blue1.setText("");
            origin1x.setText("");
            origin1y.setText("");
            origin1z.setText("");
           
        }
        
        if(e.getSource()==ValidateSphere1){
            Point pointFirstSphere= new Point (Double.parseDouble(sphere1x.getText()),Double.parseDouble(sphere1y.getText()), Double.parseDouble(sphere1z.getText()));
            Double RadiusFirstSphere = new Double (Double.parseDouble(radius1.getText()));
            Material MaterialThirdSphere=new MaterialBlack();
            Sphere Sphere1 = new Sphere(pointFirstSphere , RadiusFirstSphere, MaterialThirdSphere);
            sphere1x.setText("");
            sphere1y.setText("");
            sphere1z.setText("");
            radius1.setText("");
        }
               


    }
    // Method to verify that characters have been put in the JTextfield
    public boolean verifSaisie (String Averifier){
        if (Averifier.length() == 0){
            return false;
        }else{
            return true;
        }

    }

    // Method to verify that the characters are integers
    public boolean verifINT (String Averifier){
   
        boolean isINT = true;
        if (Averifier.length() == 0){
            return false;
        }
        for (int i = 0; i < Averifier.length(); i++) {
            if (!Character.isDigit(Averifier.charAt(i))) {
                return false;
            }
        }
        return isINT;
    }
    
    public boolean verifDOUBLE (String Averifier){
        boolean isDOUBLE=true;

        if (Averifier.length() == 0){ //Verify that the string is not empty
            return false;
        }
        try {
        Double.parseDouble(Averifier);
        }catch(NumberFormatException e) {
            return false;
        }
        return isDOUBLE;

    }
    
}
