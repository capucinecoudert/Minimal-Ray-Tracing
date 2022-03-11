import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

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
         ValidateCamera.addActionListener(this);


    public Interface (){

       

        //camera's definition






    }
public class Interface {
    // Choix de la scene : width, height
    // choix  de la sphere : radius, materiau, centre avec bouton Add et Remove
    // a cote affichage de la scene 2D 
    // bouton calculer img
    // zone pour afficher bmp file
    // blzblaba
    
    public void actionPerformed (ActionEvent e){
        if((e.getSource()== ValidateCamera)&&(verifINT(Jresolutionx.getText()))&&(verifINT(Jresolutiony.getText()))&&verifINT(JfocalDistance.getText())){
            int resolutionX = Integer.parseInt(Jresolutionx.getText()) ;
            int resolutionY = Integer.parseInt(Jresolutiony.getText());
            int focalDistance= Integer.parseInt(JfocalDistance.getText());
            Point centreImg = new Point (Double.parseDouble(JcentreImgX.getText()),Double.parseDouble(JcentreImgY.getText()), Double.parseDouble(JcentreImgZ.getText()) );
            Vector extentX = new Vector (Double.parseDouble(JextentXx.getText()),Double.parseDouble(JextentXy.getText()), Double.parseDouble(JextentXz.getText()) );
            Vector extentY = new Vector (Double.parseDouble(JextentYx.getText()),Double.parseDouble(JextentYy.getText()), Double.parseDouble(JextentYz.getText()) );
            Camera c= new Camera(resolutionX, d)

        }


    }
    // Method to verify that the characters have been put in the JTextfield
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
