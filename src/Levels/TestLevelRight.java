package Levels;

public class TestLevelRight extends LevelCreator {
	
	public TestLevelRight() {
		setImage("grass.png");
		for(int i=10; i<21; i++) {
			for(int j = 0; j<21; j++) {
				setImage(i, j, "sand.png");
			}
		}
	}
	
}
