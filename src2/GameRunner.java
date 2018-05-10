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
	// private static boolean isPaused = false;// checks if game is paused

	static int lX = 4;
	static int lY = 2;
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

				///////////////// INITIALIZATION///////////////////////
				TextBox tb = new TextBox();

				WorldGrid wg = new WorldGrid();
				LevelCreator[][][] worldGrid = wg.getWorldGrid();
				currentLevel = worldGrid[lX][lY][lZ];
				GraphicsMaker g = new GraphicsMaker(currentLevel);
				InventoryBox ib = new InventoryBox(currentLevel.getPlayer());
				CombatBox cb = new CombatBox(currentLevel.getPlayer());
				PauseScreen ps = new PauseScreen();
				EquipmentBox eq = new EquipmentBox();
				ArmorBox ab = new ArmorBox(currentLevel.getPlayer());

				window.add(g);
				window.add(ab);
				window.add(ib);
				window.add(cb);
				window.add(tb);
				window.add(ps);
				window.add(eq);

				currentLevel.getPlayer().addItems(new Potion());
				currentLevel.getPlayer().addItems(new Potion());
				currentLevel.getPlayer().addItems(new Potion());
				currentLevel.getPlayer().addArmor(new WoodenArmor());
				currentLevel.getPlayer().addArmor(new IronArmor());

				/////////////////// TIMERS////////////////////////////
				Timer gameTimer = new Timer(GAME_REFRESH, new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						g.update();
					}
				});
				/////////////// BOX TIMERS///////////////////////////////
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
				Timer combBoxTimer = new Timer(GAME_REFRESH, new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cb.update();
					}
				});
				Timer pauseTimer = new Timer(GAME_REFRESH, new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ps.update();
					}
				});
				Timer equipmentTimer = new Timer(GAME_REFRESH, new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						eq.update();
					}
				});
				Timer armorTimer = new Timer(GAME_REFRESH, new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ab.update();
					}
				});
				////////////////////////////////////////////////////////////
				Timer playerTimer = new Timer(PLAYER_DELAY, new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						debounce = false;
						for (int i = 0; i < currentLevel.getEnemyManager().getList().size(); i++) {
							Enemy e = currentLevel.getEnemyManager().getList().get(i);
							if (currentLevel.getPlayer().getxGrid() == e.getxGrid()
									&& currentLevel.getPlayer().getyGrid() == e.getyGrid()) {
								gameTimer.stop();
								currentLevel.getEnemyManager().setEnemyIndex(i);
								cb.setBounds(20, 660, 800, 150);
								combBoxTimer.start();
								cb.setTextMain("Fighting: " + e.getName() + "!");
								cb.setTextSub(" ");
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
				in.put(KeyStroke.getKeyStroke("F"), "use");
				in.put(KeyStroke.getKeyStroke("ESCAPE"), "pause");
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
								System.out.println("[" + lX + "][" + lY + "][" + lZ + "]");
								currentLevel.getPlayer().setCurrent("left");
							} else {
								if (currentLevel.getPlayer().getxGrid() != 0
										&& !currentLevel.getGrid()[currentLevel.getPlayer().getxGrid() - 1][currentLevel
												.getPlayer().getyGrid()].isBlocked()) {
									currentLevel.getPlayer().moveX(-1);
									System.out.println("X: " + currentLevel.getPlayer().getxGrid() + " Y: "
											+ currentLevel.getPlayer().getyGrid());
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
								System.out.println("[" + lX + "][" + lY + "][" + lZ + "]");
								currentLevel.getPlayer().setCurrent("right");
							} else {
								if (currentLevel.getPlayer().getxGrid() != 20
										&& !currentLevel.getGrid()[currentLevel.getPlayer().getxGrid() + 1][currentLevel
												.getPlayer().getyGrid()].isBlocked()) {
									currentLevel.getPlayer().moveX(1);
									System.out.println("X: " + currentLevel.getPlayer().getxGrid() + " Y: "
											+ currentLevel.getPlayer().getyGrid());
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
								System.out.println("[" + lX + "][" + lY + "][" + lZ + "]");
								currentLevel.getPlayer().setCurrent("up");
							} else {
								if (currentLevel.getPlayer().getyGrid() != 0 && !currentLevel.getGrid()[currentLevel
										.getPlayer().getxGrid()][currentLevel.getPlayer().getyGrid() - 1].isBlocked()) {
									currentLevel.getPlayer().moveY(-1);
									System.out.println("X: " + currentLevel.getPlayer().getxGrid() + " Y: "
											+ currentLevel.getPlayer().getyGrid());
								}
							}
						}
						if (inventoryBoxTimer.isRunning() && !gameTimer.isRunning() && ib.getArrayPostion() > 0) {
							ib.setArrowPos(1);
							// System.out.println(ib.getArrayPostion());
						}
						///
						if (combBoxTimer.isRunning() && !gameTimer.isRunning() && cb.getArrayPostion() > 0) {
							cb.setArrowPos(1);
							// System.out.println(cb.getArrayPostion());
						}
						if (pauseTimer.isRunning() && !gameTimer.isRunning() && ps.getArrayPostion() > 0) {
							ps.setArrowPos(1);
						}
						if (equipmentTimer.isRunning() && !gameTimer.isRunning() && eq.getArrayPostion() > 0) {
							eq.setArrowPos(1);
						}
						if (armorTimer.isRunning() && !gameTimer.isRunning() && ab.getArrayPostion() > 0) {
							ab.setArrowPos(1);
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
								System.out.println("[" + lX + "][" + lY + "][" + lZ + "]");
								currentLevel.getPlayer().setCurrent("down");
							} else {
								if (currentLevel.getPlayer().getyGrid() != 20 && !currentLevel.getGrid()[currentLevel
										.getPlayer().getxGrid()][currentLevel.getPlayer().getyGrid() + 1].isBlocked()) {
									currentLevel.getPlayer().moveY(1);
									System.out.println("X: " + currentLevel.getPlayer().getxGrid() + " Y: "
											+ currentLevel.getPlayer().getyGrid());
								}
							}

						}
						if (inventoryBoxTimer.isRunning() && !gameTimer.isRunning()
								&& ib.getArrayPostion() < ib.getPlayer().getInventory().size() - 1) {
							ib.setArrowPos(-1);
							// System.out.println(ib.getArrayPostion());
						}
						///
						if (combBoxTimer.isRunning() && !gameTimer.isRunning()
								&& cb.getArrayPostion() < cb.getPlayer().getAttacks().size() - 1) {
							cb.setArrowPos(-1);
							// System.out.println(cb.getArrayPostion());
						}
						if (pauseTimer.isRunning() && !gameTimer.isRunning() && ps.getArrayPostion() < 2) {
							ps.setArrowPos(-1);
						}
						if (equipmentTimer.isRunning() && !gameTimer.isRunning() && eq.getArrayPostion() < 1) {
							eq.setArrowPos(-1);
						}
						if (armorTimer.isRunning() && !gameTimer.isRunning()
								&& ab.getArrayPostion() < ab.getPlayer().getArmor().size()) {
							ab.setArrowPos(-1);
						}
					}
				});
				/// Added 5/7
				/*
				 * out.put("inventory", new AbstractAction() {
				 * 
				 * @Override public void actionPerformed(ActionEvent arg0) { boolean wasInCombat
				 * = false; if (!isPaused) { if (gameTimer.isRunning() &&
				 * !inventoryBoxTimer.isRunning()) { gameTimer.stop(); ib.setBounds(20, 360,
				 * 800, 450); inventoryBoxTimer.start(); } else if (combBoxTimer.isRunning() &&
				 * !inventoryBoxTimer.isRunning()) { wasInCombat = true; combBoxTimer.stop();
				 * ib.setBounds(20, 360, 800, 450); inventoryBoxTimer.start(); } else {
				 * inventoryBoxTimer.stop(); if (wasInCombat) { gameTimer.stop();
				 * combBoxTimer.start(); } else { gameTimer.start(); } }
				 * 
				 * } } });
				 */
				out.put("close textbox", new AbstractAction() {
					public void actionPerformed(ActionEvent arg0) {
						if (!gameTimer.isRunning() && textBoxTimer.isRunning() && !inventoryBoxTimer.isRunning()) {
							gameTimer.start();
							tb.setText("");
							tb.setText2("");
							textBoxTimer.stop();
						}
						/*
						 * if (!gameTimer.isRunning() && combBoxTimer.isRunning() &&
						 * !inventoryBoxTimer.isRunning()) { gameTimer.start(); combBoxTimer.stop(); }
						 */
					}
				});
				////////////////////////

				/// Added 5/8

				//////// Combat System/////////
				out.put("use", new AbstractAction() {
					//////// USING SHIT OUTSIDE OF COMBAT/////////
					public void actionPerformed(ActionEvent arg0) {
						if (inventoryBoxTimer.isRunning()) {
							currentLevel.getPlayer().getInventory().get(ib.getArrayPostion())
									.use(currentLevel.getPlayer());
							currentLevel.getPlayer().getInventory().remove(ib.getArrayPostion());
						}
						if (armorTimer.isRunning()) {
							int x = currentLevel.getPlayer().getArmor()
									.indexOf(currentLevel.getPlayer().getEquipArmor());
							if (currentLevel.getPlayer().getHasArmorEquiped()) {
								currentLevel.getPlayer().getArmor().get(x).unequip();
								currentLevel.getPlayer().getArmor().get(ab.getArrayPostion()).equip();
							} else {
								currentLevel.getPlayer().getArmor().get(ab.getArrayPostion()).equip();
								currentLevel.getPlayer().setHasArmorEquiped(true);
							}

						}
						if (pauseTimer.isRunning()) {
							if (ps.getArrayPostion() == 0) {
								pauseTimer.stop();
								ib.setBounds(20, 360, 800, 450);
								inventoryBoxTimer.start();
							}
							if (ps.getArrayPostion() == 1) {
								pauseTimer.stop();
								eq.setBounds(20, 660, 800, 150);
								equipmentTimer.start();
							}
							if (ps.getArrayPostion() == 2) {

							}
						}
						if (equipmentTimer.isRunning()) {
							if (ab.getArrayPostion() == 0) {
								equipmentTimer.stop();
								ab.setBounds(20, 360, 800, 450);
								armorTimer.start();
							}
						}

						/////////////////////////////////////////////////
						if (!gameTimer.isRunning() && combBoxTimer.isRunning()) {
							Enemy e = currentLevel.getEnemyManager().getList()
									.get(currentLevel.getEnemyManager().getEnemyIndex());
							// amount of total damage player deals
							int totalAttack = currentLevel.getPlayer().getAttacks().get(cb.getArrayPostion())
									.getStrength() + currentLevel.getPlayer().getStrength();

							// player attacks with chosen attack
							e.changeHealth(-1 * totalAttack);

							// print out player action
							cb.setTextMain("Player uses "
									+ currentLevel.getPlayer().getAttacks().get(cb.getArrayPostion()).getName()
									+ ", and deals " + totalAttack + " damage!");

							// if enemy dies
							if (e.getCurrentHP() <= 0) {
								currentLevel.getEnemyManager().getList().remove(e);
								combBoxTimer.stop();
								tb.setBounds(20, 660, 800, 150);

								tb.setText(e.getName() + " has died and dropped " + e.getGold() + " gold.");
								textBoxTimer.start();
								// cb.setTextSub("You have gained " + 5 + " exp. Press 'E' to close.");
								currentLevel.getPlayer().setExp(currentLevel.getPlayer().getExp() + 5);
								currentLevel.getPlayer().setGold(currentLevel.getPlayer().getGold() + e.getGold());
								// resume game

								// if player levels up
								if (currentLevel.getPlayer().ifNextLevel()) {
									currentLevel.getPlayer().levelUp();
									gameTimer.stop();
									combBoxTimer.stop();
									tb.setBounds(20, 660, 800, 150);
									tb.setText(e.getName() + " has died and dropped " + e.getGold() + " gold.");
									tb.setText2("You are now level " + currentLevel.getPlayer().getLevel() + "!");
									// textBoxTimer.start();
								}
							} else {

								int enemyAttack = e.getStrength();

								// enemy attacks
								currentLevel.getPlayer().changeHealth(-1 * enemyAttack);

								// print out enemy action
								cb.setTextSub(e.getName() + " attacks and deals " + enemyAttack + " damage!");

								if (currentLevel.getPlayer().getCurrentHP() <= 0) {
									// TODO: game over
								}

								// prints out enemy's current health after attack
								// System.out.println(e.getCurrentHP());
							}
						}
					}
				});
				/////////////////////////// PAUSING//////////////////////////
				//// made 5/9
				out.put("pause", new AbstractAction() {
					boolean wasInCombat = false;
					boolean isPaused = false;

					public void actionPerformed(ActionEvent arg0) {
						if (equipmentTimer.isRunning()) {
							equipmentTimer.stop();
							gameTimer.start();
						} else if (gameTimer.isRunning() && !equipmentTimer.isRunning()) {
							ps.setBounds(20, 660, 800, 150);
							gameTimer.stop();
							pauseTimer.start();
							isPaused = true;
						} else if (isPaused && inventoryBoxTimer.isRunning() && !equipmentTimer.isRunning()) {
							inventoryBoxTimer.stop();
							gameTimer.start();
							isPaused = false;
						} else if (combBoxTimer.isRunning() && !isPaused && !equipmentTimer.isRunning()) {
							wasInCombat = true;
							isPaused = true;
							combBoxTimer.stop();
							ib.setBounds(20, 360, 800, 450);
							inventoryBoxTimer.start();
						} else if (wasInCombat && isPaused && !equipmentTimer.isRunning()) {
							isPaused = false;
							wasInCombat = false;
							inventoryBoxTimer.stop();
							combBoxTimer.start();
						} else if (armorTimer.isRunning()) {
							armorTimer.stop();
							gameTimer.start();
						} else {
							pauseTimer.stop();
							gameTimer.start();
							wasInCombat = false;
							isPaused = false;
						}

					}

				});

			}
		});
	}
}
