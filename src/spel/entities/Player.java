package spel.entities;

import java.io.Serializable;

import spel.Game;
import spel.entities.gui.SpriteCollection;

public class Player extends Entity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8501459826523145529L;

	public int windowWidth,windowHeight;
	
	double velocity;
	
	public Player(double xpos, double ypos, Game game) {
		super(xpos, ypos);
		windowWidth = game.getWidth();
		windowHeight = game.getHeight();
		velocity = 100;
	}
	
	public void update(double dt, Game game) {
		double dx = windowWidth/2-game.cursor.getXpos();
		double dy = windowHeight/2-game.cursor.getYpos();
		double angle = Math.atan2(dy, dx);
		xspd = Math.cos(angle)*velocity*dt/1000;
		yspd = Math.sin(angle)*velocity*dt/1000;
		
		
		
		
		xpos -= xspd;
		ypos -= yspd;
		xdraw = xpos;
		ydraw = ypos;
		
	}
	
	public void render(double interpolation) {
		xdraw -= xspd*interpolation;
		ydraw -= yspd*interpolation;
		
		SpriteCollection.player.render(windowWidth/2,windowHeight/2);
	}
	
}
