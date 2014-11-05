package spel.entities.gui;

import spel.entities.Sprite;

public class SpriteCollection {

	/*
	 * PlayerSprites
	 */
	public static final Sprite player = new Sprite("res/art/kaj/kaj.png");

	/*
	 * Buttons
	 */
	public static final Sprite settings = new Sprite("res/art/buttons/settings.png");
	public static final Sprite quit = new Sprite("res/art/buttons/quit.png");
	public static final Sprite cont = new Sprite("res/art/buttons/continue.png");
	public static final Sprite start = new Sprite("res/art/buttons/start.png");

	/*
	 * Backgrounds
	 */
	public static final Sprite menubg = new Sprite("res/art/backgrounds/sstartsida.png");
	public static final Sprite pauseCover = new Sprite("res/art/backgrounds/pausecover.png");

	/*
	 * Tiles
	 */
	public static final Sprite tile = new Sprite("res/art/tiles/tileno2.png");
	public static final Sprite tile2 = new Sprite("res/art/tiles/tile2.png");
	public static final Sprite grass = new Sprite("res/art/tiles/grass.png");
	public static final Sprite darkGrass = new Sprite("res/art/tiles/dark_grass.png");
	public static final Sprite sand = new Sprite("res/art/tiles/sand.png");
	public static final Sprite water = new Sprite("res/art/tiles/water.png");

	/*
	 * Plants
	 */
	public static final Sprite palmtree = new Sprite("res/art/plants/palm.png");
	
	/*
	 * ETC
	 */
	public static final Sprite cursor = new Sprite("res/art/cursor.png");
	public static final Sprite asd = new Sprite("res/art/pixel.png");
	public static final Sprite[] WPointer = WPointer();

	public static Sprite[] WPointer() {
		Sprite[] WPointer = new Sprite[9];
		for (int i = 1; i < 10; i++) {
			WPointer[i - 1] = new Sprite("res/art/WPointer/" + i + ".png");
		}
		return WPointer;
	}

}
