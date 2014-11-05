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
	int pointerindex = 0;
	double timer;
	double pointertimer = 0.1;
	boolean drawWPointer = false;
	double velocity;
	int direction = 0;

	public Player(double xpos, double ypos, Game game) {
		super(xpos, ypos);
		windowWidth = game.getWidth();
		windowHeight = game.getHeight();
		velocity = 250;
	}

	public void update(double dt, Game game) {

		timer++;
		if (timer >= 4) {
			pointerindex++;
			timer = 0;
			if (pointerindex > 8) {
				pointerindex = 0;
			}
		}
		if (Mouse.isButtonDown(1)) {
			Ty = (int) ((int) (ypos - windowHeight / 2) + game.cursor.getYpos());
			Tx = (int) ((int) (xpos - windowWidth / 2) + game.cursor.getXpos());
		}
		if (Math.abs(xpos - Tx) >= 10 && Tx != 0
				&& Ty != 0 || Math.abs(ypos - (Ty)) >= 10 && Tx != 0
				&& Ty != 0) {
			drawWPointer = true;
			double dx = xpos - Tx;
			double dy = ypos - Ty;
			double angle = Math.atan2(dy, dx);
			xspd = Math.cos(angle) * velocity * dt / 1000;
			yspd = Math.sin(angle) * velocity * dt / 1000;

			for (int i = 0; i < 9; i++) {
				if (angle < i * (Math.PI / 8) && angle > -i * (Math.PI / 8)) {
					int temp = i;
					if (temp == 1) {
						direction = 1;
					} else if (temp == 2 || temp == 3) {
						direction = 2;
					} else if (temp == 4 || temp == 5) {
						direction = 3;
					} else if (temp == 6 || temp == 7) {
						direction = 4;
					} else if (temp == 8) {
						direction = 5;
					}
					System.out.println(direction);
					break;
				}
			}
		} else {
			drawWPointer = false;
			xspd = 0;
			yspd = 0;
		}

		xpos -= xspd;
		ypos -= yspd;
		xdraw = xpos;
		ydraw = ypos;

	}

	public void render(double interpolation) {
		interpolation /= 1000;
		xdraw -= xspd * interpolation;
		ydraw -= yspd * interpolation;
		if (drawWPointer) {
			SpriteCollection.WPointer[pointerindex].render(Tx - xpos
					+ windowWidth / 2 - 32, Ty - ypos + windowHeight / 2 - 40);
		}
		SpriteCollection.player.render((windowWidth / 2) - 32,
				(windowHeight / 2) - 87);
	}

	public void setTx(int Tx) {
		this.Tx = Tx;
	}

	public void setTy(int Ty) {
		this.Ty = Ty;
	}

	public int getrange(double ypos, double ypos2) {
		int r = (int) Math.sqrt(Math.pow(xpos - ypos, 2)
				+ Math.pow(ypos - ypos2, 2));
		return r;
	}

}
