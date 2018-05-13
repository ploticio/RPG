package SurfaceLevels;

import Levels.LevelCreator;

public class Level020  extends LevelCreator{
	public Level020(){
		setImage("Images//grass.png");
		for(int k = 0; k < 21; k++) {
			setImage(k, 0, "Images//bushHo.png", true);
		}
	}
	
}
