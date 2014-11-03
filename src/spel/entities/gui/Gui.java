package spel.entities.gui;

import java.util.Vector;

import spel.Game;
import spel.entities.Entity;
import spel.entities.gui.backgrounds.PauseCover;
import spel.entities.gui.backgrounds.StartBackground;
import spel.entities.gui.button.ContinueButton;
import spel.entities.gui.button.StartButton;

public class Gui {
	
	public Vector<Entity> pauseElements, settingsElements, menuElements;
	public Entity pauseCover, menuBackground;
	
	public boolean inSettings;
	
	public Game game;
	
	public Gui(Game game) {
		inSettings = false;
		this.game = game;
		pauseElements = new Vector<Entity>();
		settingsElements = new Vector<Entity>();
		menuElements = new Vector<Entity>();
		
		menuBackground = new StartBackground(0,0,game.getWidth(),game.getHeight());
		pauseCover = new PauseCover(0,0,game.getWidth(),game.getHeight());
		
		menuElements.add(new ContinueButton	(0.60f,0.60f,game,SpriteCollection.cont));
		menuElements.add(new StartButton	(0.60f,0.70f,game,SpriteCollection.start));
		
		
	}
	
	public void update(double dt) {
		if (!game.paused && game.gameState == Game.State.PLAYING) {
			inSettings = false;
		}
		if (game.gameState == Game.State.MENU) {
			menuBackground.update(dt);
			if (inSettings) {
				pauseCover.update(dt);
				for (Entity e : settingsElements)
					e.update(dt);
			} else {
				for (Entity e : menuElements)
					e.update(dt);
			}
		} else if (game.gameState == Game.State.PLAYING) {
			if (game.paused) {
				pauseCover.update(dt);
				if (inSettings) {
					for (Entity e : settingsElements)
						e.update(dt);
				} else {
					for (Entity e : pauseElements)
						e.update(dt);
				}
			}
		}
	}
	
	public void render(double interpolation) {
		if (game.gameState == Game.State.MENU) {
			menuBackground.render(interpolation);
			if (inSettings) {
				pauseCover.render(interpolation);
				for (Entity e : settingsElements)
					e.render(interpolation);
			} else {
				for (Entity e : menuElements)
					e.render(interpolation);
			}
		} else if (game.gameState == Game.State.PLAYING) {
			if (game.paused) {
				pauseCover.render(interpolation);
				if (inSettings) {
					for (Entity e : settingsElements)
						e.render(interpolation);;
				} else {
					for (Entity e : pauseElements)
						e.render(interpolation);
				}
			}
		}
	}
	
	public int[] swap(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int temp = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = arr[i];
			arr[i] = temp;
		}
		return arr;
	}
	
	public void bubbleSort(int[] arr, int[] second) {
		boolean swapped = true;
		int j = 0;
		int tmp;
		while (swapped) {
			swapped = false;
			j++;
			for (int i = 0; i < arr.length - j; i++) {
				if (arr[i] > arr[i + 1]) {
					tmp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = tmp;
					tmp = second[i];
					second[i] = second[i + 1];
					second[i + 1] = tmp;
					swapped = true;
				}
			}
		}
	}
	
}
