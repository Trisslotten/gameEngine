package spel.entities.gui.backgrounds;

import spel.entities.Sprite;
import spel.entities.gui.Graphics;
import spel.entities.gui.SpriteCollection;

public class WinScreen extends Graphics {

	public WinScreen(double xpos, double ypos) {
		super(xpos, ypos);
		// TODO Auto-generated constructor stub
	}

	public WinScreen(double xpos, double ypos, Sprite sprite) {
		super(xpos, ypos, sprite);
		// TODO Auto-generated constructor stub
	}
	
	public void render() {
		SpriteCollection.winScreen.render(0, 0);
	}

}
