package spel.entities.gui;

import org.newdawn.slick.Color;

import spel.Game;
import spel.entities.gui.backgrounds.BagPopup;
import spel.entities.gui.backgrounds.CraftingPopup;
import spel.entities.gui.backgrounds.Sidebar;
import spel.entities.gui.button.BagButton;
import spel.entities.gui.button.CraftFireButton;
import spel.entities.gui.button.*;
import spel.entities.gui.icons.*;
import spel.entities.items.resources.Resource;
import spel.entities.items.resources.Wood;

public class GameGUI {

	public Sidebar sidebar;

	public BagButton bagButton;
	public CraftingButton craftButton;
	public BagPopup bag;
	public CraftingPopup craftingMenu;

	public FoodIcon food;
	public IronIcon iron;
	public NailIcon nail;
	public StoneIcon stone;
	public WoodIcon wood;
	public AmountIcon amount;
	
	public SelectAxeButton selectAxe;
	public SelectPickaxeButton selectPickaxe;
	

	public CraftFireButton craftFire;
	public CraftAxeButton craftAxe;
	public CraftPickaxeButton craftPickaxe;
	public CraftBoatButton craftBoat;
	public CraftShelterButton craftShelter;
	public CraftHutButton craftHut;

	public GameGUI(Game game) {
		sidebar = new Sidebar(game.getWidth() - SpriteCollection.sidebar.width, 0);
		bagButton = new BagButton(game.getWidth() - SpriteCollection.sidebar.width + 5, 20, game);
		craftButton = new CraftingButton(game.getWidth() - SpriteCollection.sidebar.width + 5, SpriteCollection.bag.height + 100, game);

		bag = new BagPopup(0, 0);
		food = new FoodIcon(0, 0);
		iron = new IronIcon(0, 0);
		nail = new NailIcon(0, 0);
		stone = new StoneIcon(0, 0);
		wood = new WoodIcon(0, 0);
		amount = new AmountIcon(0, 0);
		
		selectAxe = new SelectAxeButton(game.getWidth() - SpriteCollection.sidebar.width, 300, game);
		selectPickaxe = new SelectPickaxeButton(game.getWidth() - SpriteCollection.sidebar.width,400, game);

		craftingMenu = new CraftingPopup(240, 20);
		craftFire = new CraftFireButton(240 + 53, 200, game);
		craftAxe = new CraftAxeButton(240 + 53 + 173, 200, game);
		craftPickaxe = new CraftPickaxeButton(240 + 53 + 173*2, 200, game);
		craftShelter = new CraftShelterButton(240 + 53 + 173*3, 200, game);
	}

	public void update(Game game) {
		bagButton.update(0);
		craftButton.update(0);
		selectAxe.update(0);
		selectPickaxe.update(0);
		if (bagButton.active) {
			if (!craftButton.active && game.cursor.buttonClicked(0)) {
				// bagButton.active = false;
			}
		}
		if (craftButton.active) {
			craftFire.update(0);
			craftAxe.update(0);
			craftPickaxe.update(0);
		}

	}

	public void render(Game game) {
		sidebar.render();
		bagButton.render();
		craftButton.render();
		selectPickaxe.render();
		selectAxe.render();
		if (bagButton.active) {
			bag.render();

			int counter = 0;
			int width = 1250 / 5;
			int start = 65;
			for (Resource res : game.saveGame.player.inventory.items) {
				if (res.getClass().getSimpleName().equals("Wood")) {
					wood.render(start + counter * width, 0);
					amount.render(start + counter * width + 140, 50);
					if (res.getAmount() >= 10) {
						if (res.getAmount() >= 100) {
							game.smaller.render(start + counter * width + 147, 59, "" + res.getAmount(), Color.black);
						} else {
							game.small.render(start + counter * width + 147, 56, "" + res.getAmount(), Color.black);
						}
					} else {
						game.text.render(start + counter * width + 150, 52, "" + res.getAmount(), Color.black);
					}
				} else if (res.getClass().getSimpleName().equals("Stone")) {
					stone.render(start + counter * width, 0);
					amount.render(start + counter * width + 140, 50);
					if (res.getAmount() >= 10) {
						if (res.getAmount() >= 100) {
							game.smaller.render(start + counter * width + 147, 59, "" + res.getAmount(), Color.black);
						} else {
							game.small.render(start + counter * width + 147, 56, "" + res.getAmount(), Color.black);
						}
					} else {
						game.text.render(start + counter * width + 150, 52, "" + res.getAmount(), Color.black);
					}
				} else if (res.getClass().getSimpleName().equals("Food")) {
					food.render(start + counter * width, 0);
					amount.render(start + counter * width + 140, 50);
					if (res.getAmount() >= 10) {
						if (res.getAmount() >= 100) {
							game.smaller.render(start + counter * width + 147, 59, "" + res.getAmount(), Color.black);
						} else {
							game.small.render(start + counter * width + 147, 56, "" + res.getAmount(), Color.black);
						}
					} else {
						game.text.render(start + counter * width + 150, 52, "" + res.getAmount(), Color.black);
					}
				} else if (res.getClass().getSimpleName().equals("Iron")) {
					iron.render(start + counter * width, 0);
					amount.render(start + counter * width + 140, 50);
					if (res.getAmount() >= 10) {
						if (res.getAmount() >= 100) {
							game.smaller.render(start + counter * width + 147, 59, "" + res.getAmount(), Color.black);
						} else {
							game.small.render(start + counter * width + 147, 56, "" + res.getAmount(), Color.black);
						}
					} else {
						game.text.render(start + counter * width + 150, 52, "" + res.getAmount(), Color.black);
					}
				} else if (res.getClass().getSimpleName().equals("IronNails")) {
					nail.render(start + counter * width, 0);
					amount.render(start + counter * width + 140, 50);
					if (res.getAmount() >= 10) {
						if (res.getAmount() >= 100) {
							game.smaller.render(start + counter * width + 147, 59, "" + res.getAmount(), Color.black);
						} else {
							game.small.render(start + counter * width + 147, 56, "" + res.getAmount(), Color.black);
						}
					} else {
						game.text.render(start + counter * width + 150, 52, "" + res.getAmount(), Color.black);
					}
				}
				counter++;
			}

		}
		if (craftButton.active) {
			craftingMenu.render();
			craftFire.render();
			craftAxe.render();
			craftPickaxe.render();
		}
	}

}
