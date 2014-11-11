package spel.entities;

public class Mob extends Entity {
	int health = 100;

	public Mob(double xpos, double ypos) {
		super(xpos, ypos);
		
	}
	public void damage(int damage){
		health-=damage;
		if(health<=0){
			
		}
	}
	public boolean ded(){
		return health<=0;
	}
}
