package spel.entities.gui.backgrounds;

import spel.entities.gui.Graphics;
import spel.entities.gui.SpriteCollection;

public class StartBackground extends Graphics {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3180740628291432604L;

	public StartBackground(double xpos, double ypos, double width, double height) {
		super(xpos, ypos);
		this.width = width;
		this.height = height;
	}

	public void render() {
		SpriteCollection.menubg.render(xdraw, ydraw, width, height);
	}

}
