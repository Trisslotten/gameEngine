package spel.entities.gui;

import spel.Game;

public class ExitButton extends Button {
	
	private Game game;
	
	public ExitButton(double xpos, double ypos, Game game, String path, String mainfile, String hoverfile, String clickedfile) {
		super(xpos, ypos, path, mainfile, hoverfile, clickedfile);
		this.game = game;	
		xpos = game.getWidth()/2-frames[frameIndex].width/2;
	}
	
	public void update(double dt) {
		super.update(dt);
		if (isReleased()) {
			game.stop();
		}
	}
}
