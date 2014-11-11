package spel.entities.structures.vegetation;

import java.util.Random;

import org.lwjgl.input.Mouse;

import spel.Game;
import spel.entities.Player;
import spel.entities.gui.SpriteCollection;
import spel.entities.items.resources.Stone;
import spel.entities.items.tools.ThrowingTool;

public class Rock extends Vegetation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 528861663061955237L;

	public Rock(double xpos, double ypos, double height, double width, boolean permanent, boolean gridlocked, Game game) {
		super(xpos, ypos, height, width, permanent, gridlocked, game);
		collx = xpos + 26;
		colly = ypos + 22;
		xpos -= 26;
		ypos -= 22;
		radius = 26;
	}

	public Stone harvest() {
		Random rand = new Random();
		durability -= 50;
		return new Stone(rand.nextInt(3) + 2);
	}

	public void update(double dt, Game game) {
		Player player = game.saveGame.player;
		boolean hover = hover(game, SpriteCollection.rock.width, SpriteCollection.rock.height);
		if (player.axeSelected && game.cursor.buttonClicked(0) && hover && !player.vegetationClicked) {
			throwingTool = new ThrowingTool(player.xpos + game.getWidth() / 2, player.ypos + game.getHeight() / 2, collx + game.getWidth() / 2, colly + game.getHeight() / 2 - 20, this, false);
			player.vegetationClicked();
		}
		if (throwingTool != null) {
			boolean hit = throwingTool.hit;
			throwingTool.update(dt);
			if (throwingTool.ded()) {
				throwingTool = null;
				player.vegetationClicked = false;
			}

			if (!hit && throwingTool.hit) {
				player.inventory.addResource(harvest());
			}
		}
	}

	public void render(int xoffset, int yoffset, Game game) {
		xdraw = xpos - xoffset;
		ydraw = ypos - yoffset;
		SpriteCollection.rock.render(xdraw, ydraw);
		if (throwingTool != null) {
			throwingTool.render(0, (int) game.saveGame.player.xpos, (int) game.saveGame.player.ypos, game);
		}
	}
}
