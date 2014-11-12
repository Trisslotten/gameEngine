package spel.entities.gui.backgrounds;

import spel.entities.gui.Graphics;
import spel.entities.gui.SpriteCollection;

public class PausePopup extends Graphics {

	public PausePopup(double xpos, double ypos) {
		super(xpos, ypos);
		// TODO Auto-generated constructor stub
	}
	public void render() {
		SpriteCollection.pausPopup.render(50,50);
	}
	
}
