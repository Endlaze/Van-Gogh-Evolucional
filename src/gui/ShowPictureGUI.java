package gui;


import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.image.BufferedImage;

public class ShowPictureGUI {

     JLabel label;
    JFrame frame;
    ImageIcon icon;

    public void showPicture(BufferedImage image){
        frame = new JFrame();
        icon = new ImageIcon(image);
        label = new JLabel(icon);
        frame.add(label);
        frame.setDefaultCloseOperation
                (JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public void  updatePicture(BufferedImage image){
        icon.getImage().flush();
        icon = new ImageIcon(image);
        label.setIcon( icon );
    }
}
