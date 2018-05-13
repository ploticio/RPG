package SurfaceLevels;

import Levels.LevelCreator;

public class Level200  extends LevelCreator{
	public Level200(){
		setImage("Images//grass.png");
		
		for(int k = 0; k < 21; k++) {
			setImage(0, k, "Images//bushVe.png", true);
		}
	}
}
