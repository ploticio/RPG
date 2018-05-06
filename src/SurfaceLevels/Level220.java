package SurfaceLevels;

import Levels.LevelCreator;

public class Level220  extends LevelCreator{
	public Level220(){
		setImage("Images\\grass.png");
		for(int i=0; i<11; i++) {
			setImage(9,i, "Images\\stoneOnGrass.png");
			setImage(i,9, "Images\\stoneOnGrass.png");
			setImage(10,i, "Images\\stoneOnGrass.png");
			setImage(i,10, "Images\\stoneOnGrass.png");
		}
	}
}
