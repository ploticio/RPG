package SurfaceLevels;

import Levels.LevelCreator;

public class Level320 extends LevelCreator {
	public Level320() {
		//no enemy
		setImage("Images//grass.png");
		for(int i = 0; i < 21; i++) {
			setImage(9,i,"Images//dirtToGrassW.png", false);
			setImage(10,i,"Images//stoneOnDirt.png", false);
			setImage(11,i,"Images//dirtToGrassE.png", false);
		}
		for(int k = 0; k < 21; k++) {
			setImage(7, k, "Images//bushVe.png", true);
			setImage(13, k,"Images//bushVe.png", true);
		}
	}
}
