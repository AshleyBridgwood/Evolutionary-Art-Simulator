/**
 * @author Ibrahim Farah
 */

package view;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{

    private BufferedImage image;

    public ImagePanel(String filename) {
       try {                
			image = ImageIO.read(new File(filename));
            //Graphics g1 = image.createGraphics(); //working up to here
           // paintComponent(g1);


       } catch (IOException ex) {
            // handle exception...
       }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);           
        repaint();
    }


}