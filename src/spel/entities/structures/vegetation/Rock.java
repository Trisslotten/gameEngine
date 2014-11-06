package spel.entities.structures.vegetation;

import spel.Game;
import spel.entities.gui.SpriteCollection;
import spel.entities.structures.Structure;

public class Rock extends Structure {

	public Rock(double xpos, double ypos, double height, double width, boolean permanent, boolean gridlocked) {
		super(xpos, ypos, height, width, permanent, gridlocked);
		// TODO Auto-generated constructor stub
	}

	public Rock(double xpos, double ypos, boolean permanent, boolean gridlocked) {
		super(xpos, ypos, permanent, gridlocked);
		// TODO Auto-generated constructor stub
	}
	
	public void render(double ip, Game game) {
		xdraw += xspd * ip / 1000;
		ydraw += yspd * ip / 1000;
		xdraw = xpos - game.saveGame.player.getXpos() + game.getWidth() / 2;
		ydraw = ypos - game.saveGame.player.getYpos() + game.getHeight() / 2;
		SpriteCollection.rock.render(xdraw, ydraw);
	}
}
