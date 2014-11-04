package spel.entities;

public class NPC extends Mob {
	String name;
	boolean eventNPC;
	boolean found = false;
	boolean friend = false;

	public NPC(double xpos, double ypos, String name, boolean eventNPC) {
		super(xpos, ypos);
		this.name = name;
		this.eventNPC = eventNPC;
	}

	public void update(double dt) {
		super.update(dt);
		/*
		 * if(eventNPC&&player.getrange<=512){ boolean found=true; }
		 */
	}
}
