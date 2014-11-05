package spel.entities.structures;

public class torch extends Structure {

	public torch(double xpos, double ypos, double height, double width,
			boolean permanent, boolean gridlocked) {
		super(xpos, ypos, height, width, permanent, gridlocked);

	}

	public void update(double dt) {// should have a two-frame animation to make
									// it look like it is burning, hense the
									// updater
		super.update(dt);
	}
}
