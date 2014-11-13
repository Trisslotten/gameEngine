package spel.entities.gui.button;

import spel.Game;
import spel.entities.gui.SpriteCollection;

public class CraftPickaxeButton extends Button {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6820466860416949609L;

	public CraftPickaxeButton(double xpos, double ypos, Game game) {
		super(xpos, ypos, game);
		this.width = SpriteCollection.craftPickaxe.width;
		this.height = SpriteCollection.craftPickaxe.height;
	}
	
	public void clickedEvent() {
		game.saveGame.player.craftPickaxe();
	}
	
	public void render() {
		SpriteCollection.craftPickaxe.render(xpos, ypos);
	}


}
