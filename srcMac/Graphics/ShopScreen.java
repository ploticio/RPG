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

public class ShopScreen extends JPanel {
	/// made 5/7
	private int arrowPos;
	private BufferedImage pause;
	private BufferedImage arrow;

	public ShopScreen() {
		arrowPos = 0;
		try {
			pause = ImageIO.read(new File("Images////textBoxMac.png"));
			arrow = ImageIO.read(new File("Images////pointarrow.png"));
		} catch (IOException e /* | FontFormatException e */) {
			e.printStackTrace();
		}
	}

	public int getArrowPos() {
		return 20 + arrowPos * 20;
	}

	public void setArrowPos(int x) {
		arrowPos -= x;
	}

	public int getArrayPostion() {
		return arrowPos;
	}

	public void update() {
		repaint();
	}

	public void paintComponent(Graphics g) {
		g.drawImage(pause, 0, 0, 800, 150, null);
		g.drawImage(arrow, 10, getArrowPos(), 10, 10, null);
		g.setFont(new Font("Arial", Font.BOLD, 16));
		g.drawString("Buy", 25, 30);
		g.drawString("Sell (for half price)", 25, 50);

	}
}