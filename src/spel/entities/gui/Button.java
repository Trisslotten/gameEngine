package spel.entities.gui;

import org.lwjgl.input.Mouse;

import spel.entities.Entity;

public class Button extends Entity {
	
	private boolean clicked, hover, released;
	
	public Button(double xpos, double ypos, String path, String mainfile, String hoverfile, String clickedfile) {
		super(xpos, ypos, new String[] { path + mainfile, path + hoverfile, path + clickedfile });
	}
	
	public boolean released() {
		return clicked && !clicked(0);
	}
	
	public boolean clicked(int button) {
		int x = Mouse.getX();
		int y = Mouse.getY();
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
		if (released) event();
	}
	
	public void event() {
		
	}
	
	public void render(double interpolation) {
		if (clicked) {
			frameIndex = 2;
		} else if (hover) {
			frameIndex = 1;
		} else {
			frameIndex = 0;
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
