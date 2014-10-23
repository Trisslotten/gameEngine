package spel;

import java.util.Vector;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Input;

import spel.entities.Entity;
import spel.entities.gui.Cursor;
import spel.main.Main;

public class Game extends Main {
	
	public Vector<Entity> entities, gui, pauseMenu;
	public Keys keys;
	public Input input;
	private boolean paused;
	Text t;
	
	public void init() {
		UPDATES_PER_SECOND = 60;
		input = new Input(0);
		keys = new Keys();
		
		t = new Text();
		
		entities = new Vector<Entity>();
		gui = new Vector<Entity>();
		pauseMenu = new Vector<Entity>();
		
		gui.add(new Cursor("res/cursor.png"));
		gui.add(new Entity(50, 50, "res/fontsheet.png"));
	}
	
	public void update(double dt) {
		
		if (keys.keyPressed(Keyboard.KEY_ESCAPE)) {
			paused = !paused;
		}
		
		keys.setKeys();
		
		for (Entity e : gui) {
			e.update(dt);
		}
		if (paused) {
			for (Entity e : pauseMenu) {
				e.update(dt);
			}
		} else {
			for (Entity e : entities) {
				e.update(dt);
			}
		}
	}
	
	public int render(double interpolation) {
		
		super.render(interpolation);
		for (Entity e : entities) {
			e.render(interpolation);
		}
		if (paused) {
			for (Entity e : pauseMenu) {
				e.render(interpolation);
			}
		}
		
		for (Entity e : gui) {
			e.render(interpolation);
		}
		
		t.render(100, 100, "Tjena test 123");
		return 0;
	}
	
	public static void main(String[] args) {
		new Game().start();
	}
	
}
