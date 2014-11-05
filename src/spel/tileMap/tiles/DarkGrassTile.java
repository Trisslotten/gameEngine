package spel.tileMap.tiles;

import spel.entities.gui.SpriteCollection;

public class DarkGrassTile extends Tile {

	public DarkGrassTile() {
		// TODO Auto-generated constructor stub
	}
	
	public void render(int xpos, int ypos) {
		SpriteCollection.darkGrass.render(xpos, ypos);
	}
	public void render(int xpos, int ypos,int width, int height) {
		SpriteCollection.darkGrass.render(xpos, ypos,width,height);
	}

}
