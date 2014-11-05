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
	boolean drawWPointer=false;
	double velocity;

	public Player(double xpos, double ypos, Game game) {
		super(xpos, ypos);
		windowWidth = game.getWidth();
		windowHeight = game.getHeight();
		velocity = 250;
	}

	public void update(double dt, Game game) {
		if (Mouse.isButtonDown(1)) {
			Ty = (int) ((int) (ypos - windowHeight / 2) + game.cursor.getYpos());
			Tx = (int) ((int) (xpos - windowWidth / 2) + game.cursor.getXpos());
		}
		if (Math.abs(xpos - Tx) >= 1 && Math.abs(ypos - (Ty)) >= 1 && Tx != 0
				&& Ty != 0) {
			drawWPointer=true;
			double dx = xpos - Tx;
			double dy = ypos - Ty;
			double angle = Math.atan2(dy, dx);
			xspd = Math.cos(angle) * velocity * dt / 1000;
			yspd = Math.sin(angle) * velocity * dt / 1000;
		} else {
			drawWPointer=false;
			xspd = 0;
			yspd = 0;
		}

		xpos -= xspd;
		ypos -= yspd;
		xdraw = xpos;
		ydraw = ypos;

	}

	public void render(double interpolation) {
		interpolation=0;
		xdraw -= xspd * interpolation;
		ydraw -= yspd * interpolation;
		if(drawWPointer){
		SpriteCollection.WPointer.render(Tx-xpos+windowWidth / 2-32,Ty-ypos+windowHeight / 2-40);
		}
		SpriteCollection.player.render((windowWidth / 2)-32, (windowHeight / 2)-87);
	}

	public void setTx(int Tx) {
		this.Tx = Tx;
	}

	public void setTy(int Ty) {
		this.Ty = Ty;
	}

}
