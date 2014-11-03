package spel.entities;

public class Tool extends Item {
	double time = 2;
	boolean iron;
	boolean weapon;
	int wear;

	public Tool(boolean iron, boolean weapon) {
		this.iron = iron;
		this.weapon = weapon;
	}

	public void use() { // increases wear depending on tool type
		if (wear < 40) {
			wear++;
			if (!iron) {
				time *= wear;
			} else {
				time *= (wear / 2);
			}
		}
		if (iron) {
			time--;
		}
	}

	public int returndamage() {// non-iron weapons suffers a lot from wear but
								// iron does not, tools deals some base damage
								// but dosen't suffer from wear at all (blunt
								// damage)
		if (!weapon) {
			if (!iron) {
				return 10;
			} else {
				return 15;
			}
		} else {
			if (!iron) {
				return 25 - (wear / 2);
			} else {
				return 50 - (wear / 2);
			}
		}
	}

	public double gettime() {
		return time; // get time should be used first to get the usage time of
						// the item (the amount of time it takes to do task X in
						// seconds (needs converting?))
	}
}
