package spel;

import java.util.Vector;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Input;

import spel.entities.Entity;
import spel.entities.gui.Gui;
import spel.entities.gui.cursor.Cursor;
import spel.main.Main;
import spel.utils.Keys;
import spel.utils.Settings;
import spel.utils.Text;

public class Game extends Main {
	
	public Vector<Entity> entities;
	public Keys keys;
	public Input input;
	public Cursor cursor;
	public Text text;
	public boolean paused;
	public State gameState;
	public State oldState;
	public Settings settings;
	public Gui gui;
	public boolean buttonClicked;
	
	public enum State {
		MENU, PLAYING, STARTING;
	}
	
	public void preGLInit() {
		settings = new Settings();
		setRes(settings);
		System.out.println(System.getProperty("user.home"));
		
	}
	
	public void init() {
		UPDATES_PER_SECOND = 144;
		gameState = State.MENU;
		keys = new Keys();
		text = new Text(14);
		gui = new Gui(this);
		
		entities = new Vector<Entity>();
	}
	
	public void loadAssets() {
		cursor = new Cursor("res/cursor.png", this);
	}
	
	public void initNewGame() {
		entities.add(new Entity(width / 2 - 32, height / 2 - 32, "res/sak.png"));
	}
	
	public void handleInputs(double dt) {
		if (keys.keyPressed(Keyboard.KEY_ESCAPE)) {
			gui.inSettings = false;
			if (gameState != State.MENU) paused = !paused;
		}
		cursor.update();
		keys.setKeys();
	}
	
	public void quit() {
		settings.save();
	}
	
	public void update(double dt) {
		handleInputs(dt);
		if (gameState == State.STARTING) {
			initNewGame();
			gameState = State.PLAYING;
			oldState = State.MENU;
		}
		if (gameState == State.PLAYING) {
			for (Entity e : entities) {
				e.update(dt);
			}
		}
		gui.update(dt);
		buttonClicked = false;
	}
	
	public int render(double interpolation) {
		super.render(interpolation);
		
		if (gameState == State.PLAYING) {
			double interp = interpolation;
			if (gameState != State.PLAYING) interp = 0;
			for (Entity e : entities) {
				e.render(interp);
			}
		}
		gui.render(interpolation);
		
		cursor.render(interpolation);
		return 0;
	}
	
	public static void main(String[] args) {
		new Game().start();
	}
	
}
