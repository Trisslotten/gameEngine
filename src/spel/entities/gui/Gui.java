package spel.entities.gui;

import java.util.Vector;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import spel.Game;
import spel.entities.Entity;
import spel.entities.gui.button.CheckBox;
import spel.entities.gui.button.ContinueButton;
import spel.entities.gui.button.QuitButton;
import spel.entities.gui.button.RButton;
import spel.entities.gui.button.SettingsButton;
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
		
		pauseCover = new Entity(0, 0, "res/pausecover.png");
		menuBackground = new Entity(0, 0, "res/mainbg.png");
		
		menuElements.add(new StartButton(590, 300, "res/start.png", game));
		menuElements.add(new SettingsButton(590, 400, "res/settings.png", game));
		menuElements.add(new QuitButton(590, 500, "res/quit.png", game));
		
		pauseElements.add(new ContinueButton(590, 300, "res/continue.png", game));
		pauseElements.add(new SettingsButton(590, 400, "res/settings.png", game));
		pauseElements.add(new QuitButton(590, 500, "res/quit.png", game));
		
		try {
			org.lwjgl.opengl.DisplayMode[] dModes = Display.getAvailableDisplayModes();
			int x = 5;
			int y = 5;
			int[] widths = new int[dModes.length];
			int[] heights = new int[dModes.length];
			for (int i = 0; i < dModes.length; i++) {
				widths[i] = dModes[i].getWidth();
				heights[i] = dModes[i].getHeight();
			}
			bubbleSort(widths, heights);
			
			Vector<String> resolutions = new Vector<String>();
			
			for (int i = 0; i < widths.length; i++) {
				System.out.println(dModes[i].getWidth());
				System.out.println(dModes[i].getHeight());
				System.out.println();
				if ((double) widths[i] / (double) heights[i] > 1 && !resolutions.contains(widths[i] + "x" + heights[i])) {
					if (y > game.getHeight()) {
						x += 105;
						y = 5;
					}
					resolutions.add(widths[i] + "x" + heights[i]);
					settingsElements.add(new RButton(x, y, "res/pixel.png", game, new DisplayMode(widths[i], heights[i])));
					y += 20;
				}
				
			}
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		settingsElements.add(new CheckBox(200,200,new String[]{"res/check0.png","res/check1.png"},game,""));
		
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
