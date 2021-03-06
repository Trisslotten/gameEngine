package spel.entities;

import java.io.Serializable;

import spel.Game;

public class Entity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3683846272279120860L;
	public double xpos, ypos, xdraw, ydraw, xspd, yspd, width, height;
	
	public Entity(double xpos, double ypos) {
		this.xpos = xpos;
		this.ypos = ypos;
		xdraw = xpos;
		ydraw = ypos;
	}
	
	public Entity(double xpos, double ypos, double height, double width) {
		this.height = height;
		this.width = width;
		this.xpos = xpos;
		this.ypos = ypos;
		xdraw = xpos;
		ydraw = ypos;
	}
	
	public void update(double dt) {
		xpos += xspd*dt/1000;
		ypos += yspd*dt/1000;
		xdraw = xpos;
		ydraw = ypos;
	}
	public void update(double dt, Game game) {
		xpos += xspd*dt/1000;
		ypos += yspd*dt/1000;
		xdraw = xpos;
		ydraw = ypos;
	}
	public void render(int xoffset,int yoffset, Game game) {
		xdraw = xpos-xoffset;
		ydraw = ypos-yoffset;
	}
	
	
	public double getXdraw() {
		return xdraw;
	}
	public double getYdraw() {
		return ydraw;
	}
	
	public double getXpos() {
		return xpos;
	}

	public void setXpos(double xpos) {
		this.xpos = xpos;
	}

	public double getYpos() {
		return ypos;
	}

	public void setYpos(double ypos) {
		this.ypos = ypos;
	}

	public double getXspd() {
		return xspd;
	}

	public void setXspd(double xspd) {
		this.xspd = xspd;
	}

	public double getYspd() {
		return yspd;
	}

	public void setYspd(double yspd) {
		this.yspd = yspd;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	
}
