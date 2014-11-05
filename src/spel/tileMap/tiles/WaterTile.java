package spel.tileMap.tiles;

import spel.entities.gui.SpriteCollection;

public class WaterTile extends Tile {

	public WaterTile() {
		// TODO Auto-generated constructor stub
	}
	public void render(int xpos, int ypos) {
		SpriteCollection.water.render(xpos, ypos);
	}
	public void render(int xpos, int ypos,int width, int height) {
		SpriteCollection.water.render(xpos, ypos,width,height);
	}
}
