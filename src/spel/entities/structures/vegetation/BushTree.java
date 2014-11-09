package spel.entities.structures.vegetation;

import java.util.Random;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;

import spel.Game;
import spel.entities.gui.SpriteCollection;
import spel.entities.items.resources.Resource;
import spel.entities.items.resources.Wood;

public class BushTree extends Vegetation {
	public BushTree(double xpos, double ypos, double height, double width, boolean permanent, boolean gridlocked) {
		super(xpos, ypos, height, width, permanent, gridlocked);
		collx = xpos+76;
		colly = ypos+225;
		xpos -= 76;
		ypos -= 225;
		radius = 14;
	}

	public Resource harvest() {
		Random rand = new Random();
		durability -= 50;
		return new Wood(rand.nextInt(2) + 1);
	}

	public void cut() {
		durability -= 50;
	}

	public void update(double dt, Game game) {
		boolean hover = hover(game, SpriteCollection.bushtree.width, SpriteCollection.bushtree.height);
		if (game.saveGame.player.axeSelected && game.cursor.buttonClicked(0) && hover && !game.saveGame.player.treeClicked) {

		}
	}

	public void render(int xoffset, int yoffset, Game game) {
		xdraw = xpos - xoffset;
		ydraw = ypos - yoffset;
		SpriteCollection.bushtree.render(xdraw, ydraw);
		game.text.render((int) xdraw, (int) ydraw, "+ " + xpos + " " + ypos, Color.pink);
		game.text.render((int) (xdraw + width), (int) (ydraw + height), "+", Color.pink);
	}
}
