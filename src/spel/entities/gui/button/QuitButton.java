package spel.entities.gui.button;

import spel.Game;
import spel.entities.Sprite;
import spel.entities.gui.SpriteCollection;
import spel.utils.Sound;


public class QuitButton extends Button {

	public QuitButton(float xpos, float ypos, Game game, Sprite sprite) {
		super(xpos, ypos, game, sprite);
	}
	
	public void render() {
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
