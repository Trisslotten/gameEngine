package spel.entities.structures.Buildings;

import spel.Game;
import spel.entities.structures.Structure;

public class Shelter extends Structure {
	int protection = 70;

	public Shelter(double xpos, double ypos, double height, double width, boolean permanent, boolean gridlocked, Game game) {
		super(xpos, ypos, height, width, permanent, gridlocked, game);
		
		
		
		game.saveGame.player.inventory.payCost(woodCost,stoneCost,nailCost,ironCost);
	}

	public void update(double dt) {
		if (!permanent) {
			if (tick >= 540) {
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

		// SpriteCollection
	}
}
