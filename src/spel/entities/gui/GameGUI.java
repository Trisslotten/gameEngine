package spel.entities.gui;

import spel.Game;
import spel.entities.gui.backgrounds.Sidebar;

public class GameGUI {
	
	public Sidebar sidebar;

	public GameGUI(Game game) {
		sidebar = new Sidebar(game.getWidth()-SpriteCollection.sidebar.width,0);
	}

	public void update(Game game) {
		
	}

	public void render(Game game) {
		sidebar.render();
		
	}
	
}
