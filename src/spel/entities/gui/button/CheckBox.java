package spel.entities.gui.button;

import spel.Game;

public class CheckBox extends Button {
	
	public boolean checked = false;
	
	public CheckBox(double xpos, double ypos, String[] frames, Game game, String text) {
		super(xpos, ypos, frames, game, text);
	}
	
	public void clickedEvent() {
		checked = !checked;
		game.settings.fullscreen = checked;
		if(checked){
			frameIndex = 1;
		} else {
			frameIndex = 0;
		}
	}
	
	public void render(double interpolation) {
		super.render(interpolation);
		if (game.text != null && text != null) {
			game.text.render((int) (xdraw+frames[frameIndex].width), (int) ydraw, text, (int) width, (int) height);
		}
	}
}
