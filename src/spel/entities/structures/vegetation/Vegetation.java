package spel.entities.structures.vegetation;

import spel.entities.items.resources.Stone;
import spel.entities.structures.Structure;
import spel.entities.items.resources.*;

public class Vegetation extends Structure {

	/**
	 * 
	 */
	public double collx, colly, radius;
	
	private static final long serialVersionUID = -5300095114937007414L;
	public Vegetation(double xpos, double ypos, double height, double width, boolean permanent, boolean gridlocked) {
		super(xpos, ypos, height, width, permanent, gridlocked);
		// TODO Auto-generated constructor stub
		collx = xpos+width/2;
		colly = ypos+height;
		radius = 10;
	}

	public Vegetation(double xpos, double ypos, boolean permanent, boolean gridlocked) {
		super(xpos, ypos, permanent, gridlocked);
		// TODO Auto-generated constructor stub
	}
	public Resource harvest(){
		return new Resource(0);
	}

}
