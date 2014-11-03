package spel.entities;

public class Structure extends Entity {

	public Structure(double xpos, double ypos, String[] frames) {
		super(xpos, ypos, frames);
		
	}

	public Structure(double xpos, double ypos, double height, double width,
			String filepath) {
		super(xpos, ypos, height, width, filepath);
		
	}

	public Structure(double xpos, double ypos, String filepath) {
		super(xpos, ypos, filepath);
		
	}

}
