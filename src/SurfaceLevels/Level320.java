package SurfaceLevels;

import Levels.LevelCreator;

public class Level320 extends LevelCreator {
	public Level320() {
		setImage("Images\\grass.png");
		for(int i = 0; i < 21; i++) {
			setImage(9,i,"Images\\dirtToGrassW.png");
			setImage(10,i,"Images\\stoneOnDirt.png");
			setImage(11,i,"Images\\dirtToGrassE.png");
		}
	}
}
