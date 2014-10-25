package spel;

import java.util.Vector;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Input;

import spel.entities.Entity;
import spel.entities.gui.Cursor;
import spel.entities.gui.button.Button;
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
		UPDATES_PER_SECOND = 10;
		gameState = State.menu;
		input = new Input(0);
		keys = new Keys();
		cursor = new Cursor("res/cursor.png", this);
		t = new Text();
		entities = new Vector<Entity>();
		gui = new Vector<Entity>();
		pauseMenu = new Vector<Entity>();
		mainMenu = new Vector<Entity>();
		
		entities.add(new Entity(0,0,"res/bg2.png"));
		entities.add(new Entity(100,100,"res/sak.png"));
		entities.elementAt(1).setXspd(144);
		
		pauseMenu.add(new Entity(0,0,"res/cover.png"));
		pauseMenu.add(new Entity(100,200,"res/pause.png"));
		
		mainMenu.add(new Entity(0,0,"res/bg.png"));
		mainMenu.add(new Button(590,300,"res/main.png", cursor,"",this));

	}
	
	double x, y;
	
	public void handleInputs() {
		if (keys.keyPressed(Keyboard.KEY_ESCAPE)) {
			if(gameState == State.paused)
				gameState = oldState;
			else {
				oldState = gameState;
				gameState = State.paused;
			}
		}
		cursor.update(0);
		keys.setKeys();
	}
	
	public void update(double dt) {
		handleInputs();
		
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
			for (Entity e : entities) {
				e.render(interpolation);
			}
			for (Entity e : gui) {
				e.render(interpolation);
			}
			break;
		case paused:
			for (Entity e : pauseMenu) {
				e.render(interpolation);
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
