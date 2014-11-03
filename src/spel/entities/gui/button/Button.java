package spel.entities.gui.button;

import org.lwjgl.input.Mouse;

import spel.Game;
import spel.entities.Entity;
import spel.entities.Sprite;

public class Button extends Entity {
	
	private boolean clicked, hover, released, down;
	
	protected String text;
	
	protected Sprite sprite;
	
	protected Game game;
	
	public Button(double xpos, double ypos, Game game, String text) {
		super(xpos, ypos);
		this.text = text;
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
			hoverEvent();
		}
	}
	
	public void releasedEvent() {
		
	}
	
	public void clickedEvent() {
		
	}
	
	public void hoverEvent() {
		
	}
	
	public void render(double interpolation) {
		super.render(interpolation);
		sprite.render(xdraw, ydraw);
		if (game.text != null && text != null) {
			game.text.render((int) xdraw, (int) ydraw, text, (int) width, (int) height);
		}
	}
	
	public boolean isClicked() {
		return clicked;
	}
	
	public boolean isReleased() {
		return released && !Mouse.isButtonDown(0);
	}
	
}