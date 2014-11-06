package spel.entities.structures.vegetation;

import spel.Game;
import spel.entities.gui.SpriteCollection;
import spel.entities.structures.Structure;

public class Rock extends Structure {

	/**
	 * 
	 */
	private static final long serialVersionUID = 528861663061955237L;

	public Rock(double xpos, double ypos, double height, double width, boolean permanent, boolean gridlocked) {
		super(xpos, ypos, height, width, permanent, gridlocked);
		// TODO Auto-generated constructor stub
	}

	public Rock(double xpos, double ypos, boolean permanent, boolean gridlocked) {
		super(xpos, ypos, permanent, gridlocked);
		// TODO Auto-generated constructor stub
	}
	
	public void render(int xoffset, int yoffset, Game game) {
		xdraw = xpos - xoffset;
		ydraw = ypos - yoffset;
		SpriteCollection.rock.render(xdraw, ydraw);
	}
}
