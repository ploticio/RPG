package SurfaceLevels;

import java.util.Random;

import Levels.LevelCreator;

public class Level230 extends LevelCreator{
	private Random r = new Random();
	public Level230() {
		setImage("Images\\grass.png");
		for(int i = 0; i<2; i++) {
			setImage(r.nextInt(21), r.nextInt(9), "Images\\bush.png", true);
			setImage(r.nextInt(21), r.nextInt(9), "Images\\rockOnGrass.png", true);
		}
		for(int i = 0; i<2; i++) {
			setImage(r.nextInt(21), r.nextInt(8)+12, "Images\\bush.png", true);
			setImage(r.nextInt(21), r.nextInt(8)+12, "Images\\rockOnGrass.png", true);
		}
		
		
		setImage(20,0,"Images\\bushEnd.png",true);
		for(int k = 0; k < 21; k++) {
			setImage(k, 20, "Images\\bushHo.png", true);
		}
		
		for(int i=0; i<21; i++) {
			setImage(i,9, "Images\\dirtToGrassN.png");
			setImage(i,10, "Images\\stoneOnDirt.png");
			setImage(i,11, "Images\\dirtToGrassS.png");
		}
		
	}
	
}
