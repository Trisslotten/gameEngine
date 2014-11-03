package spel.entities;

public class Tool extends Item {
	double time = 2;

	public Tool() {

	}

	public void use() {
		if (time < 6) {
			time += 0.08;
		}
	}

	public double gettime() {
		return time;
	}
}
