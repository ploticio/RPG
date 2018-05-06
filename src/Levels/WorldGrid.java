package Levels;

import SurfaceLevels.*;

public class WorldGrid {
	
	private LevelCreator[][][] worldGrid = new LevelCreator[3][3][3];
	
	public WorldGrid() {
		worldGrid[0][0][0] = new Level000();
		worldGrid[0][1][0] = new Level010();
		worldGrid[0][2][0] = new Level020();
		worldGrid[1][0][0] = new Level100();
		worldGrid[1][1][0] = new Level110();
		worldGrid[1][2][0] = new Level120();
		worldGrid[2][0][0] = new Level200();
		worldGrid[2][1][0] = new Level210();
		worldGrid[2][2][0] = new Level220();
		worldGrid[1][1][0].getPlayer().setxGrid(9);
		worldGrid[1][1][0].getPlayer().setyGrid(9);
	}
	
	public LevelCreator[][][] getWorldGrid(){
		return worldGrid;
	}
	
}
