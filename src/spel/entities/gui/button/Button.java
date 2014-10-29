package spel.entities.gui.button;

import org.lwjgl.input.Mouse;

import spel.Game;
import spel.Game.State;
import spel.Text;
import spel.entities.Entity;
import spel.entities.gui.Cursor;

public class Button extends Entity {
	
	private boolean clicked, hover, released;
	private Cursor c;
	private String text;
	private Text t;
	
	protected Game game;
	
	public Button(double xpos, double ypos, String path, Game game, String text) {
		super(xpos, ypos, new String[] { path });
		c = game.cursor;
		this.text = text;
		this.t = game.t;
		this.game = game;
	}
	public Button(double xpos, double ypos, String path, Game game) {
		super(xpos, ypos, new String[] { path });
		c = game.cursor;
		this.text = "";
		this.t = game.t;
		this.game = game;
	}
	
	public Button(double xpos, double ypos, String path, Cursor cursor) {
		super(xpos, ypos, new String[] { path });
		c = cursor;
	}
	
	public boolean released() {
		return clicked && !clicked(0);
	}
	
	public boolean clicked(int button) {
		int x = (int) c.getXpos();
		int y = (int) c.getYpos();
		return Mouse.isButtonDown(button) && x > xpos && x < xpos + width && y > ypos && y < ypos + height;
	}
	
	private boolean hover() {
		int x = Mouse.getX();
		int y = Mouse.getY();
		return x > xpos && x < xpos + width && y > ypos && y < ypos + height;
	}
	
	public void update(double dt) {
		super.update(dt);
		released = released();
		clicked = clicked(0);
		hover = hover();
		if (released) releasedEvent();
		if (clicked) clickedEvent();
		if (hover) hoverEvent();
	}
	
	public void releasedEvent() {
		
	}
	
	public void clickedEvent() {
		game.gameState = State.running;
	}
	
	public void hoverEvent() {
		
	}
	
	public void render(double interpolation) {
		/*
		 * if (clicked) { frameIndex = 2; } else if (hover) { frameIndex = 1; }
		 * else { frameIndex = 0; }
		 */
		if (t != null) {
			t.render((int) xdraw, (int) ydraw, text);
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
