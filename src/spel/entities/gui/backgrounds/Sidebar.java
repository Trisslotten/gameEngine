package spel.entities.gui.backgrounds;

import spel.entities.gui.Graphics;
import spel.entities.gui.SpriteCollection;

public class Sidebar extends Graphics {

	public Sidebar(double xpos, double ypos) {
		super(xpos, ypos);
	}
	
	public void render() {
		SpriteCollection.sidebar.render(xpos, ypos);
	}

}
