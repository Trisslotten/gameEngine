package spel.entities.gui.button;

import spel.Game;

public class ContinueButton extends Button {
	
	public ContinueButton(double xpos, double ypos, String path, Game game, String text) {
		super(xpos, ypos, path, game, text);
		// TODO Auto-generated constructor stub
	}
	
	public ContinueButton(double xpos, double ypos, String path, Game game) {
		super(xpos, ypos, path, game);
		// TODO Auto-generated constructor stub
	}
	
	public void clickedEvent() {
		game.paused = false;
	}
	
}
