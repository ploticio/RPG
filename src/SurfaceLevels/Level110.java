package SurfaceLevels;

import java.util.ArrayList;

import Entities.Blob;
import Entities.Enemy;
import Levels.LevelCreator;
import Managers.EnemyManager;

public class Level110  extends LevelCreator{
	
	ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	EnemyManager em;
	
	public Level110() {
		setImage("Images\\grass.png");
		for(int i = 0; i < 21; i++) {
			setImage(i,9, "Images\\stoneOnGrass.png");
			setImage(i,10, "Images\\stoneOnGrass.png");
			setImage(9,i, "Images\\stoneOnGrass.png");
			setImage(10,i, "Images\\stoneOnGrass.png");
		}
		setImage(8,8,"Images\\signOnGrass.png");
		setImage(8,11,"Images\\signOnGrass.png");
		setImage(11,11,"Images\\signOnGrass.png");
		setImage(11,8,"Images\\signOnGrass.png");
		
		enemies.add(new Blob(8,9));
		em = new EnemyManager(enemies);
	}
	
	public EnemyManager getEnemyManager() {
		return em;
	}
}
