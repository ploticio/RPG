import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import Managers.EnemyManager;
import Graphics.*;
import Levels.*;
import Entities.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

//UPDATED MAY 5TH

public class GameRunner {
	
	private static final int ENEMY_DELAY = 1000;
    private static final int PLAYER_DELAY = 100;
	private static final int GAME_REFRESH = 1;
	private static boolean debounce = false;
	
	static int lX = 1;
	static int lY = 1;
	static int lZ = 0; 
	WorldGrid wg;
	static LevelCreator currentLevel;
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				////////////////////MAKE WINDOW//////////////////////
				JFrame window = new JFrame("Game");
				window.pack();
				window.setSize(856, 879);
				window.setResizable(true);
		        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        window.setLocationRelativeTo(null);
		        window.setVisible(true);
				
		        /////////////////INITIALIZATION///////////////////////
				TextBox tb = new TextBox();
				tb.visible(false);
				WorldGrid wg = new WorldGrid();
				LevelCreator[][][] worldGrid = wg.getWorldGrid();
				currentLevel = worldGrid[lX][lY][lZ];
				GraphicsMaker g = new GraphicsMaker(currentLevel);	
				window.add(g);
				window.add(tb);	
				
				///////////////////TIMERS////////////////////////////
				Timer gameTimer = new Timer(GAME_REFRESH,new ActionListener() {
		    		public void actionPerformed(ActionEvent e) {
						g.update();
					}
		    	});
				Timer playerTimer = new Timer(PLAYER_DELAY, new ActionListener() {
		    		public void actionPerformed(ActionEvent arg0) {
						debounce = false;
						for(int i = 0; i<currentLevel.getEnemyManager().getList().size(); i++) {
							Enemy e = currentLevel.getEnemyManager().getList().get(i);
							if(currentLevel.getPlayer().getxGrid()==e.getxGrid() && currentLevel.getPlayer().getyGrid()==e.getyGrid()) {
								gameTimer.stop();
								tb.setText("You've been attacked by " + e.toString() + "!");
								tb.visible(true);
								break;
							}
						}
					}
		    	});
				Timer enemyTimer = new Timer(ENEMY_DELAY, new ActionListener() {
		    		public void actionPerformed(ActionEvent e) {
						for(int i = 0; i < currentLevel.getEnemyManager().getList().size(); i++) {
							currentLevel.getEnemyManager().getList().get(i).randomMovement(currentLevel.getGrid());
					    }
					}
		    	});
				Timer checkTimer = new Timer(GAME_REFRESH, new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!gameTimer.isRunning()) {
							playerTimer.stop();
							enemyTimer.stop();
						}
						else {
							playerTimer.start();
							enemyTimer.start();
						}
					}		
				});
				gameTimer.start();
				playerTimer.start();
				enemyTimer.start();
				checkTimer.start();
				
				////////////////////KEYBOARD INPUT//////////////////////
				InputMap in = g.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
				in.put(KeyStroke.getKeyStroke("A"), "left");
				in.put(KeyStroke.getKeyStroke("D"), "right");
				in.put(KeyStroke.getKeyStroke("W"), "up");
				in.put(KeyStroke.getKeyStroke("S"), "down");
				in.put(KeyStroke.getKeyStroke("E"), "close textbox");
				ActionMap out = g.getActionMap();
				out.put("left", new AbstractAction() {
					public void actionPerformed(ActionEvent arg0) {
						currentLevel.getPlayer().setCurrent("left");
						if(!debounce && gameTimer.isRunning()) {
							debounce = true;
							if(currentLevel.getPlayer().getxGrid()==0 && lY != 0) {
								int positionY = currentLevel.getPlayer().getyGrid();
								lY-=1;
								currentLevel = worldGrid[lX][lY][lZ];
								currentLevel.getPlayer().setxGrid(20);
								currentLevel.getPlayer().setyGrid(positionY);
								g.changeLevel(currentLevel);
								currentLevel.getPlayer().setCurrent("left");
							}
							else {
								if(currentLevel.getPlayer().getxGrid() != 0 && !currentLevel.getGrid()[currentLevel.getPlayer().getxGrid()-1][currentLevel.getPlayer().getyGrid()].isBlocked()) {
									currentLevel.getPlayer().moveX(-1);
								}
							}
						}
					}
				});
				out.put("right", new AbstractAction() {
					public void actionPerformed(ActionEvent arg0) {
						currentLevel.getPlayer().setCurrent("right");
						if(!debounce && gameTimer.isRunning()) {
							debounce = true;
							if(currentLevel.getPlayer().getxGrid()==20 && lY != worldGrid.length-1) {
								int positionY = currentLevel.getPlayer().getyGrid();
								lY+=1;
								currentLevel = worldGrid[lX][lY][lZ];
								currentLevel.getPlayer().setxGrid(0);
								currentLevel.getPlayer().setyGrid(positionY);
								g.changeLevel(currentLevel);
								currentLevel.getPlayer().setCurrent("right");
							}
							else {
								if(currentLevel.getPlayer().getxGrid() != 20 && !currentLevel.getGrid()[currentLevel.getPlayer().getxGrid()+1][currentLevel.getPlayer().getyGrid()].isBlocked()) {
									currentLevel.getPlayer().moveX(1);
								}
							}
						}
					}
				});
				out.put("up", new AbstractAction() {
					public void actionPerformed(ActionEvent arg0) {
						currentLevel.getPlayer().setCurrent("up");
						if(!debounce && gameTimer.isRunning()) {
							debounce = true;
							if(currentLevel.getPlayer().getyGrid()== 0 && lX != 0) {
								int positionX = currentLevel.getPlayer().getxGrid();
								lX-=1;
								currentLevel = worldGrid[lX][lY][lZ];
								currentLevel.getPlayer().setyGrid(20);
								currentLevel.getPlayer().setxGrid(positionX);
								g.changeLevel(currentLevel);
								currentLevel.getPlayer().setCurrent("up");
							}
							else {
								if(currentLevel.getPlayer().getyGrid() != 0 && !currentLevel.getGrid()[currentLevel.getPlayer().getxGrid()][currentLevel.getPlayer().getyGrid()-1].isBlocked()) {
									currentLevel.getPlayer().moveY(-1);
								}
							}
						}
					}
				});
				out.put("down", new AbstractAction() {
					public void actionPerformed(ActionEvent arg0) {
						currentLevel.getPlayer().setCurrent("down");
						if(!debounce && gameTimer.isRunning()) {
							debounce = true;
							if(currentLevel.getPlayer().getyGrid()==20 && lX != worldGrid[lX].length-1) {
								int positionX = currentLevel.getPlayer().getxGrid();
								lX+=1;
								currentLevel = worldGrid[lX][lY][lZ];
								currentLevel.getPlayer().setyGrid(0);
								currentLevel.getPlayer().setxGrid(positionX);
								g.changeLevel(currentLevel);
								currentLevel.getPlayer().setCurrent("down");
							}
							else {
								if(currentLevel.getPlayer().getyGrid() != 20 && !currentLevel.getGrid()[currentLevel.getPlayer().getxGrid()][currentLevel.getPlayer().getyGrid()+1].isBlocked()) {
									currentLevel.getPlayer().moveY(1);
								}
							}
						}
					}
				});
				out.put("close textbox", new AbstractAction() {
					public void actionPerformed(ActionEvent arg0) {
						if(!gameTimer.isRunning()) {
							gameTimer.start();
							tb.visible(false);
						}
					}
				});
				////////////////////////////////////////////////////////
				
				
				
				
				
			}
		});
	}
}