package spel;

import java.util.Vector;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

import spel.entities.Entity;
import spel.entities.Level;
import spel.entities.gui.Cursor;
import spel.entities.gui.button.Button;
import spel.entities.gui.button.ExitButton;
import spel.main.Main;

public class Game extends Main {
	
	public Vector<Entity> entities, gui, pauseMenu, mainMenu;
	public Keys keys;
	public Input input;
	public Cursor cursor;
	public Text t;
	public State gameState;
	public State oldState;
	
	public void init() {
		
		UPDATES_PER_SECOND = 60;
		gameState = State.menu;
		input = new Input(0);
		keys = new Keys();
		cursor = new Cursor("res/cursor.png", this);
		t = new Text();
		
		entities = new Vector<Entity>();
		gui = new Vector<Entity>();
		pauseMenu = new Vector<Entity>();
		mainMenu = new Vector<Entity>();
		
		entities.add(new Entity(width / 2 - 32, height / 2 - 32, "res/sak.png"));
		
		pauseMenu.add(new Entity(0, 0, "res/cover.png"));
		pauseMenu.add(new Entity(590, 300, "res/cont.png"));
		pauseMenu.add(new ExitButton(590, 400, "res/quit.png", this));
		
		mainMenu.add(new Entity(0, 0, "res/bg.png"));
		mainMenu.add(new Button(590, 300, "res/main.png", this, ""));
		
		level = new Level(this);
		
		try {
			asd = new Sound("res/stepgrass.wav");
		} catch (SlickException e) {
			e.printStackTrace();
		}
		System.out.println(level.getCount() + " Tiles generated");
	}
	
	public void handleInputs(double dt) {
		if (keys.keyPressed(Keyboard.KEY_ESCAPE) && gameState != State.menu) {
			if (gameState == State.paused) gameState = oldState;
			else {
				oldState = gameState;
				gameState = State.paused;
			}
		}
		if (keys.keyDown(Keyboard.KEY_A)) {
			x -= 144 * dt / 1000;
		}
		if (keys.keyDown(Keyboard.KEY_D)) {
			x += 144 * dt / 1000;
		}
		if (keys.keyDown(Keyboard.KEY_W)) {
			y -= 144 * dt / 1000;
		}
		if (keys.keyDown(Keyboard.KEY_S)) {
			y += 144 * dt / 1000;
		}
		
		if ((oldx != x || oldy != y) && !asd.playing()) asd.play();
		
		oldx = x;
		oldy = y;
		cursor.update();
		keys.setKeys();
	}
	
	Sound asd;
	
	double x, y, oldx, oldy;
	Level level;
	int objects;
	
	public void update(double dt) {
		handleInputs(dt);
		System.out.flush();
		switch (gameState) {
		case menu:
			for (Entity e : mainMenu) {
				e.update(dt);
			}
			break;
		case running:
			for (Entity e : entities) {
				e.update(dt);
			}
			for (Entity e : gui) {
				e.update(dt);
			}
			break;
		case paused:
			for (Entity e : pauseMenu) {
				e.update(dt);
			}
			break;
		}
	}
	
	public int render(double interpolation) {
		super.render(interpolation);
		
		switch (gameState) {
		case menu:
			for (Entity e : mainMenu) {
				e.render(interpolation);
			}
			break;
		case running:
		case paused:
			objects = level.render((int) x, (int) y);
			double interp = interpolation;
			for (Entity e : entities) {
				if (gameState != State.running) interp = 0;
				e.render(interp);
			}
			for (Entity e : gui) {
				e.render(interpolation);
			}
			if (gameState != State.running) {
				for (Entity e : pauseMenu) {
					e.render(interpolation);
				}
			}
			
		}
		
		cursor.render(interpolation);
		return 0;
	}
	
	public enum State {
		paused, menu, running;
	}
	
	public static void main(String[] args) {
		new Game().start();
	}
	
}
