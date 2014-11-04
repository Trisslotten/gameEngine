package spel.entities.structures;

public class bigshelter extends Structure {
int protection=90;
	public bigshelter(double xpos, double ypos, double height, double width,
			boolean permanent, boolean gridlocked) {
		super(xpos, ypos, height, width, permanent, gridlocked);

	}
	public void update() {
		if (!permanent) {
			if (tick >= 720) {
				durability--;
				tick = 0;
			} else {
				tick++;
			}
		}
	}
}
