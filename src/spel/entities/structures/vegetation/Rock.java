package spel.entities.structures.vegetation;

import java.util.Random;

import org.lwjgl.input.Mouse;

import spel.Game;
import spel.entities.gui.SpriteCollection;
import spel.entities.items.resources.Stone;
import spel.entities.structures.Structure;

public class Rock extends Structure {

	/**
	 * 
	 */
	private static final long serialVersionUID = 528861663061955237L;
	
	public Rock(double xpos, double ypos, double height, double width, boolean permanent, boolean gridlocked) {
		super(xpos, ypos, height, width, permanent, gridlocked);
	}
	public void cut() {
		durability -= 50;
	}
	
	public Stone harvest(){
		Random rand = new Random();
		return new Stone(rand.nextInt(3)+2);
	}

	public Rock(double xpos, double ypos, boolean permanent, boolean gridlocked) {
		super(xpos, ypos, permanent, gridlocked);
		// TODO Auto-generated constructor stub
	}
	
	public void update(double dt, Game game) {
		if(game.saveGame.player.axeSelected&&Mouse.isButtonDown(0)&&hover(game)){
			
		}
	}
	
	public void render(int xoffset, int yoffset, Game game) {
		xdraw = xpos - xoffset;
		ydraw = ypos - yoffset;
		SpriteCollection.rock.render(xdraw, ydraw);
	}
}
