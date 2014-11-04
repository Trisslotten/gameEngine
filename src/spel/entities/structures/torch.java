package spel.entities.structures;

public class torch extends Structure {

	public torch(double xpos, double ypos, double height, double width,
			boolean permanent, boolean gridlocked) {
		super(xpos, ypos, height, width, permanent, gridlocked);

	}

	public void update(double dt) {
		super.update(dt);
	}
}
