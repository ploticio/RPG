package SurfaceLevels;

import Levels.LevelCreator;

public class Level010  extends LevelCreator{
	public Level010(){
		setImage("Images\\grass.png");
		for(int k = 0; k < 21; k++) {
			setImage(k, 0, "Images\\bushHo.png", true);
		}
		setImage(0,20,"Images\\bushEnd.png",true);
	}
	
}
