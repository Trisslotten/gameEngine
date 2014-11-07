package spel.entities;

import java.util.Random;

import org.lwjgl.input.Mouse;

import spel.Game;
import spel.entities.gui.SpriteCollection;

public class NPC extends Mob {
	String name;
	int hunger = 100;
	int tick = 0;
	int tx = 0;
	int ty = 0;
	int velocity = 128;
	public int windowWidth, windowHeight;
	boolean eventNPC;
	boolean found = false;
	boolean friend = false;
	boolean starving = false;
	boolean clicked;

	public NPC(double xpos, double ypos, String name, boolean eventNPC,
			Game game) {
		super(xpos, ypos);
		this.name = name;
		this.eventNPC = eventNPC;
		width=SpriteCollection.NPCEX.width;
		height=SpriteCollection.NPCEX.height;
		windowWidth = game.getWidth();
		windowHeight = game.getHeight();
	}

	public void update(double dt, Game game) {
		Random rand = new Random();
		super.update(dt);

		if (eventNPC && game.saveGame.player.getrange(xpos, ypos) <= 512
				&& !found) {
			// found = true;
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
		} else
			for (int i = 1; i < 4; i++) {
				if (!friend && !found && tick == i * 360) {
					do {
						tx = (int) (xpos + (int) (rand.nextInt(1024) - 512));
						ty = (int) (ypos + (int) (rand.nextInt(1024) - 512));
					} while (game.saveGame.level.isWaterTile(tx, ty));
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
		if (tick >= 1080) {
			tick = 0;
		} else {
			tick++;
		}

		xpos -= xspd;
		ypos -= yspd;
		if (Mouse.isButtonDown(0)) {
			int cx=(int) ((game.saveGame.player.getxpos() - (windowWidth / 2))+game.cursor.getXpos());
			int cy=(int) ((game.saveGame.player.getypos() - (windowHeight / 2))+game.cursor.getYpos());
			System.out.println("clicked "+cx +" "+cy);
			System.out.println("xpos "+xpos);
			if(cx > xpos-(windowWidth/2)-30 && cx < xpos - (windowWidth/2)+30 && cy > ypos-(windowHeight/2)-height && cy < ypos - (windowHeight/2)){
			clicked = true;	
			System.out.println("being clicked");
			}	
		}
	}

	public void render(int xoffset, int yoffset, Game game) {
		super.render(xoffset, yoffset, game);
		SpriteCollection.NPC.render(xdraw - 32, ydraw - 87);
		if (clicked) {
			SpriteCollection.NPCEX.render(xdraw - 32, ydraw-170);
			clicked = false;
		}
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
