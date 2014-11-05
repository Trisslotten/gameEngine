package spel.entities.gui.button;

import spel.Game;
import spel.entities.gui.SpriteCollection;


public class QuitButton extends Button {

	public QuitButton(float xpos, float ypos, Game game, String text) {
		super(xpos, ypos, game, text);
	}
	
	public void render(double interpolation) {
		if(hover){
			SpriteCollection.quitHover.render(xpos, ypos);
		} else {
			SpriteCollection.quit.render(xpos, ypos);
		}
	}
	
	public void clickedEvent() {
		game.stop();
	}

	
}
