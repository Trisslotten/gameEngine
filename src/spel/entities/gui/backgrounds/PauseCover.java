package spel.entities.gui.backgrounds;

import spel.entities.Entity;
import spel.entities.gui.SpriteCollection;

public class PauseCover extends Entity {
	
	public PauseCover(double xpos, double ypos) {
		super(xpos, ypos);
		// TODO Auto-generated constructor stub
	}
	
	public PauseCover(double xpos, double ypos,  double width, double height) {
		super(xpos, ypos, height, width);
		// TODO Auto-generated constructor stub
	}
	
	public void render(double interpolation) {
		SpriteCollection.pauseCover.render(0, 0, width, height);
	}
	
}
