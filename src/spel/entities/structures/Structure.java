package spel.entities.structures;

import spel.Game;
import spel.entities.Entity;

public class Structure extends Entity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1493982543336491578L;
	protected boolean permanent;
	boolean gridlocked;
	protected int durability = 100;
	protected int tick = 0;
	int structurelevel = 0;
	public int woodCost;
	public int stoneCost;
	public int nailCost;
	public int ironCost;
	public int radius = 20;
	public int collx, colly;
	

	public Structure(double xpos, double ypos, double height, double width, boolean permanent, boolean gridlocked, Game game) {
		super(xpos, ypos, height, width);
		this.permanent = permanent;
		this.gridlocked = gridlocked;
		/*
		if(gridlocked){
			int x = (int) (xpos/game.saveGame.level.tilePixelLength);
			xpos = x*game.saveGame.level.tilePixelLength;
			int y = (int) (ypos/game.saveGame.level.tilePixelLength);
			ypos = y*game.saveGame.level.tilePixelLength;
		}
		*/
		woodCost = 1;
		stoneCost = 1;
		nailCost = 0;
		ironCost = 0;
		collx = (int) xpos;
		colly = (int) ypos;
	}
	
	public boolean payCost(Game game) {
		return game.saveGame.player.inventory.payCost(woodCost, stoneCost, nailCost,ironCost);
	}

	public Structure(double xpos, double ypos, boolean permanent, boolean gridlocked) {
		super(xpos, ypos);
		this.permanent = permanent;
		this.gridlocked = gridlocked;
	}

	public void build() {
		structurelevel++;
	}

	public boolean ded() {
		return durability <= 0;
	}

	public boolean gridlocked() {
		return gridlocked;
	}

	public boolean hover(Game game, double width, double height) {
		double x = game.cursor.getXpos();//-game.getWidth()/2-width;
		double y = game.cursor.getYpos();//-game.getHeight()/2-height;
		return x>xdraw&&y>ydraw&&x<xdraw+width&&y<ydraw+height;
	}

	public void update(double dt, Game game) {

	}

	public void setToDraw(int xoffset, int yoffset) {
		xdraw = xpos - xoffset;
		ydraw = ypos - yoffset;
	}

	public void render(int xoffset, int yoffset, Game game) {
		xdraw = xpos - xoffset;
		ydraw = ypos - xoffset;
	}
}
