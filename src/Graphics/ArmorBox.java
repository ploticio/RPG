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

public class ArmorBox extends JPanel {
	// made 5/9
	private int arrowPos;
	private BufferedImage invenBoxImage;
	private BufferedImage arrow;
	Player p;

	public ArmorBox(Player p) {
		this.p = p;
		try {
			invenBoxImage = ImageIO.read(new File("Images\\invenBox.png"));
			arrow = ImageIO.read(new File("Images\\pointarrow.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getArrowPos() {
		return 40 + arrowPos * 20;
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

	public void paintComponent(Graphics g) {
		g.drawImage(invenBoxImage, 0, 0, 800, 450, null);
		g.drawImage(arrow, 25, getArrowPos(), 10, 10, null);
		g.setFont(new Font("Arial", Font.BOLD, 16));
		for (int i = 0; i < p.getArmor().size(); i++) {
			g.drawString(p.getArmor().get(i).toString(), 40, 50 + i * 20);
		}
		g.drawString("Press 'F' to equip/unequip", 580, 435);

	}
}
