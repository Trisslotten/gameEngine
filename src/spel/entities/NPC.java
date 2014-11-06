package spel.entities;

import java.util.Random;

import spel.Game;
import spel.entities.gui.SpriteCollection;

public class NPC extends Mob {
	String name;
	int hunger = 100;
	int tick = 0;
	int tx = 0;
	int ty = 0;
	int velocity = 128;
	boolean eventNPC;
	boolean found = false;
	boolean friend = false;
	boolean starving = false;

	public NPC(double xpos, double ypos, String name, boolean eventNPC) {
		super(xpos, ypos);
		this.name = name;
		this.eventNPC = eventNPC;
	}

	public void update(double dt, Game game) {
		Random rand = new Random();
		super.update(dt);

		if (eventNPC && game.saveGame.player.getrange(xpos, ypos) <= 512 && !found) {
			// found = true;
		}
		if (friend) {
			if (tick >= 1080) {// should have no hunger left after aprox. 1.5
								// in-game days, will rapidly die if not fed
								// (looses all health in less than ~two seconds)
				hunger--;
				tick = 0;
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
		} else 
			for(int i=1;i<4;i++){
			if (!friend && !found && tick == i*360) {
				System.out.println("pos update");
			tx = (int) (xpos+(int) (rand.nextInt(1024) - 512));
			ty = (int) (ypos+(int) (rand.nextInt(1024) - 512));
			}
		}
		if(tx !=0 && ty!=0){
		double dx = xpos - tx;
		double dy = ypos - ty;
		double angle = Math.atan2(dy, dx);
		xspd = Math.cos(angle) * velocity * dt / 1000;
		yspd = Math.sin(angle) * velocity * dt / 1000;
		xdraw = xpos - game.getWidth() - game.saveGame.player.getXpos();
		ydraw = ypos - game.getHeight() - game.saveGame.player.getYpos();
		}
		tick++;
		xpos -= xspd;
		ypos -= yspd;
	}

	public void render(double interpolation) {
		interpolation /= 1000;
		xdraw -= xspd * interpolation;
		ydraw -= yspd * interpolation;
		SpriteCollection.NPC.render(xdraw - 32, ydraw - 87);
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
}
