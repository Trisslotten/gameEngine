package spel.entities.gui.button;

import spel.Game;
import spel.entities.gui.SpriteCollection;

public class CraftAxeButton extends Button {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1700722069846542478L;

	public CraftAxeButton(double xpos, double ypos, Game game) {
		super(xpos, ypos, game);
		// TODO Auto-generated constructor stub
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
