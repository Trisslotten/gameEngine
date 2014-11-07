package spel.entities.structures.vegetation;

import java.util.Random;

import org.newdawn.slick.Color;

import spel.Game;
import spel.entities.gui.SpriteCollection;
import spel.entities.items.resources.Stone;
import spel.entities.items.resources.Wood;
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
	
	public Wood harvest(){
		Random rand = new Random();
		return new Wood(rand.nextInt(3)+2);
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
		game.text.render((int)xdraw, (int)ydraw, "+ " + xpos + " "+ ypos, Color.pink);
		game.text.render((int)(xdraw+width), (int)(ydraw+height), "+", Color.pink);
	}
}

