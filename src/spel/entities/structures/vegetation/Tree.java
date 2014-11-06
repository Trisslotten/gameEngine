package spel.entities.structures.vegetation;

import spel.Game;
import spel.entities.gui.SpriteCollection;
import spel.entities.structures.Structure;

public class Tree extends Structure {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6169588294128635668L;

	public Tree(double xpos, double ypos, double height, double width, boolean permanent, boolean gridlocked) {
		super(xpos, ypos, height, width, permanent, gridlocked);
		xdraw = xpos;
		ydraw = ypos;
	}

	public void cut() {
		durability -= 50;
	}

	public void update(double dt) {

	}

	public void update(double dt, Game game) {
		xpos += xspd * dt / 1000;
		ypos += yspd * dt / 1000;
		xdraw = xpos;
		ydraw = ypos;
	}

	public void render(int xoffset, int yoffset, Game game) {
		xdraw = xpos - xoffset;
		ydraw = ypos - yoffset;
		SpriteCollection.palmtree.render(xdraw, ydraw);
	}
}
