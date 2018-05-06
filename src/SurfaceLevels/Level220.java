package SurfaceLevels;

import Levels.LevelCreator;

public class Level220  extends LevelCreator{
	public Level220(){
		setImage("grass.png");
		for(int i=0; i<11; i++) {
			setImage(9,i, "stoneOnGrass.png");
			setImage(i,9, "stoneOnGrass.png");
			setImage(10,i, "stoneOnGrass.png");
			setImage(i,10, "stoneOnGrass.png");
		}
	}
}
