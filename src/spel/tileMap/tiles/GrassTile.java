package spel.tileMap.tiles;

import spel.entities.gui.SpriteCollection;

public class GrassTile extends Tile {

	
	public void render(int xpos, int ypos) {
		SpriteCollection.grass.render(xpos, ypos);
	}
	public void render(int xpos, int ypos,int width, int height) {
		SpriteCollection.grass.render(xpos, ypos,width,height);
	}
}
