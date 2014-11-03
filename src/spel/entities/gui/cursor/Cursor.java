package spel.entities.gui.cursor;

import org.lwjgl.input.Mouse;

import spel.Game;
import spel.entities.Entity;
import spel.entities.gui.SpriteCollection;

public class Cursor extends Entity {
	
	private Game game;
	
	public Cursor(String filepath, Game game) {
		super(Mouse.getX(), Mouse.getY());
		this.game = game;
	}
	
	public void update() {
		xpos = Mouse.getX();
		ypos = game.getHeight() - Mouse.getY();
	}
	public void render(double ip) {
		xdraw = Mouse.getX();
		ydraw = game.getHeight() - Mouse.getY();
		SpriteCollection.cursor.render(xdraw, ydraw);
	}
	
	
}
