package spel.entities.gui.button;

import spel.Game;
import spel.entities.Sprite;
import spel.entities.gui.SpriteCollection;

public class BagButton extends Button {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8777584777931754126L;

	public BagButton(double xpos, double ypos, Game game) {
		super(xpos, ypos, game);
		// TODO Auto-generated constructor stub
	}
	
	public void render() {
		if(hover){
			SpriteCollection.bagHover.render(xpos, ypos);
		} else {
			SpriteCollection.bag.render(xpos, ypos);
		}
	}

}
