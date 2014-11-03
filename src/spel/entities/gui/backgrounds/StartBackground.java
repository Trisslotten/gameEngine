package spel.entities.gui.backgrounds;

import spel.entities.Entity;
import spel.entities.gui.SpriteCollection;

public class StartBackground extends Entity {

	public StartBackground(double xpos, double ypos, double width, double height) {
		super(xpos, ypos, height, width);
	}
	
	public void render(double interpolation) {
		SpriteCollection.menubg.render(xdraw, ydraw,width,height);
	}
	
}
