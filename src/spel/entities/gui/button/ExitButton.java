package spel.entities.gui.button;

import spel.Game;
import spel.Game.State;

public class ExitButton extends Button {
	
	public ExitButton(double xpos, double ypos, String path, Game game) {
		super(xpos, ypos, path, game);
	}
	
	public void clickedEvent() {
		game.gameState = State.menu;
	}
}
