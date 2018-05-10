package SpecialLevels;

import Levels.LevelCreator;

public class Shop222 extends LevelCreator {
	public Shop222(){
		setImage("Images\\woodHouseTile.png");
		for(int i = 0; i<21; i++) {
			setImage(i, 20, "Images\\wall_tile.png", true);
			setImage(i, 0, "Images\\wall_tile.png", true);
			setImage(0, i, "Images\\wall_tile.png", true);
			setImage(20, i, "Images\\wall_tile.png", true);
		}
		setImage(10,20, "Images\\door.png", false);
		setChanger(10,20,-2);
	}
}
