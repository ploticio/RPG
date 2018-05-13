package SurfaceLevels;

import java.util.Random;

import Levels.LevelCreator;

public class Level000 extends LevelCreator {
	private Random r = new Random();

	public Level000() {
		setImage("Images////grass.png");

		for (int i = 0; i < 6; i++) {
			setImage(r.nextInt(8), r.nextInt(18), "Images////hut.png", true);
			setImage(r.nextInt(7) + 13, r.nextInt(18), "Images////hut.png", true);
		}
		for (int k = 0; k < 21; k++) {
			setImage(k, 0, "Images////bushHo.png", true);
			setImage(0, k, "Images////bushVe.png", true);
			setImage(k, 20, "Images////bushHo.png", true);
		}
	}

}
