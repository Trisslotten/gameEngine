package spel.entities.gui.button;

import spel.Game;
import spel.entities.Sprite;
import spel.entities.gui.SpriteCollection;

public class BagButton extends Button {

	/**
	 * 
	 */
	public boolean active = false;
	private static final long serialVersionUID = 8777584777931754126L;

	public BagButton(double xpos, double ypos, Game game) {
		super(xpos, ypos, game);
		width = SpriteCollection.bag.width;
		height = SpriteCollection.bag.height;
	}
	
	public void clickedEvent() {
		active = !active;
	}
	
	public void render() {
		if(hover||active){
			SpriteCollection.bagHover.render(xpos, ypos);
		} else {
			SpriteCollection.bag.render(xpos, ypos);
		}
	}

}
