package spel.entities.gui.button;

import spel.Game;
import spel.SaveGame;
import spel.entities.Sprite;
import spel.entities.gui.SpriteCollection;

public class StartButton extends Button {
	
	public StartButton(double xpos, double ypos, Game game, String text) {
		super(xpos, ypos, game, text);
		// TODO Auto-generated constructor stub
	}
	
	public void render(double interpolation) {
		if(hover){
			SpriteCollection.quitHover.render(xpos, ypos);
		} else {
			SpriteCollection.quit.render(xpos, ypos);
		}
	}
	
	public void clickedEvent() {
		game.saveGame = new SaveGame(game); 
		game.gameState = Game.State.PLAYING;
	}
	
}
