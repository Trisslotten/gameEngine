package spel.entities.structures.Buildings;

import spel.entities.structures.Structure;

public class Shelter extends Structure {
	int protection=70;
	public Shelter(double xpos, double ypos, double height, double width,
			boolean permanent, boolean gridlocked) {
		super(xpos, ypos, height, width, permanent, gridlocked);

	}
	public void update() {
		if (!permanent) {
			if (tick >= 540) {
				durability--;
				tick = 0;
			} else {
				tick++;
			}
		}
	}
}
