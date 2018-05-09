package Managers;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import Entities.*;

//created 5/1
public class EnemyManager {

	private ArrayList<Enemy> enemies;
	private ArrayList<Enemy> created;
	private Random r = new Random();
	private int min;// minimum amount of enemies
	private int max;// maximum amount of enemies
	private int enemyIndex = 0;

	public EnemyManager(ArrayList<Enemy> enemies) {
		this.enemies = enemies;
	}

	public ArrayList<Enemy> getList() {
		return enemies;
	}

	public int getEnemyIndex() {
		return enemyIndex;
	}

	public void setEnemyIndex(int enemyIndex) {
		this.enemyIndex = enemyIndex;
	}

	public void draw(Graphics g) {
		for (Enemy e : enemies)
			e.draw(g);
	}

}
