package spel.entities.structures.vegetation;

import java.io.Serializable;

import spel.Game;
import spel.entities.gui.SpriteCollection;
import spel.entities.structures.Structure;

public class Tree extends Structure {

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

	public void render(double interpolation) {

	}

	public void update(double dt, Game game) {
		xpos += xspd * dt / 1000;
		ypos += yspd * dt / 1000;
		xdraw = xpos;
		ydraw = ypos;
	}

	public void render(double ip, Game game) {
		xdraw += xspd * ip / 1000;
		ydraw += yspd * ip / 1000;
		xdraw = xpos - game.saveGame.player.getXpos() + game.getWidth() / 2;
		ydraw = ypos - game.saveGame.player.getYpos() + game.getHeight() / 2;
		SpriteCollection.palmtree.render(xdraw, ydraw);
	}
}
