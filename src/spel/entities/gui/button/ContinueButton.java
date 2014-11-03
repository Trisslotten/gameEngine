package spel.entities.gui.button;

import spel.Game;
import spel.SaveGame;
import spel.entities.Sprite;

public class ContinueButton extends Button {
	
	public ContinueButton(double xpos, double ypos, Game game, String text) {
		super(xpos, ypos, game, text);
		// TODO Auto-generated constructor stub
	}
	
	public ContinueButton(float xpos, float ypos, Game game, Sprite sprite) {
		super(xpos, ypos, game, sprite);
		// TODO Auto-generated constructor stub
	}
	
	public void clickedEvent() {
		game.saveGame = SaveGame.load(game);
		game.gameState = Game.State.PLAYING;
	}
	
}
