package SurfaceLevels;

import Levels.LevelCreator;

public class Level220 extends LevelCreator {
	public Level220() {
		// no enemy

		setImage("Images\\grass.png");

		for (int k = 0; k < 18; k++) {
			setImage(1, k, "Images\\cobbleW.png", false);
			setImage(19, k, "Images\\cobbleE.png",false);
		}
		for (int k = 2; k < 19; k++) {
			setImage(k, 18, "Images\\cobbleS.png", false);
		}
		
		for (int r = 2; r < 19; r++) {
			for (int c = 0; c < 18; c++) {
				setImage(r, c, "Images\\cobble.png", false);
			}
		}
		setImage(1, 18, "Images\\cobbleSW.png", false);
		setImage(19,18,"Images\\cobbleSE.png",false);

		// shop
		setImage(13, 15, "Images\\shop1.png", true);
		setImage(14, 15, "Images\\shop2.png", true);
		setImage(15, 15, "Images\\shop3.png", true);
		setImage(13, 16, "Images\\shop4.png", true);
		setImage(14, 16, "Images\\shop5.png", true);
		setImage(15, 16, "Images\\shop6.png", false);
		setChanger(15, 16, 2);

		for (int k = 0; k < 8; k++) {
			setImage(k, 20, "Images\\bushHo.png", true);
		}
		for (int k = 13; k < 21; k++) {
			setImage(k, 20, "Images\\bushHo.png", true);
		}
	}
}
