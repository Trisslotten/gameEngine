package spel.utils;

import org.newdawn.slick.SlickException;

public class Sound {
	
	org.newdawn.slick.Sound sound;
	
	public Sound(String path) {
		try {
			sound = new org.newdawn.slick.Sound(path);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public void loop() {
		sound.loop();
	}
	
	public void loop(float pitch, float volume) {
		sound.loop(pitch, volume);
	}
	
	public void play() {
		sound.play();
	}
	
	public void play(float pitch, float volume) {
		sound.play(pitch, volume);
	}
	public void play(Settings settings) {
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
