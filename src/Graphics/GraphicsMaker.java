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

/**
 * 
 * draws the current level based on its tiles
 *
 */
public class GraphicsMaker extends JPanel {

	private LevelCreator l;
	private Player p;
	private EnemyManager em;
	private Tile[][] lg;
	private ArrayList<Enemy> enemyList;

	/**
	 * Loaded Constructor - Renders a level without any enemies
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

	/**
	 * Loads new level
	 * 
	 * @param l
	 *            - new level
	 */
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

	/**
	 * Updates graphics
	 */
	public void update() {
		repaint();
	}

	/**
	 * Renders new graphic
	 * 
	 * @param g
	 *            - graphic drawer
	 */
	public void paintComponent(Graphics g) {
		l.makeLevel(g);
		if (em != null)
			em.draw(g);
		p.draw(g);
		g.dispose();
	}

}