/**
 *
 */
package view;

/**
 * @author iwitt01si
 */

import config.Properties;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;

public class Startscreen_Panel extends JPanel {

    Image image;

    /**
     * Create the panel.
     */
    public Startscreen_Panel(Properties properties) {
        try {
            String imageName = properties.getRessourcesPath() + FileSystems.getDefault().getSeparator() + "Startbildschirm.png";
            System.out.println(imageName);

            image = ImageIO.read(new File(imageName));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void paint(Graphics g) {
        int wp = image.getWidth(null);
        int width = getWidth();
        int height = image.getHeight(null) * width / wp;
        g.drawImage(image, 0, 0, width, height, null);
    }

}