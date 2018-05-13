package SurfaceLevels;

import Levels.LevelCreator;

public class Level100 extends LevelCreator {
	public Level100() {
		setImage("Images////grass.png");
		for(int k = 0; k < 21; k++) {
			setImage(0, k, "Images////bushVe.png", true);
			setImage(k,0,"Images////bushHo.png",true);
		}
	}
}
