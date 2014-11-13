package spel.entities.structures.Buildings;

import org.newdawn.slick.Color;

import spel.Game;
import spel.entities.gui.SpriteCollection;
import spel.entities.structures.Structure;

public class Fireplace extends Structure {
	int protection = 50;

	public Fireplace(double xpos, double ypos, double height, double width, boolean permanent, boolean gridlocked, Game game) {
		super(xpos, ypos, height, width, permanent, gridlocked, game);
		this.woodCost = 8;
		this.stoneCost = 5;
		this.xpos-= SpriteCollection.fireOff.width/2;
		this.ypos-= SpriteCollection.fireOff.height/2;
	}

	public void update(double dt) {
		if (!permanent) {
			if (tick >= 270) {
				durability--;
				tick = 0;
			} else {
				tick++;
			}
		}
		
	}
	public boolean ded() {
		return false;
	}

	public void render(int xoffset, int yoffset, Game game) {
		xdraw = xpos - xoffset + game.getWidth()/2;
		ydraw = ypos - yoffset + game.getHeight()/2;
		if(durability<0) {
			SpriteCollection.fireOff.render(xdraw,ydraw);
		} else {
			SpriteCollection.fireOn.render(xdraw,ydraw);
		}
	}

}
