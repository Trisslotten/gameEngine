package spel.entities.gui;

import spel.entities.Sprite;

public class SpriteCollection {

	
	/*
	 * Structures
	 */
	public static final Sprite hut = new Sprite("res/art/structures/hut.png");
	public static final Sprite fireOn = new Sprite("res/art/structures/fireplace/on.png");
	public static final Sprite fireOff = new Sprite("res/art/structures/fireplace/off.png");
	
	
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
	public static final Sprite pausPopup = new Sprite("res/art/gui/paus/paus.png");
	public static final Sprite pauseQuit = new Sprite("res/art/gui/paus/avsluta_knapp.png");
	public static final Sprite pauseMenu= new Sprite("res/art/gui/paus/tillbaka_knapp.png");
	public static final Sprite sidebar = new Sprite("res/art/gui/base.png");
	public static final Sprite bagPopup = new Sprite("res/art/gui/bag/BagPopup.png");
	public static final Sprite craftingPopup = new Sprite("res/art/gui/craft/arbetsbord.png");
	public static final Sprite nail = new Sprite("res/art/gui/bag/spik.png");
	public static final Sprite iron = new Sprite("res/art/gui/bag/järn.png");
	public static final Sprite food = new Sprite("res/art/gui/bag/mat.png");
	public static final Sprite stone = new Sprite("res/art/gui/bag/sten.png");
	public static final Sprite wood = new Sprite("res/art/gui/bag/wood.png");
	public static final Sprite amount = new Sprite("res/art/gui/bag/mängd.png");
	public static final Sprite stoneAxe = new Sprite("res/art/gui/tools/Yxa.png");
	public static final Sprite stoneAxeHover = new Sprite("res/art/gui/tools/Yxa_Hover.png");
	public static final Sprite stonePick = new Sprite("res/art/gui/tools/Stenhackare.png");
	public static final Sprite stonePickHover = new Sprite("res/art/gui/tools/stenhackare_Hover.png");
	
	
	/*
	 * Buttons
	 */
	public static final Sprite pause = new Sprite("res/art/gui/Pausa.png");
	public static final Sprite pauseHover = new Sprite("res/art/gui/Paus_hover.png");
	public static final Sprite bag = new Sprite("res/art/gui/Bag.png");
	public static final Sprite bagHover = new Sprite("res/art/gui/Bag_hover.png");
	public static final Sprite workbench = new Sprite("res/art/gui/workbench.png");
	public static final Sprite workbenchHover = new Sprite("res/art/gui/Workbench_hover.png");
	public static final Sprite settings = new Sprite("res/art/buttons/menu/inst.png");
	public static final Sprite settingsHover = new Sprite("res/art/buttons/menu/inst_hover.png");
	public static final Sprite quit = new Sprite("res/art/buttons/menu/avsluta.png");
	public static final Sprite quitHover = new Sprite("res/art/buttons/menu/avsluta_hover.png");
	public static final Sprite cont = new Sprite("res/art/buttons/menu/Fortspela.png");
	public static final Sprite contHover = new Sprite("res/art/buttons/menu/Fortspela_hover.png");
	public static final Sprite start = new Sprite("res/art/buttons/menu/spela.png");
	public static final Sprite startHover = new Sprite("res/art/buttons/menu/spela_hover.png");
	public static final Sprite craftFire = new Sprite("res/art/gui/craft/fireplace.png");
	public static final Sprite craftAxe = new Sprite("res/art/gui/craft/fireplace.png");
	public static final Sprite craftPickaxe = new Sprite("res/art/gui/craft/fireplace.png");
	public static final Sprite craftHut = new Sprite("res/art/gui/craft/fireplace.png");
	public static final Sprite craftShelter = new Sprite("res/art/gui/craft/fireplace.png");
	public static final Sprite craftHammer = new Sprite("res/art/gui/craft/fireplace.png");
	public static final Sprite craftBoat = new Sprite("res/art/gui/craft/fireplace.png");
	
	
	
	
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
	public static final Sprite smallbush = new Sprite("res/art/plants/buske_liten.png");
	public static final Sprite bushtree= new Sprite("res/art/plants/buskträd.png");
	public static final Sprite coconut= new Sprite("res/art/plants/kokosnöt.png");
	public static final Sprite smallRock = new Sprite("res/art/plants/liten.png");
	
	public static final Sprite BB = new Sprite("res/art/plants/BB.png");
	public static final Sprite BBH = new Sprite("res/art/plants/BBH.png");
	
	public static final Sprite[] sticks = getSticks();
	
	/*
	 * ETC
	 */
	public static final Sprite statue = new Sprite("res/art/special/statue.png");
	public static final Sprite circle = new Sprite("res/art/circle.png");
	public static final Sprite[] axe = getAxeSprites();
	public static final Sprite[] pickaxe = getPickaxeSprites();
	public static final Sprite shadow = new Sprite("res/art/tools/shadow.png");
	
	/*
	 * NPC
	 */
	public static final Sprite[] NPC = NPC();
	public static final Sprite NPCEX = new Sprite("res/art/NPC/NPC!.png");
	public static final Sprite NPCHUNG = new Sprite("res/art/NPC/NPCHUNG.png");
	
	public static final Sprite NPCCUT = new Sprite("res/art/NPC/cut.png");
	public static final Sprite NPCHACK = new Sprite("res/art/NPC/hack.png");
	public static final Sprite NPCFUCKINGBERRIES = new Sprite("res/art/NPC/fucking berries.png");
	public static final Sprite NPCGUARD = new Sprite("res/art/NPC/guard.png");
	
	public static final Sprite[] NPCSEL = NPCSEL();
	public static Sprite[] NPCSEL() {
		Sprite[] NPCSEL = new Sprite[18];
		for (int i = 1; i < 19; i++) {
			NPCSEL[i - 1] = new Sprite("res/art/pointers/" + i + ".png");
		}
		return NPCSEL;
	}
	public static Sprite[] NPC() {
		Sprite[] NPCSEL = new Sprite[3];
		for (int i = 0; i < 3; i++) {
			NPCSEL[i] = new Sprite("res/art/NPC/" + i + ".png");
		}
		return NPCSEL;
	}
	
	/*
	 * MOB
	 */
	public static final Sprite mon = new Sprite("res/art/MOB/monkey.png");
	public static final Sprite monR = new Sprite("res/art/MOB/monkeyR.png");
	
	public static final Sprite cursor = new Sprite("res/art/cursor.png");
	public static final Sprite[] WPointer = WPointer();
	
	public static Sprite[] getSticks() {
		Sprite[] sticks = new Sprite[3];
		for (int i = 0; i < sticks.length; i++) {
			sticks[i] = new Sprite("res/art/plants/sticks/" + i + ".png");
		}
		return sticks;
	}

	public static Sprite[] getAxeSprites() {
		Sprite[] axe = new Sprite[4];
		for (int i = 0; i < axe.length; i++) {
			axe[i] = new Sprite("res/art/tools/axe/" + i + ".png");
		}
		return axe;
	}
	public static Sprite[] getPickaxeSprites() {
		Sprite[] pickaxe = new Sprite[4];
		for (int i = 0; i < axe.length; i++) {
			pickaxe[i] = new Sprite("res/art/tools/pickaxe/" + i + ".png");
		}
		return pickaxe;
	}
	
	
	public static Sprite[] WPointer() {
		Sprite[] WPointer = new Sprite[9];
		for (int i = 1; i < 10; i++) {
			WPointer[i - 1] = new Sprite("res/art/WPointer/" + i + ".png");
		}
		return WPointer;
	}

}
