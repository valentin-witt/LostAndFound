package Screens;

import Config.Properties;
import Config.PropertiesReader;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.nio.file.FileSystems;

public class Playscreen {

	JFrame frame;
	static Playscreen window;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new Playscreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Playscreen() {
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

}
