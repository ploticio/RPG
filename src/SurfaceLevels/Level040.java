package SurfaceLevels;

import Levels.LevelCreator;

public class Level040 extends LevelCreator{
	public Level040() {
		setImage("Images\\grass.png");
		for(int k = 0; k < 21; k++) {
			setImage(k, 0, "Images\\bushHo.png", true);
			setImage(0, k,"Images\\bushVe.png", true);
			setImage(20, k,"Images\\bushVe.png", true);
		}
	}
}
