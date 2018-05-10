package SurfaceLevels;

import Levels.LevelCreator;

public class Level000 extends LevelCreator{
	public Level000(){
		setImage("Images\\grass.png");
		for(int k = 0; k < 21; k++) {
			setImage(k, 0, "Images\\bushHo.png", true);
			setImage(0, k, "Images\\bushVe.png", true);	
			setImage(k, 20, "Images\\bushHo.png", true);
		}
	}
	
}
