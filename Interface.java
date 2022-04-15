import javax.swing.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;


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
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel Interface = new JPanel();
        Interface.setSize(1000, 1000);
        //our interface will be divided into cases where we will put the widgets
        Interface.setLayout(new GridBagLayout());
        //gc will determine the size and the positions on the different widgets
        GridBagConstraints gc = new GridBagConstraints();
        //the command both means that the widgets will take the maximum place in the vertical and the horizontal direction, in the case
        gc.fill = GridBagConstraints.CENTER;
        // Here, we are adding space between the components
        gc.insets = new Insets(5, 5, 5, 5);
        gc.ipady = gc.anchor = GridBagConstraints.CENTER;
        //we need 18 cases in the x direction and 14 in the y one
        gc.weightx = 18;
        gc.weighty = 14;
       

        gc.gridx = 0;
		gc.gridy = 0;


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
        JLabel cameraTest= new JLabel ("camera");
        
        Interface.add(cameraTest,gc);
        gc.gridx=0;
        gc.gridy=3;
        

        Interface.add(Resolution,gc);
        gc.gridx = 0;
		gc.gridy = 6;
        
        //gc.gridwidth = 3;
        

        Interface.add(FocalDistance,gc);
        gc.gridx = 0;
		gc.gridy = 7;
        //gc.gridwidth = 3;
         

        Interface.add(Centre,gc);
        gc.gridx = 0;
		gc.gridy = 8;
        //gc.gridwidth = 3;
         

        Interface.add(Vectorx,gc);
        gc.gridx = 0;
		gc.gridy = 10;
       // gc.gridwidth = 3;

        Interface.add(Vectory,gc);
        gc.gridx = 0;
		gc.gridy = 11;
       // gc.gridwidth = 3;

        Interface.add(Jresolutionx,gc);
        gc.gridx = 3;
		gc.gridy = 3;
        

        Interface.add(Jresolutiony,gc);
        gc.gridx = 5;
		gc.gridy = 6;

        Interface.add(JfocalDistance,gc);
        gc.gridx = 5;
		gc.gridy = 7;

        Interface.add(JcentreImgX,gc);
        gc.gridx = 4;
		gc.gridy =8;

        Interface.add(JcentreImgY,gc);
        gc.gridx = 5;
		gc.gridy =8;
        gc.gridwidth=2;

        Interface.add(JcentreImgZ,gc);
        gc.gridx = 6;
		gc.gridy =8;
        gc.gridwidth=2;

        Interface.add(JextentXy,gc);
        gc.gridx = 4;
		gc.gridy =10;
        gc.gridwidth=2;

        Interface.add(JextentXy,gc);
        gc.gridx = 5;
		gc.gridy =10;
        gc.gridwidth=2;

        Interface.add(JextentXz,gc);
        gc.gridx = 6;
		gc.gridy =10;
        gc.gridwidth=2;

        Interface.add(JextentYx,gc);
        gc.gridx = 4;
		gc.gridy =11;
        gc.gridwidth=2;

        Interface.add(JextentYy,gc);
        gc.gridx = 5;
		gc.gridy =11;
        gc.gridwidth=2;

        Interface.add(JextentYz,gc);
        gc.gridx = 6;
		gc.gridy =12;
        gc.gridwidth=2;

        Interface.add(ValidateCamera,gc);
        gc.gridx = 0;
		gc.gridy =12;
        gc.gridwidth = 2;




        //creation of the light's definition pan

        JLabel Light1 = new JLabel("Light1 1");
        JLabel OriginSphere1 = new JLabel(" Origin of the first light(x,y,z) =");
        JLabel RGBcode1 = new JLabel("RGB Code of the first light (Red, Green, Blue)=");
        
        
      
        Interface.add(Light1,gc);
        gc.gridx = 6;
		gc.gridy = 3;
       // gc.gridwidth = 3;
        

        Interface.add(OriginSphere1,gc);
        gc.gridx = 6;
		gc.gridy = 8;
       // gc.gridwidth = 3;
        
        Interface.add(RGBcode1,gc);
        gc.gridx = 6;
		gc.gridy = 8;
       // gc.gridwidth = 3;
        

        Interface.add(origin1x,gc);
        gc.gridx = 9;
		gc.gridy = 8;
          

        Interface.add(origin1y,gc);
        gc.gridx = 10;
		gc.gridy = 8;
     
        Interface.add(origin1z,gc);
        gc.gridx = 11;
		gc.gridy = 8;
  

        Interface.add(Red1,gc);
        gc.gridx = 9;
		gc.gridy = 6;
         

        Interface.add(Green1,gc);
        gc.gridx = 10;
		gc.gridy = 6;
 

        Interface.add(Blue1,gc);
        gc.gridx = 11;
		gc.gridy = 6;
        

        Interface.add(ValidateLight1,gc);
        gc.gridx = 6;
		gc.gridy = 12;
      //  gc.gridwidth = 2;
        


        
        //creation of the sphere's definition pan

        
        JLabel Sphere1 = new JLabel("Sphere 1");
        JLabel Radius1 = new JLabel("Radius of the 1st sphere");
        JLabel centre1 = new JLabel("Centre of the 1st Sphere");
        
        Interface.add(Sphere1,gc);
        gc.gridx = 12;
		gc.gridy = 3;
        //gc.gridwidth = 3;
        

        Interface.add(Radius1,gc);
        gc.gridx = 12;
		gc.gridy = 6;
      //  gc.gridwidth = 3;
        
        Interface.add(centre1,gc);
        gc.gridx = 12;
		gc.gridy = 8;
      //  gc.gridwidth = 3;
          

        Interface.add(radius1,gc);
        gc.gridx = 17;
		gc.gridy = 6;
        

        Interface.add(sphere1x,gc);
        gc.gridx = 16;
		gc.gridy = 6;
         

        Interface.add(sphere1y,gc);
        gc.gridx = 17;
		gc.gridy = 6;
        

        Interface.add(sphere1z,gc);
        gc.gridx = 18;
		gc.gridy = 6;
        
        
        Interface.add(ValidateSphere1,gc);
        gc.gridx = 12;
		gc.gridy = 12;
        //gc.gridwidth = 2;
        


           

        //final JComboBox<String> material = new JComboBox<String>(Materials1);
       // material.setVisible(true);
        // Interface.add(material);

        //Interface.setVisible(true);

        this.add(Interface);
        this.setContentPane(Interface);
        this.setVisible(true);

    

    }
    // choix  de la sphere : radius, materiau, centre avec bouton Add et Remove
    // a cote affichage de la scene 2D 
    // bouton calculer img
    // zone pour afficher bmp file
    // blablaba
    
    
    public void actionPerformed (ActionEvent e){
        Camera c;
        LinkedList<Sphere> spheres;
        LinkedList<Light> lights;


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
