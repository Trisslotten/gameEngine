package spel.entities.structures.vegetation;

import spel.entities.structures.Structure;

public class tree extends Structure {

	public tree(double xpos, double ypos, double height, double width,
			boolean permanent, boolean gridlocked) {
		super(xpos, ypos, height, width, permanent, gridlocked);
	}
	public void cut(){
		durability-=50;
	}
}
