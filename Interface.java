import javax.swing.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.util.*;
import java.awt.Insets;
import java.awt.*;

import java.awt.BorderLayout;
import javax.swing.border.Border;

public class Interface extends JFrame implements ActionListener {
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
         public JButton DeleteCamera;
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
         public JButton DeleteLight;
         
         
        //Attributes for the spheres definition
        public String[] Materials1 = {"Black", "Blue", "Cyan", "Green", "Magenta","Red","White","Yellow"}; //Attributes for the first sphere
        public JTextField radius1;
        public JTextField sphere1x; 
        public JTextField sphere1y;
        public JTextField sphere1z;
        public JButton ValidateSphere1;
        public JButton DeleteSphere;

       

    public Interface (){
        super("Mon Interface");
       // setExtendedState(JFrame.MAXIMIZED_BOTH);
      //  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1050, 1000);
        this.setLayout(null);
        JPanel Interface = new JPanel();
        Interface.setBounds(0,0,1050, 700);
        
        ValidateCamera = new JButton("Validate Camera");
        ValidateCamera.addActionListener(this);
        ValidateLight1= new JButton("Validate Light");
        ValidateLight1.addActionListener(this);
        ValidateSphere1= new JButton("Validate Sphere");
        ValidateSphere1.addActionListener(this);
        DeleteCamera = new JButton("Delete Camera");
        DeleteCamera.addActionListener(this);
        DeleteLight= new JButton("Delete Light");
        DeleteLight.addActionListener(this);
        DeleteSphere= new JButton("Delete Sphere");
        DeleteSphere.addActionListener(this);

        //String[] Menu = {"Definition of the camera", "Definition of the lights", "Definition of the spheres"};
        // String Menu2 = (String) JOptionPane.showInputDialog(null,"Select the objects you want to define", "Deinition of the parameters", JOptionPane.QUESTION_MESSAGE,null,Menu,null);

            Jresolutionx=new JTextField();
            Jresolutiony=new JTextField();
            JfocalDistance=new JTextField();
            JcentreImgX=new JTextField(); // on a besoin de 3 points cordonnées pour créer le point le centre de l'image
            JcentreImgY=new JTextField();
            JcentreImgZ=new JTextField();
            JextentXx=new JTextField();// on a besoin de 3 coordonnées pour le vecteur exentent x
            JextentXy=new JTextField();
            JextentXz=new JTextField();
            JextentYx=new JTextField(); //on a besoin de 3 coordonnées pour le vecteur exentent x
            JextentYy=new JTextField();
            JextentYz=new JTextField();
            origin1x=new JTextField(); // we need 3 coordinates to define the location of the first light
            origin1y=new JTextField();
            origin1z=new JTextField();
            Red1=new JTextField();// We need the red-grren-blue combination to define the color of the light
            Green1=new JTextField();
            Blue1=new JTextField();
            radius1=new JTextField();
            sphere1x=new JTextField();
            sphere1y=new JTextField();
            sphere1z=new JTextField();

        //creation of the camera's definition pan
        JLabel Resolution = new JLabel("Resolution(x,y)=");
        JLabel FocalDistance = new JLabel("focal distance =");
        JLabel Centre = new JLabel("Centre of the image (x,y,z)=");
        JLabel Vectorx = new JLabel(" Vector Extent x (x,t,z)=");
        JLabel Vectory = new JLabel(" Vector Extent y (x,t,z)=");
        JLabel Camera= new JLabel ("Description of the camera");
        JLabel Scene= new JLabel("Description of the scene");
        JLabel Light =new JLabel ("Description of the lights");
        JLabel Sphere =new JLabel ("Description of the spheres");

        JLabel OriginSphere = new JLabel(" Origin of the first light(x,y,z) =");
        JLabel RGBcode = new JLabel("RGB Code of the first light (Red, Green, Blue)=");
        JLabel Radius = new JLabel("Radius of the 1st sphere");
        JLabel centre = new JLabel("Centre of the 1st Sphere");
       
        JPanel CAMERA =new JPanel();
        CAMERA.setOpaque(false);
        Border lineborderCAMERA = BorderFactory.createLineBorder(Color.DARK_GRAY, 1); 
        CAMERA.setBorder(lineborderCAMERA);
        this.add(CAMERA);
        CAMERA.setBounds(0,100, 350,700);

        JPanel LIGHT =new JPanel();
        LIGHT.setOpaque(false);
        Border lineborderLIGHT = BorderFactory.createLineBorder(Color.GRAY, 1); 
        LIGHT.setBorder(lineborderLIGHT);
        this.add(LIGHT);
        LIGHT.setBounds(350,100, 350,700);

        JPanel SPHERE =new JPanel();
        SPHERE.setOpaque(false);
        Border lineborderSPHERE = BorderFactory.createLineBorder(Color.GRAY, 1); 
        SPHERE.setBorder(lineborderSPHERE);
        this.add(SPHERE);
        SPHERE.setBounds(700,100, 350,700);



        this.add(Scene);
        Scene.setFont(new Font("Serif", Font.BOLD, 20));
        Scene.setOpaque(true);
        Scene.setForeground(Color.WHITE);
        Scene.setBackground(Color.DARK_GRAY);
        Scene.setBounds(400,0,210,50);

        this.add(Camera);
        Camera.setBounds(10, 50, 340, 50);
        
        this.add(Light);
        Light.setBounds(350, 50, 350, 50);

        this.add(Sphere);
        Sphere.setBounds(700, 50, 350, 50);

        this.add(Resolution);
        Resolution.setBounds(10, 225, 140, 50);
        
        this.add(FocalDistance);
        FocalDistance.setBounds(10, 300, 140, 50);

        this.add(Centre);
        Centre.setBounds(10, 375, 140, 50);

        this.add(Vectorx);
        Vectorx.setBounds(10, 450, 140, 50);
        
        this.add(Vectory);
        Vectory.setBounds(10, 525, 140, 50);

        this.add(ValidateCamera);
        ValidateCamera.setBounds(10,600,140,50);

        this.add(DeleteCamera);
        DeleteCamera.setBounds(200,600,150,50);

        this.add(RGBcode);
        RGBcode.setBounds(350, 225, 150, 50);
        
        this.add(OriginSphere);
        OriginSphere.setBounds(350,300,150,50);

        this.add(Radius);
        Radius.setBounds(700,225,150,50);

        this.add(centre);
        centre.setBounds(700,300,150,50);

        this.add(ValidateLight1);
        ValidateLight1.setBounds(350,600,150,50);

        this.add(DeleteLight);
        DeleteLight.setBounds(550,600,150,50);

        this.add(ValidateSphere1);
        ValidateSphere1.setBounds(700,600,150,50);

        this.add(DeleteSphere);
        DeleteSphere.setBounds(900,600,150,50);
        
        //ajout des JTextField

        this.add(Jresolutionx);
        Jresolutionx.setBounds(200,225,37,50);

        this.add(Jresolutiony);
        Jresolutiony.setBounds(250,225,37,50);

        this.add(JfocalDistance);
        JfocalDistance.setBounds(250,300,37,50);
       
        this.add(JcentreImgX);
        JcentreImgX.setBounds(200,375,37,50);

        this.add(JcentreImgY);
        JcentreImgY.setBounds(250,375,37,50);

        this.add(JcentreImgZ);
        JcentreImgZ.setBounds(300,375,37,50);

        this.add(JextentXx);
        JextentXx.setBounds(200,450,37,50);

        this.add(JextentXy);
        JextentXy.setBounds(250,450,37,50);

        this.add(JextentXz);
        JextentXz.setBounds(300,450,37,50);
         
        this.add(JextentYx);
        JextentYx.setBounds(200,525,37,50);

        this.add(JextentYy);
        JextentYy.setBounds(250,525,37,50);

        this.add(JextentYz);
        JextentYz.setBounds(300,525,37,50);

        this.add(Red1);
        Red1.setBounds(550,225,37,50);

        this.add(Green1);
        Green1.setBounds(600,225,37,50);

        this.add(Blue1);
        Blue1.setBounds(650,225,37,50);

        this.add(origin1x);
        origin1x.setBounds(550,300,37,50);

        this.add(origin1y);
        origin1y.setBounds(600,300,37,50);

        this.add(origin1z);
        origin1z.setBounds(650,300,37,50);
        
        this.add(radius1);
        radius1.setBounds(950,225,37,50);

        this.add(sphere1x);
        sphere1x.setBounds(900,300,37,50);

        this.add(sphere1y);
        sphere1y.setBounds(950,300,37,50);

        this.add(sphere1z);
        sphere1z.setBounds(1000,300,37,50);

        //COMBOBOX
        JPanel PanelComboBoxLight = new JPanel();
        String [] light = {"light1", "light2", "light3"};
        JComboBox comboBoxLight = new JComboBox (light);
        PanelComboBoxLight.add(comboBoxLight);
        PanelComboBoxLight.setBounds(450, 125, 140, 50);
        this.add(PanelComboBoxLight);

        JPanel PanelComboBoxSphere = new JPanel();
        String [] sphere = {"sphere1", "sphere2", "sphere3"};
        JComboBox comboBoxSphere = new JComboBox (sphere);
        PanelComboBoxSphere.add(comboBoxSphere);
        PanelComboBoxSphere.setBounds(850, 125, 140, 50);
        this.add(PanelComboBoxSphere);

        //final JComboBox<String> material = new JComboBox<String>(Materials1);
       // material.setVisible(true);
        // Interface.add(material);

        //Interface.setVisible(true);

        this.add(Interface);
        //this.setContentPane(Interface);
        this.setVisible(true);

        


    }
    // choix  de la sphere : radius, materiau, centre avec bouton Add et Remove
    // a cote affichage de la scene 2D 
    // bouton calculer img
    // zone pour afficher bmp file
    // blablaba
    
    // COMBOBOX 
    
    
    
    public void actionPerformed (ActionEvent e){
        Camera c;
        LinkedList<Sphere> spheres=new LinkedList<>();
        LinkedList<Light> lights = new LinkedList<>();


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
            c = new Camera(centreImg,focalDistance,extentX,resolutionX, extentY,resolutionY);
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
           // Light FirstLight = new Light(origin1, i1);
            //We delete the informations written the informations written in the JtextField
            Red1.setText("");
            Green1.setText("");
            Blue1.setText("");
            origin1x.setText("");
            origin1y.setText("");
            origin1z.setText("");
           // lights.add(FirstLight);
           
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
            spheres.add(Sphere1);
        
        }
        
        if(e.getSource()==DeleteCamera){

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
