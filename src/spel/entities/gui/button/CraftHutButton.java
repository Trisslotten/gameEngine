package spel.entities.gui.button;

import spel.Game;
import spel.entities.Sprite;
import spel.entities.gui.SpriteCollection;

public class CraftHutButton extends Button {

	public CraftHutButton(double xpos, double ypos, Game game) {
		super(xpos, ypos, game);
		this.width = SpriteCollection.craftAxe.width;
		this.height = SpriteCollection.craftAxe.height;
	}
	
	public void clickedEvent() {
		game.saveGame.player.craftAxe();
	}
	
	public void render() {
		SpriteCollection.craftAxe.render(xpos, ypos);
	}

}
