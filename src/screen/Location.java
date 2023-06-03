/**
 *
 */
package screen;

import config.Properties;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;

/**
 * @author iwitt01si
 */
public class Location {
    Image image;
    int x0, y0, w, h;
    boolean isSelected;
    String name;

    public Location(Properties properties, int locationX0, int locationY0, int locationX1, int locationY1, String name) {
        // TODO Auto-generated constructor stub
        this.x0 = locationX0;
        this.y0 = locationY0;
        this.w = locationX1 - locationX0;
        this.h = locationY1 - locationY0;
        this.name = name;
    }

    public boolean ishit(int x, int y) {
        boolean hit = false;
        if (x > x0 && y > y0 && x < x0 + w && y < y0 + h) {
            hit = true;
            isSelected = hit;

        }

        return hit;
    }

    Image loadBild(Properties properties, String name) {
        Image image = null;
        try {
            String imageName = properties.getRessourcesPath() + FileSystems.getDefault().getSeparator() + name;
            System.out.println(imageName);

            image = ImageIO.read(new File(imageName));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return image;
    }

    public void draw(Graphics2D g) {
        // TODO Auto-generated method stub
        //g.setStroke(BasicStroke.CAP_ROUND);
        g.setColor(Color.green);

        if (image != null)
            g.drawImage(image, x0, y0, w, h, null);
        if (isSelected)
            g.drawRect(x0, y0, w, h);
        g.drawString(name, x0 + 10, y0 + 20);
    }
}


