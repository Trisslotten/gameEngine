package spel.entities.structures.Buildings;

import spel.Game;
import spel.entities.structures.Structure;

public class torch extends Structure {

	public torch(double xpos, double ypos, double height, double width,
			boolean permanent, boolean gridlocked, Game game) {
		super(xpos, ypos, height, width, permanent, gridlocked, game);

	}

	public void update(double dt) {// should have a two-frame animation to make
									// it look like it is burning, hense the
									// updater
		super.update(dt);
	}
}
