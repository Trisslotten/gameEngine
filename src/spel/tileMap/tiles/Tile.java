package spel.tileMap.tiles;

import spel.entities.Sprite;

public class Tile {
	
	public Tile() {
		
	}
	
	public void render(int xpos, int ypos) {
		Sprite.tile.render(xpos, ypos);
	}
	
}
