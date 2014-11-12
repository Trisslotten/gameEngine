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
		durability -= 100;
		return new Wood(1);
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
		int x = (int) (xpos+width/2);
		int y = (int) (ypos+height/2);
		int range = player.getrange(x, y);
		if(toGetHarvested&&range<40) {
			player.vegetationClicked = true; 
			player.inventory.addResource(harvest());
		} else if (game.cursor.buttonClicked(0) && hover && !player.vegetationClicked&&range<40) {
			player.vegetationClicked = true; 
			player.inventory.addResource(harvest());
		} else if(game.cursor.buttonClicked(0) && hover && !player.vegetationClicked) {
			toGetHarvested = true;
			player.Tx = (int) x;
			player.Ty = (int) y;
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
