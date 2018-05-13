package SurfaceLevels;

import java.util.Random;

import Levels.LevelCreator;


public class Level010  extends LevelCreator{
	private Random r = new Random();
	public Level010(){
		setImage("Images\\grass.png");
		for(int i = 0; i<4; i++) {
			setImage(r.nextInt(21), r.nextInt(21), "Images\\bush.png", true);
			setImage(r.nextInt(21), r.nextInt(21), "Images\\rockOnGrass.png", true);
		}
		for(int k = 0; k < 21; k++) {
			setImage(k, 0, "Images\\bushHo.png", true);
		}
		setImage(0,20,"Images\\bushEnd.png",true);
	}
	
}
