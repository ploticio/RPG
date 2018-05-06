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

	public EnemyManager(ArrayList<Enemy> enemies, int min, int max) {
		this.enemies = enemies;
		this.max = max;
		this.min = min;
		created = new ArrayList<Enemy>();
	}

	public void setList() {
		int num = r.nextInt(max + 1) + min;// number of enemies
		// int num = 10;
		int size = enemies.size();
		int[] p = new int[size];
		/**
		 * sets numbers for probability of a certain enemy being created
		 * 
		 * if there are 2 enemies in the list, p will contain[10,18] if there are 3
		 * enemies in the list, p will contain[10,18,24]
		 * 
		 */
		for (int i = 0; i < size; i++) {
			if (i == 0) {
				p[i] = 10 - (2 * i);
			} else {
				p[i] = p[i - 1] + (10 - (2 * i));
			}
		}
		/**
		 * 
		 */
		/*
		 * for (int i = 0; i < num; i++) { created.add(cloneList(enemies).get(0)); }
		 * 
		 * for (int i = 0; i < num; i++) { created.get(i).setxGrid(r.nextInt(19));
		 * created.get(i).setyGrid(r.nextInt(19)); }
		 */

		lab1: for (int k = 0; k < num; k++) {
			int x = r.nextInt(p[size - 1]);
			for (int t = 0; t < p.length; t++) {
				lab2: if (x < p[t]) {
					created.add(enemies.get(t));
					continue lab1;
				}
			}
		}
		for (int i = 0; i < num; i++) {
			created.get(i).setxGrid(r.nextInt(19));
			created.get(i).setyGrid(r.nextInt(19));
		}
	}

	public ArrayList<Enemy> getList() {
		return created;
	}

	public ArrayList<Enemy> getOGList() {
		return enemies;
	}

	public void draw(Graphics g) {
		for (Enemy e : created)
			e.draw(g);
	}

	private static ArrayList<Enemy> cloneList(ArrayList<Enemy> x) {
		ArrayList<Enemy> clone = new ArrayList<Enemy>();
		for (Enemy en : x) {
			clone.add(en);
		}
		return clone;
	}

}
