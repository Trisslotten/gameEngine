package spel.tileMap;

import java.io.Serializable;

<<<<<<< HEAD
import spel.entities.structures.Buildings.Fireplace;
import spel.entities.structures.Buildings.Hut;
=======
import spel.entities.structures.Enemies.Monkey;
>>>>>>> origin/Testing
import spel.entities.structures.special.Statue;
import spel.entities.structures.vegetation.*;

import java.util.Random;
import java.util.Vector;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import spel.Game;
import spel.entities.NPC;
import spel.entities.Player;
import spel.entities.gui.SpriteCollection;
import spel.entities.structures.Structure;
import spel.entities.structures.vegetation.Rock;
import spel.entities.structures.vegetation.SmallBush;
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
	public Vector<Vegetation> plants = new Vector<Vegetation>();
	public Vector<NPC> NPCs = new Vector<NPC>();
	Vector<Monkey> Monkeys = new Vector<Monkey>();
	public Vector<Structure> structures = new Vector<Structure>();

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
		double smthnss = 25;
		double smoothx = smthnss * levelSize / 30;
		double smoothy = smthnss * levelSize / 30;
		double lvlSize = this.levelSize;
		structures.add(new Statue(tilePixelLength * levelSize / 2, tilePixelLength * levelSize / 2, true, false));

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

					if (rand.nextBoolean() && rand.nextBoolean() && rand.nextBoolean()) {
						plants.add(new Tree(xpos, ypos, SpriteCollection.palmtree.height, SpriteCollection.palmtree.width, false, true, game));
					} else if (rand.nextBoolean() && rand.nextBoolean()) {
						plants.add(new Rock(xpos, ypos, SpriteCollection.rock.width, SpriteCollection.rock.height, false, true, game));
					} else if (rand.nextBoolean() && rand.nextBoolean() && rand.nextBoolean()) {
						plants.add(new SmallBush(xpos, ypos, SpriteCollection.smallbush.height, SpriteCollection.smallbush.width, false, true, game));
					}
				} else if (tile.getClass().getSimpleName().equals("DarkGrassTile")) {
					if (rand.nextBoolean() && rand.nextBoolean()) {
						plants.add(new Rock(xpos, ypos, SpriteCollection.rock.width, SpriteCollection.rock.height, false, true, game));
					} else if (rand.nextBoolean()) {
						plants.add(new BushTree(xpos, ypos, SpriteCollection.bushtree.height, SpriteCollection.bushtree.width, false, true, game));
					} else if (rand.nextBoolean()) {
						plants.add(new SmallBush(xpos, ypos, SpriteCollection.smallbush.height, SpriteCollection.smallbush.width, false, true, game));
					}
				}
			}
		}
		for (int i = 0; i < 50; i++) {
			Position pos = getNPCPosition();
			NPCs.add(new NPC(pos.x, pos.y, "asd", true, game));
		}
		for (int i = 0; i < 50; i++) {
			Position pos = getNPCPosition();
			Monkeys.add(new Monkey(pos.x, pos.y));
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

	public boolean getNPCclicked() {
		for (NPC e : NPCs) {
			if (e.getclicked()) {
				return true;
			}
		}
		return false;
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
		for (Monkey monkey : Monkeys) {
			monkey.update(dt, game);
		}
		for (int i = 0; i < plants.size(); i++) {
			plants.elementAt(i).update(dt, game);
			if (plants.elementAt(i).ded()) {
				plants.remove(i);
			}
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
			int x = (int) (game.saveGame.player.xpos);
			int y = (int) (game.saveGame.player.ypos);

			System.out.println("space pressed");
			structures.add(new Hut(x, y, SpriteCollection.hut.width, SpriteCollection.hut.height, true, true, game));
		}
	}

	public void render(int xoffset, int yoffset, Game game, Player player, double interpolation) {
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
			double xdraw = plants.elementAt(i).getXdraw();
			double ydraw = plants.elementAt(i).getYdraw();
			double collx = plants.elementAt(i).collx;
			double colly = plants.elementAt(i).colly;
			double width = plants.elementAt(i).getWidth();
			double height = plants.elementAt(i).getHeight();
			plants.elementAt(i).setToDraw(xoffset - game.getWidth() / 2, yoffset - game.getHeight() / 2);
			if (xdraw < game.getWidth() && xdraw + width > 0 && ydraw < game.getHeight() && ydraw + height > 0) {
				if (ydraw + height > player.getDrawBottom() && behind) {
					behind = false;
					player.render(interpolation, game);
				}
				plants.elementAt(i).render(xoffset - game.getWidth() / 2, yoffset - game.getHeight() / 2, game);
			}
		}
		if (behind) {
			player.render(interpolation, game);
		}
		for (NPC npc : NPCs) {
			npc.render(xoffset, yoffset, game);
		}
		for (Monkey monkey : Monkeys) {
			monkey.render(xoffset, yoffset, game);
		}
		for (Structure structure : structures) {
			structure.render(xoffset, yoffset, game);
			System.out.println("rendered Building");
		}

		int size = 1;
		for (int y = 0; y < levelSize; y++) {
			for (int x = 0; x < levelSize; x++) {
				tiles[x + y * levelSize].render(x * size, y * size, size, size);
			}
		}
	}
}
