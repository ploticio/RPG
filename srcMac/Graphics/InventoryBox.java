package Graphics;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import Entities.Player;

/**
 * graphic box for player's inventory
 * 
 * 
 *
 */
public class InventoryBox extends JPanel {
	/// made 5/7
	private int arrowPos;
	private BufferedImage invenBoxImage;
	private BufferedImage arrow;
	Player p;

	/**
	 * Loaded Constructor - initializes arrow and invenBoxImage to images
	 * 
	 * @param p
	 *            - player entity
	 */
	public InventoryBox(Player p) {
		this.p = p;
		try {
			invenBoxImage = ImageIO.read(new File("Images////invenBoxMac.png"));
			arrow = ImageIO.read(new File("Images////pointarrow.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets arrow position in the window
	 * 
	 * @return arrow's position
	 */
	public int getArrowPos() {
		return 60 + arrowPos * 30;
	}

	/**
	 * Sets arrow position in the window
	 * 
	 * @return x - arrow's new position
	 */
	public void setArrowPos(int x) {
		arrowPos -= x;
	}

	/**
	 * Gets array position in the window
	 * 
	 * @return arrowPos - position of arrow
	 */
	public int getArrayPostion() {
		return arrowPos;
	}

	/**
	 * Gets the player entity
	 * 
	 * @return p - player entity
	 */
	public Player getPlayer() {
		return p;
	}

	/**
	 * Updates graphics
	 */
	public void update() {
		repaint();
	}

	/**
	 * Renders inventory box in the window
	 */
	public void paintComponent(Graphics g) {
		g.drawImage(invenBoxImage, 0, 0, 800, 450, null);
		g.drawImage(arrow, 25, getArrowPos(), 10, 10, null);
		g.setFont(new Font("Arial", Font.BOLD, 16));
		g.drawString("Gold: " + p.getGold(), 40, 30);
		for (int i = 0; i < p.getInventory().size(); i++) {
			g.drawString(p.getInventory().get(i).toString(), 90, 70 + i * 30);
			g.drawImage(p.getInventory().get(i).getPicture(), 40, 40 + i * 30, null);
		}
		g.drawString("Press 'F' to use", 650, 435);

	}
}
