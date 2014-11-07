package spel.entities.structures.vegetation;

import java.util.Random;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;

import spel.Game;
import spel.entities.gui.SpriteCollection;
import spel.entities.items.resources.Food;
import spel.entities.items.resources.Resource;
import spel.entities.items.resources.Wood;

public class Coconut extends Vegetation {
	
	public Coconut(double xpos, double ypos, double height, double width,
			boolean permanent, boolean gridlocked) {
		super(xpos, ypos, height, width, permanent, gridlocked);
		xdraw = xpos;
		ydraw = ypos;
	}

	public Resource harvest() {
		Random rand = new Random();
		durability -= 50;
		return new Food(rand.nextInt(2) + 1);
	}

	public void cut() {
		durability -= 50;
	}

	public void update(double dt, Game game) {
		if (Mouse.isButtonDown(0) && hover(game)) {
			System.out.println("asdasd");
			game.saveGame.player.inventory.addResource(harvest());
		}
	}

	public void render(int xoffset, int yoffset, Game game) {
		xdraw = xpos - xoffset;
		ydraw = ypos - yoffset;
		SpriteCollection.bushtree.render(xdraw, ydraw);
		game.text.render((int) xdraw, (int) ydraw, "+ " + xpos + " " + ypos,
				Color.pink);
		game.text.render((int) (xdraw + width), (int) (ydraw + height), "+",
				Color.pink);
	}
	
}
