package SurfaceLevels;

import Levels.LevelCreator;

public class Level120 extends LevelCreator {
	public Level120() {
		// no enemy
		setImage("Images\\grass.png");

		for (int k = 2; k < 21; k++) {
			setImage(1, k, "Images\\cobbleW.png", false);
			setImage(19, k, "Images\\cobbleE.png",false);
		}
		for(int k = 2; k < 19; k++) {
			setImage(k, 1, "Images\\cobbleN.png",false);
		}
		setImage(1, 1, "Images\\cobbleNW.png", false);
		setImage(19,1,"Images\\cobbleNE.png", true);
		for(int r = 2; r < 19; r++) {
			for(int c = 2; c < 21; c++) {
				setImage(r,c,"Images\\cobble.png",false);
			}
		}
		
		setImage(3,14,"Images\\house1.png",true);
		setImage(4,14,"Images\\house2.png",true);
		setImage(5,14,"Images\\house3.png",true);
		setImage(3,15,"Images\\house4.png",true);
		setImage(4,15,"Images\\house5.png",true);
		setImage(5,15,"Images\\house6.png",true);
		setImage(3,16,"Images\\house7.png",true);
		setImage(4,16,"Images\\house8.png",true);
		setImage(5,16,"Images\\house9.png",true);
		
		setImage(3,2,"Images\\house1.png",true);
		setImage(4,2,"Images\\house2.png",true);
		setImage(5,2,"Images\\house3.png",true);
		setImage(3,3,"Images\\house4.png",true);
		setImage(4,3,"Images\\house5.png",true);
		setImage(5,3,"Images\\house6.png",true);
		setImage(3,4,"Images\\house7.png",true);
		setImage(4,4,"Images\\house8.png",true);
		setImage(5,4,"Images\\house9.png",true);

		setImage(3,8,"Images\\house1.png",true);
		setImage(4,8,"Images\\house2.png",true);
		setImage(5,8,"Images\\house3.png",true);
		setImage(3,9,"Images\\house4.png",true);
		setImage(4,9,"Images\\house5.png",true);
		setImage(5,9,"Images\\house6.png",true);
		setImage(3,10,"Images\\house7.png",true);
		setImage(4,10,"Images\\house8.png",true);
		setImage(5,10,"Images\\house9.png",true);
		
		setImage(13,2,"Images\\house1.png",true);
		setImage(14,2,"Images\\house2.png",true);
		setImage(15,2,"Images\\house3.png",true);
		setImage(13,3,"Images\\house4.png",true);
		setImage(14,3,"Images\\house5.png",true);
		setImage(15,3,"Images\\house6.png",true);
		setImage(13,4,"Images\\house7.png",true);
		setImage(14,4,"Images\\house8.png",true);
		setImage(15,4,"Images\\house9.png",true);
		
		setImage(13,14,"Images\\house1.png",true);
		setImage(14,14,"Images\\house2.png",true);
		setImage(15,14,"Images\\house3.png",true);
		setImage(13,15,"Images\\house4.png",true);
		setImage(14,15,"Images\\house5.png",true);
		setImage(15,15,"Images\\house6.png",true);
		setImage(13,16,"Images\\house7.png",true);
		setImage(14,16,"Images\\house8.png",true);
		setImage(15,16,"Images\\house9.png",true);
		
		setImage(13,8,"Images\\house1.png",true);
		setImage(14,8,"Images\\house2.png",true);
		setImage(15,8,"Images\\house3.png",true);
		setImage(13,9,"Images\\house4.png",true);
		setImage(14,9,"Images\\house5.png",true);
		setImage(15,9,"Images\\house6.png",true);
		setImage(13,10,"Images\\house7.png",true);
		setImage(14,10,"Images\\house8.png",true);
		setImage(15,10,"Images\\house9.png",true);
		
	}
}
