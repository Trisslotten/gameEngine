package spel.entities.gui.button;

import spel.Game;
import spel.entities.Sprite;
import spel.entities.gui.SpriteCollection;

public class CraftNailsButton extends Button {

	public CraftNailsButton(double xpos, double ypos, Game game) {
		super(xpos, ypos, game);
		this.width = SpriteCollection.craftAxe.width;
		this.height = SpriteCollection.craftAxe.height;
	}
	
	public void clickedEvent() {
		game.saveGame.player.craftNails();
	}
	
	public void render() {
		SpriteCollection.craftNails.render(xpos, ypos);
	}

}
