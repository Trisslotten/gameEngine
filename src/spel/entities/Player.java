package spel.entities;

public class Player extends Entity {

	public Player(double xpos, double ypos, String[] frames) {
		super(xpos, ypos, frames);
		
	}
	
	public void render(double interpolation) {
		super.render(interpolation);
		
		SpriteCollection.player.render();
	}
	
}
