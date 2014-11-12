package spel.entities.structures.vegetation;

import spel.Game;
import spel.entities.Player;
import spel.entities.gui.SpriteCollection;

public class SmallRock extends Vegetation {

	public SmallRock(double xpos, double ypos, double height, double width, boolean permanent, boolean gridlocked, Game game) {
		super(xpos, ypos, height, width, permanent, gridlocked, game);
		// TODO Auto-generated constructor stub
	}

	public SmallRock(double xpos, double ypos, boolean permanent, boolean gridlocked) {
		super(xpos, ypos, permanent, gridlocked);
		// TODO Auto-generated constructor stub
	}
	
	public boolean toGetHarvested = false;
	public void update(double dt, Game game) {
		Player player = game.saveGame.player;
		player.vegetationClicked = false;
		boolean hover = hover(game, width, height);
		if(toGetHarvested&&player.getrange(xpos, ypos)<70) {
			player.vegetationClicked = true; 
			player.inventory.addResource(harvest());
		} else if (game.cursor.buttonClicked(0) && hover && !player.vegetationClicked&&player.getrange(xpos, ypos)<70) {
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
		SpriteCollection.smallRock.render(xdraw, ydraw);
	}

}
