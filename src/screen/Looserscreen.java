package screen;

import config.Properties;
import config.PropertiesReader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.FileSystems;

public class Looserscreen {

    private final static String PATH_TO_PROPERTIES = "/Users/valentinwitt/Documents/15_Coding/01_Java/LostAndFound/properties.json";
    static Looserscreen looserscreen;
    public JFrame frame;
    private JButton btnExitGame;
    private JButton btnRestartGame;


    /**
     * Create the application.
     */
    public Looserscreen(Properties properties) {
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
                    looserscreen = new Looserscreen(properties);
                    looserscreen.frame.setVisible(true);
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

        frame = new JFrame();
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(imageName));
        frame.setTitle("Das vierte Fragezeichen ?");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Looserscreen_Panel panel = new Looserscreen_Panel(properties);
        frame.getContentPane().add(panel, BorderLayout.CENTER);

        JPanel panel_1 = new JPanel();
        frame.getContentPane().add(panel_1, BorderLayout.SOUTH);

        btnExitGame = new JButton("Spiel schließen");
        btnExitGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel_1.add(btnExitGame);

        btnRestartGame = new JButton("Spiel neu starten");
        btnRestartGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Playscreen.playscreen = new Playscreen(properties);
                Playscreen.playscreen.getFrame().setVisible(true);
                Looserscreen.looserscreen.frame.setVisible(false);
            }
        });
        panel_1.add(btnRestartGame);

    }
}

