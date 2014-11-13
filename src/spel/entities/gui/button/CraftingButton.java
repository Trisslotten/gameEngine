package spel.entities.gui.button;

import spel.Game;
import spel.entities.Sprite;
import spel.entities.gui.SpriteCollection;

public class CraftingButton extends Button {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2283970947309487504L;
	public boolean active = false;

	public CraftingButton(double xpos, double ypos, Game game) {
		super(xpos, ypos, game);
		// TODO Auto-generated constructor stub
		width = SpriteCollection.workbenchHover.width;
		height = SpriteCollection.workbenchHover.height;
	}

	public CraftingButton(float xpos, float ypos, Game game, Sprite sprite) {
		super(xpos, ypos, game, sprite);
		// TODO Auto-generated constructor stub
	}
	
	public void clickedEvent() {
		active = !active;
	}
	
	public void render() {
		if(hover||active){
			SpriteCollection.workbenchHover.render(xpos, ypos);
		} else {
			SpriteCollection.workbench.render(xpos, ypos);
		}
	}

}
