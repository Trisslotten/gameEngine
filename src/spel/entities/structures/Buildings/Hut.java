package spel.entities.structures.Buildings;

import spel.Game;
import spel.entities.gui.SpriteCollection;
import spel.entities.structures.Structure;

public class Hut extends Structure {

	public Hut(double xpos, double ypos, double height, double width, boolean permanent, boolean gridlocked, Game game) {
		super(xpos, ypos, height, width, permanent, gridlocked, game);
		game.saveGame.player.inventory.payCost(woodCost,stoneCost,nailCost);
	}

	public void update(double dt) {

	}

	public void render(int xoffset, int yoffset, Game game) {
		xdraw = xpos - xoffset;
		ydraw = ypos - xoffset;

		SpriteCollection.hut.render(xdraw,ydraw);
	}

}
