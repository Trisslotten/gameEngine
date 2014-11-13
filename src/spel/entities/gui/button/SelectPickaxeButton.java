package spel.entities.gui.button;

import spel.Game;
import spel.entities.Sprite;
import spel.entities.gui.SpriteCollection;

public class SelectPickaxeButton extends Button {

	public SelectPickaxeButton(double xpos, double ypos, Game game) {
		super(xpos, ypos, game);
		width = SpriteCollection.stonePick.width;
		height = SpriteCollection.stonePick.height;
	}

	public void clickedEvent() {
		if (game.saveGame.player.hasPickaxe) {
			game.saveGame.player.pickaxeSelected = !game.saveGame.player.pickaxeSelected;
			if (game.saveGame.player.pickaxeSelected) {
				game.saveGame.player.axeSelected = false;
			}
		}
	}

	public void render() {
		if (game.saveGame.player.hasPickaxe) {
			if (hover || game.saveGame.player.pickaxeSelected) {
				SpriteCollection.stonePickHover.render(xpos, ypos);
			} else {
				SpriteCollection.stonePick.render(xpos, ypos);
			}
		}
	}

}
