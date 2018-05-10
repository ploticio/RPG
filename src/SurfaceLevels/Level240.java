package SurfaceLevels;

import Levels.LevelCreator;

public class Level240 extends LevelCreator{
	public Level240() {
		setImage("Images\\grass.png");
		setImage(0,20,"Images\\bushEnd.png");
		for(int k = 0; k < 21; k++) {
			setImage(k, 0, "Images\\bushHo.png", true);
		}
		for(int k = 0; k < 21; k++) {
			setImage(20, k, "Images\\bushVe.png", true);
		}
		
	}
	
}
