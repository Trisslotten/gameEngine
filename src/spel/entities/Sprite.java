package spel.entities;

import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Sprite {
	
	public Texture texture;
	public double x, y, width, height;
	
	public Sprite(String path) {
		try {
			texture = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream(path));
		} catch (IOException e) {}
		this.width = texture.getImageWidth();
		this.height = texture.getImageHeight();
		texCoords();
	}
	public void render(double xpos, double ypos) {
		Color.white.bind();
		texture.bind(); // or GL11.glBind(texture.getTextureID());
		GL11.glBegin(GL11.GL_QUADS);
		{
			GL11.glTexCoord2d(0, 0);
			GL11.glVertex2d(xpos, ypos);
			
			GL11.glTexCoord2d(x, 0);
			GL11.glVertex2d(xpos + width, ypos);
			
			GL11.glTexCoord2d(x, y);
			GL11.glVertex2d(xpos + width, ypos + height);
			
			GL11.glTexCoord2d(0, y);
			GL11.glVertex2d(xpos, ypos + height);
		}
		GL11.glEnd();
	}
	
	public void render(double xpos, double ypos,double width, double height) {
		Color.white.bind();
		texture.bind(); // or GL11.glBind(texture.getTextureID());
		GL11.glBegin(GL11.GL_QUADS);
		{
			GL11.glTexCoord2d(0, 0);
			GL11.glVertex2d(xpos, ypos);
			
			GL11.glTexCoord2d(x, 0);
			GL11.glVertex2d(xpos + width, ypos);
			
			GL11.glTexCoord2d(x, y);
			GL11.glVertex2d(xpos + width, ypos + height);
			
			GL11.glTexCoord2d(0, y);
			GL11.glVertex2d(xpos, ypos + height);
		}
		GL11.glEnd();
	}
	
	public void texCoords() {
		for (int i = 0; i <= width; i++) {
			double a = Math.pow(2, i + 1);
			if (a >= width) {
				x = width / a;
				break;
			}
			
		}
		for (int i = 0; i * i <= height; i++) {
			double a = Math.pow(2, i + 1);
			if (a >= height) {
				y = height / a;
				break;
			}
		}
	}
	
}
