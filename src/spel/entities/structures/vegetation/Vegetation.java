package spel.entities.structures.vegetation;

import spel.entities.items.resources.Resource;
import spel.entities.items.tools.ThrowingTool;
import spel.entities.structures.Structure;

public class Vegetation extends Structure {

	/**
	 * 
	 */
	public double collx, colly, radius;

	public ThrowingTool throwingTool;

	private static final long serialVersionUID = -5300095114937007414L;

	public Vegetation(double xpos, double ypos, double height, double width, boolean permanent, boolean gridlocked, spel.Game game) {
		super(xpos, ypos, height, width, permanent, gridlocked, game);
		// TODO Auto-generated constructor stub
		collx = xpos + width / 2;
		colly = ypos + height;
		radius = 10;
	}

	public Vegetation(double xpos, double ypos, boolean permanent, boolean gridlocked) {
		super(xpos, ypos, permanent, gridlocked);
		// TODO Auto-generated constructor stub
	}

	public Resource harvest() {
		return new Resource(0);
	}

}
