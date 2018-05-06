package SurfaceLevels;

import Levels.LevelCreator;

public class Level110  extends LevelCreator{
	public Level110() {
		setImage("grass.png");
		for(int i = 0; i < 21; i++) {
			setImage(i,9, "stoneOnGrass.png");
			setImage(i,10, "stoneOnGrass.png");
			setImage(9,i, "stoneOnGrass.png");
			setImage(10,i, "stoneOnGrass.png");
		}
		setImage(8,8,"signOnGrass.png");
		setImage(8,11,"signOnGrass.png");
		setImage(11,11,"signOnGrass.png");
		setImage(11,8,"signOnGrass.png");
	}
}
