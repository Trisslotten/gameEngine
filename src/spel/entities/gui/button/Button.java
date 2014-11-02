package spel.entities.gui.button;

import org.lwjgl.input.Mouse;

import spel.Game;
import spel.entities.Entity;

public class Button extends Entity {
	
	private boolean clicked, hover, released;
	
	private String text;
	
	protected Game game;
	
	public Button(double xpos, double ypos, String path, Game game, String text) {
		super(xpos, ypos, new String[] { path });
		this.text = text;
		this.game = game;
		
	}
	
	public Button(double xpos, double ypos, String path, Game game) {
		super(xpos, ypos, new String[] { path });
		this.game = game;
	}
	
	private boolean hover() {
		int x = (int) game.cursor.getXpos();
		int y = (int) game.cursor.getYpos();
		return x > xpos && x < xpos + width && y > ypos && y < ypos + height;
	}
	
	public boolean released() {
		return clicked && !clicked();
	}
	
	public boolean clicked() {
		return hover() && Mouse.isButtonDown(0) && !clicked;
	}
	
	public void update(double dt) {
		super.update(dt);
		
		released = released();
		clicked = clicked();
		hover = hover();
		
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
		/*
		 * if (clicked) { frameIndex = 2; } else if (hover) { frameIndex = 1; }
		 * else { frameIndex = 0; }
		 */
		if (game.text != null && text != null) {
			game.text.render((int) xdraw, (int) ydraw, text);
		}
		super.render(interpolation);
	}
	
	public boolean isClicked() {
		return clicked;
	}
	
	public boolean isReleased() {
		return released && !Mouse.isButtonDown(0);
	}
	
}
