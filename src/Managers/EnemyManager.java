package Managers;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import Entities.*;

public class EnemyManager {
	
	private ArrayList<Enemy> enemies;
	private Random r = new Random();
	
	
	public EnemyManager(ArrayList<Enemy>enemies) {
		this.enemies = enemies;
	}
	
	public ArrayList<Enemy> getList(){
		return enemies;
	}
	
	public void draw(Graphics g) {
		for(Enemy e : enemies)
			e.draw(g);
	}
	
	
}
