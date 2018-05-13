package CaveLevels;

import java.util.Random;

import Levels.LevelCreator;

public class Level331 extends LevelCreator {
	private Random r = new Random();
	
	public Level331(){
		//STARTING AREA//
		setChanger(10, 20, -1);
		setImage("Images//cave.png");
		
		for(int i = 0; i < 10; i++) {
			setImage(r.nextInt(8), r.nextInt(19), "Images//rockOnCave.png", true);
			setImage(r.nextInt(7)+13, r.nextInt(19), "Images//rockOnCave.png", true);
		}
		
		for(int k = 0; k < 21; k++) {
			setImage(0,k, "Images//caveWall.png",true);
			setImage(k,20, "Images//caveWall.png",true);
		}
		setImage(10,20,"Images//cEntTile.png",false);

	}
}
