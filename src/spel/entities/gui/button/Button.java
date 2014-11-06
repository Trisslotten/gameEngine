package spel.entities.gui.button;

import org.lwjgl.input.Mouse;

import spel.Game;
import spel.entities.Entity;
import spel.entities.Sprite;
import spel.entities.gui.Graphics;
import spel.utils.Sound;

public class Button extends Graphics {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1198390322690529505L;

	protected boolean clicked, hover,  released, down, soundPlayed = false;

	protected Sprite sprite;

	protected Game game;

	public Button(double xpos, double ypos, Game game) {
		super(xpos, ypos);
		this.game = game;
	}

	public Button(float xpos, float ypos, Game game, Sprite sprite) {
		super(xpos, ypos);
		this.width = sprite.width;
		this.height = sprite.height;
		this.xpos = xpos * (float) game.getWidth();
		this.ypos = ypos * (float) game.getHeight();
		this.sprite = sprite;
		this.game = game;
	}

	private boolean hover() {
		int x = (int) game.cursor.getXpos();
		int y = (int) game.cursor.getYpos();
		return x > xpos && x < xpos + width && y > ypos && y < ypos + height;
	}

	public boolean released() {
		return hover() && down && !isDown();
	}

	public boolean isDown() {
		return Mouse.isButtonDown(0);
	}

	public boolean clicked() {
		return hover() && !down && isDown();
	}

	public void update(double dt) {
		super.update(dt);
		if (!hover && hover()) {
			Sound.woodbutton.play(game.settings);
		}

		released = released();
		clicked = clicked();
		hover = hover();
		down = isDown();
		if (released) {
			releasedEvent();
		}
		if (clicked) {
			clickedEvent();
			game.buttonClicked = true;
		}
		if (hover) {
			soundPlayed = true;
			hoverEvent();
		}
	}

	public void releasedEvent() {

	}

	public void clickedEvent() {

	}

	public void hoverEvent() {

	}

	public void render() {
		sprite.render(xdraw, ydraw);
	}

	public boolean isClicked() {
		return clicked;
	}

	public boolean isReleased() {
		return released && !Mouse.isButtonDown(0);
	}

}