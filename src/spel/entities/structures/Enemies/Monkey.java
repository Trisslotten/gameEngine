package spel.entities.structures.Enemies;

import java.util.Random;

import spel.Game;
import spel.entities.Mob;
import spel.entities.gui.SpriteCollection;
import spel.utils.Sound;

public class Monkey extends Mob {
	boolean attackmode = true;
	int velocity = 176;
	int tx = 0;
	int ty = 0;
	int tick = 0;
	int timer=0;
	int timertick=0;
	boolean facing = true; // true=right, false = left;
	boolean fleeing = false;

	public Monkey(double xpos, double ypos) {
		super(xpos, ypos);
		// TODO Auto-generated constructor stub
	}

	public void update(double dt, Game game) {
		Random rand = new Random();
		timer=rand.nextInt(10000)+100;
		if(timertick>=timer && getrange(game.saveGame.player.xpos,
				game.saveGame.player.ypos) < 512){
			Sound.gorillascream.play();
			timertick=0;
		}
			timertick++;
		if (rand.nextInt(512) == 256) {
			fleeing = false;
		}
		if (rand.nextInt(1024) == 512) {
			attackmode = true;
		}
		if (rand.nextInt(1024) == 512) {
			attackmode = false;
		}
		attackmode = true;
		if (!attackmode && rand.nextBoolean() && tick >= 360) {
			tx = (int) (xpos + (int) (rand.nextInt(1024) - (1024 / 2)));
			ty = (int) (ypos + (int) (rand.nextInt(1024) - (1024 / 2)));
			tick = 0;
		} else if (attackmode) {
			if (!fleeing) {
				//for(Structure s: game.saveGame.level.structures){
				//get structure position "barn"
				//}
			}
			for (int i = 0; i < game.saveGame.level.NPCs.size(); i++) {
				if (getrange(game.saveGame.level.NPCs.elementAt(i).xpos,
						game.saveGame.level.NPCs.elementAt(i).ypos) < 256) {
					tx = (int) game.saveGame.level.NPCs.elementAt(i).xpos;
					ty = (int) game.saveGame.level.NPCs.elementAt(i).ypos;
					fleeing = true;
				}
				if(getrange(game.saveGame.player.xpos,
								game.saveGame.player.ypos) < 256){
					tx = (int) game.saveGame.player.xpos;
					ty = (int) game.saveGame.player.ypos;
					fleeing = true;
				}
			}
		} else {
			tick++;
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
		if (tx > xpos) {
			facing = true;
		} else {
			facing = false;
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
		if (facing) {
			SpriteCollection.monR.render(xdraw + 32, ydraw + 32);
		} else {
			SpriteCollection.monL.render(xdraw + 32, ydraw + 32);
		}
	}

	public int getrange(double xpos, double ypos) {
		int r = (int) Math.sqrt(Math.pow(this.xpos - xpos, 2)
				+ Math.pow(this.ypos - ypos, 2));
		return r;
	}
}
