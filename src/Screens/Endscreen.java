package Screens;

import Config.Properties;
import Config.PropertiesReader;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.nio.file.FileSystems;


public class Endscreen {

	private JFrame frame;
	static Endscreen window;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new Endscreen();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Endscreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// Initialize reader, read properties file and parse json content to POJO Properties
		PropertiesReader reader = new PropertiesReader();
		Properties properties = reader.readPropertiesFile("/Users/valentinwitt/Documents/15_Coding/01_Java/LostAndFound/properties.json");
		String imageName = properties.getRessourcesPath() + FileSystems.getDefault().getSeparator() + "Logo_neu.jpg";

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

