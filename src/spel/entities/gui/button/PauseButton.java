package spel.entities.gui.button;

import spel.Game;
import spel.entities.Sprite;
import spel.entities.gui.SpriteCollection;

public class PauseButton extends Button {

	public PauseButton(double xpos, double ypos, Game game, String text) {
		super(xpos, ypos, game, text);
		// TODO Auto-generated constructor stub
	}

	public PauseButton(float xpos, float ypos, Game game, Sprite sprite) {
		super(xpos, ypos, game, sprite);
		// TODO Auto-generated constructor stub
	}

	public void clickedEvent() {
		game.paused = !game.paused;
	}
	public void render(double interpolation) {
		if(hover){
			SpriteCollection.contHover.render(xpos, ypos);
		} else {
			SpriteCollection.cont.render(xpos, ypos);
		}
	}

}
