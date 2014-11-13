package spel.entities.gui;

import spel.entities.Entity;
import spel.entities.Sprite;

public class Graphics extends Entity {

	/**
	 * 
	 */
	
	public Sprite sprite; 
	
	private static final long serialVersionUID = -8576723094542416352L;

	public Graphics(double xpos, double ypos) {
		super(xpos, ypos);
	}
	
	public Graphics(double xpos, double ypos, Sprite sprite) {
		super(xpos, ypos);
		this.width = sprite.width;
		this.height = sprite.height;
	}
	
	public void render() {
		sprite.render(xpos, ypos);
	}

}
