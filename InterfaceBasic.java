import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import java.lang.System;

public class InterfaceBasic extends JFrame{

    JLabel b ;
    JLabel image;

    public InterfaceBasic(){
        super("Minimal Ray Tracing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1050, 1000);
        this.setLayout(null);

        this.b= new JLabel("FINAL IMAGE");
        this.add(this.b);
        this.b.setFont(new Font("Serif", Font.BOLD, 20));
        this.b.setOpaque(true);
        this.b.setForeground(Color.WHITE);
        this.b.setBackground(Color.DARK_GRAY);
        this.b.setBounds(400, 0, 210, 50);
        this.b.setAlignmentX(CENTER_ALIGNMENT);
        this.add(this.b);

        this.image = new JLabel();
        this.image.setBounds(100, 100, 800, 600);
        this.image.setAlignmentX(CENTER_ALIGNMENT);
        this.add(this.image);
        
        try { 
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
