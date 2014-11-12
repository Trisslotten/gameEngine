package spel;

import java.util.Random;

import org.lwjgl.input.Keyboard;

import spel.entities.gui.GameGUI;
import spel.entities.gui.Gui;
import spel.entities.gui.cursor.Cursor;
import spel.main.Main;
import spel.utils.Keys;
import spel.utils.Settings;
import spel.utils.Sound;
import spel.utils.Text;

public class Game extends Main {
	int i;
	public Keys keys;
	public Cursor cursor;
	public Text text;
	public boolean paused;
	public State gameState;
	public State oldState;
	public Settings settings;
	public SaveGame saveGame;
	public Gui gui;
	public GameGUI gameGui;
	public boolean buttonClicked;

	public enum State {
		MENU, PLAYING, STARTING;
	}

	public void preGLInit() {
		settings = new Settings();
		setRes(settings);
	}

	public void init() {
		UPDATES_PER_SECOND = 60;
		gameState = State.MENU;
		keys = new Keys();
		text = new Text(14);
		gui = new Gui(this);
		Random rand = new Random();
		i = rand.nextInt(3);
	}

	public void loadAssets() {
		gameGui = new GameGUI(this);
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
			gameGui.update(this);
		}
		gui.update(dt);
		buttonClicked = false;
		cursor.setButtons();
		if (!Sound.music[i].playing()) {
			if (i == 2) {
				i = 0;
			}else{
				i++;
			}
				Sound.music[i].play(1.0f,0.2f);
		}
	}

	public int render(double interpolation) {
		super.render(interpolation);

		if (gameState == State.PLAYING) {
			double interp = interpolation;
			if (gameState != State.PLAYING)
				interp = 0;
			saveGame.render(interp, this);
			gameGui.render(this);
		}
		gui.render();

		cursor.render(interpolation);
		return 0;
	}

	public static void main(String[] args) {
		new Game().start();
	}

}
