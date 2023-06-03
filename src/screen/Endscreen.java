package screen;

import config.Properties;
import config.PropertiesReader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.FileSystems;


public class Endscreen {

    private final static String PATH_TO_PROPERTIES = "/Users/valentinwitt/Documents/15_Coding/01_Java/LostAndFound/properties.json";
    static Endscreen endscreen;
    private JFrame frame;

    /**
     * Create the application.
     */
    public Endscreen(Properties properties) {
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
                    endscreen = new Endscreen(properties);
                    endscreen.getFrame().setVisible(true);
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
        String separator = FileSystems.getDefault().getSeparator();
        String imageName = properties.getRessourcesPath() + separator + "Logo_neu.jpg";

        setFrame(new JFrame());
        getFrame().setIconImage(Toolkit.getDefaultToolkit().getImage(imageName));
        getFrame().setTitle("Das vierte Fragezeichen ?");
        getFrame().setExtendedState(JFrame.MAXIMIZED_BOTH);
        getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btnSpiel_schließen = new JButton("Spiel schließen");
        btnSpiel_schließen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        getFrame().getContentPane().setLayout(new BorderLayout(0, 0));
        getFrame().getContentPane().add(btnSpiel_schließen, BorderLayout.SOUTH);

        Endscreen_Panel panel = new Endscreen_Panel(properties);
        getFrame().getContentPane().add(panel, BorderLayout.CENTER);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
}

