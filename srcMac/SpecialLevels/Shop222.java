package SpecialLevels;

import Levels.LevelCreator;

public class Shop222 extends LevelCreator {
	public Shop222() {
		for (int r = 5; r < 16; r++) {
			for (int c = 10; c < 21; c++) {
				setImage(r, c, "Images//woodHouseTile.png", false);
			}
		}
		for (int i = 4; i < 17; i++) {
			setImage(i, 20, "Images//wallTile.png", true);
			setImage(i, 9, "Images//wallTile.png", true);
		}
		for (int i = 10; i < 21; i++) {
			setImage(4, i, "Images//wallTile.png", true);
			setImage(16, i, "Images//wallTile.png", true);
		}

		setImage(10, 11, "Images//shopKeeper.png", true);
		setImage(10, 13, "Images//shopTile.png", false);// SHOPPING SPOT
		for (int i = 6; i < 14; i++) {
			setImage(i, 12, "Images//counter2.png", true);
		}
		setImage(6, 12, "Images//counter1.png", true);
		setImage(14, 12, "Images//counter3.png", true);

		setImage(13, 18, "Images//chair.png", false);
		setImage(14, 18, "Images//table.png", true);
		setImage(15, 18, "Images//chair.png", false);
		setImage(13, 15, "Images//chair.png", false);
		setImage(14, 15, "Images//table.png", true);
		setImage(15, 15, "Images//chair.png", false);
		setImage(5, 15, "Images//chair.png", false);
		setImage(6, 15, "Images//table.png", true);
		setImage(7, 15, "Images//chair.png", false);
		setImage(5, 18, "Images//chair.png", false);
		setImage(6, 18, "Images//table.png", true);
		setImage(7, 18, "Images//chair.png", false);

		setImage(10, 20, "Images//door.png", false);
		setChanger(10, 20, -2);
	}
}
