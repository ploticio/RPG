package SurfaceLevels;

import Levels.LevelCreator;

public class Level230 extends LevelCreator{
	public Level230() {
		setImage("Images//grass.png");
		setImage(20,0,"Images//bushEnd.png",true);
		for(int k = 0; k < 21; k++) {
			setImage(k, 20, "Images//bushHo.png", true);
		}
		
	}
	
}
