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

    private final Properties properties;
    ArrayList<Image> images;
    ArrayList<Location> locations;
    Endscreen endscreen;
    Looserscreen looserscreen;
    private int counterCurrentRiddle = 0;

    private final ActionListener countdownExpired;
    private final Timer countdownTimer;
    private final int countdownTime;

    /**
     * Create the panel.
     */
    public Playscreen_Panel(Properties properties) {
        this.properties = properties;
        images = new ArrayList();
        locations = new ArrayList();

        // CountdownTimer
        countdownTime = properties.getCountdownTime() * 60 * 1000; // Delay in milliseconds

        // Initialize ActionListener to perform task if the countdownTime expires
        countdownExpired = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Looserscreen.looserscreen = new Looserscreen(properties);
                Looserscreen.looserscreen.frame.setVisible(true);
                Playscreen.playscreen.frame.setVisible(false);
                // remove actionListener from timer
                countdownTimer.removeActionListener(countdownExpired);
            }
        };
        countdownTimer = new Timer(countdownTime, countdownExpired);
        countdownTimer.start();

        if (properties.getRiddles() != null) {
            for (Riddle riddle : this.properties.getRiddles()) {
                images.add(loadImage(riddle.getImage()));
                locations.add(new Location(properties, riddle.getLocationX0(), riddle.getLocationY0(), riddle.getLocationX1(), riddle.getLocationY1(), riddle.getName()));
            }
        }
        addMouseListener(this);
    }

    Image loadImage(String name) {
        Image image = null;
        try {
            String imageName = this.properties.getRessourcesPath() + FileSystems.getDefault().getSeparator() + name;
            System.out.println(imageName);

            image = ImageIO.read(new File(imageName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    public void paint(Graphics g) {
        Image image = images.get(counterCurrentRiddle);
        int wp = image.getWidth(null);
        int width = getWidth();
        int height = image.getHeight(null) * width / wp;

        g.drawImage(image, 0, 0, width, height, null);
        //loclist.get(actraetsel).draw((Graphics2D)g);
        for (Location l : locations) {
            //		l.draw((Graphics2D)g);
        }

    }

    public Image getImage() {
        return images.get(counterCurrentRiddle);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("( " + e.getX() + ", " + e.getY() + " )");
        for (Location l : locations) {
            if (l.isHit(e.getX(), e.getY())) {
                System.out.println("Rätsel " + l.name + " " + counterCurrentRiddle);
                nextRiddle(properties);
            } else {
                l.isSelected = false;
                System.out.println("Rätsel wurde nicht gelöst.");
                //	repaint();
            }
        }
    }

    private void nextRiddle(Properties properties) {
        counterCurrentRiddle++;
        if (counterCurrentRiddle >= images.size()) {
            // remove actionListener from timer
            countdownTimer.removeActionListener(countdownExpired);

            counterCurrentRiddle = 0;
            endscreen = new Endscreen(properties);
            endscreen.getFrame().setVisible(true);
            Playscreen.playscreen.frame.setVisible(false);
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
