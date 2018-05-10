package SurfaceLevels;

import java.util.ArrayList;
import java.util.Random;

import Entities.Blob;
import Entities.Enemy;
import Levels.LevelCreator;
import Managers.EnemyManager;

public class Level420 extends LevelCreator{
	private Random r = new Random();
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	private EnemyManager em;
	
	public Level420(){
		setImage("Images\\grass.png");
		for(int i = 0; i < 2; i++) {
			setImage(r.nextInt(8), r.nextInt(18), "Images\\bush.png", true);
			setImage(r.nextInt(7)+13, r.nextInt(18), "Images\\bush.png", true);
		}
		for(int i = 0; i < 2; i++) {
			setImage(r.nextInt(8), r.nextInt(18), "Images\\rockOnGrass.png", true);
			setImage(r.nextInt(7)+13, r.nextInt(18), "Images\\rockOnGrass.png", true);
		}
		for(int i = 0; i < 14; i++) {
			setImage(9,i,"Images\\dirtToGrassW.png", false);
			setImage(10,i,"Images\\stoneOnDirt.png", false);
			setImage(11,i,"Images\\dirtToGrassE.png", false);
		}
		for(int j = 0; j<21; j++) {
			setImage(j,20,"Images\\water.png", true);
			setImage(j,19,"Images\\waterToSand.png", true);
			setImage(j,18,"Images\\sand.png", true);
		}
		setImage(9,14, "Images\\dirtToGrassSW.png", false);
		setImage(10,14, "Images\\dirtToGrassS.png", false);
		setImage(11,14, "Images\\dirtToGrassSE.png", false);
		
		enemies.add(new Blob(9,9));
		em = new EnemyManager(enemies);
	}
	
	public EnemyManager getEnemyManager() {
		return em;
	}
	
}
