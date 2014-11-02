package spel.entities.gui.button;

import spel.Game;

public class QuitButton extends Button {
	
	public QuitButton(double xpos, double ypos, String path, Game game, String text) {
		super(xpos, ypos, path, game, text);
		// TODO Auto-generated constructor stub
	}
	
	public QuitButton(double xpos, double ypos, String path, Game game) {
		super(xpos, ypos, path, game);
		// TODO Auto-generated constructor stub
	}
	
	public void clickedEvent() {
		game.stop();
	}
	
}
