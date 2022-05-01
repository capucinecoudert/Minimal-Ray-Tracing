import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;
import java.io.IOException;
import java.awt.BorderLayout;
import javax.swing.border.Border;

public class InterfaceEdition extends JFrame implements ActionListener, ListSelectionListener {
    // attributes for the camera's definition
    public Material black;
    public Material white;
    public Material green;
    public Material cyan;
    public Material red;
    public Material magenta;
    public Material yellow;
    public Material blue;
    public JComboBox<String> comboBoxMaterial;
    
    public Camera c;
    public ArrayList<Sphere> spheres;
    public ArrayList<Light> lights; 

    //Camera definition
    public JTextField Jresolutionx;
    public JTextField Jresolutiony;
    public JTextField JfocalDistance;
    public JTextField JcentreImgX;
    public JTextField JcentreImgY;
    public JTextField JcentreImgZ;
    public JTextField JextentXx;
    public JTextField JextentXy;
    public JTextField JextentXz;
    public JTextField JextentYx; 
    public JTextField JextentYy;
    public JTextField JextentYz;

    // Light definition
    public JTextField origin1x; 
    public JTextField origin1y;
    public JTextField origin1z;
    public JTextField Red1; 
    public JTextField Green1;
    public JTextField Blue1;

   //Sphere definition
    public JTextField radius1;
    public JTextField sphere1x;
    public JTextField sphere1y;
    public JTextField sphere1z;

    //Validate and Delete buttons
    public JButton ValidateCamera; 
    public JButton DeleteCamera;
    public JButton ValidateLight1;
    public JButton DeleteLight;
    public JButton ValidateSphere1;
    public JButton DeleteSphere;
    public JButton ValidateScene;

    //List for spheres
    /*public JList sphereList;
    public DefaultListModel sphereListModel;
    public JButton addSphereButton;
    public JTextField sphereName;

    //List for lights
    public JList lightList;
    public DefaultListModel  lightListModel;
    public JButton addLightButton;
    public JTextField lightName;

    //A RAJOUTER DANS LE READ ME SI ON AJOUTE LES LIST FOR LIGHT ET SPHERE : + sphereList : JList
        + sphereListModel : DefaultListModel
        + addSphereButton : JButton
        + sphereName : JTextField

        + lightList : JList 
        + lightListModel : DefaultListModel
        + addLightButton : JButton
        + lightName : JTextField
    */
    
    public InterfaceEdition() {
        // Initialization of the window
        super("Minimal Ray Tracing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1050, 1000);
        this.setLayout(null);
        JPanel Interface = new JPanel();
        Interface.setBounds(0, 0, 1100, 800);

        // Initialization of a reference scene
        this.initScene();

        // Setting of all the buttons ad texts of the window
        this.createIHM();

        //Display the elements of the reference scene 
        cameraToInterface();
        lightToInterface(0);
        sphereToInterface(0);

        this.add(Interface);
        this.setVisible(true);
    }

    public void actionPerformed (ActionEvent e){ //Deals with the different actions to do when clicking on a button
        //When clicking on ValidateCamera, update the values of the Camera c and reset the buttons
        if(e.getSource()== ValidateCamera){
            if(isCameraValid()){
                interfaceToCamera();
                resetCamera();
                displayMessage("The camera has been successfully added to the scene.");
            }else{
                displayMessage("The camera can't be validated. Please check the values you have entered.");
            }
        }
        // When clicking on DeleteCamera, set the Camera c to a null object
        if(e.getSource()==DeleteCamera){
            resetCamera();
            c=null;
            displayMessage("The camera has been deleted. You can add a new one.");
        }
        //Update the first light of the arraylist lights with the values entered by the user
        if(e.getSource()==ValidateLight1){  
            if (isLightValid()){
                interfaceToLight(0);
                resetLight();
                displayMessage("The light has been successfully added to the scene.");
            }else{
                displayMessage("The light can't be validated. Please check the values you have entered.");
            }
        }  
        //Update the first sphere of the arraylist spheres with the values entered by the user
        if(e.getSource()==ValidateSphere1){
            if (isSphereValid()){
                interfaceToSphere(0);
                resetSphere();
                displayMessage("The sphere has been successfully added to the scene.");
            }else{
                displayMessage("The sphere can't be validated. Please check the values you have entered.");
            }  
        }
        //Call the lauchRayRendering() function 
        if(e.getSource()==ValidateScene){
            if(isSceneValid()){
                launchRayRendering(this.spheres, this.lights, this.c);
            }else{
                displayMessage("The scene has to contain a camera and at least one sphere and one light to launch the computation of the final image");
            }
        }
    }

    public void initScene() { //Definition of a reference scene
        this.initializeMaterials();
        // Spheres
        this.spheres = new ArrayList<Sphere>();
        spheres.add(new Sphere(new Point(0, 0, 500.0), 100.0, this.white));
        spheres.add(new Sphere(new Point(150, 0, 400.0), 30.0, this.red ));
        spheres.add(new Sphere(new Point(100, -100, 400.0), 40.0, this.blue ));

        // lights
        this.lights= new ArrayList<Light>();
        lights.add(new Light(new Point(250, 0, 300), new ColorFloat(0.4, 0.4, 0))); // lumiere cote droit jaune
        lights.add(new Light(new Point(0, 200, 0), new ColorFloat(0.6, 0.6, 0.6))); // lumiere face grise
            
        // camera
        Point pointOrigin= new Point(0,0,0);
        int distanceFocale= 100;
        Vector vX= new Vector(new Point(0, 0, 0), new Point(80, 0, 0));
        int rX= 800;
        Vector vY= new Vector(new Point(0, 0, 0), new Point(0, 60, 0));
        int rY= 600;
        this.c = new Camera(pointOrigin, distanceFocale, vX, rX, vY, rY);
    }

    //Method to displaay a message window
    public void displayMessage(String s) {
        JOptionPane.showMessageDialog(null,  s);
    }

    //Create a RayRendering object, compute its image and call the InterfaceBasic to display it
    public void launchRayRendering(ArrayList<Sphere> sp, ArrayList<Light> l, Camera ca) {
        Scene s = new Scene(sp, ca, l);
        RayRendering r = new RayRendering(s);
        try {
            r.createImage();
            InterfaceBasic Image =new InterfaceBasic();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to verify that characters have been put in the JTextfield
    public boolean verifSaisie(String Averifier) {
        if (Averifier.length() == 0) {
            return false;
        } else {
            return true;
        }
    }

    // Method to verify that the characters are integers
    public boolean verifINT(String Averifier) {
        if (Averifier.length() == 0) {
            return false;
        }
        for (int i = 0; i < Averifier.length(); i++) {
            if (!Character.isDigit(Averifier.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    //Method to verify the user entered a value and if yes that it's a double
    public boolean verifDOUBLE(String Averifier) {
        boolean isDOUBLE = true;
        if (Averifier.length() == 0) { // Verify that the string is not empty
            return false;
        }
        try {
            Double.parseDouble(Averifier);
        } catch (NumberFormatException e) {
            return false;
        }
        return isDOUBLE;
    }
    
    //method that associates the selected material in a combo box to a Material element
    public Material comboToMaterial (String selected){
        if( selected == "red"){return red;
        }else if( selected == "cyan"){
            return cyan;
        }else if( selected == "blue"){
            return blue;
        }else if( selected == "black"){
            return black;
        }else if( selected == "white"){
            return white;
        }else if( selected == "magenta"){
            return magenta;
        }else if ( selected == "yellow"){
            return yellow;
        }else if ( selected == "green"){
            return green;
        }
        return red;
    }

    // method that returns the index of the associated Material in the ComboBox of the interface
    public int materialToCombo( Material m){ 
        if( m == this.red){return 5;
        }else if( m == this.cyan){
            return 2;
        }else if( m == this.blue){
            return 1;
        }else if( m == this.black){
            return 0;
        }else if( m == this.white){
            return 6;
        }else if( m == this.magenta){
            return 4;
        }else if ( m == this.yellow){
            return 7;
        }else if ( m == this.green){
            return 3;
        }
        return 5;
    }
    
    //Reset the Camera values
    public void resetCamera(){
        Jresolutionx.setText("0");
        Jresolutiony.setText("0");
        JfocalDistance.setText("0");
        JcentreImgX.setText("0");
        JcentreImgY.setText("0");
        JcentreImgZ.setText("0");
        JextentXx.setText("0");
        JextentXy.setText("0");
        JextentXz.setText("0");
        JextentYx.setText("0");
        JextentYy.setText("0");
        JextentYz.setText("0");
    }

    // method that takes the values entered in the interface and update the Camera c with it
    public void interfaceToCamera(){
        int rX = Integer.parseInt(Jresolutionx.getText()) ;
        int rY = Integer.parseInt(Jresolutiony.getText());
        int d = Integer.parseInt(JfocalDistance.getText());
        Point centre = new Point (Double.parseDouble(JcentreImgX.getText()),Double.parseDouble(JcentreImgY.getText()), Double.parseDouble(JcentreImgZ.getText()) );
        Vector vX = new Vector (Double.parseDouble(JextentXx.getText()),Double.parseDouble(JextentXy.getText()), Double.parseDouble(JextentXz.getText()) );
        Vector vY = new Vector (Double.parseDouble(JextentYx.getText()),Double.parseDouble(JextentYy.getText()), Double.parseDouble(JextentYz.getText()) );
        this.c= new Camera(centre, d, vX, rX, vY, rY);
    }

    public void cameraToInterface(){
        Jresolutionx.setText(String.valueOf(this.c.resolutionX));
        Jresolutiony.setText(String.valueOf(this.c.resolutionY));
        JfocalDistance.setText(String.valueOf(this.c.focalDistance));
        JcentreImgX.setText(String.valueOf(this.c.centreImg.x));
        JcentreImgY.setText(String.valueOf(this.c.centreImg.y));
        JcentreImgZ.setText(String.valueOf(this.c.centreImg.z));
        JextentXx.setText(String.valueOf(this.c.extentX.x));
        JextentXy.setText(String.valueOf(this.c.extentX.y));
        JextentXz.setText(String.valueOf(this.c.extentX.z));
        JextentYx.setText(String.valueOf(this.c.extentY.x));
        JextentYy.setText(String.valueOf(this.c.extentY.y));
        JextentYz.setText(String.valueOf(this.c.extentY.z));
    }

    //Reset the light values on interface
    public void resetLight(){
        Red1.setText("0");
        Green1.setText("0");
        Blue1.setText("0");
        origin1x.setText("0");
        origin1y.setText("0");
        origin1z.setText("0");
    }

    //Write the values of the Light l (at position i in lights) in the interface
    public void lightToInterface(int i){
        Light l= lights.get(i);
        Red1.setText(String.valueOf((int)(l.intensity.red*255)));
        Green1.setText(String.valueOf((int)(l.intensity.green*255)));
        Blue1.setText(String.valueOf((int)(l.intensity.blue*255)));
        origin1x.setText(String.valueOf(l.origin.x));
        origin1y.setText(String.valueOf(l.origin.y));
        origin1z.setText(String.valueOf(l.origin.z));
    }

    // method that takes the values entered in the interface and update the Light l  at position j in lights with it
    public void interfaceToLight(int j){
        Point origin1 = new Point(Double.parseDouble(origin1x.getText()),Double.parseDouble(origin1y.getText()), Double.parseDouble(origin1z.getText()));
        ColorInt i1= new ColorInt(Integer.parseInt(Red1.getText()),Integer.parseInt(Green1.getText()), Integer.parseInt(Blue1.getText()));
        ColorFloat i= i1.intToColor();
        Light firstLight = new Light(origin1, i);
        lights.set(j,firstLight);
    }

    // resets the values of the sphere in the interface
    public void resetSphere(){
        sphere1x.setText("0");
        sphere1y.setText("0");
        sphere1z.setText("0");
        radius1.setText("0");
    }

    //Write the values of the Sphere s (at position i in spheres) in the interface 
    public void sphereToInterface(int i){
        Sphere s= spheres.get(i);
        sphere1x.setText(String.valueOf(s.center.x));
        sphere1y.setText(String.valueOf(s.center.y));
        sphere1z.setText(String.valueOf(s.center.z));
        radius1.setText(String.valueOf(s.radius));
        comboBoxMaterial.setSelectedIndex(materialToCombo(s.material));
    }

    // method that takes the values entered in the interface and update the Sphere s  at position i in spheres with it
    public void interfaceToSphere(int i){
        Point pointFirstSphere= new Point(Double.parseDouble(sphere1x.getText()),Double.parseDouble(sphere1y.getText()), Double.parseDouble(sphere1z.getText()));
        double RadiusFirstSphere = Double.parseDouble(radius1.getText());
        Material m = comboToMaterial(comboBoxMaterial.getSelectedItem().toString());
        Sphere Sphere1 = new Sphere(pointFirstSphere , RadiusFirstSphere, m);
        spheres.set(i,Sphere1);
    }

    // checks the values entered by user are correct for the camera
    public boolean isCameraValid(){
        return verifINT(Jresolutionx.getText())
                &&(verifINT(Jresolutiony.getText()))
                &&(verifINT(JfocalDistance.getText()))
                &&(verifDOUBLE(JextentXy.getText()))
                &&(verifDOUBLE(JextentXx.getText()))
                &&(verifDOUBLE(JextentXz.getText()))
                &&(verifDOUBLE(JextentYx.getText()))
                &&((verifDOUBLE(JextentYy.getText())))
                &&(verifDOUBLE(JextentYz.getText()))
                &&(verifDOUBLE(JcentreImgX.getText()))
                &&(verifDOUBLE(JcentreImgY.getText()))
                &&(verifDOUBLE(JcentreImgZ.getText()));
    }

    // checks the values entered by user are correct for the light
    public boolean isLightValid(){
        String r= Red1.getText();
        String g= Green1.getText();
        String b = Blue1.getText();
        return (verifINT(r)
                &&verifINT(g)
                &&verifINT(b)
                &&checkRGBvalue(r)
                && checkRGBvalue(g)
                && checkRGBvalue(b)
                &&verifDOUBLE(origin1x.getText())
                &&verifDOUBLE(origin1y.getText())
                &&verifDOUBLE(origin1z.getText()));
    }

    //Check the value entered is between 0-255
    public boolean checkRGBvalue(String s){
        int i = Integer.parseInt(s);
        return (i/255 <= 1 && i>= 0);
    }

    // checks the values entered by user are correct for the sphere
    public boolean isSphereValid(){
        return (verifDOUBLE(radius1.getText())
                && verifDOUBLE(sphere1x.getText())
                && verifDOUBLE(sphere1y.getText())
                && verifDOUBLE(sphere1z.getText()));
    }

    // checks the values entered by user are correct for the scene
    public boolean isSceneValid(){
        return (!(c==null) && !spheres.isEmpty() && !lights.isEmpty());
    }

    // initializes the material of the scene
    public void initializeMaterials(){
        this.white= new Material(0.0, 1.0, new ColorFloat(1, 1, 1) );
        this.red = new Material(0.5, 0.5, new ColorFloat(1.0, 0.0, 0));
        this.black = new Material(1.0, 60.0, new ColorFloat(0, 0, 0));
        this.blue = new Material(0.0, 0.5, new ColorFloat(0.0, 0.0, 1.0));
        this.cyan = new Material(0.0, 0.5, new ColorFloat(0.0, 1.0, 1.0));
        this.green = new Material(0.5, 0.5, new ColorFloat(0.0, 1.0, 0.0));
        this.magenta = new Material(0.0, 60, new ColorFloat(1.0, 0.0, 1.0));
        this.yellow = new Material(0.5, 60, new ColorFloat(1.0, 1.0, 0.0));
    }

    // Creates and places all the swing components of the interface
    public void createIHM(){
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

        // Initialization of the JTextField necessary for the definition of the scene
        this.Jresolutionx = new JTextField();
        this.Jresolutiony = new JTextField();
        this.JfocalDistance = new JTextField();
        this.JcentreImgX = new JTextField(); // on a besoin de 3 points cordonnées pour créer le point le centre del'image
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
        
        String[] Materials1 = { "Black", "Blue", "Cyan", "Green", "Magenta", "Red", "White", "Yellow" }; 
        comboBoxMaterial = new JComboBox<>(Materials1); 

        // creation of the camera's definition pan
        JLabel Resolution = new JLabel("Resolution(x,y) :");
        JLabel FocalDistance = new JLabel("Focal distance :");
        JLabel Centre = new JLabel("Image center (x,y,z) :");
        JLabel Vectorx = new JLabel(" Vector Extent x (x,y,z) :");
        JLabel Vectory = new JLabel(" Vector Extent y (x,y,z) :");
        JLabel Camera = new JLabel("Description of the camera");
        Camera.setAlignmentX(CENTER_ALIGNMENT);
        JLabel Scene = new JLabel(" Description of the scene");
        Scene.setAlignmentX(CENTER_ALIGNMENT);
        JLabel Light = new JLabel("Description of the lights");
        Light.setAlignmentX(CENTER_ALIGNMENT);
        JLabel Sphere = new JLabel("Description of the spheres");

        JLabel OriginSphere = new JLabel(" Origin of the light (x,y,z) :");
        JLabel RGBcode = new JLabel("Light Intensity RGB (0-255) :");
        JLabel Radius = new JLabel("Radius of the 1st sphere :");
        JLabel centre = new JLabel("Centre of the 1st Sphere :");
        JLabel material = new JLabel("Material of the sphere :");

        JPanel CAMERA = new JPanel();
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

        this.add(Light);
        Light.setBounds(360, 50, 350, 50);

        this.add(Sphere);
        Sphere.setBounds(710, 50, 350, 50);

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
        DeleteCamera.setBounds(200, 600, 130, 50);

        this.add(RGBcode);
        RGBcode.setBounds(360, 225, 200, 50);

        this.add(OriginSphere);
        OriginSphere.setBounds(360, 300, 150, 50);

        this.add(Radius);
        Radius.setBounds(710, 225, 150, 50);

        this.add(comboBoxMaterial);
        comboBoxMaterial.setBounds(900, 370, 150, 30);

        this.add(material);
        material.setBounds(710, 360, 150, 50);

        this.add(centre);
        centre.setBounds(710, 300, 150, 50);

        this.add(ValidateLight1);
        ValidateLight1.setBounds(370, 600, 130, 50);

        this.add(DeleteLight);
        DeleteLight.setBounds(550, 600, 130, 50);

        this.add(ValidateScene);
        ValidateScene.setBounds(450, 800, 200, 50);

        this.add(ValidateSphere1);
        ValidateSphere1.setBounds(720, 600, 130, 50);

        this.add(DeleteSphere);
        DeleteSphere.setBounds(900, 600, 130, 50);

        // Addition and positioning of JTextFields in the window
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

       /* //Setting Sphere list
        this.sphereListModel = new DefaultListModel();
 
        //Create the list and put it in a scroll pane.
        this.sphereList = new JList(this.sphereListModel);
        this.sphereList .setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.sphereList .setSelectedIndex(0);
        this.sphereList .addListSelectionListener(this);
        this.sphereList .setVisibleRowCount(5);
        JScrollPane listScrollPane = new JScrollPane(this.sphereList );
 

        this.addSphereButton = new JButton("New Sphere");
        this.addSphereButton.setActionCommand("New Sphere");
        this.addSphereButton.addActionListener(new AddSphereListener());

 
        this.sphereName = new JTextField(10);
        this.sphereName.addActionListener(hireListener);
        this.sphereName.getDocument().addDocumentListener(hireListener);
        String name = this.sphereListModel.getElementAt(
                              this.sphereList.getSelectedIndex()).toString();
 
        //Create a panel that uses BoxLayout.
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane,
                                           BoxLayout.LINE_AXIS));
        buttonPane.add(addSphereButton);
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(new JSeparator(SwingConstants.VERTICAL));
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(sphereName);
        buttonPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
 
        add(listScrollPane, BorderLayout.CENTER);
        add(buttonPane, BorderLayout.PAGE_END);
*/
    }
}
