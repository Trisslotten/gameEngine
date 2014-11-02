package spel.entities.gui.button;

import spel.Game;

public class SettingsButton extends Button {
	
	public SettingsButton(double xpos, double ypos, String path, Game game, String text) {
		super(xpos, ypos, path, game, text);
		// TODO Auto-generated constructor stub
	}
	
	public SettingsButton(double xpos, double ypos, String path, Game game) {
		super(xpos, ypos, path, game);
		// TODO Auto-generated constructor stub
	}
	
	public void clickedEvent() {
		game.gui.inSettings = true;
	}
	
}
