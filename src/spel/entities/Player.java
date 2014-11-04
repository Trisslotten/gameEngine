package spel.entities;

import java.io.Serializable;

import org.lwjgl.input.Mouse;

import spel.Game;
import spel.entities.gui.SpriteCollection;

public class Player extends Entity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8501459826523145529L;
	public int Ty = 0;
	public int Tx = 0;
	public int windowWidth, windowHeight;

	double velocity;

	public Player(double xpos, double ypos, Game game) {
		super(xpos, ypos);
		windowWidth = game.getWidth();
		windowHeight = game.getHeight();
		velocity = 175;
	}

	public void update(double dt, Game game) {
		if (Mouse.isButtonDown(0)) {
			Ty = (int) ((int) (ypos - windowHeight / 2) + game.cursor.getYpos());
			Tx = (int) ((int) (xpos - windowWidth / 2) + game.cursor.getXpos());
		}
		if (Math.abs(xpos - Tx) >= 5 && Math.abs(ypos - Ty) >= 5 && Tx != 0
				&& Ty != 0) {
			double dx = xpos - Tx;
			double dy = ypos - Ty;
			double angle = Math.atan2(dy, dx);
			xspd = Math.cos(angle) * velocity * dt / 1000;
			yspd = Math.sin(angle) * velocity * dt / 1000;
		} else {
			xspd = 0;
			yspd = 0;
		}

		xpos -= xspd;
		ypos -= yspd;
		xdraw = xpos;
		ydraw = ypos;

	}

	public void render(double interpolation) {
		xdraw -= xspd * interpolation;
		ydraw -= yspd * interpolation;

		SpriteCollection.player.render(windowWidth / 2, windowHeight / 2);
	}

	public void setTx(int Tx) {
		this.Tx = Tx;
	}

	public void setTy(int Ty) {
		this.Ty = Ty;
	}

}
