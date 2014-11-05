package spel.entities;

public class NPC extends Mob {
	String name;
	int hunger = 100;
	int tick = 0;
	boolean eventNPC;
	boolean found = false;
	boolean friend = false;
	boolean starving = false;

	public NPC(double xpos, double ypos, String name, boolean eventNPC) {
		super(xpos, ypos);
		this.name = name;
		this.eventNPC = eventNPC;
	}

	public void update(double dt) {
		super.update(dt);

		if (eventNPC && player.getrange(xpos, ypos) <= 512 && !found) {
			boolean found = true;
		}

		if (friend) {
			if (tick >= 1080) {// should have no hunger left after aprox. 1.5
								// in-game days, will rapidly die if not fed
								// (looses all health in less than ~two seconds)
				hunger--;
				tick = 0;
			} else {
				tick++;
			}
			if (hunger <= 0) {
				health--;
			} else if (hunger >= 40) {
				health++;
			}
			if (hunger <= 25) {
				starving = true;
			} else {
				starving = false;
			}
		}
	}

	public void eat(int amount) {
		hunger += amount;
	}

	public boolean getfound() {
		return found;
	}

	public boolean getfriend() {
		return friend;
	}

	public boolean getstarving() {
		return starving;
	}
}
