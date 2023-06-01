package Screens;

import Config.Properties;
import Config.PropertiesReader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.FileSystems;

public class Startscreen {

    JFrame frame;

    /**
     * Create the application.
     */
    public Startscreen(Properties properties) {

        String imageName = properties.getRessourcesPath() + FileSystems.getDefault().getSeparator() + "Logo_neu.jpg";

        frame = new JFrame();
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(imageName));
        frame.setTitle("Das vierte Fragezeichen ?");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JButton btnStartGame = new JButton("Spiel starten");
        btnStartGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Playscreen.window = new Playscreen();
                Playscreen.window.frame.setVisible(true);
                frame.setVisible(false);
            }
        });
        frame.getContentPane().setLayout(new BorderLayout(0, 0));
        frame.getContentPane().add(btnStartGame, BorderLayout.SOUTH);

        Startscreen_Panel panel = new Startscreen_Panel(properties);
        frame.getContentPane().add(panel, BorderLayout.CENTER);

    }

}

