package Levels;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import Entities.Enemy;
import Entities.Player;
import Graphics.TextBox;
import Managers.EnemyManager;

public class LevelCreator {
	
	private final int tileSize = 40;  //size of square tile in pixels
	private final int levelSize = 21; //size of square grid in tiles
	private Player player = new Player();
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	private EnemyManager enemyManager = new EnemyManager(enemies,0,0,0,0);
	private Tile[][] grid = new Tile[levelSize][levelSize];
	
	/**
	 * Default Constructor - Creates level grid
	 */
	public LevelCreator() {
		for(int i = 0; i < 21; i++) {
			for(int j = 0 ; j < 21; j++) {
				grid[i][j] = new Tile(i*tileSize, j*tileSize);
			}
		}
	}
	
	/**
	 * Gets grid array
	 * @return grid - 2d array of tiles
	 */
	public Tile[][] getGrid(){
		return grid;
	}
	
	/**
	 * Sets color of all tiles
	 * @param c - new color
	 */
	public void setColor(Color c) {
		for(int i = 0; i < 21; i++) {
			for(int j = 0 ; j < 21; j++) {
				grid[i][j].setColor(c);
			}
		}
	}
	
	/**
	 * Sets image of all tiles
	 * @param s - name of image
	 */
	public void setImage(String s) {
		for(int i = 0; i < 21; i++) {
			for(int j = 0 ; j < 21; j++) {
				grid[i][j].setImage(s);
			}
		}
	}
	
	/**
	 * Sets color of one tile
	 * @param x - x position of tile
	 * @param y - y position of tile
	 * @param c - new color
	 */
	public void setColor(int x, int y, Color c) {
		grid[x][y].setColor(c);
	}
	
	/**
	 * Sets image of one tile
	 * @param x - x position of tile
	 * @param y - y position of tile
	 * @param s - name of new image
	 */
	public void setImage(int x, int y, String s) {
		grid[x][y].setImage(s);
	}
	
	/**
	 * Sets image and block property of one tile
	 * @param x - x position of tile
	 * @param y - y position of tile
	 * @param s - name of new image
	 * @param b - block property
	 */
	public void setImage(int x, int y, String s, boolean b) {
		setImage(x,y,s);
		grid[x][y].setBlocked(b);
	}
	
	/**
	 * Sets level changer property of one tile
	 * @param x - x position of tile
	 * @param y - y position of tile
	 * @param n - level changer property
	 */
	public void setChanger(int x, int y, int n) {
		grid[x][y].setChanger(n);
	}
	
	/**
	 * 
	 * @param x - x position of tile
	 * @param y - y position of tile
	 * @return changer property
	 */
	public int getChanger(int x, int y) {
		return grid[x][y].getChanger();
	}
	
	/**
	 * Sets block property of one tile
	 * @param x - x position of tile
	 * @param y - y position of tile
	 * @param b - block property
	 */
	public void setBlocked(int x, int y, boolean b) {
		grid[x][y].setBlocked(b);
	}
	
	/**
	 * Sets entity possession property of one tile
	 * @param x - x position of tile
	 * @param y - y position of tile
	 * @param b - entity possession property
	 */
	public void setHasEntity(int x, int y, boolean b) {
		grid[x][y].setHasEntity(b);
	}
	
	/**
	 * Creates level
	 * @param g - graphics drawer
	 */
	public void makeLevel(Graphics g) {
		for(int i = 0; i < 21; i++) {
			for(int j = 0 ; j < 21; j++) {
				grid[i][j].drawTile(g);
			}
		}
	}

	/**
	 * Gets player entity
	 * @return player - player entity
	 */
	public Player getPlayer() {
		return player;
	}
	
	/**
	 * Gets enemy manager array list
	 * @return enemyManager - array list of enemies
	 */
	public EnemyManager getEnemyManager() {
		return enemyManager;
	}
}
