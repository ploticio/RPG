package SurfaceLevels;
import java.util.Random;

import Levels.LevelCreator;


public class Level110  extends LevelCreator{
	private Random r = new Random();
	public Level110() {
		setImage("Images\\grass.png");
		for(int i = 0; i<4; i++) {
			setImage(r.nextInt(21), r.nextInt(21), "Images\\bush.png", true);
			setImage(r.nextInt(21), r.nextInt(21), "Images\\rockOnGrass.png", true);
		}
		setImage(0,0,"Images\\bushEnd.png",true);
	}
	
}
