package Managers;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

import Entities.*;

//created 5/1
/**
 * 
 * Enemy Manager class that deals with spawning enemies
 *
 */
public class EnemyManager {
	
	
	////////RESPAWN RATE///////////
	private int respawnRate = 3500;
	private int caveRespawnRate = 2000;
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
	/**
	 * Constructor that initializes all enemy timers
	 */
	public EnemyManager() {
		TimerList.add(blobRespawner);
		TimerList.add(mushroomRespawner);
		TimerList.add(witchRespawner);
		TimerList.add(flameSkullRespawner);
		TimerList.add(crawlerRespawner);
		TimerList.add(batRespawner);
		TimerList.add(goblinRespawner);
	}
	/**
	 * Returns the current list of enemies
	 * @return
	 */
	public ArrayList<Enemy> getList() {
		return enemies;
	}
	/**
	 * Sets the respawn rate for enemies
	 * @param rate
	 */
	public void setRespawnRate(int rate) {
		respawnRate = rate;
	}
	/**
	 * Sets the spawn chance for enemies over the minimum limit
	 * @param chance
	 */
	public void setSpawnChance(int chance) {
		this.chance = chance;
	}
	/**
	 * Spawns blobs
	 * @param min - minimum number of enemies
	 * @param max - maximum number of enemies
	 * @param xBound - x bound of where enemies can spawn
	 * @param yBound - y bound of where enemies can spawn
	 */
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
	/**
	 * Spawns bats
	 * @param min - minimum number of enemies
	 * @param max - maximum number of enemies
	 * @param xBound - x bound of where enemies can spawn
	 * @param yBound - y bound of where enemies can spawn
	 */
	public void spawnBats(int min, int max, int xBound, int yBound) {
		batRespawner = new Timer(caveRespawnRate, new ActionListener() { //respawn every 10 seconds
			public void actionPerformed(ActionEvent arg0) {
				if(enemies.size() < min) {
					enemies.add(new Bat(1 +r.nextInt(xBound), 1 + r.nextInt(yBound)));
				}
				else if(enemies.size()>=min && enemies.size()<max) {
					int spawnChance = r.nextInt(100);
					if(spawnChance<chance) {
						enemies.add(new Bat(1 +r.nextInt(xBound), 1 + r.nextInt(yBound)));
					}
				}
			}});
		batRespawner.start();
	}
	/**
	 * Spawns goblins
	 * @param min - minimum number of enemies
	 * @param max - maximum number of enemies
	 * @param xBound - x bound of where enemies can spawn
	 * @param yBound - y bound of where enemies can spawn
	 */
	public void spawnGoblins(int min, int max, int xBound, int yBound) {
		goblinRespawner = new Timer(respawnRate, new ActionListener() { //respawn every 10 seconds
			public void actionPerformed(ActionEvent arg0) {
				if(enemies.size() < min) {
					enemies.add(new Goblin(1 + r.nextInt(xBound), 1 + r.nextInt(yBound)));
				}
				else if(enemies.size()>=min && enemies.size()<max) {
					int spawnChance = r.nextInt(100);
					if(spawnChance<chance) {
						enemies.add(new Goblin(1 + r.nextInt(xBound), 1 +  r.nextInt(yBound)));
					}
				}
			}});
		goblinRespawner.start();
	}
	/**
	 * Spawns mushroom
	 * @param min - minimum number of enemies
	 * @param max - maximum number of enemies
	 * @param xBound - x bound of where enemies can spawn
	 * @param yBound - y bound of where enemies can spawn
	 */
	public void spawnMushrooms(int min, int max, int xBound, int yBound) {
		mushroomRespawner = new Timer(respawnRate, new ActionListener() { //respawn every 10 seconds
			public void actionPerformed(ActionEvent arg0) {
				if(enemies.size() < min) {
					enemies.add(new Mushroom(1 + r.nextInt(xBound), 1 + r.nextInt(yBound)));
				}
				else if(enemies.size()>=min && enemies.size()<max) {
					int spawnChance = r.nextInt(100);
					if(spawnChance<chance) {
						enemies.add(new Mushroom(1 + r.nextInt(xBound), 1 + r.nextInt(yBound)));
					}
				}
			}});
		mushroomRespawner.start();
	}
	/**
	 * Spawns witches
	 * @param min - minimum number of enemies
	 * @param max - maximum number of enemies
	 * @param xBound - x bound of where enemies can spawn
	 * @param yBound - y bound of where enemies can spawn
	 */
	public void spawnWitches(int min, int max, int xBound, int yBound) {
		witchRespawner = new Timer(respawnRate, new ActionListener() { //respawn every 10 seconds
			public void actionPerformed(ActionEvent arg0) {
				if(enemies.size() < min) {
					enemies.add(new Witch(1 + r.nextInt(xBound),1 +  r.nextInt(yBound)));
				}
				else if(enemies.size()>=min && enemies.size()<max) {
					int spawnChance = r.nextInt(100);
					if(spawnChance<chance) {
						enemies.add(new Witch(1 + r.nextInt(xBound),1 +  r.nextInt(yBound)));
					}
				}
			}});
		witchRespawner.start();
	}
	/**
	 * Spawns Flame Skulls
	 * @param min - minimum number of enemies
	 * @param max - maximum number of enemies
	 * @param xBound - x bound of where enemies can spawn
	 * @param yBound - y bound of where enemies can spawn
	 */
	public void spawnFlameSkulls(int min, int max, int xBound, int yBound) {
		flameSkullRespawner = new Timer(caveRespawnRate, new ActionListener() { //respawn every 10 seconds
			public void actionPerformed(ActionEvent arg0) {
				if(enemies.size() < min) {
					enemies.add(new FlameSkull(1 + r.nextInt(xBound),1 + r.nextInt(yBound)));
				}
				else if(enemies.size()>=min && enemies.size()<max) {
					int spawnChance = r.nextInt(100);
					if(spawnChance<chance) {
						enemies.add(new FlameSkull(1 + r.nextInt(xBound), 1 + r.nextInt(yBound)));
					}
				}
			}});
		flameSkullRespawner.start();
	}
	/**
	 * Spawns Crawlers
	 * @param min - minimum number of enemies
	 * @param max - maximum number of enemies
	 * @param xBound - x bound of where enemies can spawn
	 * @param yBound - y bound of where enemies can spawn
	 */
	public void spawnCrawlers(int min, int max, int xBound, int yBound) {
		crawlerRespawner = new Timer(caveRespawnRate, new ActionListener() { //respawn every 10 seconds
			public void actionPerformed(ActionEvent arg0) {
				if(enemies.size() < min) {
					enemies.add(new Crawler(1 + r.nextInt(xBound), 1 + r.nextInt(yBound)));
				}
				else if(enemies.size()>=min && enemies.size()<max) {
					int spawnChance = r.nextInt(100);
					if(spawnChance<chance) {
						enemies.add(new Crawler(1 + r.nextInt(xBound), 1 + r.nextInt(yBound)));
					}
				}
			}});
		crawlerRespawner.start();
	}
	
	
	/**
	 * Helper method to randomly spawn differently colored blobs
	 * @param xBound - x bound of where enemies can spawn
	 * @param yBound - y bound of where enemies can spawn
	 */
	private void blob(int xBound, int yBound) {
		int blobType = r.nextInt(3);
		if(blobType == 0)
			enemies.add(new Blob(1 + r.nextInt(xBound), 1 + r.nextInt(yBound)));
		if(blobType == 1)
			enemies.add(new RedBlob(1 + r.nextInt(xBound),1 + r.nextInt(yBound)));
		if(blobType == 2)
			enemies.add(new BlueBlob(1 + r.nextInt(xBound), 1 + r.nextInt(yBound)));
	}
	/**
	 * Grabs the index of the enemy
	 * @return index of enemy
	 */
	public int getEnemyIndex() {
		return enemyIndex;
	}
	/**
	 * returns all timers
	 * @return list of timers
	 */
	public ArrayList<Timer> getTimers() {
		return TimerList;
	}
	
	/**
	 * Sets the enemy's index
	 * @param enemyIndex
	 */
	public void setEnemyIndex(int enemyIndex) {
		this.enemyIndex = enemyIndex;
	}
	
	/**
	 * Draws the graphics
	 * @param g - graphics object
	 */
	public void draw(Graphics g) {
		for (Enemy e : enemies)
			e.draw(g);
	}

}
