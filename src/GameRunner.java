import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import Graphics.*;
import Levels.*;
import Entities.*;
import Items.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Random;

//UPDATED MAY 12TH

public class GameRunner {

	private static final int ENEMY_DELAY = 1000;
	private static final int PLAYER_DELAY = 100;
	private static final int DESPAWN_RATE = 5000;
	private static final int GAME_REFRESH = 1;
	private static boolean debounce = false;
	private static boolean isBuying = false;
	private static boolean isSelling = false;
	private static Random r = new Random();
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
				JFrame window = new JFrame("RPG Master");
				window.pack();
				window.setSize(846, 869);
				window.setResizable(false);
				window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				window.setLocationRelativeTo(null);
				window.setVisible(true);
				
				///////////////// INITIALIZATION///////////////////////
				TextBox tb = new TextBox();
				Player p = new Player();
				Player shopKeeper = new Player();

				WorldGrid wg = new WorldGrid();
				LevelCreator[][][] worldGrid = wg.getWorldGrid();
				currentLevel = worldGrid[lX][lY][lZ];
				GraphicsMaker g = new GraphicsMaker(currentLevel);
				InventoryBox ib = new InventoryBox(p);
				CombatBox cb = new CombatBox(p);
				PauseScreen ps = new PauseScreen();
				ArmorBox ab = new ArmorBox(p);
				WeaponBox wb = new WeaponBox(p);
				DeathScreen ds = new DeathScreen();
				WinScreen ws = new WinScreen();
				ShopScreen ss = new ShopScreen();
				BuySellScreen bs = new BuySellScreen();
				InventoryBox shopItems = new InventoryBox(shopKeeper);
				ArmorBox shopArmor = new ArmorBox(shopKeeper);
				WeaponBox shopWeapon = new WeaponBox(shopKeeper);

				window.add(g);
				window.add(ab);
				window.add(ib);
				window.add(cb);
				window.add(tb);
				window.add(ps);
				window.add(wb);
				window.add(ds);
				window.add(ws);
				window.add(ss);
				window.add(bs);
				window.add(shopItems);
				window.add(shopArmor);
				window.add(shopWeapon);
				
				p.addItems(new Potion());
				p.addItems(new Potion());
				p.addItems(new Potion());
				
				shopKeeper.addItems(new Potion());
				shopKeeper.addItems(new BigPotion());
				shopKeeper.addArmor(new GoblinMail());
				shopKeeper.addArmor(new ChainMail());
				shopKeeper.addArmor(new GoldMail());
				shopKeeper.addWeapon(new WoodenSword());
				shopKeeper.addWeapon(new StoneSword());
				shopKeeper.addWeapon(new GoldSword());
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
				Timer armorTimer = new Timer(GAME_REFRESH, new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ab.update();
					}
				});
				Timer weaponTimer = new Timer(GAME_REFRESH, new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						wb.update();
					}
				});
				Timer deathTimer = new Timer(GAME_REFRESH, new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ds.update();
					}
				});
				Timer winTimer = new Timer(GAME_REFRESH, new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ws.update();
					}
				});
				Timer shopTimer = new Timer(GAME_REFRESH, new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ss.update();
					}
				});
				Timer buySellTimer = new Timer(GAME_REFRESH, new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						bs.update();
					}
				});
				Timer shopItemsTimer = new Timer(GAME_REFRESH, new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						shopItems.update();
						shopKeeper.setGold(p.getGold());
					}
				});
				Timer shopArmorTimer = new Timer(GAME_REFRESH, new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						shopArmor.update();
						shopKeeper.setGold(p.getGold());
					}
				});
				Timer shopWeaponTimer = new Timer(GAME_REFRESH, new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						shopWeapon.update();
						shopKeeper.setGold(p.getGold());
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
								cb.setEnemy(e);
								// System.out.println(p.getEquipedWeapon());
								if (p.hasWeapon()) {
									p.setWeaponAttacks(true);
								} else {
									p.setWeaponAttacks(false);
								}
								combBoxTimer.start();
								cb.setTextMain("Fighting: " + e.getName() + "!");
								cb.setTextSub(" ");
								cb.setTextTertiary(" ");
							}
							if (lX == 2 && lY == 4 && lZ == 2) {
								if (currentLevel.getPlayer().getxGrid() > 0 && currentLevel.getPlayer().getxGrid() < 19
										&& currentLevel.getPlayer().getyGrid() > 0
										&& currentLevel.getPlayer().getyGrid() < 14) {
									gameTimer.stop();
									currentLevel.getEnemyManager().setEnemyIndex(i);
									cb.setBounds(20, 660, 800, 150);
									cb.setEnemy(e);
									// System.out.println(p.getEquipedWeapon());
									if (p.hasWeapon()) {
										p.setWeaponAttacks(true);
									} else {
										p.setWeaponAttacks(false);
									}
									combBoxTimer.start();
									cb.setTextMain("Fighting: " + e.getName() + "!");
									cb.setTextSub(" ");
								}
								if (currentLevel.getPlayer().getxGrid() == 10
										&& currentLevel.getPlayer().getyGrid() == 0) {
									//
								}
							}
						}
					}
				});
				Timer enemyTimer = new Timer(ENEMY_DELAY, new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (lZ != 2) {
							for (int i = 0; i < currentLevel.getEnemyManager().getList().size(); i++) {
								currentLevel.getEnemyManager().getList().get(i).randomMovement(currentLevel.getGrid());
							}
						}
					}
				});
				Timer checkTimer = new Timer(GAME_REFRESH, new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (!gameTimer.isRunning()) {
							playerTimer.stop();
							enemyTimer.stop();
							if (lZ == 0) {
								for (int y = 0; y < 5; y++) {
									for (int x = 0; x < 5; x++) {
										for (int i = 0; i < worldGrid[x][y][lZ].getEnemyManager().getTimers()
												.size(); i++) {
											if (worldGrid[x][y][lZ].getEnemyManager().getTimers().get(i) != null) {
												worldGrid[x][y][lZ].getEnemyManager().getTimers().get(i).stop();
											}
										}
									}
								}
							}
							if (lZ == 1) {
								for (int y = 3; y < 5; y++) {
									for (int x = 2; x < 4; x++) {
										for (int i = 0; i < worldGrid[x][y][lZ].getEnemyManager().getTimers()
												.size(); i++) {
											if (worldGrid[x][y][lZ].getEnemyManager().getTimers().get(i) != null) {
												worldGrid[x][y][lZ].getEnemyManager().getTimers().get(i).stop();
											}
										}
									}
								}
							}
						} else {
							playerTimer.start();
							enemyTimer.start();
							if (lZ == 0) {
								for (int y = 0; y < 5; y++) {
									for (int x = 0; x < 5; x++) {
										for (int i = 0; i < worldGrid[x][y][lZ].getEnemyManager().getTimers()
												.size(); i++) {
											if (worldGrid[x][y][lZ].getEnemyManager().getTimers().get(i) != null) {
												worldGrid[x][y][lZ].getEnemyManager().getTimers().get(i).start();
											}
										}
									}
								}
							}
							if (lZ == 1) {
								for (int y = 3; y < 5; y++) {
									for (int x = 2; x < 4; x++) {
										for (int i = 0; i < worldGrid[x][y][lZ].getEnemyManager().getTimers()
												.size(); i++) {
											if (worldGrid[x][y][lZ].getEnemyManager().getTimers().get(i) != null) {
												worldGrid[x][y][lZ].getEnemyManager().getTimers().get(i).start();
											}
										}
									}
								}
							}
						}

					}
				});

				Timer despawnTimer = new Timer(DESPAWN_RATE, new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (lZ == 0) {
							for (int y = 3; y < 5; y++) {
								for (int x = 2; x < 4; x++) {
									Iterator<Enemy> iter = worldGrid[x][y][1].getEnemyManager().getList().iterator();
									while (iter.hasNext()) {
										iter.next();
										// System.out.println(iter);
										iter.remove();
									}
								}
							}
						}
						if (lZ == 1) {
							for (int y = 0; y < 5; y++) {
								for (int x = 0; x < 5; x++) {
									Iterator<Enemy> iter = worldGrid[x][y][0].getEnemyManager().getList().iterator();
									while (iter.hasNext()) {
										iter.next();
										// System.out.println(iter);
										iter.remove();
									}
								}
							}
						}
					}
				});

				gameTimer.start();
				playerTimer.start();
				enemyTimer.start();
				checkTimer.start();
				despawnTimer.start();
				
				//////////////////// KEYBOARD INPUT//////////////////////
				InputMap in = g.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
				in.put(KeyStroke.getKeyStroke("A"), "left");
				in.put(KeyStroke.getKeyStroke("D"), "right");
				in.put(KeyStroke.getKeyStroke("W"), "up");
				in.put(KeyStroke.getKeyStroke("S"), "down");
				in.put(KeyStroke.getKeyStroke("LEFT"), "left");
				in.put(KeyStroke.getKeyStroke("RIGHT"), "right");
				in.put(KeyStroke.getKeyStroke("UP"), "up");
				in.put(KeyStroke.getKeyStroke("DOWN"), "down");
				in.put(KeyStroke.getKeyStroke("E"), "menu");
				in.put(KeyStroke.getKeyStroke("F"), "use");
				in.put(KeyStroke.getKeyStroke("F12"), "level");
				ActionMap out = g.getActionMap();
				out.put("level", new AbstractAction() {
					public void actionPerformed(ActionEvent arg0) {
						p.levelUp();
					}});
				out.put("left", new AbstractAction() {
					public void actionPerformed(ActionEvent arg0) {
						currentLevel.getPlayer().setCurrent("left");
						if (!debounce && gameTimer.isRunning()) {
							debounce = true;
							if ((currentLevel.getPlayer().getxGrid() == 0 && lY != 0 && lZ == 0)
									|| (currentLevel.getPlayer().getxGrid() == 0 && lY != 3 && lZ == 1)) {
								int positionY = currentLevel.getPlayer().getyGrid();
								lY -= 1;
								currentLevel = worldGrid[lX][lY][lZ];
								currentLevel.getPlayer().setxGrid(20);
								currentLevel.getPlayer().setyGrid(positionY);
								g.changeLevel(currentLevel);
								// System.out.println("[" + lX + "][" + lY + "][" + lZ + "]");
								currentLevel.getPlayer().setCurrent("left");
							} else if (currentLevel.getGrid()[currentLevel.getPlayer().getxGrid() - 1][currentLevel
									.getPlayer().getyGrid()].getChanger() != 0) {
								int changer = currentLevel.getGrid()[currentLevel.getPlayer().getxGrid()
										- 1][currentLevel.getPlayer().getyGrid()].getChanger();
								lZ += currentLevel.getGrid()[currentLevel.getPlayer().getxGrid() - 1][currentLevel
										.getPlayer().getyGrid()].getChanger();
								currentLevel = worldGrid[lX][lY][lZ];
								g.changeLevel(currentLevel);
								if (lZ == 2 || lZ == 1) {
									currentLevel.getPlayer().setyGrid(19);
									currentLevel.getPlayer().setxGrid(10);
									currentLevel.getPlayer().setCurrent("up");
								} else if (lZ == 0) {
									if (changer == -2) {
										currentLevel.getPlayer().setyGrid(17);
										currentLevel.getPlayer().setxGrid(15);
										currentLevel.getPlayer().setCurrent("down");
									}
									if (changer == -1) {
										currentLevel.getPlayer().setyGrid(7);
										currentLevel.getPlayer().setxGrid(8);
										currentLevel.getPlayer().setCurrent("down");
									}
								}
								// System.out.println("[" + lX + "][" + lY + "][" + lZ + "]");
							} else {
								if (currentLevel.getPlayer().getxGrid() != 0
										&& !currentLevel.getGrid()[currentLevel.getPlayer().getxGrid() - 1][currentLevel
												.getPlayer().getyGrid()].isBlocked()) {
									currentLevel.getPlayer().moveX(-1);
									// System.out.println("X: " + currentLevel.getPlayer().getxGrid() + " Y: "+
									// currentLevel.getPlayer().getyGrid());
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
							if (currentLevel.getPlayer().getxGrid() == 20 && lY != worldGrid.length - 1 && lZ != 2) {
								int positionY = currentLevel.getPlayer().getyGrid();
								lY += 1;
								currentLevel = worldGrid[lX][lY][lZ];
								currentLevel.getPlayer().setxGrid(0);
								currentLevel.getPlayer().setyGrid(positionY);
								g.changeLevel(currentLevel);
								// System.out.println("[" + lX + "][" + lY + "][" + lZ + "]");
								currentLevel.getPlayer().setCurrent("right");
							} else if (currentLevel.getGrid()[currentLevel.getPlayer().getxGrid() + 1][currentLevel
									.getPlayer().getyGrid()].getChanger() != 0) {
								int changer = currentLevel.getGrid()[currentLevel.getPlayer().getxGrid()
										+ 1][currentLevel.getPlayer().getyGrid()].getChanger();
								lZ += currentLevel.getGrid()[currentLevel.getPlayer().getxGrid() + 1][currentLevel
										.getPlayer().getyGrid()].getChanger();
								currentLevel = worldGrid[lX][lY][lZ];
								g.changeLevel(currentLevel);
								if (lZ == 2 || lZ == 1) {
									currentLevel.getPlayer().setyGrid(19);
									currentLevel.getPlayer().setxGrid(10);
									currentLevel.getPlayer().setCurrent("up");
								} else if (lZ == 0) {
									if (changer == -2) {
										currentLevel.getPlayer().setyGrid(17);
										currentLevel.getPlayer().setxGrid(15);
										currentLevel.getPlayer().setCurrent("down");
									}
									if (changer == -1) {
										currentLevel.getPlayer().setyGrid(7);
										currentLevel.getPlayer().setxGrid(8);
										currentLevel.getPlayer().setCurrent("down");
									}
								}
								// System.out.println("[" + lX + "][" + lY + "][" + lZ + "]");
							} else {
								if (currentLevel.getPlayer().getxGrid() != 20
										&& !currentLevel.getGrid()[currentLevel.getPlayer().getxGrid() + 1][currentLevel
												.getPlayer().getyGrid()].isBlocked()) {
									currentLevel.getPlayer().moveX(1);
									// System.out.println("X: " + currentLevel.getPlayer().getxGrid() + " Y: "+
									// currentLevel.getPlayer().getyGrid());
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
							if ((currentLevel.getPlayer().getyGrid() == 0 && lX != 0 && lZ == 0)
									|| (currentLevel.getPlayer().getyGrid() == 0 && lX != 2 && lZ == 1)) {
								int positionX = currentLevel.getPlayer().getxGrid();
								lX -= 1;
								currentLevel = worldGrid[lX][lY][lZ];
								currentLevel.getPlayer().setyGrid(20);
								currentLevel.getPlayer().setxGrid(positionX);
								g.changeLevel(currentLevel);
								//System.out.println("[" + lX + "][" + lY + "][" + lZ + "]");
								currentLevel.getPlayer().setCurrent("up");
							} else if (currentLevel.getGrid()[currentLevel.getPlayer().getxGrid()][currentLevel
									.getPlayer().getyGrid() - 1].getChanger() != 0) {
								int changer = currentLevel.getGrid()[currentLevel.getPlayer().getxGrid()][currentLevel
										.getPlayer().getyGrid() - 1].getChanger();
								lZ += currentLevel.getGrid()[currentLevel.getPlayer().getxGrid()][currentLevel
										.getPlayer().getyGrid() - 1].getChanger();
								currentLevel = worldGrid[lX][lY][lZ];
								g.changeLevel(currentLevel);
								if (lZ == 2 || lZ == 1) {
									currentLevel.getPlayer().setyGrid(19);
									currentLevel.getPlayer().setxGrid(10);
									currentLevel.getPlayer().setCurrent("up");
								} else if (lZ == 0) {
									if (changer == -2) {
										currentLevel.getPlayer().setyGrid(17);
										currentLevel.getPlayer().setxGrid(15);
										currentLevel.getPlayer().setCurrent("down");
									}
									if (changer == -1) {
										currentLevel.getPlayer().setyGrid(7);
										currentLevel.getPlayer().setxGrid(8);
										currentLevel.getPlayer().setCurrent("down");
									}
								}
								// System.out.println("[" + lX + "][" + lY + "][" + lZ + "]");
							} else {
								if (currentLevel.getPlayer().getyGrid() != 0 && !currentLevel.getGrid()[currentLevel
										.getPlayer().getxGrid()][currentLevel.getPlayer().getyGrid() - 1].isBlocked()) {
									currentLevel.getPlayer().moveY(-1);
									// System.out.println("X: " + currentLevel.getPlayer().getxGrid() + " Y: "+
									// currentLevel.getPlayer().getyGrid());
								}
							}
						}
						if (inventoryBoxTimer.isRunning() && !gameTimer.isRunning() && ib.getArrayPostion() > 0) {
							ib.setArrowPos(1);
							// System.out.println(ib.getArrayPostion());
						}
						if (shopItemsTimer.isRunning() && !gameTimer.isRunning() && shopItems.getArrayPostion() > 0) {
							shopItems.setArrowPos(1);
						}
						if (shopArmorTimer.isRunning() && !gameTimer.isRunning() && shopArmor.getArrayPostion() > 0) {
							shopArmor.setArrowPos(1);
						}
						if (shopWeaponTimer.isRunning() && !gameTimer.isRunning() && shopWeapon.getArrayPostion() > 0) {
							shopWeapon.setArrowPos(1);
						}
						if (combBoxTimer.isRunning() && !gameTimer.isRunning() && cb.getArrayPostion() > 0) {
							cb.setArrowPos(1);
							// System.out.println(cb.getArrayPostion());
						}
						if (pauseTimer.isRunning() && !gameTimer.isRunning() && ps.getArrayPostion() > 0) {
							ps.setArrowPos(1);
						}
						if (armorTimer.isRunning() && !gameTimer.isRunning() && ab.getArrayPostion() > 0) {
							ab.setArrowPos(1);
						}
						if (weaponTimer.isRunning() && !gameTimer.isRunning() && wb.getArrayPostion() > 0) {
							wb.setArrowPos(1);
						}
						if (shopTimer.isRunning() && ss.getArrayPostion() > 0) {
							ss.setArrowPos(1);
						}
						if (buySellTimer.isRunning() && bs.getArrayPostion() > 0) {
							bs.setArrowPos(1);
						}
					}
				});
				out.put("down", new AbstractAction() {
					public void actionPerformed(ActionEvent arg0) {
						currentLevel.getPlayer().setCurrent("down");
						if (!debounce && gameTimer.isRunning()) {
							debounce = true;
							if ((currentLevel.getPlayer().getyGrid() == 20 && lX != worldGrid[lX].length - 1 && lZ == 0)
									|| (currentLevel.getPlayer().getyGrid() == 20 && lX != 3 && lZ == 1)) {
								int positionX = currentLevel.getPlayer().getxGrid();
								lX += 1;
								currentLevel = worldGrid[lX][lY][lZ];
								currentLevel.getPlayer().setyGrid(0);
								currentLevel.getPlayer().setxGrid(positionX);
								g.changeLevel(currentLevel);
								// System.out.println("[" + lX + "][" + lY + "][" + lZ + "]");
								currentLevel.getPlayer().setCurrent("down");
							} else if (currentLevel.getGrid()[currentLevel.getPlayer().getxGrid()][currentLevel
									.getPlayer().getyGrid() + 1].getChanger() != 0) {
								int changer = currentLevel.getGrid()[currentLevel.getPlayer().getxGrid()][currentLevel
										.getPlayer().getyGrid() + 1].getChanger();
								// System.out.println(changer);
								lZ += currentLevel.getGrid()[currentLevel.getPlayer().getxGrid()][currentLevel
										.getPlayer().getyGrid() + 1].getChanger();
								currentLevel = worldGrid[lX][lY][lZ];
								g.changeLevel(currentLevel);
								if (lZ == 2 || lZ == 1) {
									// System.out.println(changer);
									currentLevel.getPlayer().setyGrid(19);
									currentLevel.getPlayer().setxGrid(10);
									currentLevel.getPlayer().setCurrent("up");
								} else if (lZ == 0) {
									if (changer == -2) {
										// System.out.println(changer);
										currentLevel.getPlayer().setyGrid(17);
										currentLevel.getPlayer().setxGrid(15);
										currentLevel.getPlayer().setCurrent("down");
									}
									if (changer == -1) {
										// System.out.println(changer);
										currentLevel.getPlayer().setyGrid(7);
										currentLevel.getPlayer().setxGrid(8);
										currentLevel.getPlayer().setCurrent("down");
									}
								}
								// System.out.println("[" + lX + "][" + lY + "][" + lZ + "]");
							} else {
								if (currentLevel.getPlayer().getyGrid() != 20 && !currentLevel.getGrid()[currentLevel
										.getPlayer().getxGrid()][currentLevel.getPlayer().getyGrid() + 1].isBlocked()) {
									currentLevel.getPlayer().moveY(1);
									// System.out.println("X: " + currentLevel.getPlayer().getxGrid() + " Y: " +
									// currentLevel.getPlayer().getyGrid());
								}
							}
						}
						if (inventoryBoxTimer.isRunning() && !gameTimer.isRunning()
								&& ib.getArrayPostion() < ib.getPlayer().getInventory().size() - 1) {
							ib.setArrowPos(-1);
							// System.out.println(ib.getArrayPostion());
						}
						if (shopItemsTimer.isRunning() && !gameTimer.isRunning()
								&& shopItems.getArrayPostion() < shopItems.getPlayer().getInventory().size() - 1) {
							shopItems.setArrowPos(-1);
						}
						if (shopArmorTimer.isRunning() && !gameTimer.isRunning()
								&& shopArmor.getArrayPostion() < shopArmor.getPlayer().getArmor().size() - 1) {
							shopArmor.setArrowPos(-1);
						}
						if (shopWeaponTimer.isRunning() && !gameTimer.isRunning()
								&& shopWeapon.getArrayPostion() < shopWeapon.getPlayer().getWeapons().size() - 1) {
							shopWeapon.setArrowPos(-1);
						}
						if (combBoxTimer.isRunning() && !gameTimer.isRunning()
								&& cb.getArrayPostion() < cb.getPlayer().getAttacks().size() - 1) {
							cb.setArrowPos(-1);
							// System.out.println(cb.getArrayPostion());
						}
						if (pauseTimer.isRunning() && !gameTimer.isRunning() && ps.getArrayPostion() < 3) {
							ps.setArrowPos(-1);
						}
						if (armorTimer.isRunning() && !gameTimer.isRunning()
								&& ab.getArrayPostion() < ab.getPlayer().getArmor().size() - 1) {
							ab.setArrowPos(-1);
						}
						if (weaponTimer.isRunning() && !gameTimer.isRunning()
								&& wb.getArrayPostion() < wb.getPlayer().getWeapons().size() - 1) {
							wb.setArrowPos(-1);
						}
						if (shopTimer.isRunning() && ss.getArrayPostion() < 1) {
							ss.setArrowPos(-1);
						}
						if (buySellTimer.isRunning() && bs.getArrayPostion() < 2) {
							bs.setArrowPos(-1);
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
				out.put("menu", new AbstractAction() {
					boolean wasInCombat = false;
					boolean isPaused = false;

					public void actionPerformed(ActionEvent arg0) {
						// closes text box if one is open
						if (!gameTimer.isRunning() && textBoxTimer.isRunning() && !inventoryBoxTimer.isRunning()) {
							gameTimer.start();
							tb.setText("");
							tb.setText2("");
							tb.setText3("");
							tb.setText4("");
							tb.setText5("");
							textBoxTimer.stop();
						}
						// closes the item shop if it's open
						else if (shopItemsTimer.isRunning()) {
							shopItemsTimer.stop();
							gameTimer.start();
							isPaused = false;
							isBuying = false;
							isSelling = false;
						}
						// closes the armor shop if it's open
						else if (shopArmorTimer.isRunning()) {
							shopArmorTimer.stop();
							gameTimer.start();
							isPaused = false;
							isBuying = false;
							isSelling = false;
						}
						// closes the weapon shop if it's open
						else if (shopWeaponTimer.isRunning()) {
							shopWeaponTimer.stop();
							gameTimer.start();
							isPaused = false;
							isBuying = false;
							isSelling = false;
						}
						// closes the shop menu if it's open(the menu that says buy or sell)
						else if (shopTimer.isRunning()) {
							shopTimer.stop();
							gameTimer.start();
						}
						// opens the shop if he is on the shop tile
						else if (lX == 2 && lY == 2 && lZ == 2 && currentLevel.getPlayer().getxGrid() == 10
								&& currentLevel.getPlayer().getyGrid() == 13 && (!isBuying && !isSelling)) {
							gameTimer.stop();
							ss.setBounds(20, 660, 800, 150);
							shopTimer.start();
						}
						// turns of combat if you opened inventroy while in combat
						else if (wasInCombat && isPaused) {
							ib.setBounds(800, 800, 800, 800);
							isPaused = false;
							wasInCombat = false;
							combBoxTimer.start();
							inventoryBoxTimer.stop();
						}
						// opens the pause menu if you are in the over world
						else if (gameTimer.isRunning()) {
							ps.setBounds(20, 660, 800, 150);
							gameTimer.stop();
							pauseTimer.start();
							inventoryBoxTimer.stop();
							isPaused = true;
						}
						// I don't know what this one does, but I'll keep it just in case
						else if (textBoxTimer.isRunning()) {
							textBoxTimer.stop();
							tb.setText("");
							tb.setText2("");
							tb.setText3("");
							tb.setText4("");
							tb.setText5("");
							gameTimer.start();
							inventoryBoxTimer.stop();
						}
						// closes the inventory box if that was opened
						else if (isPaused && inventoryBoxTimer.isRunning()) {
							inventoryBoxTimer.stop();
							gameTimer.start();
							isPaused = false;
						}
						// opens the inventory in combat
						else if (combBoxTimer.isRunning() && !isPaused) {
							wasInCombat = true;
							isPaused = true;
							combBoxTimer.stop();
							ib.setBounds(20, 360, 800, 450);
							inventoryBoxTimer.start();
						}
						// closes the armor box if it's open
						else if (armorTimer.isRunning()) {
							armorTimer.stop();
							gameTimer.start();
							isPaused = false;
						}
						// closes the weapon box if it's open
						else if (weaponTimer.isRunning()) {
							weaponTimer.stop();
							gameTimer.start();
							isBuying = false;
							isSelling = false;
							isPaused = false;
						} else {
							// closes every thing just in case something is running if you're still alive
							if (!winTimer.isRunning() && !deathTimer.isRunning()) {
								pauseTimer.stop();
								shopTimer.stop();
								buySellTimer.stop();
								inventoryBoxTimer.stop();
								armorTimer.stop();
								weaponTimer.stop();
								gameTimer.start();
								isBuying = false;
								isSelling = false;
								wasInCombat = false;
								isPaused = false;
							}
						}

						/*
						 * if (!gameTimer.isRunning() && combBoxTimer.isRunning() &&
						 * !inventoryBoxTimer.isRunning()) { gameTimer.start(); combBoxTimer.stop(); }
						 */
					}
				});
				////////////////////////

				/// Added 5/8

				out.put("use", new AbstractAction() {
					//////// USING STUFF OUTSIDE OF COMBAT/////////
					public void actionPerformed(ActionEvent arg0) {
						////////// BUYING/SELLING//////////////////////
						if (shopArmorTimer.isRunning() && isBuying) {
							if (p.getGold() < shopKeeper.getArmor().get(shopArmor.getArrayPostion()).getPrice()
									|| p.getArmor().contains(shopKeeper.getArmor().get(shopArmor.getArrayPostion()))) {
								// do nothing
							} else {
								shopKeeper.getArmor().get(shopArmor.getArrayPostion()).buy(p);
								p.armorMergeSort(p.getArmor());
							}
						} else if (shopItemsTimer.isRunning() && isBuying) {
							if (p.getGold() < shopKeeper.getInventory().get(shopItems.getArrayPostion()).getPrice()) {
								// do nothing
							} else {
								shopKeeper.getInventory().get(shopItems.getArrayPostion()).buy(p);
							}
						} else if (shopWeaponTimer.isRunning() && isBuying) {
							if (p.getGold() < shopKeeper.getInventory().get(shopItems.getArrayPostion()).getPrice() || p
									.getWeapons().contains(shopKeeper.getWeapons().get(shopWeapon.getArrayPostion()))) {
								// do nothing
							} else {
								shopKeeper.getWeapons().get(shopWeapon.getArrayPostion()).buy(p);
								p.weaponMergeSort(p.getWeapons());
							}
						} else if (buySellTimer.isRunning() && isBuying) {
							buySellTimer.stop();
							if (bs.getArrayPostion() == 0) {
								shopItems.setBounds(20, 360, 800, 450);
								shopItemsTimer.start();
							} else if (bs.getArrayPostion() == 1) {
								shopArmor.setBounds(20, 360, 800, 450);
								shopArmorTimer.start();
							} else if (bs.getArrayPostion() == 2) {
								shopWeapon.setBounds(20, 360, 800, 450);
								shopWeaponTimer.start();
							}
						} else if (inventoryBoxTimer.isRunning() && isSelling) {
							p.getInventory().get(ib.getArrayPostion()).sell(p);
							p.getInventory().remove(ib.getArrayPostion());
						} else if (armorTimer.isRunning() && isSelling) {
							p.getArmor().get(ab.getArrayPostion()).sell(p);
							p.getArmor().remove(ab.getArrayPostion());
							p.unequipArmor();
							p.armorMergeSort(p.getArmor());
						} else if (weaponTimer.isRunning() && isSelling) {
							p.getWeapons().get(wb.getArrayPostion()).sell(p);
							p.getWeapons().remove(wb.getArrayPostion());
							p.unequipWeapon();
							p.weaponMergeSort(p.getWeapons());
						} else if (isSelling && buySellTimer.isRunning()) {
							buySellTimer.stop();
							if (bs.getArrayPostion() == 0) {
								ib.setBounds(20, 360, 800, 450);
								inventoryBoxTimer.start();
							} else if (bs.getArrayPostion() == 1) {
								ab.setBounds(20, 360, 800, 450);
								armorTimer.start();
							} else if (bs.getArrayPostion() == 2) {
								wb.setBounds(20, 360, 800, 450);
								weaponTimer.start();
							}
						}
						//////////////////////////////////////
						//////////// SHOPING STUFF////////////
						else if (shopTimer.isRunning()) {
							if (ss.getArrayPostion() == 0) {
								shopTimer.stop();
								isBuying = true;
								bs.setBounds(20, 660, 800, 150);
								buySellTimer.start();

							} else {
								isSelling = true;
								shopTimer.stop();
								bs.setBounds(20, 660, 800, 150);
								buySellTimer.start();
							}
							//////////////////////////////////////
							////////////// Unequipping stuff////
						} else if (armorTimer.isRunning() && p.getArmor().get(ab.getArrayPostion()).isEquiped()) {
							p.getArmor().get(ab.getArrayPostion()).unequip();
							p.unequipArmor();
						} else if (weaponTimer.isRunning() && p.getWeapons().get(wb.getArrayPostion()).isEquiped()) {
							p.getWeapons().get(wb.getArrayPostion()).unequip();
							p.unequipWeapon();
						}
						////////////// Equipping stuff///////
						else if (inventoryBoxTimer.isRunning()) {
							p.getInventory().get(ib.getArrayPostion()).use(p);
							p.getInventory().remove(ib.getArrayPostion());
						} else if (armorTimer.isRunning()) {
							for (int i = 0; i < p.getArmor().size(); i++) {
								p.getArmor().get(i).unequip();
							}
							// p.setMaxHP();
							p.getArmor().get(ab.getArrayPostion()).equip();
							p.setEquipedArmor(p.getArmor().get(ab.getArrayPostion()));
							if (p.getMaxHP() < p.getCurrentHP()) {
								p.setCurrentHP(p.getMaxHP());
							}
						} else if (weaponTimer.isRunning()) {
							for (int i = 0; i < p.getWeapons().size(); i++) {
								p.getWeapons().get(i).unequip();
							}
							p.setStrength();
							p.getWeapons().get(wb.getArrayPostion()).equip();
							p.setEquipedWeapon(p.getWeapons().get(wb.getArrayPostion()));
						}
						/////////////////////////////////////////////
						/////////// PAUSE MENU///////////////////////
						else if (pauseTimer.isRunning()) {
							if (ps.getArrayPostion() == 0) {
								pauseTimer.stop();
								ib.setBounds(20, 360, 800, 450);
								inventoryBoxTimer.start();
							}
							if (ps.getArrayPostion() == 1) {
								pauseTimer.stop();
								ab.setBounds(20, 360, 800, 450);
								armorTimer.start();
							}
							if (ps.getArrayPostion() == 2) {
								pauseTimer.stop();
								wb.setBounds(20, 360, 800, 450);
								weaponTimer.start();
							}
							if (ps.getArrayPostion() == 3) {
								pauseTimer.stop();
								tb.setBounds(20, 660, 800, 150);
								tb.setText("Level: " + p.getLevel());
								tb.setText2("Health: " + p.getCurrentHP() + "/" + p.getMaxHP());
								tb.setText3("Strength: " + p.getTrueStrength() + "(+"
										+ p.getEquipedWeapon().getIncrease() + ")");
								tb.setText4("EXP: " + Math.round(p.getExp() * 10) / 10 + "/"
										+ Math.round(p.getRequiredEXP() * 10) / 10);
								textBoxTimer.start();
							}
						}

						//////////// Combat System//////////////
						if (!gameTimer.isRunning() && combBoxTimer.isRunning()) {
							Enemy e = currentLevel.getEnemyManager().getList()
									.get(currentLevel.getEnemyManager().getEnemyIndex());
							// amount of total damage player deals
							double percentIncrease = (double) p.getStrength() / 100;
							double initialAttack = p.getAttacks().get(cb.getArrayPostion()).getStrength() + r.nextInt(3);
							double totalAttack = initialAttack + p.getAttacks().get(cb.getArrayPostion()).getStrength() * percentIncrease;
							if(p.getAttacks().get(cb.getArrayPostion()).wasCritical()) {
								totalAttack*=1.3;
							}
							// player attacks with chosen attack
							e.changeHealth((int) (-1 * totalAttack));
							System.out.println(percentIncrease);
							System.out.println(totalAttack);

							// print out player action
							cb.setTextMain("Player uses " + p.getAttacks().get(cb.getArrayPostion()).getName()
									+ ", and deals " + (int)totalAttack + " damage!");
							System.out.println(p.getAttacks().get(cb.getArrayPostion()).wasCritical());
							if(p.getAttacks().get(cb.getArrayPostion()).wasCritical()){
								cb.setTextTertiary("*** CRITICAL HIT ***");
							}
							else {
								cb.setTextTertiary(" ");
							}
							// if enemy dies
							if (e.getCurrentHP() <= 0 && p.getCurrentHP() > 0) {
								if (e.isBoss()) {
									gameTimer.stop();
									combBoxTimer.stop();
									ws.setBounds(0, 0, 840, 840);
									winTimer.start();
								} else {
									currentLevel.getEnemyManager().getList().remove(e);
									combBoxTimer.stop();
									tb.setBounds(20, 660, 800, 150);
									p.setExp(p.getExp() + e.getExp());
									p.setGold(p.getGold() + e.getGold());
									// if player levels up
									if (p.ifNextLevel()) {
										p.levelUp();
										gameTimer.stop();
										combBoxTimer.stop();
										tb.setBounds(20, 660, 800, 150);
										tb.setText(e.getName() + " has died and dropped " + e.getGold() + " gold.");
										tb.setText2("You are now level " + p.getLevel() + "!");
										tb.setText3("HP is now: " + p.getMaxHP());
										tb.setText4("Strength is now: " + p.getTrueStrength());
										if (p.getLevel() == 3 || p.getLevel() == 10) {
											tb.setText5("You learned a new move!");
										}
										// System.out.println("current: " + p.getExp());
										// System.out.println("required: " + p.getRequiredEXP());
									}
									tb.setText(e.getName() + " has died and dropped " + e.getGold() + " gold.");
									textBoxTimer.start();
									// cb.setTextSub("You have gained " + 5 + " exp. Press 'E' to close.");
									// resume game
								}
							} else {

								int initialEnemyAttack = e.getStrength() + r.nextInt(3);
								int enemyAttack = initialEnemyAttack - (int) (e.getStrength() * p.getEquipedArmor().getIncrease());

								// enemy attacks
								p.changeHealth(-1 * enemyAttack);

								// print out enemy action
								cb.setTextSub(e.getName() + " attacks and deals " + enemyAttack + " damage!");

								if (p.getCurrentHP() <= 0) {
									p.setCurrentHP(0);
									combBoxTimer.stop();
									gameTimer.stop();
									ds.setBounds(0, 0, 840, 840);
									deathTimer.start();

								}
								// prints out enemy's current health after attack
								// System.out.println(e.getCurrentHP());
							}
						}
					}
				});
			}
		});
	}
}
