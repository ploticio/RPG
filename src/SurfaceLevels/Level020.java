package SurfaceLevels;

import Levels.LevelCreator;

public class Level020  extends LevelCreator{
	public Level020(){
		setImage("grass.png");
		for(int i=10; i<21; i++) {
			setImage(i-10,9, "stoneOnGrass.png");
			setImage(i-10,10, "stoneOnGrass.png");
			setImage(9,i, "stoneOnGrass.png");
			setImage(10,i, "stoneOnGrass.png");
		}
	}
}
