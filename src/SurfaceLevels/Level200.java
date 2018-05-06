package SurfaceLevels;

import Levels.LevelCreator;

public class Level200  extends LevelCreator{
	public Level200(){
		setImage("Images\\grass.png");
		for(int i=10; i<21; i++) {
			setImage(9,i-10, "Images\\stoneOnGrass.png");
			setImage(i,9, "Images\\stoneOnGrass.png");
			setImage(10,i-10, "Images\\stoneOnGrass.png");
			setImage(i,10, "Images\\stoneOnGrass.png");
		}
	}
}
