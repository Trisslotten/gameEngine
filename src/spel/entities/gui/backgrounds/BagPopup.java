package spel.entities.gui.backgrounds;

import spel.Game;
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
	private boolean hover(Game game) {
		int x = (int) game.cursor.getXpos();
		int y = (int) game.cursor.getYpos();
		return x > xpos && x < xpos + width && y > ypos && y < ypos + height;
	}

}
