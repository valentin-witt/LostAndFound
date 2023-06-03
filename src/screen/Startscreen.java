package screen;

import config.Properties;
import config.PropertiesReader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.FileSystems;

public class Startscreen {

    private final static String PATH_TO_PROPERTIES = "/Users/valentinwitt/Documents/15_Coding/01_Java/LostAndFound/properties.json";
    public static Startscreen startscreen;
    public JFrame frame;

    /**
     * Create the application.
     */
    public Startscreen(Properties properties) {
        initialize(properties);
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        // Initialize reader, read properties file and parse json content to POJO Properties
        PropertiesReader reader = new PropertiesReader();
        Properties properties = reader.readPropertiesFile(PATH_TO_PROPERTIES);

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    startscreen = new Startscreen(properties);
                    startscreen.getFrame().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize(Properties properties) {
        // Initialize reader, read properties file and parse json content to POJO Properties
        String separator = FileSystems.getDefault().getSeparator();
        String imageName = properties.getRessourcesPath() + separator + "Logo_neu.jpg";

        frame = new JFrame();
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(imageName));
        frame.setTitle("Das vierte Fragezeichen ?");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JButton btnStartGame = new JButton("Spiel starten");
        btnStartGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Playscreen.playscreen = new Playscreen(properties);
                Playscreen.playscreen.frame.setVisible(true);
                frame.setVisible(false);
            }
        });
        frame.getContentPane().setLayout(new BorderLayout(0, 0));
        frame.getContentPane().add(btnStartGame, BorderLayout.SOUTH);

        Startscreen_Panel panel = new Startscreen_Panel(properties);
        frame.getContentPane().add(panel, BorderLayout.CENTER);

    }

    private Component getFrame() {
        return frame;
    }

}

