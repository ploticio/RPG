package Graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Entities.Enemy;
import Entities.Player;

public class CombatBox extends JPanel {
	/// made 5/8
	private int arrowPos;
	private BufferedImage combBoxImage;
	private BufferedImage statBoxImage;
	private BufferedImage arrow;
	Player p;
	Enemy e;
	String s1 = "";
	String s2 = "";
	String s3 = "";

	/**
	 * Loaded Constructor - initializes combBoxImage and arrow to images 
	 * and initializes player entity
	 * @param p - 
	 */
	public CombatBox(Player p) {
		this.p = p;
		try {
			combBoxImage = ImageIO.read(new File("Images////combBoxMac.png"));
			arrow = ImageIO.read(new File("Images////pointarrow.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets arrow position in the window
	 * @return arrow's position
	 */
	public int getArrowPos() {
		return 40 + arrowPos * 25;
	}

	/**
	 * Sets arrow position in the window
	 * @return x - arrow's new position
	 */
	public void setArrowPos(int x) {
		arrowPos -= x;
	}

	/**
	 * Gets array position in the window
	 * @return arrowPos - position of arrow
	 */
	public int getArrayPostion() {
		return arrowPos;
	}

	/**
	 * Gets the player entity
	 * @return p - player entity
	 */
	public Player getPlayer() {
		return p;
	}
	
	public void setEnemy(Enemy e) {
		this.e = e;
	}
	/**
	 * Updates graphics
	 */
	public void update() {
		repaint();
	}

	/**
	 * Sets primary text
	 * @param s - new primary text
	 */
	public void setTextMain(String s) {
		this.s1 = s;
	}
	
	/**
	 * Sets secondary text
	 * @param s - new secondary text
	 */
	public void setTextSub(String s) {
		this.s2 = s;
	}
	
	public void setTextTertiary(String s) {
		this.s3 = s;
	}

	/**
	 * Renders combat box in the window
	 */
	public void paintComponent(Graphics g) {
		g.drawImage(combBoxImage, 0, 0, 800, 150, null);
		g.drawImage(arrow, 25, getArrowPos(), 10, 10, null);
		g.setFont(new Font("Arial", Font.BOLD, 24));
		for (int i = 0; i < p.getAttacks().size(); i++) {
			g.drawString(p.getAttacks().get(i).getName().toString(), 50, 50 + i * 25);
		}
		g.drawString(s1, 300, 65);
		g.drawString(s2, 300, 115);
		g.drawString(s3, 300, 90);
		if(p!=null && e!=null) {
			g.drawImage(statBoxImage, 5,5, 70, 70, null);
			g.setFont(new Font("Arial", Font.BOLD, 16));
			g.drawString("Your Health: " + p.getCurrentHP(), 300, 20);
			g.drawString("Enemy's Health: " + e.getCurrentHP(), 600, 20);
		}
	}
}
