package spel.entities.gui;

import java.util.Vector;

import spel.Game;
import spel.entities.Entity;
import spel.entities.gui.backgrounds.PauseCover;
import spel.entities.gui.backgrounds.StartBackground;
import spel.entities.gui.button.Button;
import spel.entities.gui.button.ContinueButton;
import spel.entities.gui.button.QuitButton;
import spel.entities.gui.button.StartButton;

public class Gui {
	
	public Vector<Button> pauseElements, settingsElements, menuElements;
	public Graphics pauseCover, menuBackground;
	
	public boolean inSettings;
	
	public Game game;
	
	public Gui(Game game) {
		inSettings = false;
		this.game = game;
		pauseElements = new Vector<Button>();
		settingsElements = new Vector<Button>();
		menuElements = new Vector<Button>();
		
		menuBackground = new StartBackground(0,0,game.getWidth(),game.getHeight());
		pauseCover = new PauseCover(0,0,game.getWidth(),game.getHeight());
		
		menuElements.add(new ContinueButton	(0.60f,0.60f,game,SpriteCollection.quit));
		menuElements.add(new StartButton	(0.60f,0.70f,game,SpriteCollection.quit));
		menuElements.add(new QuitButton	(0.60f,0.80f,game,SpriteCollection.quit));
		
		
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
	
	public void render() {
		if (game.gameState == Game.State.MENU) {
			menuBackground.render();
			if (inSettings) {
				pauseCover.render();
				for (Graphics e : settingsElements)
					e.render();
			} else {
				for (Graphics e : menuElements)
					e.render();
			}
		} else if (game.gameState == Game.State.PLAYING) {
			if (game.paused) {
				pauseCover.render();
				if (inSettings) {
					for (Graphics e : settingsElements)
						e.render();;
				} else {
					for (Graphics e : pauseElements)
						e.render();
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
