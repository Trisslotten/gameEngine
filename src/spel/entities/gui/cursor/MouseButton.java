package spel.entities.gui.cursor;

import org.lwjgl.input.Mouse;

public class MouseButton {
	
	public MouseButton() {
		
	}
	
	public boolean isDown(int i) {
		return Mouse.isButtonDown(i);
	}
	
	
}
