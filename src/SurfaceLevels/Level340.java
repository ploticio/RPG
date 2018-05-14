package SurfaceLevels;

import java.util.Random;

import Levels.LevelCreator;

public class Level340 extends LevelCreator {
	private Random r = new Random();
	public Level340() {
		setImage("Images\\grass.png");
		for(int i=0; i<11; i++) {
			setImage(i,9, "Images\\dirtToGrassN.png");
			setImage(i,10, "Images\\stoneOnDirt.png");
			setImage(i,11, "Images\\dirtToGrassS.png");
		}
		for(int i = 0; i<10; i++) {
			setImage(10,i, "Images\\stoneOnDirt.png");
			setImage(9,i,"Images\\dirtToGrassW.png");
			setImage(11,i,"Images\\dirtToGrassE.png");
		}
		setImage(9,9,"Images\\grassToDirtSE.png");
		setImage(11,9,"Images\\dirtToGrassE.png");
		setImage(11,10,"Images\\dirtToGrassE.png");
		setImage(11,11,"Images\\dirtToGrassSE.png");
		
		for(int i = 0; i<2; i++) {
			setImage(r.nextInt(21), r.nextInt(9)+12, "Images\\bush.png", true);
			setImage(r.nextInt(21), r.nextInt(9)+12, "Images\\rockOnGrass.png", true);
		}
		for(int i = 0; i<1; i++) {
			setImage(r.nextInt(9), r.nextInt(9), "Images\\bush.png", true);
			setImage(r.nextInt(9), r.nextInt(9), "Images\\rockOnGrass.png", true);
		}
		for(int i = 0; i<1; i++) {
			setImage(r.nextInt(9)+12, r.nextInt(9), "Images\\bush.png", true);
			setImage(r.nextInt(9)+12, r.nextInt(9), "Images\\rockOnGrass.png", true);
		}
		
		setImage(0,0,"Images\\bushEnd.png",true);
		for(int k = 0; k < 21; k++) {
			setImage(k, 20, "Images\\bushHo.png", true);
		}
		for(int k = 0; k < 21; k++) {
			setImage(20, k, "Images\\bushVe.png", true);
		}
		
	}
	
}
