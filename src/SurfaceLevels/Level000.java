package SurfaceLevels;

import Levels.LevelCreator;

public class Level000 extends LevelCreator{
	public Level000(){
		setImage("grass.png");
		for(int i=9; i<21; i++) {
			setImage(9,i, "stoneOnGrass.png");
			setImage(i,9, "stoneOnGrass.png");
			setImage(10,i, "stoneOnGrass.png");
			setImage(i,10, "stoneOnGrass.png");
		}
	}
}
