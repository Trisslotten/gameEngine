package spel.entities.gui.button;

import spel.Game;
import spel.SaveGame;
import spel.entities.Sprite;
import spel.entities.gui.SpriteCollection;

public class StartButton extends Button {
	
	public StartButton(float xpos, float ypos, Game game, Sprite sprite) {
		super(xpos, ypos, game, sprite);
	}
	
	public void render() {
		if(hover){
			SpriteCollection.startHover.render(xpos, ypos);
		} else {
			SpriteCollection.start.render(xpos, ypos);
		}
	}
	
	public void clickedEvent() {
		game.saveGame = new SaveGame(game); 
		game.gameState = Game.State.PLAYING;
	}
	
}
