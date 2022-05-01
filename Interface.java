// these are the librairies in the Interface class
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

import java.io.IOException;

import java.awt.BorderLayout;
import javax.swing.border.Border;

public class Interface extends JFrame implements ActionListener {
    // attributes for the available materials
    public Material black;
    public Material white;
    public Material green;
    public Material cyan;
    public Material red;
    public Material magenta;
    public Material yellow;
    public Material blue;
    public String[] Materials1 = { "Black", "Blue", "Cyan", "Green", "Magenta", "Red", "White", "Yellow" }; // Attributes

<<<<<<< HEAD
         //Here is the initialisation of the camera, spheres and lights
         // The lights and the spheres will be store in the linkedlists
         public Camera c;
         public LinkedList<Sphere> spheres=new LinkedList<>(); //liste des spheres
         public LinkedList<Light> lights = new LinkedList<>(); // liste des lights

         // All the JText Field have to be declared as attributes since the user is interacting with them 
         public JTextField Jresolutionx;
         public JTextField Jresolutiony;
         public JTextField JfocalDistance;
         public JTextField JcentreImgX; // We need 3 coordinates to define the centre of the image
         public JTextField JcentreImgY;
         public JTextField JcentreImgZ;
         public JTextField JextentXx;// We need 3 coordinates to define the extent vector x
         public JTextField JextentXy;
         public JTextField JextentXz;
         public JTextField JextentYx; // We need 3 coordinates to define the extent vector y
         public JTextField JextentYy;
         public JTextField JextentYz;
         public JButton ValidateCamera; 
         public JButton DeleteCamera;

         // attributes for the lights definition
         public JTextField origin1x; // we need 3 coordinates to define the location of the first light
         public JTextField origin1y;
         public JTextField origin1z;
         public JTextField Red1; // We need the red-green-blue combination to define the color of the light
         public JTextField Green1;
         public JTextField Blue1;
         public JButton ValidateLight1;
         public JButton DeleteLight;
         
         
        //Attributes for the spheres definition
        public String[] Materials1 = {"Black", "Blue", "Cyan", "Green", "Magenta","Red","White","Yellow"}; //Attributes for the first sphere
        public JTextField radius1;
        public JTextField sphere1x; //We need 4 coordinates to define the center of the sphere
        public JTextField sphere1y;
        public JTextField sphere1z;
        public JButton ValidateSphere1;
        public JButton DeleteSphere;

       public JButton ValidateALL; // The JButton ValidateAll is used to validate the all scene
=======
    // attributes for the camera's definition
    public Camera c;
    public ArrayList<Sphere> spheres;// liste des spheres
    public ArrayList<Light> lights; // liste des lights

    public JTextField Jresolutionx;
    public JTextField Jresolutiony;
    public JTextField JfocalDistance;
    public JTextField JcentreImgX; // on a besoin de 3 points cordonnées pour créer le point le centre de l'image
    public JTextField JcentreImgY;
    public JTextField JcentreImgZ;
    public JTextField JextentXx;// on a besoin de 3 coordonnées pour le vecteur exentent x
    public JTextField JextentXy;
    public JTextField JextentXz;
    public JTextField JextentYx; // on a besoin de 3 coordonnées pour le vecteur exentent x
    public JTextField JextentYy;
    public JTextField JextentYz;
    
    // on branche les écoueteurs pour la caméra

    // attributes for the lights definition
    public JTextField origin1x; // we need 3 coordinates to define the location of the first light
    public JTextField origin1y;
    public JTextField origin1z;
    public JTextField Red1; // We need the red-grren-blue combination to define the color of the light
    public JTextField Green1;
    public JTextField Blue1;
    
    // Attributes for the spheres definition
                                                                                                            // for the
                                                                                                            // first
                                                                                                            // sphere
    public JTextField radius1;
    public JTextField sphere1x;
    public JTextField sphere1y;
    public JTextField sphere1z;
    

    // ComboBox declaration
    // Light Combobox
    public JPanel PanelComboBoxLight;
    public String[] lightName = { "create a new light" };
    public JComboBox comboBoxLight;
>>>>>>> 5b199bfc15cbbdc7fc17d04a450a9f8274f398d2

    // Sphere ComboBox
    public JPanel PanelComboBoxSphere;
    public String[] sphereName = { "create a new sphere" };
    public JComboBox comboBoxSphere;

    // Button to launch the scene
    public JButton ValidateSphere1;
    public JButton DeleteSphere;
    public JButton ValidateLight1;
    public JButton DeleteLight;
    public JButton ValidateCamera; // bouton pour valider la caméra
    public JButton DeleteCamera;
    public JButton ValidateScene;
    

    public Interface() {
        // Initialization of the window
        super("Minimal Ray Tracing");
<<<<<<< HEAD
        setSize(1050, 1000);
        this.setLayout(null);
        JPanel Interface = new JPanel();
        Interface.setBounds(0,0,1050, 700);
        
        // Initialisation of the JButtons of the interface 
        // We are adding "addActionListener" because these buttons are needed in the actionperformed method

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
        ValidateALL=new JButton ("Validate all");
        ValidateALL.addActionListener(this);
=======
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1050, 1000);
        this.setLayout(null);
        JPanel Interface = new JPanel();
        Interface.setBounds(0, 0, 1050, 700);
>>>>>>> 5b199bfc15cbbdc7fc17d04a450a9f8274f398d2

        // Initializations of the main elements of the scene
        this.spheres = new ArrayList<Sphere>();
        this.lights = new ArrayList<Light>();
        this.c = null;

<<<<<<< HEAD
        // Initialisation of the JTextField
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
            Red1=new JTextField();// We need the red-green-blue combination to define the color of the light
            Green1=new JTextField();
            Blue1=new JTextField();
            radius1=new JTextField();
            sphere1x=new JTextField();
            sphere1y=new JTextField();
            sphere1z=new JTextField();

            ValidateALL=new JButton("Validate the scene");
        //Initialisation and declaration of the pan of the interfaces (used for the written text)
=======
        // Create the serie of materials
        this.white = new Material(1.0, 1.0, new ColorFloat(1.0, 1.0, 1.0));
        this.red = new Material(0.5, 0.5, new ColorFloat(1.0, 0.0, 0));
        this.black = new Material(1.0, 60.0, new ColorFloat(0.01, 0.01, 0.01));
        this.blue = new Material(0.0, 0.5, new ColorFloat(0.0, 0.0, 1.0));
        this.cyan = new Material(0.0, 0.5, new ColorFloat(0.0, 1.0, 1.0));
        this.green = new Material(0.5, 0.5, new ColorFloat(0.0, 1.0, 0.0));
        this.magenta = new Material(0.0, 60, new ColorFloat(1.0, 0.0, 1.0));
        this.yellow = new Material(0.5, 60, new ColorFloat(1.0, 1.0, 0.0));

        // Initialization of the Validate and Delete buttons of the window
        this.ValidateCamera = new JButton("Validate Camera");
        this.ValidateCamera.addActionListener(this);
        this.ValidateLight1 = new JButton("Validate Light");
        this.ValidateLight1.addActionListener(this);
        this.ValidateSphere1 = new JButton("Validate Sphere");
        this.ValidateSphere1.addActionListener(this);
        this.DeleteCamera = new JButton("Delete Camera");
        this.DeleteCamera.addActionListener(this);
        this.DeleteLight = new JButton("Delete Light");
        this.DeleteLight.addActionListener(this);
        this.DeleteSphere = new JButton("Delete Sphere");
        this.DeleteSphere.addActionListener(this);
        this.ValidateScene = new JButton("Display the image");
        this.ValidateScene.addActionListener(this);

        // String[] Menu = {"Definition of the camera", "Definition of the lights",
        // "Definition of the spheres"};
        // String Menu2 = (String) JOptionPane.showInputDialog(null,"Select the objects
        // you want to define", "Deinition of the parameters",
        // JOptionPane.QUESTION_MESSAGE,null,Menu,null);

        // Initialization of the JTextField necessary for the definition of the scene
        this.Jresolutionx = new JTextField();
        this.Jresolutiony = new JTextField();
        this.JfocalDistance = new JTextField();
        this.JcentreImgX = new JTextField(); // on a besoin de 3 points cordonnées pour créer le point le centre de
                                             // l'image
        this.JcentreImgY = new JTextField();
        this.JcentreImgZ = new JTextField();
        this.JextentXx = new JTextField();// on a besoin de 3 coordonnées pour le vecteur exentent x
        this.JextentXy = new JTextField();
        this.JextentXz = new JTextField();
        this.JextentYx = new JTextField(); // on a besoin de 3 coordonnées pour le vecteur exentent x
        this.JextentYy = new JTextField();
        this.JextentYz = new JTextField();
        this.origin1x = new JTextField(); // we need 3 coordinates to define the location of the first light
        this.origin1y = new JTextField();
        this.origin1z = new JTextField();
        this.Red1 = new JTextField();// We need the red-green-blue combination to define the color of the light
        this.Green1 = new JTextField();
        this.Blue1 = new JTextField();
        this.radius1 = new JTextField();
        this.sphere1x = new JTextField();
        this.sphere1y = new JTextField();
        this.sphere1z = new JTextField();

        // creation of the camera's definition pan
>>>>>>> 5b199bfc15cbbdc7fc17d04a450a9f8274f398d2
        JLabel Resolution = new JLabel("Resolution(x,y) :");
        JLabel FocalDistance = new JLabel("Focal distance :");
        JLabel Centre = new JLabel("Image center (x,y,z) :");
        JLabel Vectorx = new JLabel(" Vector Extent x (x,y,z) :");
        JLabel Vectory = new JLabel(" Vector Extent y (x,y,z) :");
<<<<<<< HEAD
        JLabel Camera= new JLabel ("Description of the camera");
        JLabel Scene= new JLabel(" Description of the scene");
        JLabel Light =new JLabel ("Description of the lights");
        JLabel Sphere =new JLabel ("Description of the spheres");
=======
        JLabel Camera = new JLabel("Description of the camera");
        JLabel Scene = new JLabel(" Description of the scene");
        JLabel Light = new JLabel("Description of the lights");
        JLabel Sphere = new JLabel("Description of the spheres");

>>>>>>> 5b199bfc15cbbdc7fc17d04a450a9f8274f398d2
        JLabel OriginSphere = new JLabel(" Origin of the light (x,y,z) :");
        JLabel RGBcode = new JLabel("Light Code (Red, Green, Blue) :");
        JLabel Radius = new JLabel("Radius of the 1st sphere :");
        JLabel centre = new JLabel("Centre of the 1st Sphere :");
<<<<<<< HEAD
       
        // All the differents widgets (JPanel, JButton and JTextField) are add to the window and well-placed
        JPanel CAMERA =new JPanel(); 
=======

        JPanel CAMERA = new JPanel();
>>>>>>> 5b199bfc15cbbdc7fc17d04a450a9f8274f398d2
        CAMERA.setOpaque(false);
        Border lineborderCAMERA = BorderFactory.createLineBorder(Color.DARK_GRAY, 1);
        CAMERA.setBorder(lineborderCAMERA);
        this.add(CAMERA);
        CAMERA.setBounds(0, 100, 350, 700);

        JPanel LIGHT = new JPanel();
        LIGHT.setOpaque(false);
        Border lineborderLIGHT = BorderFactory.createLineBorder(Color.GRAY, 1);
        LIGHT.setBorder(lineborderLIGHT);
        this.add(LIGHT);
        LIGHT.setBounds(350, 100, 350, 700);

        JPanel SPHERE = new JPanel();
        SPHERE.setOpaque(false);
        Border lineborderSPHERE = BorderFactory.createLineBorder(Color.GRAY, 1);
        SPHERE.setBorder(lineborderSPHERE);
        this.add(SPHERE);
<<<<<<< HEAD
        SPHERE.setBounds(700,100, 350,700);

        this.add(Scene);
        Scene.setFont(new Font("Serif", Font.BOLD, 40)); // The title of the window is written with a bigger text frony
        Scene.setOpaque(false);
        Scene.setForeground(Color.DARK_GRAY);
        Scene.setBounds(260,0,800,50);

        this.add(Camera); 
        Camera.setBounds(50, 50, 200, 50);
        
=======
        SPHERE.setBounds(700, 100, 350, 700);

        this.add(Scene);
        Scene.setFont(new Font("Serif", Font.BOLD, 20));
        Scene.setOpaque(true);
        Scene.setForeground(Color.WHITE);
        Scene.setBackground(Color.DARK_GRAY);
        Scene.setBounds(400, 0, 210, 50);

        // Addition and positioning of different elements in the window
        this.add(Camera);
        Camera.setBounds(10, 50, 340, 50);

>>>>>>> 5b199bfc15cbbdc7fc17d04a450a9f8274f398d2
        this.add(Light);
        Light.setBounds(400, 50, 200, 50);

        this.add(Sphere);
        Sphere.setBounds(750, 50, 200, 50);

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
        ValidateCamera.setBounds(20, 600, 130, 50);

        this.add(DeleteCamera);
<<<<<<< HEAD
        DeleteCamera.setBounds(205,600,140,50);
=======
        DeleteCamera.setBounds(200, 600, 130, 50);
>>>>>>> 5b199bfc15cbbdc7fc17d04a450a9f8274f398d2

        this.add(RGBcode);
        RGBcode.setBounds(360, 225, 200, 50);

        this.add(OriginSphere);
        OriginSphere.setBounds(360, 300, 150, 50);

        this.add(Radius);
        Radius.setBounds(710, 225, 150, 50);

        this.add(centre);
        centre.setBounds(710, 300, 150, 50);

        this.add(ValidateLight1);
<<<<<<< HEAD
        ValidateLight1.setBounds(355,600,140,50);

        this.add(DeleteLight);
        DeleteLight.setBounds(555,600,140,50);

        this.add(ValidateSphere1);
        ValidateSphere1.setBounds(705,600,140,50);

        this.add(DeleteSphere);
        DeleteSphere.setBounds(895,600,140,50);
        
=======
        ValidateLight1.setBounds(370, 600, 130, 50);

        this.add(DeleteLight);
        DeleteLight.setBounds(550, 600, 130, 50);

        this.add(ValidateSphere1);
        ValidateSphere1.setBounds(720, 600, 130, 50);

        this.add(DeleteSphere);
        DeleteSphere.setBounds(900, 600, 130, 50);

        // Addition and positioning of JTextFields in the window
>>>>>>> 5b199bfc15cbbdc7fc17d04a450a9f8274f398d2
        this.add(Jresolutionx);
        Jresolutionx.setBounds(200, 225, 37, 50);

        this.add(Jresolutiony);
        Jresolutiony.setBounds(250, 225, 37, 50);

        this.add(JfocalDistance);
        JfocalDistance.setBounds(250, 300, 37, 50);

        this.add(JcentreImgX);
        JcentreImgX.setBounds(200, 375, 37, 50);

        this.add(JcentreImgY);
        JcentreImgY.setBounds(250, 375, 37, 50);

        this.add(JcentreImgZ);
        JcentreImgZ.setBounds(300, 375, 37, 50);

        this.add(JextentXx);
        JextentXx.setBounds(200, 450, 37, 50);

        this.add(JextentXy);
        JextentXy.setBounds(250, 450, 37, 50);

        this.add(JextentXz);
        JextentXz.setBounds(300, 450, 37, 50);

        this.add(JextentYx);
        JextentYx.setBounds(200, 525, 37, 50);

        this.add(JextentYy);
        JextentYy.setBounds(250, 525, 37, 50);

        this.add(JextentYz);
        JextentYz.setBounds(300, 525, 37, 50);

        this.add(Red1);
        Red1.setBounds(550, 225, 37, 50);

        this.add(Green1);
        Green1.setBounds(600, 225, 37, 50);

        this.add(Blue1);
        Blue1.setBounds(650, 225, 37, 50);

        this.add(origin1x);
        origin1x.setBounds(550, 300, 37, 50);

        this.add(origin1y);
        origin1y.setBounds(600, 300, 37, 50);

        this.add(origin1z);
        origin1z.setBounds(650, 300, 37, 50);

        this.add(radius1);
        radius1.setBounds(950, 225, 37, 50);

        this.add(sphere1x);
        sphere1x.setBounds(900, 300, 37, 50);

        this.add(sphere1y);
        sphere1y.setBounds(950, 300, 37, 50);

        this.add(sphere1z);
        sphere1z.setBounds(1000, 300, 37, 50);

<<<<<<< HEAD
        this.add(ValidateALL);
        ValidateALL.setBounds(800,450,200,75);
        Border lineborderValidate = BorderFactory.createLineBorder(Color.GRAY, 1); 
        ValidateALL.setBorder(lineborderValidate);
        
=======
        
        
        // COMBOBOX
        /*
        PanelComboBoxLight = new JPanel();
        comboBoxLight = new JComboBox (lightName);
        comboBoxLight.addActionListener(this);
        PanelComboBoxLight.add(comboBoxLight);
        PanelComboBoxLight.setBounds(450, 125, 140, 50);
        this.add(PanelComboBoxLight);

        PanelComboBoxSphere = new JPanel();
        comboBoxSphere = new JComboBox(sphereName);
        comboBoxSphere.addActionListener(this);
        PanelComboBoxSphere.add(comboBoxSphere);
        PanelComboBoxSphere.setBounds(850, 125, 140, 50);
        this.add(PanelComboBoxSphere);
>>>>>>> 5b199bfc15cbbdc7fc17d04a450a9f8274f398d2

        // final JComboBox<String> material = new JComboBox<String>(Materials1);
        // material.setVisible(true);
        // Interface.add(material);

<<<<<<< HEAD
=======

        */

>>>>>>> 5b199bfc15cbbdc7fc17d04a450a9f8274f398d2
        this.add(Interface);
        // this.setContentPane(Interface);
        this.setVisible(true);

    }
<<<<<<< HEAD
    
    
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
            c = new Camera(centreImg,focalDistance,extentX,resolutionX, extentY,resolutionY);
            // When the camera has been created, we delete the informations written in the JTextFields
            Jresolutionx.setText("");
            Jresolutiony.setText("");
            JfocalDistance.setText("");
            JcentreImgX.setText("");
            JcentreImgY.setText("");
            JcentreImgZ.setText("");
            JextentXx.setText("");
            JextentXy.setText("");
            JextentXz.setText("");
            JextentYx.setText("");s
            JextentYy.setText("");
            JextentYz.setText("");
            JextentYx.setText("");
            JextentYy.setText("");
            JextentYz.setText("");
            
            //Camera c= new Camera(resolutionX, d);
=======
    // choix de la sphere : radius, materiau, centre avec bouton Add et Remove
    // a cote affichage de la scene 2D
    
    // zone pour afficher bmp file
    // blablaba
    
   

    public void actionPerformed (ActionEvent e){ 
        if (e.getSource() == comboBoxLight) {
            // faire en sorte d'afficher les attributs de chaque light quand on clique sur le nom correspondant
            int n = comboBoxLight.getSelectedIndex();
            if (n!= (comboBoxLight.getItemCount()-1)) {
                /*Red1.setText(Light[n].Color.); ?? JE SAIS PAS COMMENT FAIRE AVEC LES COULEURS
                Green1.setText("");
                Blue1.setText("");
                origin1x.setText("");
                origin1y.setText("");
                origin1z.setText("");*/
                // AFFICHER LES ATTRIBUTS 
            }
        }
        
        if (e.getSource() == comboBoxSphere) {
            // faire en sorte d'afficher les attributs de chaque sphere quand on clique sur le nom correspondant
            int n = comboBoxSphere.getSelectedIndex();
            if (n!= (comboBoxSphere.getItemCount()-1)) {
                sphere1x.setText(Sphere[n].center.x);
                sphere1y.setText(Sphere[n].center.y);
                sphere1z.setText(Sphere[n].center.z);
                radius1.setText(Sphere[n].radius));          
            }
>>>>>>> 5b199bfc15cbbdc7fc17d04a450a9f8274f398d2

        }

        
        if((e.getSource()== ValidateCamera)&&(verifINT(Jresolutionx.getText()))&&(verifINT(Jresolutiony.getText()))&&(verifINT(JfocalDistance.getText()))&&(verifDOUBLE(JextentXy.getText()))&&(verifDOUBLE(JextentXx.getText()))&&(verifDOUBLE(JextentXz.getText()))&&(verifDOUBLE(JextentYx.getText()))&&((verifDOUBLE(JextentYy.getText())))&&(verifDOUBLE(JextentYz.getText()))&&(verifDOUBLE(JcentreImgX.getText()))&&(verifDOUBLE(JcentreImgY.getText()))&&(verifDOUBLE(JcentreImgZ.getText()))){
            int resolutionX = Integer.parseInt(Jresolutionx.getText()) ;
            int resolutionY = Integer.parseInt(Jresolutiony.getText());
            int focalDistance= Integer.parseInt(JfocalDistance.getText());
            Point centreImg = new Point (Double.parseDouble(JcentreImgX.getText()),Double.parseDouble(JcentreImgY.getText()), Double.parseDouble(JcentreImgZ.getText()) );
            Vector extentX = new Vector (Double.parseDouble(JextentXx.getText()),Double.parseDouble(JextentXy.getText()), Double.parseDouble(JextentXz.getText()) );
            Vector extentY = new Vector (Double.parseDouble(JextentYx.getText()),Double.parseDouble(JextentYy.getText()), Double.parseDouble(JextentYz.getText()) );
            this.c = new Camera(centreImg,focalDistance,extentX,resolutionX, extentY,resolutionY);
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
        }
        
        if ((e.getSource()==ValidateLight1)&&(verifINT(Red1.getText()))&&(verifINT(Green1.getText()))&&verifINT(Blue1.getText())&&(verifDOUBLE(origin1x.getText()))&&(verifDOUBLE(origin1y.getText()))&&(verifDOUBLE(origin1z.getText()))){
<<<<<<< HEAD
            Point origin1 = new Point (Double.parseDouble(origin1x.getText()),Double.parseDouble(origin1y.getText()), Double.parseDouble(origin1z.getText()));
            Color i1= new Color (Integer.parseInt(Red1.getText()),Integer.parseInt(Green1.getText()),Integer.parseInt(Blue1.getText()));
            Light FirstLight = new Light(origin1, i1);
            //When the camera has been created, we delete the informations written in the JtextField
=======
            Point origin1 = new Point(Double.parseDouble(origin1x.getText()),Double.parseDouble(origin1y.getText()), Double.parseDouble(origin1z.getText()));
            ColorFloat i1= new ColorFloat(Double.parseDouble(Red1.getText()), Double.parseDouble(Green1.getText()), Double.parseDouble(Blue1.getText()));
            Light firstLight = new Light(origin1, i1);

            //We delete the informations written the informations written in the JtextField
>>>>>>> 5b199bfc15cbbdc7fc17d04a450a9f8274f398d2
            Red1.setText("");
            Green1.setText("");
            Blue1.setText("");
            origin1x.setText("");
            origin1y.setText("");
            origin1z.setText("");
            if (comboBoxLight.getSelectedItem()== "create a new light"){ //Si le combobox est sur l'item "create a new light", on rajoute une nouvelle light au combobox, et on crée une nouvelle light
                int index = comboBoxLight.getItemCount() -1;
                lights.add(firstLight);
                comboBoxLight.insertItemAt("light "+index+ " ", index);
            }else{
                displayMessage("Warning ! Each element of the Light has to be completed to add the light in the scene.");
            }  
        }
    
        if(e.getSource()==ValidateSphere1){

            Point pointFirstSphere= new Point (Double.parseDouble(sphere1x.getText()),Double.parseDouble(sphere1y.getText()), Double.parseDouble(sphere1z.getText()));
            Double RadiusFirstSphere = new Double (Double.parseDouble(radius1.getText()));
<<<<<<< HEAD
            Material MaterialThirdSphere=new MaterialBlack();
            Sphere Sphere1 = new Sphere(pointFirstSphere , RadiusFirstSphere, MaterialThirdSphere);
            // When the spehere is add to the Linkedlist, we delete what is written in the JTextField
=======
            Sphere Sphere1 = new Sphere(pointFirstSphere , RadiusFirstSphere, black);
            spheres.add(Sphere1);
            //comboBoxSphere.addItem("sphere 1");
            //faire boucle pour que ça marche à chaque fois
>>>>>>> 5b199bfc15cbbdc7fc17d04a450a9f8274f398d2
            sphere1x.setText("");
            sphere1y.setText("");
            sphere1z.setText("");
            radius1.setText("");
            spheres.add(Sphere1);
            if (comboBoxSphere.getSelectedItem()== "create a new sphere"){//Si le combobox est sur l'item "create a new sphere", on rajoute une nouvelle sphere au combobox, et on crée une nouvelle sphere
                int index = comboBoxSphere.getItemCount() -1;
                spheres.add(Sphere1);
                comboBoxSphere.insertItem("sphere "+index+ " ", index);
            }
        }
        
        if(e.getSource()==DeleteCamera){
            //essayer de choper quelle camera c'est pour la supprimer de la lsite
        
        }
        
        if(e.getSource()==DeleteLight){ 
            // supprime light selectionnée si on n'est pas sur l'option "create a new light"
            int index = comboBoxLight.getSelectedIndex();
            if (index!= comboBoxLight.getItemCount()-1){
                comboBoxLight.removeItemAt(index);
                lights.remove(index);
                LightSetNil(); //on se remet sur l'onglet "create a new light" avec les cases vides
            }
        }

        if(e.getSource()==DeleteSphere){
            // supprime sphere selectionnée si on n'est pas sur l'option "create a new sphere"
            int index = comboBoxSphere.getSelectedIndex();
            if (index!= comboBoxSphere.getItemCount()-1){
                comboBoxSphere.removeItemAt(index);
                spheres.remove(index);
                SphereSetNil(); //on se remet sur l'onglet "create a new Sphere" avec les cases vides
            }
        }


        if(e.getSource()==ValidateScene){
            if(!(c==null) && !spheres.isEmpty() && !lights.isEmpty()){
                launchRayRendering(spheres, lights, c);
            }else{
                displayMessage("The scene has to contain a camera and at least one sphere and one light to launch the computation of the final image");
            }
            
        }

        //PB avec les colors à regler
        //lancement d'1 calcul
        // voir pour add les remove button 


    }

    public void displayMessage(String s) {
        JOptionPane.showMessageDialog(null, s);
    }

    public void launchRayRendering(ArrayList<Sphere> spheres, ArrayList<Light> lights, Camera c) {
        Scene s = new Scene(spheres, c, lights);
        RayRendering r = new RayRendering(s);
        try {
            r.createImage();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // Method to verify that characters have been put in the JTextfield
    public boolean verifSeaisi(String Averifier) {
        if (Averifier.length() == 0) {
            return false;
        } else {
            return true;
        }
    }

<<<<<<< HEAD
    // Method to verify that the characters that have been enter are integers
    public boolean verifINT (String Averifier){
   
=======
    // Method to verify that the characters are integers
    public boolean verifINT(String Averifier) {
>>>>>>> 5b199bfc15cbbdc7fc17d04a450a9f8274f398d2
        boolean isINT = true;
        if (Averifier.length() == 0) {
            return false;
        }
        for (int i = 0; i < Averifier.length(); i++) {
            if (!Character.isDigit(Averifier.charAt(i))) {
                return false;
            }
        }
        return isINT;
    }

<<<<<<< HEAD
        if (Averifier.length() == 0){ //We verify that the string is not empty
=======
    public boolean verifDOUBLE(String Averifier) {
        boolean isDOUBLE = true;
        if (Averifier.length() == 0) { // Verify that the string is not empty
>>>>>>> 5b199bfc15cbbdc7fc17d04a450a9f8274f398d2
            return false;
        }
        try {
            Double.parseDouble(Averifier);
        } catch (NumberFormatException e) {
            return false;
        }
        return isDOUBLE;
    }
    
    public void LightSetNil(){
        comboBoxLight.setSelectedIndex(comboBoxLight.getItemCount-1);
        Red1.setText("");
        Green1.setText("");
        Blue1.setText("");
        origin1x.setText("");
        origin1y.setText("");
        origin1z.setText("");

    }
    public void SphereSetNil(){
        comboBoxSphere.setSelectedIndex(comboBoxSphere.getItemCount-1);
        sphere1x.setText("");
        sphere1y.setText("");
        sphere1z.setText("");
        radius1.setText("");

    }
    
}
