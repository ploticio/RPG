package SurfaceLevels;

import Levels.LevelCreator;

public class Level120 extends LevelCreator {
	public Level120() {
		// no enemy
		setImage("Images\\grass.png");

		for (int k = 2; k < 21; k++) {
			setImage(1, k, "Images\\cobbleW.png", false);
			setImage(19, k, "Images\\cobbleE.png",false);
		}
		for(int k = 2; k < 19; k++) {
			setImage(k, 1, "Images\\cobbleN.png",false);
		}
		setImage(1, 1, "Images\\cobbleNW.png", false);
		setImage(19,1,"Images\\cobbleNE.png", true);
		for(int r = 2; r < 19; r++) {
			for(int c = 2; c < 21; c++) {
				setImage(r,c,"Images\\cobble.png",false);
			}
		}
	}
}
