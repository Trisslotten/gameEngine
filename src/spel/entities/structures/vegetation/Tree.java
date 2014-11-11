package spel.entities.structures.vegetation;

import java.util.Random;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;

import spel.Game;
import spel.entities.Player;
import spel.entities.gui.SpriteCollection;
import spel.entities.items.resources.Stone;
import spel.entities.items.resources.Wood;
import spel.entities.structures.Structure;
import spel.entities.items.resources.*;
import spel.entities.items.tools.ThrowingTool;

public class Tree extends Vegetation {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6169588294128635668L;

	public ThrowingTool throwingTool;

	public Tree(double xpos, double ypos, double height, double width, boolean permanent, boolean gridlocked, Game game) {
		super(xpos, ypos, height, width, permanent, gridlocked, game);
		this.width = SpriteCollection.palmtree.width;
		this.height = SpriteCollection.palmtree.height;
		collx = xpos + 115;
		colly = ypos + 275;
		radius = 25;
		xpos -= 115;
		ypos -= 275;
		xdraw = xpos;
		ydraw = ypos;
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
		Player player = game.saveGame.player;
		boolean hover = hover(game, SpriteCollection.palmtree.width, SpriteCollection.palmtree.height);
		if (player.axeSelected && game.cursor.buttonClicked(0) && hover && !player.vegetationClicked) {
			throwingTool = new ThrowingTool(player.xpos + game.getWidth() / 2, player.ypos + game.getHeight() / 2, collx + game.getWidth() / 2, colly + game.getHeight() / 2 - 20, this,true);
			player.vegetationClicked = true; 
		}
		if (throwingTool != null) {
			boolean hit = throwingTool.hit;
			throwingTool.update(dt);
			if (throwingTool.ded()) {
				throwingTool = null;
				player.vegetationClicked = false;
			}
				
			if (!hit && throwingTool.hit) {
				player.inventory.addResource(harvest());
			}
		}
	}

	public void render(int xoffset, int yoffset, Game game) {
		xdraw = xpos - xoffset;
		ydraw = ypos - yoffset;
		SpriteCollection.palmtree.render(xdraw, ydraw);
		if (throwingTool != null) {
			throwingTool.render(0, (int) game.saveGame.player.xpos, (int) game.saveGame.player.ypos, game);
		}
		// game.text.render((int) xdraw, (int) ydraw, "+ " + xpos + " " + ypos,
		// Color.pink);
		// game.text.render((int) (xdraw + width), (int) (ydraw + height), "+",
		// Color.pink);
	}
}
