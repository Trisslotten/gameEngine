package spel.entities.gui.backgrounds;

import spel.entities.gui.Graphics;
import spel.entities.gui.SpriteCollection;

public class BagPopup extends Graphics {

	public BagPopup(double xpos, double ypos) {
		super(xpos, ypos);
		// TODO Auto-generated constructor stub
	}
	public void render() {
		SpriteCollection.bagPopup.render(0, 0);
	}

}
