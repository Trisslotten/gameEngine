package spel.entities.gui;

import spel.entities.Sprite;

public class SpriteCollection {

	/*
	 * PlayerSprites
	 */
	public static final Sprite player = new Sprite("res/art/kaj/kaj.png");

	public static final Sprite[][] playerWalking = new Sprite[][] { new Sprite[] {
			new Sprite("res/art/kaj/0/walk1.png"),new Sprite("res/art/kaj/0/walk2.png"),new Sprite("res/art/kaj/0/walk3.png")
	}, new Sprite[] {
			new Sprite("res/art/kaj/1/walk1.png"),new Sprite("res/art/kaj/1/walk2.png"),new Sprite("res/art/kaj/1/walk3.png")
	}, new Sprite[] {
			new Sprite("res/art/kaj/2/walk1.png"),new Sprite("res/art/kaj/2/walk2.png"),new Sprite("res/art/kaj/2/walk3.png")
	}, new Sprite[] {
			new Sprite("res/art/kaj/3/walk1.png"),new Sprite("res/art/kaj/3/walk2.png"),new Sprite("res/art/kaj/3/walk3.png")
	}, new Sprite[] {
			new Sprite("res/art/kaj/4/walk1.png"),new Sprite("res/art/kaj/4/walk2.png"),new Sprite("res/art/kaj/4/walk3.png")
	}, new Sprite[] {
			new Sprite("res/art/kaj/5/walk1.png"),new Sprite("res/art/kaj/5/walk2.png"),new Sprite("res/art/kaj/5/walk3.png")
	}, new Sprite[] {
			new Sprite("res/art/kaj/6/walk1.png"),new Sprite("res/art/kaj/6/walk2.png"),new Sprite("res/art/kaj/6/walk3.png")
	}, new Sprite[] {
			new Sprite("res/art/kaj/7/walk1.png"),new Sprite("res/art/kaj/7/walk2.png"),new Sprite("res/art/kaj/7/walk3.png")
	}, };
	
	/*
	 * GUI
	 */
	public static final Sprite sidebar = new Sprite("res/art/gui/base.png");

	/*
	 * Buttons
	 */
	public static final Sprite settings = new Sprite("res/art/buttons/menu/inst.png");
	public static final Sprite settingsHover = new Sprite("res/art/buttons/menu/inst_hover.png");
	public static final Sprite quit = new Sprite("res/art/buttons/menu/avsluta.png");
	public static final Sprite quitHover = new Sprite("res/art/buttons/menu/avsluta_hover.png");
	public static final Sprite cont = new Sprite("res/art/buttons/menu/Fortspela.png");
	public static final Sprite contHover = new Sprite("res/art/buttons/menu/Fortspela_hover.png");
	public static final Sprite start = new Sprite("res/art/buttons/menu/spela.png");
	public static final Sprite startHover = new Sprite("res/art/buttons/menu/spela_hover.png");
	
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
	public static final Sprite darkWater = new Sprite("res/art/tiles/dark_water.png");

	/*
	 * Plants
	 */
	public static final Sprite palmtree = new Sprite("res/art/plants/palm.png");
	public static final Sprite rock = new Sprite("res/art/plants/rock.png");

	/*
	 * ETC
	 */
	
	/*
	 * NPC
	 */
	public static final Sprite NPC = new Sprite("res/art/NPC/NPC.png");
	public static final Sprite NPCEX = new Sprite("res/art/NPC/NPC!.png");
	
	public static final Sprite cursor = new Sprite("res/art/cursor.png");
	public static final Sprite[] WPointer = WPointer();

	public static Sprite[] WPointer() {
		Sprite[] WPointer = new Sprite[9];
		for (int i = 1; i < 10; i++) {
			WPointer[i - 1] = new Sprite("res/art/WPointer/" + i + ".png");
		}
		return WPointer;
	}

}
