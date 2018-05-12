package SurfaceLevels;

import Levels.LevelCreator;

public class Level330 extends LevelCreator {
	public Level330() {
		setImage("Images\\grass.png");
		setImage(0,0,"Images\\bushEnd.png",true);
		setImage(0,20,"Images\\bushEnd.png",true);
		
		for(int k = 1; k < 20; k++) {
			setImage(0, k, "Images\\bushVe.png", true);
		}
		for(int k = 1; k < 21; k++) {
			setImage(k, 0, "Images\\bushHo.png", true);
			setImage(k, 20,"Images\\bushHo.png", true);
		}
		setImage(6,4,"Images\\cEnt1.png",true);
		setImage(7,4,"Images\\cEnt2.png",true);
		setImage(8,4,"Images\\cEnt3.png",true);
		setImage(9,4,"Images\\cEnt4.png",true);
		setImage(10,4,"Images\\cEnt5.png",true);
		setImage(6,5,"Images\\cEnt6.png",true);
		setImage(7,5,"Images\\cEnt7.png",true);
		setImage(8,5,"Images\\cEnt8.png",true);
		setImage(9,5,"Images\\cEnt9.png",true);
		setImage(10,5,"Images\\cEnt10.png",true);
		setImage(6,6,"Images\\cEnt11.png",true);
		setImage(7,6,"Images\\cEnt12.png",true);
		setImage(8,6,"Images\\cEnt13.png",true);
		setImage(9,6,"Images\\cEnt14.png",true);
		setImage(10,6,"Images\\cEnt15.png",true);
		setImage(6,7,"Images\\cEnt16.png",true);
		setImage(7,7,"Images\\cEnt17.png",true);
		setImage(8,7,"Images\\cEnt18.png",false);//entrance
		setChanger(8, 6, 1);
		setImage(9,7,"Images\\cEnt19.png",true);
		setImage(10,7,"Images\\cEnt20.png",true);
	}
	
	
}
