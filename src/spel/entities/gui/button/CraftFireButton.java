package spel.entities.gui.button;

import spel.Game;
import spel.entities.Sprite;
import spel.entities.gui.SpriteCollection;

public class CraftFireButton extends Button {

	public CraftFireButton(double xpos, double ypos, Game game) {
		super(xpos, ypos, game);
		// TODO Auto-generated constructor stub
		width = SpriteCollection.craftFire.width;
		height = SpriteCollection.craftFire.height;
	}
	
	public void render() {
		SpriteCollection.craftFire.render(xpos, ypos);
	}

	
	public void clickedEvent() {
		game.saveGame.player.fireplaceActive();
		game.gameGui.craftButton.active = false;
	}
}
