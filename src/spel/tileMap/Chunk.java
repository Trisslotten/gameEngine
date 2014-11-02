package spel.tileMap;

import java.util.Random;

import spel.tileMap.tiles.Tile;

public class Chunk {
	
	public Tile[] tiles;
	
	public Chunk(int chunkSize) {
		Random rand = new Random();
		tiles = new Tile[chunkSize * chunkSize];
		for (int i = 0; i < tiles.length; i++) {
			tiles[i] = new Tile();
		}
	}
	
	public int render(int xoffset, int yoffset, int width, int height, int tilePixelLength, int chunkSize) {
		int xstart = (-xoffset) / tilePixelLength;
		int ystart = (-yoffset) / tilePixelLength;
		int xend = (-xoffset + width + tilePixelLength) / tilePixelLength;
		int yend = (-yoffset + height + tilePixelLength) / tilePixelLength;
		if (xstart < 0) xstart = 0;
		if (ystart < 0) ystart = 0;
		if (xend > chunkSize) xend = chunkSize;
		if (yend > chunkSize) yend = chunkSize;
		int objects = 0;
		for (int y = ystart; y < yend; y++) {
			for (int x = xstart; x < xend; x++) {
				tiles[x + y * chunkSize].render(x * tilePixelLength + xoffset, y * tilePixelLength + yoffset);
				objects++;
			}
		}
		return objects;
	}
	
}
