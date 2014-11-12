package spel.entities.gui.icons;

import spel.entities.gui.Graphics;
import spel.entities.gui.SpriteCollection;

public class NailIcon extends Graphics {

	public NailIcon(double xpos, double ypos) {
		super(xpos, ypos);
		// TODO Auto-generated constructor stub
	}
	
	public void render(int xpos, int ypos) {
		SpriteCollection.nail.render(xpos, ypos);
	}
}
