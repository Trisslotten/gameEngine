package spel.entities.structures.vegetation;

import java.util.Random;

import spel.Game;
import spel.entities.Player;
import spel.entities.gui.SpriteCollection;
import spel.entities.items.resources.Food;
import spel.entities.items.resources.Resource;
import spel.entities.items.resources.Wood;

public class BerryBush extends Vegetation {
	

	public BerryBush(double xpos, double ypos, double height, double width, boolean permanent, boolean gridlocked, Game game) {
		super(xpos, ypos, height, width, permanent, gridlocked, game);
		// TODO Auto-generated constructor stub
	}

	public BerryBush(double xpos, double ypos, boolean permanent, boolean gridlocked) {
		super(xpos, ypos, permanent, gridlocked);
		// TODO Auto-generated constructor stub
	}
	
	public Resource harvest() {
		Random rand = new Random();
		durability -= 100;
		return new Food(rand.nextInt(2) + 1);
	}
	
	public boolean toGetHarvested = false;
	public void update(double dt, Game game) {
		Player player = game.saveGame.player;
		player.vegetationClicked = false;
		boolean hover = hover(game, width, height);
		int x = (int) (xpos+32);
		int y = (int) (ypos+32);
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
		SpriteCollection.sticks[0].render(xdraw, ydraw);
	}

}
