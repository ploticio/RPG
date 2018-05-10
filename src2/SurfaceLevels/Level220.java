package SurfaceLevels;


import Levels.LevelCreator;

public class Level220  extends LevelCreator{
	public Level220(){
		setImage("Images\\grass.png");
		setImage(13,15,"Images\\shop1.png");
		setImage(14,15,"Images\\shop2.png");
		setImage(15,15,"Images\\shop3.png");
		setImage(13,16,"Images\\shop4.png");
		setImage(14,16,"Images\\shop5.png");
		setImage(15,16,"Images\\shop6.png");
		setChanger(15,16,2);
	}
}
