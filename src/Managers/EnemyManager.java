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

	//NOTE FOR MYSELF: ADAPT ENEMY MANAGER INTO WORLD GRID SO ENEMIES DONT KEEP SPAWNING WHILE PLAYER IS IN COMBAT
	
	
	////////RESPAWN RATE///////////
	private final int RESPAWN_RATE = 5000;
	
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	private Random r = new Random();
	private int enemyIndex = 0;
	private Timer respawner;
	
	public EnemyManager() {
		//nothing
	}

	public ArrayList<Enemy> getList() {
		return enemies;
	}
	
	public void spawnBlobs(int min, int max, int xBound, int yBound) {
		respawner = new Timer(RESPAWN_RATE, new ActionListener() { //respawn every 10 seconds
			public void actionPerformed(ActionEvent arg0) {
				if(enemies.size() < min) {
					blob(xBound, yBound);
				}
				else if(enemies.size()>=min && enemies.size()<max) {
					int spawnChance = r.nextInt(100);
					if(spawnChance<15) {
						blob(xBound, yBound);
					}
				}
			}});
		respawner.start();
	}
	
	public void spawnMushrooms(int min, int max, int xBound, int yBound) {
		respawner = new Timer(RESPAWN_RATE, new ActionListener() { //respawn every 10 seconds
			public void actionPerformed(ActionEvent arg0) {
				if(enemies.size() < min) {
					enemies.add(new Mushroom(r.nextInt(xBound), r.nextInt(yBound)));
				}
				else if(enemies.size()>=min && enemies.size()<max) {
					int spawnChance = r.nextInt(100);
					if(spawnChance<25) {
						enemies.add(new Mushroom(r.nextInt(xBound), r.nextInt(yBound)));
					}
				}
			}});
		respawner.start();
	}
	
	public void spawnWitches(int min, int max, int xBound, int yBound) {
		respawner = new Timer(RESPAWN_RATE, new ActionListener() { //respawn every 10 seconds
			public void actionPerformed(ActionEvent arg0) {
				if(enemies.size() < min) {
					enemies.add(new Witch(r.nextInt(xBound), r.nextInt(yBound)));
				}
				else if(enemies.size()>=min && enemies.size()<max) {
					int spawnChance = r.nextInt(100);
					if(spawnChance<25) {
						enemies.add(new Witch(r.nextInt(xBound), r.nextInt(yBound)));
					}
				}
			}});
		respawner.start();
	}
	
	public void spawnFlameSkulls(int min, int max, int xBound, int yBound) {
		respawner = new Timer(RESPAWN_RATE, new ActionListener() { //respawn every 10 seconds
			public void actionPerformed(ActionEvent arg0) {
				if(enemies.size() < min) {
					enemies.add(new FlameSkull(r.nextInt(xBound), r.nextInt(yBound)));
				}
				else if(enemies.size()>=min && enemies.size()<max) {
					int spawnChance = r.nextInt(100);
					if(spawnChance<25) {
						enemies.add(new FlameSkull(r.nextInt(xBound), r.nextInt(yBound)));
					}
				}
			}});
		respawner.start();
	}
	
	public void spawnCrawlers(int min, int max, int xBound, int yBound) {
		respawner = new Timer(RESPAWN_RATE, new ActionListener() { //respawn every 10 seconds
			public void actionPerformed(ActionEvent arg0) {
				if(enemies.size() < min) {
					enemies.add(new Crawler(r.nextInt(xBound), r.nextInt(yBound)));
				}
				else if(enemies.size()>=min && enemies.size()<max) {
					int spawnChance = r.nextInt(100);
					if(spawnChance<25) {
						enemies.add(new Crawler(r.nextInt(xBound), r.nextInt(yBound)));
					}
				}
			}});
		respawner.start();
	}
	
	private void blob(int xBound, int yBound) {
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
