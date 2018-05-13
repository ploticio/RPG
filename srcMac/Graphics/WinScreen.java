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
 * graphic box for win screen
 *
 */
public class WinScreen extends JPanel {

	private BufferedImage winScreen;

	/**
	 * default constructor; initializes win screen image
	 */
	public WinScreen() {
		try {
			winScreen = ImageIO.read(new File("Images////winScreen.png"));
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
	 * Renders win screen in the window
	 */
	public void paintComponent(Graphics g) {
		g.drawImage(winScreen, 0, 0, 840, 840, null);
	}

}
