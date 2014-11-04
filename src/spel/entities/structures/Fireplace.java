package spel.entities.structures;

public class Fireplace extends Structure {
int protection=50;
	public Fireplace(double xpos, double ypos, double height, double width,
			boolean permanent, boolean gridlocked) {
		super(xpos, ypos, height, width, permanent, gridlocked);

	}
	public void update() {
		if (!permanent) {
			if (tick >= 270) {
				durability--;
				tick = 0;
			} else {
				tick++;
			}
		}
	}

}
