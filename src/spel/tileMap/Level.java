package spel.tileMap;

import java.io.Serializable;
import java.util.Random;

import spel.Game;
import spel.entities.gui.SpriteCollection;
import spel.tileMap.tiles.*;
import spel.utils.SimplexNoise_octave;

public class Level implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7039780207013125942L;

	public Tile[] tiles;

	public int levelSize = 64;
	public int tilePixelLength;

	public int width, height;
	
	public Tile getTile(int xoffset, int yoffset) {
		int x = xoffset/tilePixelLength;
		int y = yoffset/tilePixelLength;
		return tiles[x+y*levelSize];
	}

	public Level(Game game) {
		this.width = game.getWidth();
		this.height = game.getHeight();
		tilePixelLength = (int) SpriteCollection.tile.width;
		tiles = new Tile[levelSize * levelSize];

		double[] noise = new double[levelSize * levelSize];
		
		SimplexNoise_octave noisegen = new SimplexNoise_octave(0);
		double amplitude = 0;
		int iterations = 50;
		double smthnss = 45;
		double smoothx = smthnss * levelSize / 30;
		double smoothy = smthnss * levelSize / 30;
		double levelSize = this.levelSize;

		for (int y = 0; y < levelSize; y++) {
			for (int x = 0; x < levelSize; x++) {
				noise[(int) (x + y * levelSize)] = 0;
				amplitude = 2;
				for (int i = 0; i < iterations; i++) {
					noise[(int) (x + y * levelSize)] += (noisegen.noise(x / (smoothx) * amplitude, y / (smoothy) * amplitude) + 1) / amplitude;
					amplitude *= 2;
				}
				noise[(int) (x + y * levelSize)] *= (1 - Math.abs((x / levelSize * 2) - 1)) * (1 - Math.abs((y / levelSize * 2) - 1));
				System.out.print((int) (noise[(int) (x + y * levelSize)] * 9.0) + ",");
			}
			System.out.println();
		}

		for (int i = 0; i < tiles.length; i++) {
			if (noise[i] > 0.2) {
				if (noise[i] > 0.3) {
					if(noise[i] > 0.6)
						tiles[i] = new DarkGrassTile();
					else
						tiles[i] = new GrassTile();
				} else
					tiles[i] = new SandTile();
			} else {
				tiles[i] = new WaterTile();
			}
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
				tiles[x + y * levelSize].render(x * tilePixelLength - xoffset + width / 2, y * tilePixelLength - yoffset + height / 2);
			}
		}
		int size = 1;
		for (int y = 0; y < levelSize; y++) {
			for (int x = 0; x < levelSize; x++) {
				tiles[x + y * levelSize].render(x * size, y * size, size, size);
			}
		}
	}
}
