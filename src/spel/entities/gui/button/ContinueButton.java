package spel.entities.gui.button;

import spel.Game;
import spel.SaveGame;
import spel.entities.Sprite;
import spel.entities.gui.SpriteCollection;

public class ContinueButton extends Button {
	
	
	public ContinueButton(float xpos, float ypos, Game game, Sprite sprite) {
		super(xpos, ypos, game, sprite);
		// TODO Auto-generated constructor stub
	}
	
	public void clickedEvent() {
		game.saveGame = SaveGame.load(game);
		game.gameState = Game.State.PLAYING;
	}
	public void render(double interpolation) {
		if(hover){
			SpriteCollection.contHover.render(xpos, ypos);
		} else {
			SpriteCollection.cont.render(xpos, ypos);
		}
	}
	
}
