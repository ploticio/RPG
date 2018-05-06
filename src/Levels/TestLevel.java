package Levels;
import java.util.ArrayList;
import java.util.Random;

import Entities.Blob;
import Entities.BlueBlob;
import Entities.Enemy;
import Entities.Player;
import Entities.RedBlob;
import Graphics.TextBox;
import Managers.EnemyManager;

public class TestLevel extends LevelCreator {
	private Random r = new Random();
	
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	private EnemyManager enemyManager = new EnemyManager(enemies);
	private Player player = new Player(10,10);
	
	public TestLevel() {
		setImage("grass.png");
		for(int i = 0; i<7 ; i++) {
			setImage(r.nextInt(21), r.nextInt(18)+3, "bush.png", true);
			setImage(r.nextInt(21), r.nextInt(18)+3, "rockOnGrass.png", true);
		}
		for(int i = 0; i<21; i++) {
			setImage(i, 0, "water.png", true);
			setImage(i, 1, "water.png", true);
			setImage(i, 2, "sand.png");
		}
		for(int i1 = 0; i1<21; i1++) {
			setLevelChanger(i1, 0, true);
			setLevelChanger(i1, 20, true);
			setLevelChanger(0, i1, true);
			setLevelChanger(20, i1, true);
		}
		enemies.add(new Blob(4,4));
		enemies.add(new RedBlob(5,5));
		enemies.add(new BlueBlob(6,6));
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public EnemyManager getEnemyManager() {
		return enemyManager;
	}
	
}
