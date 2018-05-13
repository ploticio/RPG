package SurfaceLevels;

import Levels.LevelCreator;

public class Level310 extends LevelCreator {
	public Level310() {
		setImage("Images////grass.png");
		for (int k = 0; k < 21; k++) {
			setImage(k, 20, "Images////bushHo.png", true);
			setImage(20, k, "Images////bushVe.png", true);
		}
	}
}
