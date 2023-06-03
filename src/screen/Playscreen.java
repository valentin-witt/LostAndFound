package screen;

import config.Properties;
import config.PropertiesReader;

import javax.swing.*;
import java.awt.*;
import java.nio.file.FileSystems;

public class Playscreen {

    private final static String PATH_TO_PROPERTIES = "/Users/valentinwitt/Documents/15_Coding/01_Java/LostAndFound/properties.json";
    public static Playscreen playscreen;
    public JFrame frame;

    /**
     * Create the application.
     */
    public Playscreen() {
        initialize();
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    playscreen = new Playscreen();
                    playscreen.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        // Initialize reader, read properties file and parse json content to POJO Properties
        PropertiesReader reader = new PropertiesReader();
        String separator = FileSystems.getDefault().getSeparator();
        Properties properties = reader.readPropertiesFile(PATH_TO_PROPERTIES);
        String imageName = properties.getRessourcesPath() + separator + "Logo_neu.jpg";

        frame = new JFrame();
        frame.setTitle("Das vierte Fragezeichen ?");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));
        Playscreen_Panel panel = new Playscreen_Panel(properties);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setBounds(100, 100, panel.getimg().getWidth(null), panel.getimg().getHeight(null));
    }

    public JFrame getFrame() {
        return frame;
    }
}
