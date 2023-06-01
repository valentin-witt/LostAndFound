package Screens;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.io.File;

public class Looserscreen_Panel extends JPanel {

	Image img;
	/**
	 * Create the panel.
	 */
	public Looserscreen_Panel() {
		try { 
			String img_name=System.getProperty("user.dir")+"\\ressources\\Looserbildschirm.png";
			System.out.println(img_name);
			
			img = ImageIO.read(new File(img_name));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void paint(Graphics g) {
		int wp= img.getWidth(null);
		int w= getWidth();
		int h= img.getHeight(null)*w/wp;
		g.drawImage(img, 0, 0, w, h, null);
	}

}
