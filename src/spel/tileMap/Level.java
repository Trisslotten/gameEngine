package spel.tileMap;

import java.io.Serializable;

import spel.Game;
import spel.entities.gui.SpriteCollection;
import spel.tileMap.tiles.Tile;

public class Level implements Serializable {
	
	public Tile[] tiles;
	
	public int levelSize = 32;
	public int tilePixelLength;
	private Game game;
	
	public int width, height;
	
	public Level(Game game) {
		this.game = game;
		tilePixelLength = (int) SpriteCollection.tile.width;
		tiles = new Tile[levelSize * levelSize];
		for (int i = 0; i < tiles.length; i++) {
			tiles[i] = new Tile();
		}
	}
	
	public void render(int xoffset, int yoffset) {
		
		for (int y = 0; y < levelSize; y++) {
			for (int x = 0; x < levelSize; x++) {
				tiles[x + y * levelSize].render(x * tilePixelLength - xoffset + game.getWidth() / 2, y * tilePixelLength - yoffset + game.getHeight() / 2);
			}
		}
	}
}
