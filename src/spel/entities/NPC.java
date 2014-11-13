package spel.entities;

import java.util.Random;

import org.lwjgl.input.Mouse;

import spel.Game;
import spel.entities.gui.SpriteCollection;
import spel.entities.structures.Structure;
import spel.entities.structures.vegetation.Vegetation;

public class NPC extends Mob {
	String name;
	int hunger = 100;
	int tick = 0;
	int tx = 0;
	int ty = 0;
	int cx;
	int cy;
	int velocity = 176;
	int idlewalking = 0;
	int selectorindex = 0;
	int pointerindex = 0;
	int timer = 0;
	int Wtimer = 0;
	int variation = 0;
	int initx = 0;
	int inity = 0;
	int workertick;
	public int windowWidth, windowHeight;
	boolean eventNPC;
	boolean found = false;
	boolean friend = false;
	boolean starving = false;
	boolean clicked;
	boolean stop = false;
	boolean playercommand = false;
	boolean cut;
	boolean hack;
	boolean collect;
	boolean guard;
	boolean working;
	boolean step1 = true;
	boolean step2 = false;
	boolean dropoff = true;

	public NPC(double xpos, double ypos, String name, boolean eventNPC,
			Game game, int variation) {
		super(xpos, ypos);
		this.name = name;
		this.eventNPC = eventNPC;
		this.variation=variation;
		width = SpriteCollection.NPCEX.width;
		height = SpriteCollection.NPCEX.height;
		windowWidth = game.getWidth();
		windowHeight = game.getHeight();
	}

	public void update(double dt, Game game) {
		jobselector(game);
		workchk();
		Random rand = new Random();
		super.update(dt);
		timer++;
		if (timer >= 4) {
			selectorindex++;
			timer = 0;
			if (selectorindex > 17) {
				selectorindex = 0;
			}
		}
		Wtimer++;
		if (Wtimer >= 4) {
			pointerindex++;
			Wtimer = 0;
			if (pointerindex > 8) {
				pointerindex = 0;
			}
		}

		if (eventNPC && clicked && !found) {
			found = true;
			friend = true;
		}
		if (friend) {
			if (tick >= 1080) {// should have no hunger left after aprox. 1.5
								// in-game days, will rapidly die if not fed
								// (looses all health in less than ~two seconds)
				hunger--;
			}
			if (hunger <= 0) {
				health--;
			} else if (hunger >= 40) {
				health++;
			}
			if (hunger <= 25) {
				starving = true;
			} else {
				starving = false;
			}
		}
		if (!found) {
			idlewalking = 1024;
		} else {
			idlewalking = 128;
		}
		if (starving) {
			goeat();
		} else {
			for (int i = 1; i < 4; i++) {
				if (tick == i * 360 && !clicked && !playercommand
						&& rand.nextBoolean() && !working) {// checks if the
					// unit is idle,
					// or not simply
					// found, and
					// then decides
					// whatever or
					// not it should
					// walk
					tx = (int) (xpos + (int) (rand.nextInt(idlewalking) - (idlewalking / 2)));
					ty = (int) (ypos + (int) (rand.nextInt(idlewalking) - (idlewalking / 2)));
				} else if (clicked && Mouse.isButtonDown(1)) {
					tx = (int) (game.cursor.getXpos() + game.saveGame.player
							.getXpos());
					ty = (int) (game.cursor.getYpos() + game.saveGame.player
							.getYpos());
					playercommand = true;
					working = false;
					step1 = true;
					step2 = false;
				}
			}

			if (tx != 0 && ty != 0 && Math.abs(xpos - tx) >= 10
					|| Math.abs(ypos - (ty)) >= 10 && tx != 0 && ty != 0) {
				double dx = xpos - tx;
				double dy = ypos - ty;
				double angle = Math.atan2(dy, dx);
				xspd = Math.cos(angle) * velocity * dt / 1000;
				yspd = Math.sin(angle) * velocity * dt / 1000;
			} else {
				playercommand = false;
				xspd = 0;
				yspd = 0;
			}

			xdraw = xpos - game.getWidth() - game.saveGame.player.getXpos();
			ydraw = ypos - game.getHeight() - game.saveGame.player.getYpos();

			if (tick >= 1080) {// tick reset
				tick = 0;
			} else {
				tick++;
			}

			xpos -= xspd;
			ypos -= yspd;

			clickbutton(game.saveGame.player.getxpos(),
					game.saveGame.player.getypos(), game.cursor.getXpos(),
					game.cursor.getYpos(), game);

			if (Mouse.isButtonDown(0) && !stop) {// Player clicking the NPC
				stop = true;
				cx = (int) ((game.saveGame.player.getxpos() - (windowWidth / 2)) + game.cursor
						.getXpos());
				cy = (int) ((game.saveGame.player.getypos() - (windowHeight / 2)) + game.cursor
						.getYpos());
				if (cx > xpos - (windowWidth / 2) - 30
						&& cx < xpos - (windowWidth / 2) + 30
						&& cy > ypos - (windowHeight / 2) - height
						&& cy < ypos - (windowHeight / 2)) {
					if (clicked) {
						clicked = false;
					} else {
						clicked = true;
					}
				} else {
					clicked = false;
				}
			}

			if (!Mouse.isButtonDown(0)) {
				stop = false;
			}
		}
	}

	public void render(int xoffset, int yoffset, Game game) {

		super.render(xoffset, yoffset, game);
		SpriteCollection.NPC[variation].render(xdraw - 32, ydraw - 87);
		if (clicked) {
			SpriteCollection.NPCSEL[selectorindex].render(xdraw - 40,
					ydraw - 170);

			SpriteCollection.NPCCUT.render(xdraw + 28, ydraw);
			SpriteCollection.NPCHACK.render(xdraw + 28, ydraw - 128);
			SpriteCollection.NPCFUCKINGBERRIES.render(xdraw - 100, ydraw);
			SpriteCollection.NPCGUARD.render(xdraw - 100, ydraw - 128);
		}
		if (starving) {
			SpriteCollection.NPCHUNG.render(xdraw - 32, ydraw - 170);
		}
		if (playercommand) {
			SpriteCollection.WPointer[pointerindex].render(tx - xoffset - 32,
					ty - yoffset - 40);
		}
	}

	public void clickbutton(int pxpos, int pypos, double d, double e, Game game) {
		if (Mouse.isButtonDown(0)) {
			cx = (int) ((pxpos - (windowWidth / 2)) + d);
			cy = (int) ((pypos - (windowHeight / 2)) + e);
			if (cx > xpos + 92 - (windowWidth / 2) - 64
					&& cx < xpos + 92 - (windowWidth / 2)
					&& cy > ypos + 66 - (windowHeight / 2) - 64
					&& cy < ypos + 66 - (windowHeight / 2)) {
				cut = true;
				collect = false;
				hack = false;
				guard = false;
				working = true;
			}
			if (cx > xpos + 92 - (windowWidth / 2) - 64
					&& cx < xpos + 92 - (windowWidth / 2)
					&& cy > ypos - 66 - (windowHeight / 2) - 64
					&& cy < ypos - 66 - (windowHeight / 2)) {
				cut = false;
				collect = false;
				hack = true;
				guard = false;
				working = true;
			}
			if (cx > xpos - 34 - (windowWidth / 2) - 64
					&& cx < xpos - 34 - (windowWidth / 2)
					&& cy > ypos + 66 - (windowHeight / 2) - 64
					&& cy < ypos + 66 - (windowHeight / 2)) {
				cut = false;
				collect = true;
				hack = false;
				guard = false;
				working = true;
			}
			if (cx > xpos - 34 - (windowWidth / 2) - 64
					&& cx < xpos - 34 - (windowWidth / 2)
					&& cy > ypos - 66 - (windowHeight / 2) - 64
					&& cy < ypos - 66 - (windowHeight / 2)) {
				cut = false;
				collect = false;
				hack = false;
				guard = true;
				working = true;
			}
		}
	}

	public void workchk() {
		if (!working) {
			cut = false;
			collect = false;
			hack = false;
			guard = false;
		}
	}

	public void collectwood(Game game) {
		if (step1) {

			int[] tree = new int[game.saveGame.level.plants.size()];
			int counter = 0;
			for (Vegetation v : game.saveGame.level.plants) {
				if (game.saveGame.level.plants.elementAt(counter).getClass()
						.getSimpleName().equals("Tree")) {
					tree[counter] = getrange(
							game.saveGame.level.plants.elementAt(counter).xpos,
							game.saveGame.level.plants.elementAt(counter).ypos);
				} else {
					tree[counter] = 100000000;
				}
				counter++;
			}
			int min = tree[0];
			int index = 0;
			for (int i = 1; i < tree.length; i++) {
				if (tree[i] < min) {
					min = tree[i];
					index = i;
				}
			}
			tx = (int) game.saveGame.level.plants.elementAt(index).xpos + 100
					+ (windowWidth / 2);
			ty = (int) game.saveGame.level.plants.elementAt(index).ypos + 291
					+ (windowHeight / 2);
			step1 = false;
		}
		if (getrange(tx, ty) < 20) {
			workertick++;
		}
		if (workertick >= 100) {
			workertick = 0;
			step2 = true;
			dropoff = true;
		}
		if (step2) {
			int i = 0;
			for (Structure s : game.saveGame.level.structures) {
				if (game.saveGame.level.structures.elementAt(i).getClass()
						.getSimpleName().equals("Hut")) {
					tx = (int) game.saveGame.level.structures.elementAt(i).xpos;
					ty = (int) game.saveGame.level.structures.elementAt(i).ypos;
				}
				i++;
			}
		}
		if (getrange(initx, inity) < 20) {
			step1 = true;
			step2 = false;
			if (dropoff) {
				game.saveGame.player.addwood();
				dropoff = false;
			}
		}
	}

	public void collectfood(Game game) {
		if (step1) {

			int[] tree = new int[game.saveGame.level.plants.size()];
			int counter = 0;
			for (Vegetation v : game.saveGame.level.plants) {
				if (game.saveGame.level.plants.elementAt(counter).getClass()
						.getSimpleName().equals("SmallBush")) {
					tree[counter] = getrange(
							game.saveGame.level.plants.elementAt(counter).xpos,
							game.saveGame.level.plants.elementAt(counter).ypos);
				} else {
					tree[counter] = 100000000;
				}
				counter++;
			}
			int min = tree[0];
			int index = 0;
			for (int i = 1; i < tree.length; i++) {
				if (tree[i] < min) {
					min = tree[i];
					index = i;
				}
			}
			tx = (int) game.saveGame.level.plants.elementAt(index).xpos + 32
					+ (windowWidth / 2);
			ty = (int) game.saveGame.level.plants.elementAt(index).ypos + 53
					+ (windowHeight / 2);
			step1 = false;
		}
		if (getrange(tx, ty) < 20) {
			workertick++;
		}
		if (workertick >= 100) {
			workertick = 0;
			step2 = true;
			dropoff = true;
		}
		if (step2) {
			int i = 0;
			for (Structure s : game.saveGame.level.structures) {
				if (game.saveGame.level.structures.elementAt(i).getClass()
						.getSimpleName().equals("Hut")) {
					tx = (int) game.saveGame.level.structures.elementAt(i).xpos;
					ty = (int) game.saveGame.level.structures.elementAt(i).ypos;
				}
				i++;
			}
		}
		if (getrange(initx, inity) < 20) {
			step1 = true;
			step2 = false;
			if (dropoff) {
				game.saveGame.player.addfood();
				dropoff = false;
			}
		}
	}

	public void collectstone(Game game) {
		if (step1) {

			int[] tree = new int[game.saveGame.level.plants.size()];
			int counter = 0;
			for (Vegetation v : game.saveGame.level.plants) {
				if (game.saveGame.level.plants.elementAt(counter).getClass()
						.getSimpleName().equals("Rock")) {
					tree[counter] = getrange(
							game.saveGame.level.plants.elementAt(counter).xpos,
							game.saveGame.level.plants.elementAt(counter).ypos);
				} else {
					tree[counter] = 100000000;
				}
				counter++;
			}
			int min = tree[0];
			int index = 0;
			for (int i = 1; i < tree.length; i++) {
				if (tree[i] < min) {
					min = tree[i];
					index = i;
				}
			}
			tx = (int) game.saveGame.level.plants.elementAt(index).xpos + 25
					+ (windowWidth / 2);
			ty = (int) game.saveGame.level.plants.elementAt(index).ypos + 45
					+ (windowHeight / 2);
			step1 = false;
		}
		if (getrange(tx, ty) < 20) {
			workertick++;
		}
		if (workertick >= 100) {
			workertick = 0;
			step2 = true;
			dropoff = true;
		}
		if (step2) {
			int i = 0;
			for (Structure s : game.saveGame.level.structures) {
				if (game.saveGame.level.structures.elementAt(i).getClass()
						.getSimpleName().equals("Hut")) {
					tx = (int) game.saveGame.level.structures.elementAt(i).xpos;
					ty = (int) game.saveGame.level.structures.elementAt(i).ypos;
				}
				i++;
			}
		}
		if (getrange(initx, inity) < 20) {
			step1 = true;
			step2 = false;
			if (dropoff) {
				game.saveGame.player.addstone();
				dropoff = false;
			}
		}
	}

	public void guard(Game game) {

	}

	public int getrange(double xpos, double ypos) {
		int r = (int) Math.sqrt(Math.pow(this.xpos - xpos, 2)
				+ Math.pow(this.ypos - ypos, 2));
		return r;
	}

	public void jobselector(Game game) {
		if (working) {
			if (cut) {
				collectwood(game);
			}
			if (hack) {
				collectstone(game);
			}
			if (collect) {
				collectfood(game);
			}
			if (guard) {
				guard(game);
			}
		}
	}

	public void goeat() {

	}

	public void eat(int amount) {
		hunger += amount;
	}

	public boolean getfound() {
		return found;
	}

	public boolean getfriend() {
		return friend;
	}

	public boolean getstarving() {
		return starving;
	}

	public boolean getclicked() {
		return clicked;
	}
}
