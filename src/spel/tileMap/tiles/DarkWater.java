package spel.tileMap.tiles;

import spel.entities.gui.SpriteCollection;

public class DarkWater extends Tile {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1734868297603944684L;
	
	
	public void render(int xpos, int ypos) {
		SpriteCollection.darkWater.render(xpos, ypos);
	}
	public void render(int xpos, int ypos,int width, int height) {
		SpriteCollection.darkWater.render(xpos, ypos,width,height);
	}
}
