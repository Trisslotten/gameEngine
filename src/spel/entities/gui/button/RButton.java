package spel.entities.gui.button;

import org.lwjgl.opengl.DisplayMode;

import spel.Game;
import spel.utils.Settings;

public class RButton extends Button {
	
	private DisplayMode displayMode;

	public RButton(double xpos, double ypos, String path, Game game, String text) {
		super(xpos, ypos, path, game, text);
		// TODO Auto-generated constructor stub
	}
	
	public RButton(double xpos, double ypos, String path, Game game) {
		super(xpos, ypos, path, game);
		// TODO Auto-generated constructor stub
	}
	
	public RButton(int xpos, int ypos, String path, Game game, DisplayMode displayMode) {
		super(xpos, ypos, path, game);
		this.displayMode = displayMode;
		text = displayMode.getWidth()+"x"+displayMode.getHeight();
	}

	public void clickedEvent() {
		game.settings.setWidth(displayMode.getWidth());
		game.settings.setHeight(displayMode.getHeight());
		System.out.println(displayMode.getWidth());
		System.out.println(displayMode.getHeight());
		System.out.println();
	}
	
}
