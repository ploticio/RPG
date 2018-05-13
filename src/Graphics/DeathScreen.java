package Graphics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

// MAY 1ST

/**
 * 
 * graphic box for the death screen
 *
 */
public class DeathScreen extends JPanel {

	private BufferedImage gameover;

	/**
	 * default constructor; initializes death screen image
	 */
	public DeathScreen() {
		try {
			gameover = ImageIO.read(new File("Images\\gameover.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Updates graphics
	 */
	public void update() {
		repaint();
	}

	/**
	 * Renders death screen in the window
	 */
	public void paintComponent(Graphics g) {
		g.drawImage(gameover, 0, 0, 840, 840, null);
	}

}
