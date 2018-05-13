package SurfaceLevels;

import Levels.LevelCreator;

public class Level300 extends LevelCreator{
	public Level300() {
		setImage("Images////grass.png");
		for (int k = 0; k < 21; k++) {
			setImage(k, 20, "Images////bushHo.png", true);
			setImage(0, k, "Images////bushVe.png", true);
		}
	}
}
