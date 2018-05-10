package SurfaceLevels;

import java.util.Random;

import Levels.LevelCreator;

public class Level410 extends LevelCreator{
	private Random r = new Random();
	public Level410(){
		setImage("Images\\grass.png");
		for(int i = 0; i<4; i++) {
			setImage(r.nextInt(21), r.nextInt(21), "Images\\bush.png", true);
			setImage(r.nextInt(21), r.nextInt(21), "Images\\rockOnGrass.png", true);
		}
		for(int j = 0; j<21; j++) {
			setImage(j,20,"Images\\waterToSand.png", true);
			setImage(j,19,"Images\\sand.png", false);
			setImage(j,18,"Images\\sandToGrassN.png", false);
		}
	}
}
