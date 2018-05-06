package SurfaceLevels;

import Levels.LevelCreator;

public class Level000 extends LevelCreator{
	public Level000(){
		setImage("Images\\grass.png");
		for(int i=9; i<21; i++) {
			setImage(9,i, "Images\\stoneOnGrass.png");
			setImage(i,9, "Images\\stoneOnGrass.png");
			setImage(10,i, "Images\\stoneOnGrass.png");
			setImage(i,10, "Images\\stoneOnGrass.png");
		}
	}
}
