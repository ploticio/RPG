package Levels;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Tile {

    private int xPos, yPos;
    private Color color = Color.black; //default color (black)
    private BufferedImage image;
    
    
    //PROPERTIES
    private boolean blocked = false;
    private boolean hasEntity = false;
    private boolean levelChanger = false;

    public Tile() {
    	//default constructor
    }
    
    public Tile(int x, int y) {
        xPos = x;
        yPos = y;
    }
    
    public void setColor(Color c) {
    	color = c;
    }
    
    public void setImage(String s) {
    	try {
			image = ImageIO.read(new File(s));
		} catch (IOException e) {
			System.out.println("No Image Found: " + s);
		}
    }
    
    public void drawTile(Graphics g) {
    	g.setColor(color);
    	g.fillRect(xPos, yPos, 40, 40);
    	if(image != null) {
    		g.drawImage(image, xPos, yPos, 40, 40, null);
    	}
    	
    }
    
    //PROPERTIES
    public boolean isBlocked() {
    	return blocked;
    }
    
    public void setBlocked(boolean b) {
    	blocked = b;
    }
    
    public void setHasEntity(boolean b) {
    	hasEntity = b;
    }
    
    public boolean hasEntity() {
    	return hasEntity;
    }
    
    public void setLevelChanger(boolean b) {
    	levelChanger = b;
    }
    
    public boolean isLevelChanger() {
    	return levelChanger;
    }
    
}