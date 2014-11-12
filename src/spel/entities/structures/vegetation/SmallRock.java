package spel.entities.structures.vegetation;

import spel.Game;
import spel.entities.Player;
import spel.entities.gui.SpriteCollection;
import spel.entities.items.resources.Resource;
import spel.entities.items.resources.Stone;

public class SmallRock extends Vegetation {

	public SmallRock(double xpos, double ypos, double height, double width, boolean permanent, boolean gridlocked, Game game) {
		super(xpos, ypos, height, width, permanent, gridlocked, game);
		// TODO Auto-generated constructor stub
	}

	public SmallRock(double xpos, double ypos, boolean permanent, boolean gridlocked) {
		super(xpos, ypos, permanent, gridlocked);
		// TODO Auto-generated constructor stub
	}
	public Resource harvest() {
		durability -= 100;
		return new Stone(1);
	}
	
	public boolean toGetHarvested = false;
	public void update(double dt, Game game) {
		Player player = game.saveGame.player;
		player.vegetationClicked = false;
		boolean hover = hover(game, width, height);
		int x = (int) (xpos+16);
		int y = (int) (ypos+16);
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
		SpriteCollection.smallRock.render(xdraw, ydraw);
	}

}
