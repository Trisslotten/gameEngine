package spel.entities;

public class Entity {
	
	protected double xpos, ypos, xdraw, ydraw, xspd, yspd, width, height;
	

	protected int frameIndex;
	
	protected Sprite[] frames;
	
	public Entity(double xpos, double ypos, String[] frames) {
		frameIndex = 0;
		this.frames = new Sprite[frames.length];
		for (int i = 0; i < frames.length; i++) {
			this.frames[i] = new Sprite(frames[i]);
		}
		height = this.frames[0].height;
		width = this.frames[0].width;
		this.xpos = xpos;
		this.ypos = ypos;
		xdraw = xpos;
		ydraw = ypos;
	}
	
	public Entity(double xpos, double ypos, double height, double width, String filepath) {
		frameIndex = 0;
		frames = new Sprite[1];
		this.height = height;
		this.width = width;
		frames[0] = new Sprite(filepath);
		frames[0].height = height;
		frames[0].width = width;
		this.xpos = xpos;
		this.ypos = ypos;
		xdraw = xpos;
		ydraw = ypos;
	}
	
	public Entity(double xpos, double ypos, String filepath) {
		frameIndex = 0;
		frames = new Sprite[1];
		frames[frameIndex] = new Sprite(filepath);
		this.xpos = xpos;
		this.ypos = ypos;
		xdraw = xpos;
		ydraw = ypos;
	}
	
	public void update(double dt) {
		xdraw = xpos;
		ydraw = ypos;
	}
	
	public void render(double ip) {
		xdraw += xspd * ip;
		ydraw += yspd * ip;
		frames[frameIndex].render(xdraw, ydraw);
	}
	
	public void setFrame(Sprite frame) {
		frames[0] = frame;
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

	public int getFrameIndex() {
		return frameIndex;
	}

	public void setFrameIndex(int frameIndex) {
		this.frameIndex = frameIndex;
	}
	
}
