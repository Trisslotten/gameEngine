package spel.entities.structures;

import spel.Game;
import spel.entities.Entity;

public class Structure extends Entity {
	protected boolean permanent;
	boolean gridlocked;
	protected int durability = 100;
	protected int tick = 0;
	int structurelevel = 0;

	public Structure(double xpos, double ypos, double height, double width,
			boolean permanent, boolean gridlocked) {
		super(xpos, ypos, height, width);
		this.permanent = permanent;
		this.gridlocked = gridlocked;
	}
	
	public Structure(double xpos, double ypos, boolean permanent, boolean gridlocked) {
		super(xpos,ypos);
		this.permanent = permanent;
		this.gridlocked = gridlocked;
	}

	public void build(){
		structurelevel++;
	}

	public boolean ded() {
		return durability <= 0;
	}

	public boolean gridlocked() {
		return gridlocked;
	}
	
	
	public void update(double dt, Game game) {
		xpos += xspd*dt/1000;
		ypos += yspd*dt/1000;
		xdraw = xpos;
		ydraw = ypos;
	}
	
	public void render(double ip, Game game) {
		xdraw += xspd * ip/1000;
		ydraw += yspd * ip/1000;
	}
}
