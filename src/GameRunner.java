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
import SurfaceLevels.*;
import Entities.*;
import Items.*;

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
	private static boolean isOpen = false;// checks if inventory is open

	static int lX = 1;
	static int lY = 1;
	static int lZ = 0;
	static WorldGrid wg;
	static LevelCreator currentLevel;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				//////////////////// MAKE WINDOW//////////////////////
				JFrame window = new JFrame("Game");
				window.pack();
				window.setSize(846, 869);
				window.setResizable(false);
				window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				window.setLocationRelativeTo(null);
				window.setVisible(true);
				
				/////////////////INITIALIZATION///////////////////////
				TextBox tb = new TextBox();
				
				WorldGrid wg = new WorldGrid();
				LevelCreator[][][] worldGrid = wg.getWorldGrid();
				currentLevel = worldGrid[lX][lY][lZ];
				GraphicsMaker g = new GraphicsMaker(currentLevel);
				InventoryBox ib = new InventoryBox(currentLevel.getPlayer());
				
				window.add(g);
				window.add(ib);
				window.add(tb);
				
				currentLevel.getPlayer().addItems(new Potion());
				currentLevel.getPlayer().addItems(new Potion());
				currentLevel.getPlayer().addItems(new Potion());
				
				
				
				
				
				/////////////////// TIMERS////////////////////////////
				Timer gameTimer = new Timer(GAME_REFRESH, new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						g.update();
					}
				});
				Timer textBoxTimer = new Timer(GAME_REFRESH, new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						tb.update();
					}
				});
				Timer inventoryBoxTimer = new Timer(GAME_REFRESH, new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ib.update();
					}
				});
				Timer playerTimer = new Timer(PLAYER_DELAY, new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						debounce = false;
						for (int i = 0; i < currentLevel.getEnemyManager().getList().size(); i++) {
							Enemy e = currentLevel.getEnemyManager().getList().get(i);
							if (currentLevel.getPlayer().getxGrid() == e.getxGrid()
									&& currentLevel.getPlayer().getyGrid() == e.getyGrid()) {
								gameTimer.stop();
								tb.setBounds(20,660,800,150);
								tb.setText("You've been attacked by " + e.toString() + "!");
								textBoxTimer.start();
								break;
							}
						}
					}
				});
				Timer enemyTimer = new Timer(ENEMY_DELAY, new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						for (int i = 0; i < currentLevel.getEnemyManager().getList().size(); i++) {
							currentLevel.getEnemyManager().getList().get(i).randomMovement(currentLevel.getGrid());
						}
					}
				});
				Timer checkTimer = new Timer(GAME_REFRESH, new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (!gameTimer.isRunning()) {
							playerTimer.stop();
							enemyTimer.stop();
						} else {
							playerTimer.start();
							enemyTimer.start();
						}
					}
				});
				gameTimer.start();
				playerTimer.start();
				enemyTimer.start();
				checkTimer.start();

				//////////////////// KEYBOARD INPUT//////////////////////
				InputMap in = g.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
				in.put(KeyStroke.getKeyStroke("A"), "left");
				in.put(KeyStroke.getKeyStroke("D"), "right");
				in.put(KeyStroke.getKeyStroke("W"), "up");
				in.put(KeyStroke.getKeyStroke("S"), "down");
				in.put(KeyStroke.getKeyStroke("E"), "close textbox");
				in.put(KeyStroke.getKeyStroke("I"), "inventory");
				ActionMap out = g.getActionMap();
				out.put("left", new AbstractAction() {
					public void actionPerformed(ActionEvent arg0) {
						currentLevel.getPlayer().setCurrent("left");
						if (!debounce && gameTimer.isRunning()) {
							debounce = true;
							if (currentLevel.getPlayer().getxGrid() == 0 && lY != 0) {
								int positionY = currentLevel.getPlayer().getyGrid();
								lY -= 1;
								currentLevel = worldGrid[lX][lY][lZ];
								currentLevel.getPlayer().setxGrid(20);
								currentLevel.getPlayer().setyGrid(positionY);
								g.changeLevel(currentLevel);
								currentLevel.getPlayer().setCurrent("left");
							} else {
								if (currentLevel.getPlayer().getxGrid() != 0
										&& !currentLevel.getGrid()[currentLevel.getPlayer().getxGrid() - 1][currentLevel
												.getPlayer().getyGrid()].isBlocked()) {
									currentLevel.getPlayer().moveX(-1);
								}
							}
						}
					}
				});
				out.put("right", new AbstractAction() {
					public void actionPerformed(ActionEvent arg0) {
						currentLevel.getPlayer().setCurrent("right");
						if (!debounce && gameTimer.isRunning()) {
							debounce = true;
							if (currentLevel.getPlayer().getxGrid() == 20 && lY != worldGrid.length - 1) {
								int positionY = currentLevel.getPlayer().getyGrid();
								lY += 1;
								currentLevel = worldGrid[lX][lY][lZ];
								currentLevel.getPlayer().setxGrid(0);
								currentLevel.getPlayer().setyGrid(positionY);
								g.changeLevel(currentLevel);
								currentLevel.getPlayer().setCurrent("right");
							} else {
								if (currentLevel.getPlayer().getxGrid() != 20
										&& !currentLevel.getGrid()[currentLevel.getPlayer().getxGrid() + 1][currentLevel
												.getPlayer().getyGrid()].isBlocked()) {
									currentLevel.getPlayer().moveX(1);
								}
							}
						}
					}
				});
				out.put("up", new AbstractAction() {
					public void actionPerformed(ActionEvent arg0) {
						currentLevel.getPlayer().setCurrent("up");
						if (!debounce && gameTimer.isRunning()) {
							debounce = true;
							if (currentLevel.getPlayer().getyGrid() == 0 && lX != 0) {
								int positionX = currentLevel.getPlayer().getxGrid();
								lX -= 1;
								currentLevel = worldGrid[lX][lY][lZ];
								currentLevel.getPlayer().setyGrid(20);
								currentLevel.getPlayer().setxGrid(positionX);
								g.changeLevel(currentLevel);
								currentLevel.getPlayer().setCurrent("up");
							} else {
								if (currentLevel.getPlayer().getyGrid() != 0 && !currentLevel.getGrid()[currentLevel
										.getPlayer().getxGrid()][currentLevel.getPlayer().getyGrid() - 1].isBlocked()) {
									currentLevel.getPlayer().moveY(-1);
								}
							}
						}
						if (!gameTimer.isRunning() && ib.getArrayPostion() > 0) {
							ib.setArrowPos(1);
							// System.out.println(ib.getArrayPostion());
						}
					}
				});
				out.put("down", new AbstractAction() {
					public void actionPerformed(ActionEvent arg0) {
						currentLevel.getPlayer().setCurrent("down");
						if (!debounce && gameTimer.isRunning()) {
							debounce = true;
							if (currentLevel.getPlayer().getyGrid() == 20 && lX != worldGrid[lX].length - 1) {
								int positionX = currentLevel.getPlayer().getxGrid();
								lX += 1;
								currentLevel = worldGrid[lX][lY][lZ];
								currentLevel.getPlayer().setyGrid(0);
								currentLevel.getPlayer().setxGrid(positionX);
								g.changeLevel(currentLevel);
								currentLevel.getPlayer().setCurrent("down");
							} else {
								if (currentLevel.getPlayer().getyGrid() != 20 && !currentLevel.getGrid()[currentLevel
										.getPlayer().getxGrid()][currentLevel.getPlayer().getyGrid() + 1].isBlocked()) {
									currentLevel.getPlayer().moveY(1);
								}
							}
						}
						if (!gameTimer.isRunning() && ib.getArrayPostion() < ib.getPlayer().getInventory().size() - 1) {
							ib.setArrowPos(-1);
							// System.out.println(ib.getArrayPostion());
						}
					}
				});
				out.put("close textbox", new AbstractAction() {
					public void actionPerformed(ActionEvent arg0) {
						if (!gameTimer.isRunning()) {
							gameTimer.start();
							textBoxTimer.stop();
						}
					}
				});
				/// Added 5/7
				out.put("inventory", new AbstractAction() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						if (gameTimer.isRunning()) {
							gameTimer.stop();
							ib.setBounds(20, 360, 800, 450);
							inventoryBoxTimer.start();
						} else {
							inventoryBoxTimer.stop();
							gameTimer.start();
							
						}
						in.put(KeyStroke.getKeyStroke("F"), "use");
						out.put("use", new AbstractAction() {
							@Override
							public void actionPerformed(ActionEvent arg0) {
									currentLevel.getPlayer().getInventory().get(ib.getArrayPostion()).use(currentLevel.getPlayer());
									currentLevel.getPlayer().getInventory().remove(ib.getArrayPostion());
									
							}
						});
					}
				});
				////////////////////////////////////////////////////////
			}
		});
	}
}
