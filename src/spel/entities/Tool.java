package spel.entities;

public class Tool extends Item {
	double time = 2;
	boolean iron;
	int wear;

	public Tool(boolean iron) {
		this.iron = iron;
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

	public void attack() {

	}

	public double gettime() {
		return time; // get time should be used first to get the usage time of
						// the item (the amount of time it takes to do task X in
						// seconds (needs converting?))
	}
}
