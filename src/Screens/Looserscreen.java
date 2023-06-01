package Screens;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Looserscreen {

	private JFrame frame;
	private JButton btnExitGame;
	private JButton btnRestartGame;
	static Looserscreen window;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new Looserscreen();
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
	public Looserscreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		String img_name=System.getProperty("user.dir")+"\\ressources\\Logo_neu.jpg";
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(img_name));
		frame.setTitle("Das vierte Fragezeichen ?"); 
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Looserscreen_Panel panel = new Looserscreen_Panel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JButton btnSpiel_schließen = new JButton("Spiel schließen");
		btnSpiel_schließen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panel_1.add(btnSpiel_schließen);
		
		JButton btnSpiel_neu_starten = new JButton("Spiel neu starten");
		btnSpiel_neu_starten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Startscreen.window = new Startscreen();
				//Startscreen.window.getFrame().setVisible(true);
				Looserscreen.window.frame.setVisible(false);

			}
		});
		panel_1.add(btnSpiel_neu_starten);		
		
	}
}

