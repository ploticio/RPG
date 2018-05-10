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

	/**
	 * Loaded constructor - initializes enemies array list
	 * @param enemies - array list of enemies
	 */
	public EnemyManager(ArrayList<Enemy> enemies) {
		this.enemies = enemies;
	}

	/**
	 * Gets enemy array list
	 * @return enemies - enemy array list
	 */
	public ArrayList<Enemy> getList() {
		return enemies;
	}

	/**
	 * Gets index of enemy
	 * @return enemyIndex - index of enemy
	 */
	public int getEnemyIndex() {
		return enemyIndex;
	}

	/**
	 * Gets index of enemy
	 * @param enemyIndex - index of enemy
	 */
	public void setEnemyIndex(int enemyIndex) {
		this.enemyIndex = enemyIndex;
	}

	/**
	 * Renders enemies
	 * @param g - graphics drawer
	 */
	public void draw(Graphics g) {
		for (Enemy e : enemies)
			e.draw(g);
	}

}
