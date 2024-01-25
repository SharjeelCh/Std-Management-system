package SMS;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Splash extends JFrame {
    public Splash() {
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/Splash.jpg"));        //imageicon class ka object bnate hain
       Image i2=i1.getImage().getScaledInstance(1000,700,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);                                                             // bc we cannt pass image directly into jlabel
       JLabel img=new JLabel(i3);
       add(img);                       // places the image on frame

        setVisible(true);
        setLocation(250, 50);            //changers location of frame
        setSize(1000, 700);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        new Login();
        Splash.this.dispose();

    }
}
