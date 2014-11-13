package spel.entities.structures.Enemies;

import java.util.Random;

import spel.Game;
import spel.entities.Mob;
import spel.entities.gui.SpriteCollection;
import spel.entities.structures.Structure;
import spel.utils.Sound;

public class Monkey extends Mob {
	boolean attackmode = true;
	int velocity = 176;
	int tx = 0;
	int ty = 0;
	int tick = 0;
	int timer = 0;
	int timertick = 0;
	int windowWidth;
	int windowHeight;
	boolean steal = true;
	boolean fleeing = false;

	public Monkey(double xpos, double ypos, Game game) {
		super(xpos, ypos);
		windowWidth = game.getWidth();
		windowHeight = game.getHeight();
	}

	public void update(double dt, Game game) {
		Random rand = new Random();
		timer = rand.nextInt(10000) + 100;
		if (timertick >= timer
				&& getrange(game.saveGame.player.xpos,
						game.saveGame.player.ypos) < 512) {
			Sound.gorillascream.play(1.0f, 0.3f);
			timertick = 0;
		}
		timertick++;
		if (rand.nextInt(512) == 256) {
			fleeing = false;
		}
		if (rand.nextInt(2048) == 1024) {
			attackmode = true;
		}
		if (rand.nextInt(2048) == 1024) {
			attackmode = false;
		}
		if (!attackmode && rand.nextBoolean() && tick >= 360 && !fleeing) {
			tx = (int) (xpos + (int) (rand.nextInt(1024) - (1024 / 2)));
			ty = (int) (ypos + (int) (rand.nextInt(1024) - (1024 / 2)));
			tick = 0;
		} else if (attackmode) {
			if (!fleeing) {
				tx = (int) game.saveGame.player.xpos + (windowWidth / 2 - 50);
				ty = (int) game.saveGame.player.ypos + (windowHeight / 2 - 96);
				if (getrange(
						game.saveGame.player.xpos + (windowWidth / 2 - 50),
						game.saveGame.player.ypos + (windowHeight / 2) - 96) < 20) {
					int random = rand.nextInt(4);
					if (random == 0) {
						game.saveGame.player.inventory.payCost(
								rand.nextInt(10) + 10, 0, 0, 0);
					}
					if (random == 1) {
						game.saveGame.player.inventory.payCost(0,
								rand.nextInt(10) + 10, 0, 0);
					}
					if (random == 2) {
						game.saveGame.player.inventory.payCost(0, 0,
								rand.nextInt(10) + 10, 0);
					}
					if (random == 3) {
						game.saveGame.player.inventory.payCost(0, 0, 0,
								rand.nextInt(10) + 10);
					}
						attackmode = false;
						tx = (int) game.saveGame.player.xpos + (windowWidth / 2 - 50);
						ty = (int) game.saveGame.player.ypos + (windowHeight / 2 - 96);
						fleeing=true;
				}
			}

		} else {
			tick++;
		}
		for (int i = 0; i < game.saveGame.level.NPCs.size(); i++) {
			if (getrange(game.saveGame.level.NPCs.elementAt(i).xpos,
					game.saveGame.level.NPCs.elementAt(i).ypos) < 256) {
				tx = (int) game.saveGame.level.NPCs.elementAt(i).xpos;
				ty = (int) game.saveGame.level.NPCs.elementAt(i).ypos;
				fleeing = true;
				attackmode = false;
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
			xspd = 0;
			yspd = 0;
		}
		xdraw = xpos - game.getWidth() - game.saveGame.player.getXpos();
		ydraw = ypos - game.getHeight() - game.saveGame.player.getYpos();

		if (!fleeing) {
			xpos -= xspd;
			ypos -= yspd;
		} else {
			xpos += xspd;
			ypos += yspd;
		}
	}

	public void render(int xoffset, int yoffset, Game game) {
		super.render(xoffset, yoffset, game);
		SpriteCollection.mon.render(xdraw + 32, ydraw + 32);
	}

	public int getrange(double xpos, double ypos) {
		int r = (int) Math.sqrt(Math.pow(this.xpos - xpos, 2)
				+ Math.pow(this.ypos - ypos, 2));
		return r;
	}
}
