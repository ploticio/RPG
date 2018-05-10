package Graphics;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import Entities.Enemy;
import Entities.Player;
import Levels.LevelCreator;
import Levels.Tile;
import Managers.EnemyManager;

//UPDATED MAY 1ST

public class GraphicsMaker extends JPanel {

	private LevelCreator l;
	private Player p;
	private EnemyManager em;
	private Tile[][] lg;
	private ArrayList<Enemy> enemyList;
	private Player thePlayer;

	/**
	 * Renders a level without any enemies
	 * 
	 * @param l
	 *            - level to be rendered
	 * @param p
	 *            - player object to be placed
	 */

	public GraphicsMaker(LevelCreator l) {
		p = l.getPlayer();
		this.l = l;
		lg = l.getGrid();
		this.em = l.getEnemyManager();
		enemyList = em.getList();
		for (int i = 0; i < enemyList.size(); i++) {
			lg[enemyList.get(i).getxGrid()][enemyList.get(i).getyGrid()].setHasEntity(true);
		}
		setSize(840, 840);
	}

	public void changeLevel(LevelCreator l) {
		p = l.getPlayer();
		this.l = l;
		lg = l.getGrid();
		this.em = l.getEnemyManager();
		enemyList = em.getList();
		for (int i = 0; i < enemyList.size(); i++) {
			lg[enemyList.get(i).getxGrid()][enemyList.get(i).getyGrid()].setHasEntity(true);
		}
	}

	public void update() {
		repaint();
	}

	public void setThePlayer(Player p) {
		thePlayer = p;
	}

	public void paintComponent(Graphics g) {
		l.makeLevel(g);
		if (em != null)
			em.draw(g);
		p.draw(g);
		g.dispose();
		try {
			g.drawImage(ImageIO.read(new File("Images\\boiStat.png")), 5, 5, 70, 70, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.setFont(new Font("Arial", Font.BOLD, 16));
		g.drawString("Player", 80, 24);
		g.drawString("Health: " + thePlayer.getCurrentHP() + "/" + thePlayer.getMaxHP(), 80, 44);
		g.drawString("Level: " + thePlayer.getLevel(), 80, 64);
		g.drawString("EXP: " + thePlayer.getExp() + "/" + thePlayer.getRequiredEXP(), 80, 84);
	}

}