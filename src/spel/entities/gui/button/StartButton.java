package spel.entities.gui.button;

import spel.Game;

public class StartButton extends Button {
	
	public StartButton(double xpos, double ypos, String path, Game game, String text) {
		super(xpos, ypos, path, game, text);
		// TODO Auto-generated constructor stub
	}
	
	public StartButton(double xpos, double ypos, String path, Game game) {
		super(xpos, ypos, path, game);
		// TODO Auto-generated constructor stub
	}
	
	public void clickedEvent() {
		game.gameState = Game.State.STARTING;
	}
	
}
