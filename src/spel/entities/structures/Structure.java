package spel.entities.structures;

import spel.entities.Entity;

public class Structure extends Entity {
	boolean permanent;
	boolean gridlocked;
	int durability = 100;
	int tick = 0;
	int structurelevel = 0;

	public Structure(double xpos, double ypos, double height, double width,
			boolean permanent, boolean gridlocked) {
		super(xpos, ypos, height, width);
		this.permanent = permanent;
		this.gridlocked = gridlocked;
	}

	public void update() {
		if (!permanent) {
			if (tick >= 360) {
				durability--;
				tick = 0;
			} else {
				tick++;
			}
		}
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
}
