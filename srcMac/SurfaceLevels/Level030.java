package SurfaceLevels;

import Levels.LevelCreator;

public class Level030 extends LevelCreator {
	public Level030() {
		setImage("Images////grass.png");
		for(int k = 0; k < 21; k++) {
			setImage(20, k, "Images////bushVe.png", true);
		}
		for(int k = 0; k < 21; k++) {
			setImage(k, 0, "Images////bushHo.png", true);
		}
	}
}
