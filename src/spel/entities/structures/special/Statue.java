package spel.entities.structures.special;

import org.newdawn.slick.Color;

import spel.Game;
import spel.entities.gui.SpriteCollection;
import spel.entities.structures.Structure;

public class Statue extends Structure {

	public Statue(double xpos, double ypos, double height, double width,
			boolean permanent, boolean gridlocked) {
		super(xpos, ypos, height, width, permanent, gridlocked);
	}

	public Statue(double xpos, double ypos, boolean permanent,
			boolean gridlocked) {
		super(xpos, ypos, permanent, gridlocked);

	}
	public void render(int xoffset, int yoffset, Game game) {
		xdraw = xpos - xoffset;
		ydraw = ypos - yoffset;
		SpriteCollection.statue.render(xdraw, ydraw);
	}

}
