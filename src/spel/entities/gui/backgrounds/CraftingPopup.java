package spel.entities.gui.backgrounds;

import spel.entities.gui.Graphics;
import spel.entities.gui.SpriteCollection;

public class CraftingPopup extends Graphics {

	public CraftingPopup(double xpos, double ypos) {
		super(xpos, ypos);
		// TODO Auto-generated constructor stub
	}
	
	public void render() {
		SpriteCollection.craftingPopup.render(0, 0);
	}

}
