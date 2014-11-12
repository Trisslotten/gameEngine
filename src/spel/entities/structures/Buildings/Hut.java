package spel.entities.structures.Buildings;

import spel.Game;
import spel.entities.gui.SpriteCollection;
import spel.entities.structures.Structure;

public class Hut extends Structure {
	int wood;
	int stone;
	int iron;
	int food;
	int spikes;
	int save;

	public Hut(double xpos, double ypos, double height, double width,
			boolean permanent, boolean gridlocked, Game game) {
		super(xpos, ypos, height, width, permanent, gridlocked, game);
	}

	public void update(double dt) {

	}

	public void render(int xoffset, int yoffset, Game game) {
		xdraw = xpos - xoffset + game.getWidth() / 2 - width / 2;
		ydraw = ypos - yoffset + game.getHeight() / 2 - height / 2;

		SpriteCollection.hut.render(xdraw, ydraw);
	}

	public void addstone(int amount) {
		stone += amount;
	}

	public void addwood(int amount) {
		wood += amount;
	}

	public void addiron(int amount) {
		iron += amount;
	}

	public void addfood(int amount) {
		food += amount;
	}

	public void addspikes(int amount) {
		spikes += amount;
	}

	public int removestone(int amount) {
		if (amount > stone) {
			stone = 0;
			return amount;
		} else {
			stone -= amount;
			return amount;
		}
	}

	public int removewood(int amount) {
		if (amount > wood) {
			save = wood;
			wood = 0;
			return save;
		} else {
			wood -= amount;
			return amount;
		}
	}

	public int removeiron(int amount) {
		if (amount > iron) {
			save = iron;
			iron = 0;
			return save;
		} else {
			iron -= amount;
			return amount;
		}
	}

	public int removefood(int amount) {
		if (amount > food) {
			save = food;
			food = 0;
			return save;
		} else {
			food -= amount;
			return amount;
		}

	}

	public int removespikes(int amount) {
		if (amount > spikes) {
			save = spikes;
			spikes = 0;
			return save;
		} else {
			spikes -= amount;
			return amount;
		}
	}
}
