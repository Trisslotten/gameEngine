package spel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

import spel.entities.Entity;
import spel.tileMap.Level;

public class SaveGame implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 134354553867719645L;

	public static final String filepath = System.getProperty("user.home") + "/Documents/My Games/TestGame/save.med";
	public static final String filedir = System.getProperty("user.home") + "/Documents/My Games/TestGame/";
	
	public Vector<Entity> entities;
	// public Player player;
	public Level level;
	
	public SaveGame(Game game) {
		entities = new Vector<Entity>();
		// player = new Player();
		level = new Level(game);
	}
	
	public SaveGame(SaveGame saveGame){ 
		this.entities = saveGame.entities;
		this.level = saveGame.level;
	}
	
	public static SaveGame load() {
		SaveGame saveGame = null;
		ObjectInputStream in;
		try {
			in = new ObjectInputStream(new FileInputStream(filepath));
			saveGame = (SaveGame) in.readObject();
			in.close();
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {}
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
			File dir = new File(filedir);
			if(dir.mkdir()) save();
		}
	}

	public void update(double dt) {
		
		
	}

	public void render(double interp) {
		
	}
	
}
