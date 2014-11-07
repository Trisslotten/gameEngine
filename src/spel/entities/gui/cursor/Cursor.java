package spel.entities.gui.cursor;

import org.lwjgl.input.Mouse;

import spel.Game;
import spel.entities.Entity;
import spel.entities.gui.SpriteCollection;

public class Cursor extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7518857373686635775L;

	private Game game;

	private boolean[] down = new boolean[Mouse.getButtonCount()];

	public Cursor(String filepath, Game game) {
		super(Mouse.getX(), Mouse.getY());
		this.game = game;
	}

	public boolean down(int i) {
		return down[i];
	}

	public void update() {
		xpos = Mouse.getX();
		ypos = game.getHeight() - Mouse.getY();

		setButtons();

	}

	public boolean buttonDown(int i) {
		return down[i];
	}

	public boolean buttonClicked(int i) {
		return !down[i] && Mouse.isButtonDown(i);
	}

	public boolean buttonReleased(int i) {
		return down[i] && !Mouse.isButtonDown(i);
	}

	public void setButtons() {
		for (int i = 0; i < down.length; i++) {
			down[i] = Mouse.isButtonDown(i);
		}
	}

	public void render(double ip) {
		xdraw = Mouse.getX();
		ydraw = game.getHeight() - Mouse.getY();
		SpriteCollection.cursor.render(xdraw, ydraw);
	}

}
