package spel.entities.gui.button;

import spel.Game;
import spel.entities.Sprite;
import spel.entities.gui.SpriteCollection;

public class SelectAxeButton extends Button {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5714222191483826940L;

	public SelectAxeButton(double xpos, double ypos, Game game) {
		super(xpos, ypos, game);
		width = SpriteCollection.stoneAxe.width;
		height = SpriteCollection.stoneAxe.height;
	}

	public SelectAxeButton(float xpos, float ypos, Game game, Sprite sprite) {
		super(xpos, ypos, game, sprite);
		width = SpriteCollection.stoneAxe.width;
		height = SpriteCollection.stoneAxe.height;
	}

	public void clickedEvent() {
		if (game.saveGame.player.hasAxe) {
			game.saveGame.player.axeSelected = !game.saveGame.player.axeSelected;
			if (game.saveGame.player.axeSelected) {
				game.saveGame.player.pickaxeSelected = false;
			}
		}
	}

	public void render() {
		if (game.saveGame.player.hasAxe) {
			if (hover || game.saveGame.player.axeSelected) {
				SpriteCollection.stoneAxeHover.render(xpos, ypos);
			} else {
				SpriteCollection.stoneAxe.render(xpos, ypos);
			}
		}
	}
}
