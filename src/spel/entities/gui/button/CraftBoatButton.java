package spel.entities.gui.button;

import spel.Game;
import spel.entities.Sprite;
import spel.entities.gui.SpriteCollection;

public class CraftBoatButton extends Button {

	public CraftBoatButton(double xpos, double ypos, Game game) {
		super(xpos, ypos, game);
		width = SpriteCollection.craftBoat.width;
		height = SpriteCollection.craftBoat.height;
	}

	public CraftBoatButton(float xpos, float ypos, Game game, Sprite sprite) {
		super(xpos, ypos, game, sprite);
		// TODO Auto-generated constructor stub
	}

	public void clickedEvent() {
		game.saveGame.player.craftBoat(game);
	}
	
	public void render() {
		SpriteCollection.craftBoat.render(xpos, ypos);
	}
}
