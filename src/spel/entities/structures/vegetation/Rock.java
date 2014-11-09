package spel.entities.structures.vegetation;

import java.util.Random;

import org.lwjgl.input.Mouse;

import spel.Game;
import spel.entities.gui.SpriteCollection;
import spel.entities.items.resources.Stone;

public class Rock extends Vegetation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 528861663061955237L;
	
	public Rock(double xpos, double ypos, double height, double width, boolean permanent, boolean gridlocked) {
		super(xpos, ypos, height, width, permanent, gridlocked);
		collx = xpos+26;
		colly = ypos+22;
		xpos -=  26;
		ypos -= 22;
		radius = 26;
	}
	
	public Stone harvest(){
		Random rand = new Random();
		durability -= 50;
		return new Stone(rand.nextInt(3)+2);
	}
	
	public void update(double dt, Game game) {
		boolean hover = hover(game, SpriteCollection.rock.width,SpriteCollection.rock.height);
		if(game.saveGame.player.axeSelected&&game.cursor.buttonClicked(0)&&hover&&!game.saveGame.player.treeClicked) {
			game.saveGame.player.treeClicked();
			game.saveGame.player.inventory.addResource(harvest());
		}
	}
	
	public void render(int xoffset, int yoffset, Game game) {
		xdraw = xpos - xoffset;
		ydraw = ypos - yoffset;
		SpriteCollection.rock.render(xdraw, ydraw);
	}
}
