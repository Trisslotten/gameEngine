package spel.entities.items.tools;

import spel.Game;
import spel.entities.gui.SpriteCollection;
import spel.entities.structures.vegetation.Vegetation;

public class ThrowingTool {

	public double x, y, z, xspd, yspd, zspd;
	public double time, spriteTimer;
	public int spriteIndex;
	public double xstart, ystart, xtarget, ytarget, xcenter, ycenter;
	public double velocity = 500, gravity = 120;
	public boolean hit = false;
	public Vegetation plant;
	public boolean isAxe;

	public ThrowingTool(double xstart, double ystart, double xtarget, double ytarget, Vegetation plant, boolean isAxe) {
		ystart -= 40;
		double dx = xstart - xtarget;
		double dy = ystart - ytarget;
		double d = Math.sqrt(dx * dx + dy * dy);
		double azimuth = Math.atan2(dy, dx);
		double elevation = Math.asin(gravity * d / (velocity * velocity)) / 2;
		xspd = velocity * Math.cos(elevation) * Math.cos(azimuth);
		yspd = velocity * Math.cos(elevation) * Math.sin(azimuth);
		zspd = velocity * Math.sin(elevation);
		this.isAxe = isAxe;

		time = 0;
		x = xstart;
		y = ystart;
		z = 1;
		this.xstart = xstart;
		this.ystart = ystart;
		this.xtarget = xtarget;
		this.ytarget = ytarget;
		this.plant = plant;
		spriteTimer = time;
		spriteIndex = 0;

	}

	public void update(double dt) {
		time += dt / 1000;
		if(time>spriteTimer+0.1){
			spriteTimer+=0.1;
			spriteIndex++;
			if(spriteIndex>3){
				spriteIndex = 0;
			}
		}
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
			spriteTimer = time;
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
		if(isAxe){
			SpriteCollection.shadow.render(x - xoffset, y - yoffset);
			SpriteCollection.axe[spriteIndex].render(x - xoffset, y - z * 10 - yoffset);
		} else {
			SpriteCollection.shadow.render(x - xoffset, y - yoffset);
			SpriteCollection.pickaxe[spriteIndex].render(x - xoffset, y - z * 10 - yoffset);
		}
		
	}

	public double[] rotateVector(double x, double y, double rads) {
		double[] vector = new double[2];
		vector[0] = x * Math.cos(rads) - y * Math.sin(rads);
		vector[1] = x * Math.sin(rads) + y * Math.cos(rads);
		return vector;
	}

}
