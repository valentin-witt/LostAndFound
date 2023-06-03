package screen;

/**
 * @author iwitt01si
 */

import config.Properties;
import config.Riddle;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.ArrayList;

public class Playscreen_Panel extends JPanel implements MouseListener, ActionListener {

    ArrayList<Image> images;
    int aktindex = 0;
    ArrayList<Location> locations;
    Endscreen wnd3;
    private int counterCurrentRiddle = 0;

    /**
     * Create the panel.
     */
    public Playscreen_Panel(Properties properties) {
        images = new ArrayList();
        locations = new ArrayList();

        if (properties.getRiddles() != null) {
            for (Riddle riddle : properties.getRiddles()) {
                images.add(loadBild(properties, riddle.getImage()));
                locations.add(new Location(properties, riddle.getLocationX0(), riddle.getLocationY0(), riddle.getLocationX1(), riddle.getLocationY1(), riddle.getName()));
            }
        }
        addMouseListener(this);
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

    public void paint(Graphics g) {
        Image img = images.get(counterCurrentRiddle);
        int wp = img.getWidth(null);
        int w = getWidth();
        int h = img.getHeight(null) * w / wp;

        g.drawImage(img, 0, 0, w, h, null);
        //loclist.get(actraetsel).draw((Graphics2D)g);
        for (Location l : locations) {
            //		l.draw((Graphics2D)g);
        }

    }

    public Image getimg() {
        // TODO Auto-generated method stub

        return images.get(aktindex);
    }

    /**
     * @return the aktindex
     */
    public int getAktindex() {
        return aktindex;
    }

    /**
     * @param aktindex the aktindex to set
     */
    public void setAktindex(int aktindex) {
        this.aktindex = aktindex;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("( " + e.getX() + ", " + e.getY() + " )");
        for (Location l : locations) {
            if (l.ishit(e.getX(), e.getY())) {
                System.out.println("Rätsel " + l.name + " " + counterCurrentRiddle);
                nextraetsel();
            } else {
                l.isSelected = false;
                System.out.println("Rätsel wurde nicht gelöst.");
                //	repaint();
            }
        }
    }

    private void nextraetsel() {
        // TODO Auto-generated method stub
        counterCurrentRiddle++;
        if (counterCurrentRiddle >= images.size()) {
            counterCurrentRiddle = 0;
            wnd3 = new Endscreen();
            wnd3.getFrame().setVisible(true);
            Playscreen.playscreen.frame.setVisible(false);
            //Spielscreen.window.getFrame().setVisible(false);
            //Spielscreen.window.frame.setVisible(false);
        }
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

}
