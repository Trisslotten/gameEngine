package spel.entities.gui;

import org.lwjgl.input.Mouse;

import spel.entities.Entity;

public class Cursor extends Entity {
	
	public Cursor(String filepath) {
		super(Mouse.getX(), Mouse.getY(), filepath);
	}
	
	public void update(double dt) {
		xpos = Mouse.getX();
		ypos = Mouse.getY() - 16;
		xdraw = xpos;
		ydraw = ypos;
	}
	
	public void render(double ip) {
		Mouse.poll();
		xdraw = Mouse.getX();
		ydraw = Mouse.getY() - 16;
		super.render(ip);
	}
	
}
