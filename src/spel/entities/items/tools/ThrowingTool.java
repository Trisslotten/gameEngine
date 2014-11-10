package spel.entities.items.tools;

import org.newdawn.slick.Color;

import spel.Game;
import spel.entities.gui.SpriteCollection;

public class ThrowingTool {

	public double x, y, z, xspd, yspd, zspd;
	public double time;
	public double xstart, ystart, xtarget, ytarget, xcenter, ycenter;
	public double velocity = 500, gravity = 120;
	public boolean hit = false;

	public ThrowingTool(double xstart, double ystart, double xtarget, double ytarget) {
		ystart -= 40;
		double dx = xstart - xtarget;
		double dy = ystart - ytarget;
		/* double diameter = Math.sqrt(dx * dx + dy * dy); double distance =
		 * Math.PI * diameter; double heightAngle = Math.asin(distance * gravity
		 * / (velocity * velocity)) / 2; double normalAngle = Math.atan(dx /
		 * dy)+ Math.PI/2; x = xstart; y = ystart; z = 1; xspd =
		 * Math.cos(normalAngle) * velocity; yspd = Math.sin(normalAngle) *
		 * velocity; double time = distance / velocity; zspd =
		 * Math.sin(Math.sqrt(distance * gravity) / Math.sin(2 * heightAngle));
		 * xcenter = xstart + dx/2; ycenter = ystart + dy/2; */
		double d = Math.sqrt(dx * dx + dy * dy);
		double azimuth = Math.atan2(dy, dx);
		double elevation = Math.asin(gravity * d / (velocity * velocity)) / 2;
		xspd = velocity * Math.cos(elevation) * Math.cos(azimuth);
		yspd = velocity * Math.cos(elevation) * Math.sin(azimuth);
		zspd = velocity * Math.sin(elevation);

		time = 0;
		x = xstart;
		y = ystart;
		z = 1;
		this.xstart = xstart;
		this.ystart = ystart;
		this.xtarget = xtarget;
		this.ytarget = ytarget;

	}

	public void update(double dt) {
		time += dt / 1000;
		x = xstart - xspd * time;
		y = ystart - yspd * time;
		z = zspd * time - 0.5 * gravity * time * time;
		if (z < 0 && !hit) {
			hit = true;
			double dx = xstart - xtarget;
			double dy = ystart - ytarget;
			double d = Math.sqrt(dx * dx + dy * dy);
			double azimuth = Math.atan2(dy, dx);
			double elevation = Math.asin(gravity * d / (velocity * velocity)) / 2;
			xspd = -velocity * Math.cos(elevation) * Math.cos(azimuth);
			yspd = -velocity * Math.cos(elevation) * Math.sin(azimuth);
			zspd = velocity * Math.sin(elevation);

			time = 0;
			x = xtarget;
			y = ytarget;
			xstart = xtarget;
			ystart = ytarget;
			z = 1;
		}

	}

	public boolean ded() {
		return z < 0 && hit;
	}

	public void render(double interpolation, int xoffset, int yoffset, Game game) {
		SpriteCollection.coconut.render(x - xoffset, y - yoffset);
		SpriteCollection.coconut.render(x - xoffset, y - z * 10 - yoffset);
		game.text.render(500, 500, xspd + " " + yspd + " " + (zspd + 0.5 * gravity * time), Color.black);
	}

	public double[] rotateVector(double x, double y, double rads) {
		double[] vector = new double[2];
		vector[0] = x * Math.cos(rads) - y * Math.sin(rads);
		vector[1] = x * Math.sin(rads) + y * Math.cos(rads);
		return vector;
	}

}
