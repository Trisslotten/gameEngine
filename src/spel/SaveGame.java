package spel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.newdawn.slick.Color;

import spel.entities.Player;
import spel.tileMap.Level;
import spel.utils.Position;

public class SaveGame implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 134354553867719645L;

	public static final String filepath = System.getProperty("user.home") + "/Documents/TestGame/save.med";
	public static final String filedir = System.getProperty("user.home") + "/Documents/TestGame/";

	public Player player;
	public Level level;

	public SaveGame(Game game) {
		level = new Level(game);
		Position pos = level.getSpawnPosition(); 
		player = new Player(pos.x, pos.y, game);

	}

	public SaveGame(SaveGame saveGame) {
		this.player = saveGame.player;
		this.level = saveGame.level;
	}

	public static SaveGame load(Game game) {
		SaveGame saveGame = null;
		ObjectInputStream in;
		try {
			in = new ObjectInputStream(new FileInputStream(filepath));
			saveGame = (SaveGame) in.readObject();
			in.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			File dir = new File(filedir);
			dir.mkdir();
			saveGame = new SaveGame(game);
		}
		return saveGame;
	}

	public void save() {
		SaveGame saveGame = new SaveGame(this);
		ObjectOutputStream ut;
		try {
			ut = new ObjectOutputStream(new FileOutputStream(filepath));
			ut.writeObject(saveGame);
			ut.close();
		} catch (IOException e) {
			e.printStackTrace();
			File dir = new File(filedir);
			if (dir.mkdir())
				save();
		}
	}

	public void update(double dt, Game game) {
		player.update(dt, game);
		level.update(dt, game);
	}

	public void render(double interp, Game game) {
		level.render((int) player.getXdraw(), (int) player.getYdraw(), game, player);
		
		game.text.render(200, 20, (int)player.getXpos()+ " "+ (int)player.getYpos(), Color.pink);
		
	}

}
