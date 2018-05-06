package SurfaceLevels;

import Levels.LevelCreator;

public class Level100 extends LevelCreator {
	public Level100() {
		setImage("grass.png");
		for(int i = 0; i<21; i++) {
			setImage(9,i, "stoneOnGrass.png");
			setImage(10,i, "stoneOnGrass.png");
		}
		for(int i = 10; i<21; i++) {
			setImage(i,9, "stoneOnGrass.png");
			setImage(i,10, "stoneOnGrass.png");
		}
	}
}
