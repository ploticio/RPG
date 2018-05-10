package SurfaceLevels;

import Levels.LevelCreator;

public class Level330 extends LevelCreator {
	public Level330() {
		setImage("Images\\grass.png");
		setImage(0,0,"Images\\bushEnd.png",true);
		setImage(0,20,"Images\\bushEnd.png",true);
		
		for(int k = 1; k < 20; k++) {
			setImage(0, k, "Images\\bushVe.png", true);
		}
		for(int k = 1; k < 21; k++) {
			setImage(k, 0, "Images\\bushHo.png", true);
			setImage(k, 20,"Images\\bushHo.png", true);
		}
	}
	
	
}
