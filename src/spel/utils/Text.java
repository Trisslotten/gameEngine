package spel.utils;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;

public class Text {
	
	TrueTypeFont font;
	
	public Text(int fontSize) {
		// load a default java font
		Font awtFont = new Font("Arial", Font.BOLD, fontSize);
		font = new TrueTypeFont(awtFont, false);
	}
	
	public void render(int x, int y, String text, int width,int height) {
		int fontWidth = font.getWidth(text);
		font.drawString(x+(width/2-fontWidth/2), y, text, Color.white);
	}
	public void render(int x, int y, String text, Color color) {
		font.drawString(x, y, text, color);
	}
}
