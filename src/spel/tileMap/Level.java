package spel.tileMap;

import spel.Game;
import spel.entities.Sprite;

public class Level {
	
	public Chunk[] chunks;
	public int chunkSize = 16;
	public int levelSize = 32;
	public int chunkPixelLength;
	public int tilePixelLength;
	
	public int width, height;
	
	public Level(Game game) {
		chunks = new Chunk[levelSize * levelSize];
		width = game.getWidth();
		height = game.getHeight();
		for (int i = 0; i < chunks.length; i++) {
			chunks[i] = new Chunk(chunkSize);
		}
		tilePixelLength = (int) Sprite.tile.height;
		chunkPixelLength = tilePixelLength * chunkSize;
		
	}
	
	public int render(int xoffset, int yoffset) {
		xoffset -= width / 2;
		yoffset -= height / 2;
		int xstart = xoffset / chunkPixelLength;
		int ystart = yoffset / chunkPixelLength;
		int xend = (xoffset + width + chunkPixelLength) / chunkPixelLength;
		int yend = (yoffset + width + chunkPixelLength) / chunkPixelLength;
		if (xstart < 0) xstart = 0;
		if (ystart < 0) ystart = 0;
		if (xend > chunkSize) xend = chunkSize;
		if (yend > chunkSize) yend = chunkSize;
		int objects = 0;
		for (int y = ystart; y < yend; y++) {
			for (int x = xstart; x < xend; x++) {
				objects += chunks[x + y * chunkSize].render(x * chunkPixelLength - xoffset, y * chunkPixelLength - yoffset, width, height, tilePixelLength, chunkSize);
			}
		}
		return objects;
	}
	
	public long getCount() {
		long count = 0;
		for (int i = 0; i < chunks.length; i++) {
			count += chunks[i].tiles.length;
		}
		return count;
	}
}
