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

public class CombatBox extends JPanel {
	/// made 5/8
	private int arrowPos;
	private BufferedImage combBoxImage;
	private BufferedImage arrow;
	Player p;
	String s1 = "";
	String s2 = "";

	public CombatBox(Player p) {
		this.p = p;
		try {
			combBoxImage = ImageIO.read(new File("Images\\combBox.png"));
			arrow = ImageIO.read(new File("Images\\pointarrow.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getArrowPos() {
		return 40 + arrowPos * 25;
	}

	public void setArrowPos(int x) {
		arrowPos -= x;
	}

	public int getArrayPostion() {
		return arrowPos;
	}

	public Player getPlayer() {
		return p;
	}

	public void update() {
		repaint();
	}

	public void setTextMain(String s) {
		this.s1 = s;
	}
	
	public void setTextSub(String s) {
		this.s2 = s;
	}

	public void paintComponent(Graphics g) {
		g.drawImage(combBoxImage, 0, 0, 800, 150, null);
		g.drawImage(arrow, 25, getArrowPos(), 10, 10, null);
		g.setFont(new Font("Arial", Font.BOLD, 24));
		for (int i = 0; i < p.getAttacks().size(); i++) {
			g.drawString(p.getAttacks().get(i).getName().toString(), 50, 50 + i * 25);
		}
		g.drawString(s1, 300, 75);
		g.drawString(s2, 300, 100);

	}
}
