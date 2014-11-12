package spel.entities.structures.vegetation;

import java.util.Random;

import spel.Game;
import spel.entities.Player;
import spel.entities.gui.SpriteCollection;
import spel.entities.items.resources.Resource;
import spel.entities.items.resources.Wood;

public class Sticks extends Vegetation {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2736725844143458843L;
	private int stickIndex;

	public Sticks(double xpos, double ypos, double height, double width, boolean permanent, boolean gridlocked, Game game) {
		super(xpos, ypos, height, width, permanent, gridlocked, game);
		// TODO Auto-generated constructor stub
		Random rand = new Random();
		stickIndex = rand.nextInt(3);
		radius = 1;
	}
	public Resource harvest() {
		Random rand = new Random();
		durability -= 100;
		return new Wood(rand.nextInt(2) + 1);
	}

	public Sticks(double xpos, double ypos, boolean permanent, boolean gridlocked) {
		super(xpos, ypos, permanent, gridlocked);
		// TODO Auto-generated constructor stub
	}
	public boolean toGetHarvested = false;
	public void update(double dt, Game game) {
		Player player = game.saveGame.player;
		player.vegetationClicked = false;
		boolean hover = hover(game, width, height);
		if(toGetHarvested&&player.getrange(xpos, ypos)<50) {
			player.vegetationClicked = true; 
			player.inventory.addResource(harvest());
		} else if (game.cursor.buttonClicked(0) && hover && !player.vegetationClicked&&player.getrange(xpos, ypos)<50) {
			player.vegetationClicked = true; 
			player.inventory.addResource(harvest());
		} else if(game.cursor.buttonClicked(0) && hover && !player.vegetationClicked) {
			toGetHarvested = true;
			player.Tx = (int) xpos+32;
			player.Ty = (int) ypos+32;
		}
	}

	public void render(int xoffset, int yoffset, Game game) {
		xdraw = xpos - xoffset;
		ydraw = ypos - yoffset;
		SpriteCollection.sticks[stickIndex].render(xdraw, ydraw);
		
		// game.text.render((int) xdraw, (int) ydraw, "+ " + xpos + " " + ypos,
		// Color.pink);
		// game.text.render((int) (xdraw + width), (int) (ydraw + height), "+",
		// Color.pink);
	}

}
