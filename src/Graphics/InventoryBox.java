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

public class InventoryBox extends JPanel {
	///made 5/7
	private int arrowPos;
	private BufferedImage invenBoxImage;
	private BufferedImage arrow;
	private boolean isVisibleInventory;
	private Timer invenBoxTimer;
	Player p;

	public InventoryBox() {
		try {
			invenBoxImage = ImageIO.read(new File("Images\\invenBox.png"));
			arrow = ImageIO.read(new File("Images\\pointarrow.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		invenBoxTimer = new Timer(1, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		});
	}

	public InventoryBox(Player p) {
		this.p = p;
		try {
			invenBoxImage = ImageIO.read(new File("Images\\invenBox.png"));
			arrow = ImageIO.read(new File("Images\\pointarrow.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		invenBoxTimer = new Timer(1, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		});
	}

	public int getArrowPos() {
		return 395 + arrowPos * 20;
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

	public void visibleInventory(boolean b) {
		isVisibleInventory = b;
		if(isVisibleInventory) {
			invenBoxTimer.start();
		}
		else {
			invenBoxTimer.stop();
		}
		
	}
	
	public boolean getVisibilityInventory() {
		return isVisibleInventory;
	}
	
	public Timer getTimer() {
		return invenBoxTimer;
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(invenBoxImage, 20, 360, 800, 450, null);
		g.drawImage(arrow, 30, getArrowPos(), 10, 10, null);
		g.setFont(new Font("Arial", Font.BOLD, 16));
		g.drawString("Gold: " + p.getGold(), 45, 385);
		for (int i = 0; i < p.getInventory().size(); i++) {
			g.drawString(p.getInventory().get(i).toString(), 45, 405 + i * 20);
		}
		g.drawString("Press 'F' to use", 660, 800);

	}
}
