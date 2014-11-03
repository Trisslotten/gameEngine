package spel.entities.gui.button;

import spel.Game;
import spel.SaveGame;
import spel.entities.Sprite;

public class StartButton extends Button {
	
	public StartButton(double xpos, double ypos, Game game, String text) {
		super(xpos, ypos, game, text);
		// TODO Auto-generated constructor stub
	}
	
	public StartButton(float xpos, float ypos, Game game, Sprite sprite) {
		super(xpos, ypos, game, sprite);
	}
	
	public void clickedEvent() {
		game.saveGame = new SaveGame(game); 
		game.gameState = Game.State.PLAYING;
	}
	
}
