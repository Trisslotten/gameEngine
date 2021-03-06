package spel.tileMap;

import java.io.Serializable;
import java.util.Random;
import java.util.Vector;

import spel.Game;
import spel.entities.NPC;
import spel.entities.Player;
import spel.entities.gui.SpriteCollection;
import spel.entities.structures.Structure;
import spel.entities.structures.vegetation.Rock;
import spel.entities.structures.vegetation.Tree;
import spel.tileMap.tiles.DarkGrassTile;
import spel.tileMap.tiles.DarkWater;
import spel.tileMap.tiles.GrassTile;
import spel.tileMap.tiles.SandTile;
import spel.tileMap.tiles.Tile;
import spel.tileMap.tiles.WaterTile;
import spel.utils.Position;
import spel.utils.SimplexNoise_octave;

public class Level implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7039780207013125942L;

	public Tile[] tiles;
	Vector<Structure> plants = new Vector<Structure>();
	Vector<NPC> NPCs = new Vector<NPC>();

	public int levelSize = 128;
	public int tilePixelLength;

	public int width, height;
	Random rand = new Random();

	public Level(Game game) {
		this.width = game.getWidth();
		this.height = game.getHeight();
		tilePixelLength = (int) SpriteCollection.grass.width;
		tiles = new Tile[levelSize * levelSize];

		double[] noise = new double[levelSize * levelSize];

		SimplexNoise_octave noisegen = new SimplexNoise_octave(0);
		double amplitude = 0;
		int iterations = 3;
		double smthnss = 20;
		double smoothx = smthnss * levelSize / 30;
		double smoothy = smthnss * levelSize / 30;
		double lvlSize = this.levelSize;

		for (int y = 0; y < lvlSize; y++) {
			for (int x = 0; x < lvlSize; x++) {
				noise[(int) (x + y * lvlSize)] = 0;
				amplitude = 2;
				for (int i = 0; i < iterations; i++) {
					noise[(int) (x + y * lvlSize)] += (noisegen.noise(x / (smoothx) * amplitude, y / (smoothy) * amplitude) + 1) / amplitude;
					amplitude *= 2;
				}
				noise[(int) (x + y * lvlSize)] *= (1 - Math.abs((x / lvlSize * 2) - 1)) * (1 - Math.abs((y / lvlSize * 2) - 1));
			}
		}

		for (int i = 0; i < tiles.length; i++) {
			if (noise[i] > 0.12) {
				if (noise[i] > 0.2) {
					if (noise[i] > 0.3) {
						if (noise[i] > 0.6)
							tiles[i] = new DarkGrassTile();
						else
							tiles[i] = new GrassTile();
					} else
						tiles[i] = new SandTile();
				} else {
					tiles[i] = new WaterTile();
				}
			} else {
				tiles[i] = new DarkWater();
			}
		}

		for (int y = 0; y < this.levelSize; y++) {
			for (int x = 0; x < this.levelSize; x++) {
				Tile tile = tiles[x + y * this.levelSize];
				int xpos = x * tilePixelLength + rand.nextInt(tilePixelLength);
				int ypos = y * tilePixelLength + rand.nextInt(tilePixelLength);
				if (tile.getClass().getSimpleName().equals("GrassTile")) {
					if (rand.nextBoolean() && rand.nextBoolean()&& rand.nextBoolean()) {
						plants.add(new Tree(xpos, ypos, SpriteCollection.grass.height, SpriteCollection.grass.width, false, true));
					} else if (rand.nextBoolean()&& rand.nextBoolean()) {
						plants.add(new Rock(xpos, ypos, SpriteCollection.rock.width, SpriteCollection.rock.height, false, true));
					}
				} else if (tile.getClass().getSimpleName().equals("DarkGrassTile")) {

				}
			}
		}
		for (int i = 0; i < 50; i++) {
			Position pos = getNPCPosition();
			NPCs.add(new NPC(pos.x, pos.y, "asd", true));
		}
	}
	
	

	public boolean isWaterTile(int xoffset, int yoffset) {
		boolean isWater = false;
		int x = (int) ((double) xoffset / (double) (tilePixelLength));
		int y = (int) ((double) yoffset / (double) (tilePixelLength));
		try {
			isWater = tiles[x + y * levelSize].getClass().getSimpleName().equals("WaterTile") || tiles[x + y * levelSize].getClass().getSimpleName().equals("DarkWater");
		} catch (IndexOutOfBoundsException e) {

		}
		return isWater;
	}

	public Tile getTile(int xoffset, int yoffset) {
		int x = (int) ((double) xoffset / (double) (tilePixelLength));
		int y = (int) ((double) yoffset / (double) (tilePixelLength));
		if (x + y * levelSize > 0 && x + y * levelSize < levelSize - 1)
			return tiles[x + y * levelSize];
		return tiles[0];
	}

	public Position getNPCPosition() {
		int x = rand.nextInt(levelSize - 1);
		int y = 0;
		Tile tile = null;
		if (rand.nextBoolean()) {
			y = levelSize - 1;
			do {
				if (x + y * levelSize > 0 && x + y * levelSize < levelSize * levelSize - 1 && rand.nextBoolean())
					tile = tiles[x + y * levelSize];
				else
					tile = tiles[0];
				y--;
				if (y < 0) {
					x = rand.nextInt(levelSize - 1);
					y = levelSize;
				}
			} while (!tile.getClass().getSimpleName().equals(new GrassTile().getClass().getSimpleName()));
		} else {
			y = 0;
			do {
				if (x + y * levelSize > 0 && x + y * levelSize < levelSize * levelSize - 1 && rand.nextBoolean())
					tile = tiles[x + y * levelSize];
				else
					tile = tiles[0];
				y++;
				if (y >= levelSize) {
					x = rand.nextInt(levelSize - 1);
					y = 0;
				}
			} while (!tile.getClass().getSimpleName().equals(new GrassTile().getClass().getSimpleName()));
		}
		return new Position(x * tilePixelLength, y * tilePixelLength);

	}

	public Position getSpawnPosition() {
		int x = rand.nextInt(levelSize - 1);
		int y = 0;
		Tile tile = null;
		if (rand.nextBoolean()) {
			y = levelSize - 1;
			do {
				if (x + y * levelSize > 0 && x + y * levelSize < levelSize * levelSize - 1)
					tile = tiles[x + y * levelSize];
				else
					tile = tiles[0];
				y--;
				if (y < 0) {
					x = rand.nextInt(levelSize - 1);
					y = levelSize;
				}
			} while (!tile.getClass().getSimpleName().equals(new SandTile().getClass().getSimpleName()));
		} else {
			y = 0;
			do {
				if (x + y * levelSize > 0 && x + y * levelSize < levelSize * levelSize - 1)
					tile = tiles[x + y * levelSize];
				else
					tile = tiles[0];
				y++;
				if (y >= levelSize) {
					x = rand.nextInt(levelSize - 1);
					y = 0;
				}
			} while (!tile.getClass().getSimpleName().equals(new SandTile().getClass().getSimpleName()));
		}
		return new Position(x * tilePixelLength, y * tilePixelLength);

	}

	public void update(double dt, Game game) {
		for (NPC npc : NPCs) {
			npc.update(dt, game);
		}
	}

	public void render(int xoffset, int yoffset, Game game, Player player) {
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
		boolean behind = true;
		for (int i = 0; i < plants.size(); i++) {
			if (plants.elementAt(i).getYpos() + plants.elementAt(i).getHeight() > player.getYpos() + player.height && behind) {
				behind = false;
				player.render(0);
			}
			plants.elementAt(i).render(xoffset, yoffset, game);
		}
		if (behind) {
			player.render(0);
		}
		for (NPC npc : NPCs) {
			npc.render(xoffset, yoffset, game);
		}

		int size = 1;
		for (int y = 0; y < levelSize; y++) {
			for (int x = 0; x < levelSize; x++) {
				tiles[x + y * levelSize].render(x * size, y * size, size, size);
			}
		}
	}
}
