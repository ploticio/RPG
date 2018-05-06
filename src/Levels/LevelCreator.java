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
	private EnemyManager enemyManager = new EnemyManager(enemies,2,4);
	private Tile[][] grid = new Tile[levelSize][levelSize];
	
	public LevelCreator() {
		for(int i = 0; i < 21; i++) {
			for(int j = 0 ; j < 21; j++) {
				grid[i][j] = new Tile(i*tileSize, j*tileSize);
			}
		}
	}
	
	public Tile[][] getGrid(){
		return grid;
	}
	
	public void setColor(Color c) {
		for(int i = 0; i < 21; i++) {
			for(int j = 0 ; j < 21; j++) {
				grid[i][j].setColor(c);
			}
		}
	}
	
	public void setImage(String s) {
		for(int i = 0; i < 21; i++) {
			for(int j = 0 ; j < 21; j++) {
				grid[i][j].setImage(s);
			}
		}
	}
	
	public void setColor(int x, int y, Color c) {
		grid[x][y].setColor(c);
	}
	
	public void setImage(int x, int y, String s) {
		grid[x][y].setImage(s);
	}
	
	public void setImage(int x, int y, String s, boolean b) {
		setImage(x,y,s);
		grid[x][y].setBlocked(b);
	}
	
	public void setLevelChanger(int x, int y, boolean b) {
		grid[x][y].setLevelChanger(b);
	}
	
	public void setBlocked(int x, int y, boolean b) {
		grid[x][y].setBlocked(b);
	}
	
	public void setHasEntity(int x, int y, boolean b) {
		grid[x][y].setHasEntity(b);
	}
	
	public void makeLevel(Graphics g) {
		for(int i = 0; i < 21; i++) {
			for(int j = 0 ; j < 21; j++) {
				grid[i][j].drawTile(g);
			}
		}
	}

	public Player getPlayer() {
		return player;
	}
	
	public EnemyManager getEnemyManager() {
		return enemyManager;
	}
}
