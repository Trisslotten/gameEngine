package spel.tileMap.tiles;

import spel.entities.gui.SpriteCollection;

public class SandTile extends Tile {

	public SandTile() {
		// TODO Auto-generated constructor stub
	}
	public void render(int xpos, int ypos) {
		SpriteCollection.sand.render(xpos, ypos);
	}
	public void render(int xpos, int ypos,int width, int height) {
		SpriteCollection.sand.render(xpos, ypos,width,height);
	}
}
