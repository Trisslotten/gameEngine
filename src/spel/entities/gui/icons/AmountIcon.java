package spel.entities.gui.icons;

import spel.entities.gui.Graphics;
import spel.entities.gui.SpriteCollection;

public class AmountIcon extends Graphics {

	public AmountIcon(double xpos, double ypos) {
		super(xpos, ypos);
		// TODO Auto-generated constructor stub
	}
	
	public void render(int xpos, int ypos) {
		SpriteCollection.amount.render(xpos, ypos);
	}

}
