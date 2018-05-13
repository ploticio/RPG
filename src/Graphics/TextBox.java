package Graphics;

import java.awt.Color;
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

// MAY 1ST

/**
 * 
 * graphic box for text boxes
 *
 */
public class TextBox extends JPanel {

	private String s = "Sample Text";
	private String s2 = "";
	private String s3 = "";
	private String s4 = "";
	private String s5 = "";
	private BufferedImage textBoxImage;
	private Font customFont;
	private BufferedImage statBoxImage;

	/**
	 * Default Constructor - initializes textBoxImage to image
	 */
	public TextBox() {
		try {
			textBoxImage = ImageIO.read(new File("Images\\textBox.png"));
			statBoxImage = ImageIO.read(new File("Images\\boiStat.png"));
			// customFont = Font.createFont(Font.TRUETYPE_FONT, new File(""));
			// GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			// ge.registerFont(customFont);
		} catch (IOException e /* | FontFormatException e */) {
			e.printStackTrace();
		}
	}

	/**
	 * Loaded Constructor - initializes s to text content
	 * 
	 * @param s
	 *            - text in text box as string
	 */
	public TextBox(String s) {
		this();
		this.s = s;
	}

	/**
	 * Sets text for text box
	 * 
	 * @param s
	 *            - text content
	 */
	public void setText(String s) {
		this.s = s;
	}

	/**
	 * Sets text for text box
	 * 
	 * @param s
	 *            - text content
	 */
	public void setText2(String s) {
		this.s2 = s;
	}

	/**
	 * Sets text for text box
	 * 
	 * @param s
	 *            - text content
	 */
	public void setText3(String s) {
		this.s3 = s;
	}

	public void setText4(String s) {
		this.s4 = s;
	}

	public void setText5(String s) {
		this.s5 = s;
	}

	/**
	 * Updates graphics
	 */
	public void update() {
		repaint();
	}

	/**
	 * Renders text box in the window
	 */
	public void paintComponent(Graphics g) {
		g.drawImage(textBoxImage, 0, 0, 800, 150, null);
		g.drawImage(statBoxImage, 20, 35, null);
		g.setFont(new Font("Arial", Font.BOLD, 16));
		// g.setFont(customFont);
		g.drawString(s, 95, 30);
		g.drawString(s2, 95, 50);
		g.drawString(s3, 95, 70);
		g.drawString(s4, 95, 90);
		g.drawString(s5, 95, 110);
		g.drawString("Press 'E' to close", 635, 135);
	}

}
