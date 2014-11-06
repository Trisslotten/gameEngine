package spel.entities.gui.backgrounds;

import spel.entities.gui.Graphics;
import spel.entities.gui.SpriteCollection;

public class PauseCover extends Graphics {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8228715056376401207L;

	public PauseCover(double xpos, double ypos) {
		super(xpos, ypos);
		// TODO Auto-generated constructor stub
	}
	
	public PauseCover(double xpos, double ypos,  double width, double height) {
		super(xpos, ypos);
		this.width = width;
		this.height = height;
	}
	
	public void render() {
		SpriteCollection.pauseCover.render(0, 0, width, height);
	}
	
}
