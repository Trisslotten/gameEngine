package spel.entities.structures.Buildings;

import spel.Game;
import spel.entities.structures.Structure;

public class Fireplace extends Structure {
	int protection = 50;

	public Fireplace(double xpos, double ypos, double height, double width, boolean permanent, boolean gridlocked, Game game) {
		super(xpos, ypos, height, width, permanent, gridlocked, game);
		this.woodCost = 8;
		this.stoneCost = 5;
		game.saveGame.player.inventory.payCost(woodCost,stoneCost,nailCost);	
	}

	public void update(double dt) {
		if (!permanent) {
			if (tick >= 270) {
				durability--;
				tick = 0;
			} else {
				tick++;
			}
		}
	}

	public void render(int xoffset, int yoffset, Game game) {
		xdraw = xpos - xoffset;
		ydraw = ypos - xoffset;

		//SpriteCollection.fireplace.render(xdraw,ydraw);
	}

}
