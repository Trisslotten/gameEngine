package spel;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;

public class Text {
	
	TrueTypeFont font;
	
	public Text() {
		// load a default java font
		Font awtFont = new Font("Times New Roman", Font.BOLD, 24);
		font = new TrueTypeFont(awtFont, false);
	}
	
	public void render(int x, int y, String text) {
		font.drawString(x, y, text, Color.white);
	}
}
