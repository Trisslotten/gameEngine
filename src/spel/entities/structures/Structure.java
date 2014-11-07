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

	public Structure(double xpos, double ypos, double height, double width, boolean permanent, boolean gridlocked) {
		super(xpos, ypos, height, width);
		this.permanent = permanent;
		this.gridlocked = gridlocked;
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
	public boolean hover(Game game) {
		int x= (int) game.cursor.getXpos();
		int y= (int) game.cursor.getXpos();
		return x>xdraw&&y>ydraw&&x<xdraw+width&&y<ydraw+height;
	}

	public void update(double dt, Game game) {

	}
	public void setToDraw(int xoffset, int yoffset) {
		xdraw = xpos - xoffset;
		ydraw = ypos - yoffset;
	}

	public void render(int xoffset,int yoffset, Game game) {
		xdraw = xpos-xoffset;
		ydraw = ypos-xoffset;
	}
}
