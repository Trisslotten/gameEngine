package spel.entities.items.tools;


import org.newdawn.slick.Color;

import spel.Game;
import spel.entities.gui.SpriteCollection;

public class ThrowingTool {

	public double x, y, z, xspd, yspd, zspd;
	public double time;
	public double xstart, ystart, xtarget, ytarget, xcenter, ycenter;
	public double velocity = 500, gravity = 10;

	public ThrowingTool(double xstart, double ystart, double xtarget, double ytarget) {
		double dx = xstart - xtarget;
		double dy = ystart - ytarget;
		/*
		 * double diameter = Math.sqrt(dx * dx + dy * dy); double distance =
		 * Math.PI * diameter; double heightAngle = Math.asin(distance * gravity
		 * / (velocity * velocity)) / 2; double normalAngle = Math.atan(dx /
		 * dy)+ Math.PI/2; x = xstart; y = ystart; z = 1; xspd =
		 * Math.cos(normalAngle) * velocity; yspd = Math.sin(normalAngle) *
		 * velocity; double time = distance / velocity; zspd =
		 * Math.sin(Math.sqrt(distance * gravity) / Math.sin(2 * heightAngle));
		 * xcenter = xstart + dx/2; ycenter = ystart + dy/2;
		 */
		double d = Math.sqrt(dx * dx + dy * dy);
		double azimuth = Math.atan(dy/dx);
		double elevation = Math.asin(gravity*d/(velocity*velocity))/2;
		xspd = velocity * Math.cos(elevation) * Math.sin(azimuth);
		yspd = velocity * Math.cos(elevation) * Math.cos(azimuth);
		zspd = velocity * Math.sin(elevation);
		
		System.out.println(azimuth);
		System.out.println(elevation);
		System.out.println(xspd);
		System.out.println(yspd);
		System.out.println(zspd);
		
		time = 0;
		x = xstart;
		y = ystart;
		z = 1;
		this.xstart = xstart;
		this.ystart = ystart;
		
		
		

	}

	public void update(double dt) {
		time += dt/1000;
		x = xstart + xspd * time;
		y = ystart + yspd * time;
		z = zspd * time - 0.5*gravity*time*time;
	}

	public boolean ded() {
		if (z == Double.NaN)
			return true;
		return z < 0;
	}

	public void render(double interpolation, int xoffset, int yoffset, Game game) {
		SpriteCollection.coconut.render(x - xoffset, y - yoffset);
		SpriteCollection.coconut.render(x - xoffset, y - z*10 - yoffset);
		game.text.render(500, 500, x + " "+ y + " "+ z, Color.black);
	}

	public double[] rotateVector(double x, double y, double rads) {
		double[] vector = new double[2];
		vector[0] = x * Math.cos(rads) - y * Math.sin(rads);
		vector[1] = x * Math.sin(rads) + y * Math.cos(rads);
		return vector;
	}

}
