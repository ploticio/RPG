package Managers;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

import Entities.*;

//created 5/1
public class EnemyManager {

	////////RESPAWN RATE///////////
	private final int RESPAWN_RATE = 5000;
	
	private ArrayList<Enemy> enemies;
	private Random r = new Random();
	private int min, max, xBound, yBound;
	private int enemyIndex = 0;
	private Timer respawner;
	
	public EnemyManager(ArrayList<Enemy> enemies, int min, int max, int xBound, int yBound) {
		this.enemies = enemies;
		this.min = min;
		this.max = max;
		this.xBound = xBound;
		this.yBound = yBound;
	}
	
	public EnemyManager(ArrayList<Enemy> enemies, int min, int max) {
		this(enemies,min,max,21,21);
	}

	public ArrayList<Enemy> getList() {
		return enemies;
	}
	
	public void spawnBlobs() {
		respawner = new Timer(RESPAWN_RATE, new ActionListener() { //respawn every 10 seconds
			public void actionPerformed(ActionEvent arg0) {
				if(enemies.size() < min) {
					blob();
				}
				else if(enemies.size()>=min && enemies.size()<max) {
					int spawnChance = r.nextInt(100);
					System.out.println(spawnChance);
					if(spawnChance<25) {
						blob();
					}
				}
			}});
		respawner.start();
	}
	
	public void spawnBats() {
		respawner = new Timer(RESPAWN_RATE, new ActionListener() { //respawn every 10 seconds
			public void actionPerformed(ActionEvent arg0) {
				if(enemies.size() < min) {
					enemies.add(new Bat(r.nextInt(xBound), r.nextInt(yBound)));
				}
				else if(enemies.size()>=min && enemies.size()<max) {
					int spawnChance = r.nextInt(100);
					System.out.println(spawnChance);
					if(spawnChance<25) {
						enemies.add(new Bat(r.nextInt(xBound), r.nextInt(yBound)));
					}
				}
			}});
		respawner.start();
	}
	
	private void blob() {
		int blobType = r.nextInt(3);
		if(blobType == 0)
			enemies.add(new Blob(r.nextInt(xBound), r.nextInt(yBound)));
		if(blobType == 1)
			enemies.add(new RedBlob(r.nextInt(xBound), r.nextInt(yBound)));
		if(blobType == 2)
			enemies.add(new BlueBlob(r.nextInt(xBound), r.nextInt(yBound)));
	}
	
	public int getEnemyIndex() {
		return enemyIndex;
	}

	public Timer getTimer() {
		return respawner;
	}
	
	public void setEnemyIndex(int enemyIndex) {
		this.enemyIndex = enemyIndex;
	}

	public void draw(Graphics g) {
		for (Enemy e : enemies)
			e.draw(g);
	}

}
