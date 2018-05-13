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
	private int respawnRate = 5000;
	private int caveRespawnRate = 500;
	private int chance = 15;
	
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	private Random r = new Random();
	private int enemyIndex = 0;
	private Timer blobRespawner;
	private Timer mushroomRespawner;
	private Timer witchRespawner;
	private Timer flameSkullRespawner;
	private Timer crawlerRespawner;
	private Timer batRespawner;
	private Timer goblinRespawner;
	private ArrayList<Timer> TimerList = new ArrayList<Timer>();
	
	public EnemyManager() {
		TimerList.add(blobRespawner);
		TimerList.add(mushroomRespawner);
		TimerList.add(witchRespawner);
		TimerList.add(flameSkullRespawner);
		TimerList.add(crawlerRespawner);
		TimerList.add(batRespawner);
		TimerList.add(goblinRespawner);
	}

	public ArrayList<Enemy> getList() {
		return enemies;
	}
	
	public void setRespawnRate(int rate) {
		respawnRate = rate;
	}
	
	public void setSpawnChance(int chance) {
		this.chance = chance;
	}
	
	public void spawnBlobs(int min, int max, int xBound, int yBound) {
		blobRespawner = new Timer(respawnRate, new ActionListener() { //respawn every 10 seconds
			public void actionPerformed(ActionEvent arg0) {
				if(enemies.size() < min) {
					blob(xBound, yBound);
				}
				else if(enemies.size()>=min && enemies.size()<max) {
					int spawnChance = r.nextInt(100);
					if(spawnChance<chance) {
						blob(xBound, yBound);
					}
				}
			}});
		blobRespawner.start();
	}
	
	public void spawnBats(int min, int max, int xBound, int yBound) {
		batRespawner = new Timer(caveRespawnRate, new ActionListener() { //respawn every 10 seconds
			public void actionPerformed(ActionEvent arg0) {
				if(enemies.size() < min) {
					enemies.add(new Bat(r.nextInt(xBound), r.nextInt(yBound)));
				}
				else if(enemies.size()>=min && enemies.size()<max) {
					int spawnChance = r.nextInt(100);
					if(spawnChance<chance) {
						enemies.add(new Bat(r.nextInt(xBound), r.nextInt(yBound)));
					}
				}
			}});
		batRespawner.start();
	}
	
	public void spawnGoblins(int min, int max, int xBound, int yBound) {
		goblinRespawner = new Timer(respawnRate, new ActionListener() { //respawn every 10 seconds
			public void actionPerformed(ActionEvent arg0) {
				if(enemies.size() < min) {
					enemies.add(new Goblin(r.nextInt(xBound), r.nextInt(yBound)));
				}
				else if(enemies.size()>=min && enemies.size()<max) {
					int spawnChance = r.nextInt(100);
					if(spawnChance<chance) {
						enemies.add(new Goblin(r.nextInt(xBound), r.nextInt(yBound)));
					}
				}
			}});
		goblinRespawner.start();
	}
	
	public void spawnMushrooms(int min, int max, int xBound, int yBound) {
		mushroomRespawner = new Timer(respawnRate, new ActionListener() { //respawn every 10 seconds
			public void actionPerformed(ActionEvent arg0) {
				if(enemies.size() < min) {
					enemies.add(new Mushroom(r.nextInt(xBound), r.nextInt(yBound)));
				}
				else if(enemies.size()>=min && enemies.size()<max) {
					int spawnChance = r.nextInt(100);
					if(spawnChance<chance) {
						enemies.add(new Mushroom(r.nextInt(xBound), r.nextInt(yBound)));
					}
				}
			}});
		mushroomRespawner.start();
	}
	
	public void spawnWitches(int min, int max, int xBound, int yBound) {
		witchRespawner = new Timer(respawnRate, new ActionListener() { //respawn every 10 seconds
			public void actionPerformed(ActionEvent arg0) {
				if(enemies.size() < min) {
					enemies.add(new Witch(r.nextInt(xBound), r.nextInt(yBound)));
				}
				else if(enemies.size()>=min && enemies.size()<max) {
					int spawnChance = r.nextInt(100);
					if(spawnChance<chance) {
						enemies.add(new Witch(r.nextInt(xBound), r.nextInt(yBound)));
					}
				}
			}});
		witchRespawner.start();
	}
	
	public void spawnFlameSkulls(int min, int max, int xBound, int yBound) {
		flameSkullRespawner = new Timer(caveRespawnRate, new ActionListener() { //respawn every 10 seconds
			public void actionPerformed(ActionEvent arg0) {
				if(enemies.size() < min) {
					enemies.add(new FlameSkull(r.nextInt(xBound), r.nextInt(yBound)));
				}
				else if(enemies.size()>=min && enemies.size()<max) {
					int spawnChance = r.nextInt(100);
					if(spawnChance<chance) {
						enemies.add(new FlameSkull(r.nextInt(xBound), r.nextInt(yBound)));
					}
				}
			}});
		flameSkullRespawner.start();
	}
	
	public void spawnCrawlers(int min, int max, int xBound, int yBound) {
		crawlerRespawner = new Timer(caveRespawnRate, new ActionListener() { //respawn every 10 seconds
			public void actionPerformed(ActionEvent arg0) {
				if(enemies.size() < min) {
					enemies.add(new Crawler(r.nextInt(xBound), r.nextInt(yBound)));
				}
				else if(enemies.size()>=min && enemies.size()<max) {
					int spawnChance = r.nextInt(100);
					if(spawnChance<chance) {
						enemies.add(new Crawler(r.nextInt(xBound), r.nextInt(yBound)));
					}
				}
			}});
		crawlerRespawner.start();
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

	public ArrayList<Timer> getTimers() {
		return TimerList;
	}
	
	public void setEnemyIndex(int enemyIndex) {
		this.enemyIndex = enemyIndex;
	}
	
	public void draw(Graphics g) {
		for (Enemy e : enemies)
			e.draw(g);
	}

}
