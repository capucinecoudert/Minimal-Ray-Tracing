import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import java.lang.System;

public class InterfaceBasic extends JFrame{

    JLabel b ; //title
    JLabel image; //final image

    public InterfaceBasic(){
        super("Minimal Ray Tracing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1050, 1000);
        this.setLayout(null);

        this.b= new JLabel("FINAL IMAGE");
        this.add(this.b);
        this.b.setFont(new Font("Serif", Font.BOLD, 40));
        this.b.setOpaque(true);
        this.b.setForeground(Color.DARK_GRAY);
        this.b.setBounds(350, 0, 300, 100);
        this.b.setAlignmentX(CENTER_ALIGNMENT);
        this.b.setHorizontalAlignment(SwingConstants.CENTER); 
        this.add(this.b);

        this.image = new JLabel();
        this.image.setBounds(100, 100, 800, 600);
        this.image.setHorizontalAlignment(SwingConstants.CENTER); 
        this.image.setAlignmentX(CENTER_ALIGNMENT);
        this.add(this.image);
        
        try { //Gets the image created by the program and displays it
            String path = System.getProperty("user.dir") +"\\output.bmp";
            BufferedImage myPicture = ImageIO.read(new File(path));
            ImageIcon imgIc = new ImageIcon(myPicture);
            this.image.setIcon(imgIc);
        } catch (IOException a) {
            a.printStackTrace();
        }

        this.setVisible(true);
    }
}
