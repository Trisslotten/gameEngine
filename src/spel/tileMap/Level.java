package spel.tileMap;

import java.io.Serializable;
import java.util.Random;

import spel.Game;
import spel.entities.gui.SpriteCollection;
import spel.tileMap.tiles.Tile;

public class Level implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7039780207013125942L;

	public Tile[] tiles;

	public int levelSize = 32;
	public int tilePixelLength;

	public int width, height;

	public Level(Game game) {
		this.width = game.getWidth();
		this.height = game.getHeight();
		tilePixelLength = (int) SpriteCollection.tile.width;
		tiles = new Tile[levelSize * levelSize];

		float[] noise = new float[levelSize * levelSize];

		Random rand = new Random();
		for (int i = 0; i < noise.length; i++) {
			while (noise[i] > 0)
				noise[i] = rand.nextFloat();
		}
		int range = 3;
		float a = 0;
		float b = 0;
		float ab = 0;
		for (int y = 0; y < levelSize; y++) {
			for (int x = 0; x < levelSize; x++) {
				if (x + range + (y + range) * levelSize < levelSize * levelSize) {
					ab += 1 / range;
					if (x % range == 0) {
						a = noise[x + y * levelSize];
						b = noise[x + range + y * levelSize];
						ab = 0;
					}
					noise[x + y * levelSize] = a * (1 - ab) + b * ab;
				}
			}
		}
		float[] gradient = new float[levelSize * levelSize];
		

		for (int i = 0; i < tiles.length; i++) {
			tiles[i] = new Tile();
		}
	}

	public void render(int xoffset, int yoffset) {
		int xstart = (xoffset - width / 2) / tilePixelLength;
		int ystart = (yoffset - height / 2) / tilePixelLength;
		int xend = (xoffset + tilePixelLength + width / 2) / tilePixelLength;
		int yend = (yoffset + tilePixelLength + height / 2) / tilePixelLength;
		if (xstart < 0)
			xstart = 0;
		if (ystart < 0)
			ystart = 0;
		if (xend > levelSize)
			xend = levelSize;
		if (yend > levelSize)
			yend = levelSize;

		for (int y = ystart; y < yend; y++) {
			for (int x = xstart; x < xend; x++) {
				tiles[x + y * levelSize]
						.render(x * tilePixelLength - xoffset + width / 2, y
								* tilePixelLength - yoffset + height / 2);
			}
		}
	}
}
