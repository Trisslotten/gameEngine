package spel.entities.gui.button;

import spel.Game;
import spel.entities.gui.Cursor;

public class ExitButton extends Button {
	
	private Game game;
	
	public ExitButton(double xpos, double ypos, Game game, String path, Cursor c) {
		super(xpos, ypos, path, c);
		this.game = game;
	}
	
	public void clickedEvent() {
		if (isReleased()) {
			game.stop();
		}
	}
}
