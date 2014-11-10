package spel.entities.gui.backgrounds;

import spel.entities.gui.Graphics;
import spel.entities.gui.SpriteCollection;

public class Sidebar extends Graphics {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7700472291716601165L;

	public Sidebar(double xpos, double ypos) {
		super(xpos, ypos);
		width = SpriteCollection.sidebar.width;
		height = SpriteCollection.sidebar.height;
	}
	
	public void render() {
		SpriteCollection.sidebar.render(xpos, ypos);
	}

}
