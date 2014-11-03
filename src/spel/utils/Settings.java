package spel.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import spel.Game;

public class Settings implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2193533982488815929L;
	public int height, width;
	public float volume;
	
	public static final String filename = "settings.stn";
	public static final String filedir = System.getProperty("user.home") + "/Documents/My Games/TestGame/";
	public static final String filepath = filedir + filename;
	
	public Settings() {
		Settings settings = null;
		ObjectInputStream in;
		boolean success = false;
		do {
			try {
				in = new ObjectInputStream(new FileInputStream(filepath));
				settings = (Settings) in.readObject();
				in.close();
				break;
				
			} catch (IOException e) {
				File dir = new File(filedir);
				success = dir.mkdir();
				settings = new Settings(1280,720,1);
				settings.save();
			} catch (ClassNotFoundException e) {}
		} while(success);
		this.height = settings.height;
		this.width = settings.width;
		this.volume = settings.volume;
	}
	
	public void set(Game game) {
		width = game.getWidth();
		height = game.getHeight();
	}
	
	public void save() {
		Settings settings = new Settings(width, height, volume);
		System.out.println("height = "+height);
		ObjectOutputStream ut;
		try {
			ut = new ObjectOutputStream(new FileOutputStream(filepath));
			ut.writeObject(settings);
			ut.close();
		} catch (IOException e) {
			File dir = new File(filedir);
			if(dir.mkdir()) save();
			
		}
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	public Settings(int width, int height, float volume) {
		super();
		this.height = height;
		this.width = width;
		this.volume = volume;
	}
	
}
