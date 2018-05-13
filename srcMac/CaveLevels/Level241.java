package CaveLevels;

import java.util.Random;

import Levels.LevelCreator;

public class Level241 extends LevelCreator {
	private Random r = new Random();
	
	public Level241() {
		setImage("Images//cave.png");
		
		for(int i = 0; i < 10; i++) {
			setImage(r.nextInt(8), r.nextInt(19), "Images//rockOnCave.png", true);
			setImage(r.nextInt(7)+13, r.nextInt(19), "Images//rockOnCave.png", true);
		}
		
		for(int k = 0; k < 21; k++) {
			setImage(k,0, "Images//caveWall.png",true);
			setImage(20,k, "Images//caveWall.png",true);
		}
		setImage(17,1,"Images//cave.png",false);
		setImage(17,2,"Images//cave.png",false);
		setImage(17,3,"Images//cave.png",false);
		setImage(18,1,"Images//cave.png",false);
		setImage(18,2, "Images//door.png", false);//boss level door
		setChanger(18,2,1);
		setImage(18,3,"Images//cave.png",false);
		setImage(19,1,"Images//cave.png",false);
		setImage(19,2,"Images//cave.png",false);
		setImage(19,3,"Images//cave.png",false);

	}
}
