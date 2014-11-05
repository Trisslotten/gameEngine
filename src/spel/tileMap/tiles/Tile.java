package spel.tileMap.tiles;

import java.io.Serializable;

import spel.entities.Sprite;
import spel.entities.gui.SpriteCollection;

public class Tile implements Serializable {
	
	public Tile() {
		
	}
	
	public void render(int xpos, int ypos) {
		SpriteCollection.tile.render(xpos, ypos);
	}
	public void render(int xpos, int ypos,int width, int height) {
		SpriteCollection.tile.render(xpos, ypos,width,height);
	}
	
}
