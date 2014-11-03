package spel.entities;

public class Structure extends Entity {
	boolean permanent;
	int durability = 100;
	int tick = 0;

	public Structure(double xpos, double ypos, double height, double width,
			boolean permanent) {
		super(xpos, ypos, height, width);
		this.permanent = permanent;
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

	public boolean ded() {
		return durability <= 0;
	}
}
