package spel.entities.items.tools;

public class ThrowingTool {

	public double x, y, z, xspd, yspd, zspd;
	public double xstart, ystart, xtarget, ytarget, xcenter, ycenter;
	public double velocity = 20, gravity = 5;

	public ThrowingTool(double xstart, double ystart, double xtarget, double ytarget) {
		double dx = xstart - xtarget;
		double dy = ystart - ytarget;
		double diameter = Math.sqrt(dx * dx + dy * dy);
		double distance = Math.PI * diameter;
		double heightAngle = Math.asin(distance * gravity / (velocity * velocity)) / 2;
		double normalAngle = Math.atan(dx / dy) + Math.PI / 2;
		x = xstart;
		y = ystart;
		z = 0;
		xspd = Math.cos(normalAngle) * velocity;
		yspd = Math.sin(normalAngle) * velocity;
		double time = distance / velocity;
		zspd = Math.sin(Math.sqrt(distance * gravity) / Math.sin(2 * heightAngle));
		xcenter = xstart + dx/2;
		ycenter = ystart + dy/2;
		
	}

	public void update(double dt) {
		zspd -= gravity*dt/1000;
		double dx = x-xcenter;
		double dy = y-ycenter;
		double angle = Math.atan(dx/dy);
		xspd += Math.cos(angle)*velocity;
		yspd += Math.sin(angle)*velocity;
		
		z += zspd*dt/1000;
		x += xspd*dt/1000;
		y += yspd*dt/1000;
		
		
	}

	public void render(double interpolation, int xoffset, int yoffset) {

	}

	public double[] rotateVector(double x, double y, double rads) {
		double[] vector = new double[2];
		vector[0] = x * Math.cos(rads) - y * Math.sin(rads);
		vector[1] = x * Math.sin(rads) + y * Math.cos(rads);
		return vector;
	}

}
