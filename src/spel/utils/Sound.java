package spel.utils;

import org.newdawn.slick.SlickException;

public class Sound {

	org.newdawn.slick.Sound sound;

	public boolean played;

	public static Sound woodbutton = new Sound("res/sounds/woodbutton.wav");
	public static Sound gorillascream = new Sound(
			"res/sounds/gorillascream.wav");
	public static Sound grasstep = new Sound(
			"res/sounds/grasstep.wav");
	public static Sound[] music = music();
	public static Sound[] sandstep = sandwalk();

	public static Sound[] music() {
		Sound[] Music = new Sound[3];
		for (int i = 0; i < 3; i++) {
			Music[i] = new Sound("res/sounds/music/" + i + ".wav");
		}
		return Music;
	}
	
	public static Sound[] sandwalk() {
		Sound[] Music = new Sound[3];
		for (int i = 0; i < 3; i++) {
			Music[i] = new Sound("res/sounds/sandstep/" + i + ".wav");
		}
		return Music;
	}

	public void reset() {
		played = false;
	}

	public Sound(String path) {
		try {
			sound = new org.newdawn.slick.Sound(path);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public void loop() {
		played = true;
		sound.loop();
	}

	public void loop(float pitch, float volume) {
		played = true;
		sound.loop(pitch, volume);
	}

	public void play() {
		played = true;
		sound.play();
	}

	public void play(float pitch, float volume) {
		played = true;
		sound.play(pitch, volume);
	}

	public void play(Settings settings) {
		played = true;
		sound.play(1.0f, settings.volume);
	}

	public void stop() {
		sound.stop();
	}

	public boolean playing() {
		return sound.playing();
	}

	public void loop(Settings settings) {
		sound.loop(1.0f, settings.volume);

	}

}
