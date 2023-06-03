package view;

import config.Properties;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;

public class Endscreen_Panel extends JPanel {

    Image image;

    /**
     * Create the panel.
     */
    public Endscreen_Panel(Properties properties) {
        try {
            String imageName = properties.getRessourcesPath() + FileSystems.getDefault().getSeparator() + "Schlussbildschirm.png";
            System.out.println(imageName);

            image = ImageIO.read(new File(imageName));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public void paint(Graphics g) {
        int wp = image.getWidth(null);
        int w = getWidth();
        int h = image.getHeight(null) * w / wp;
        g.drawImage(image, 0, 0, w, h, null);
    }

}
