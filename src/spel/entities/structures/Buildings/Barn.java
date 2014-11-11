package spel.entities.structures.Buildings;

import spel.Game;
import spel.entities.structures.Structure;

public class Barn extends Structure {

	public Barn(double xpos, double ypos, double height, double width,
			boolean permanent, boolean gridlocked, Game game) {
		super(xpos, ypos, height, width, permanent, gridlocked, game);
		// TODO Auto-generated constructor stub
		this.woodCost = 50;
		this.stoneCost = 30;
		//this.nailCost = 0;
		if(gridlocked){
			int x = (int) (xpos/game.saveGame.level.tilePixelLength);
			xpos = x*game.saveGame.level.tilePixelLength;
			int y = (int) (ypos/game.saveGame.level.tilePixelLength);
			ypos = y*game.saveGame.level.tilePixelLength;
		}
		game.saveGame.player.inventory.payCost(woodCost,stoneCost,nailCost);	
	}
	
	public void update(double dt) {
		
	}
	
	public void render(int xoffset, int yoffset, Game game) {
		xdraw = xpos - xoffset;
		ydraw = ypos - xoffset;
		
		
		//SpriteCollection
	}

}
