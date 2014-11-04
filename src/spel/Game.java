package spel;

import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import org.lwjgl.input.Keyboard;

import spel.entities.gui.Gui;
import spel.entities.gui.cursor.Cursor;
import spel.main.Main;
import spel.utils.Keys;
import spel.utils.Settings;
import spel.utils.Text;

public class Game extends Main {

	public Keys keys;
	public Cursor cursor;
	public Text text;
	public boolean paused;
	public State gameState;
	public State oldState;
	public Settings settings;
	public SaveGame saveGame;
	public Gui gui;
	public double ty=0;
	public double tx=0;
	public boolean buttonClicked;

	public enum State {
		MENU, PLAYING, STARTING;
	}

	public void preGLInit() {
		settings = new Settings();
		setRes(settings);
	}

	public void init() {
		UPDATES_PER_SECOND = 10;
		gameState = State.MENU;
		keys = new Keys();
		text = new Text(14);
		gui = new Gui(this);
	}

	public void loadAssets() {
		cursor = new Cursor("res/cursor.png", this);
	}

	public void handleInputs(double dt) {
		if (keys.keyPressed(Keyboard.KEY_ESCAPE)) {
			gui.inSettings = false;
			if (gameState != State.MENU)
				paused = !paused;
		}
		cursor.update();
		keys.setKeys();
	}

	public void quit() {
		saveGame.save();
		settings.save();
	}

	public void update(double dt) {
		handleInputs(dt);
		if (gameState == State.STARTING) {
			gameState = State.PLAYING;
			oldState = State.MENU;
		}
		if (gameState == State.PLAYING) {
			saveGame.update(dt, this);
		}
		gui.update(dt);
		buttonClicked = false;
	}

	public int render(double interpolation) {
		super.render(interpolation);

		if (gameState == State.PLAYING) {
			double interp = interpolation;
			if (gameState != State.PLAYING)
				interp = 0;
			saveGame.render(interp);
		}
		gui.render(interpolation);

		cursor.render(interpolation);
		return 0;
	}

	public static void main(String[] args) {
		new Game().start();
	}
	public int getTx(){
		return (int) tx;
	}
	public int getTy(){
		return (int) ty;
	}
	
}
