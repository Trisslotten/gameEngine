package spel.entities.structures.vegetation;

import java.util.Random;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;

import spel.Game;
import spel.entities.gui.SpriteCollection;
import spel.entities.items.resources.Resource;
import spel.entities.items.resources.Wood;

public class SmallBush extends Vegetation {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3920308251178819548L;

	public SmallBush(double xpos, double ypos, double height, double width, boolean permanent, boolean gridlocked) {
		super(xpos, ypos, height, width, permanent, gridlocked);
		collx = xpos+31;
		colly = ypos+21;
		xpos -=  31;
		ypos -= 21;
		radius = 20;
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
		boolean hover = hover(game, SpriteCollection.smallbush.width,SpriteCollection.smallbush.height);
		if(game.cursor.buttonClicked(0)&&hover&&!game.saveGame.player.vegetationClicked) {
			game.saveGame.player.harvest(this);
		}
	}

	public void render(int xoffset, int yoffset, Game game) {
		xdraw = xpos - xoffset;
		ydraw = ypos - yoffset;
		SpriteCollection.smallbush.render(xdraw, ydraw);
	}

}
