package spel.entities;

import spel.entities.gui.SpriteCollection;

public class Player extends Entity {

	public Player(double xpos, double ypos) {
		super(xpos, ypos);
		
	}
	
	public void render(double interpolation) {
		super.render(interpolation);
		
		SpriteCollection.player.render();
	}
	
}
