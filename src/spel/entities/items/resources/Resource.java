package spel.entities.items.resources;

import spel.entities.items.Item;

public class Resource extends Item {
	int amount;
	public Resource (int amount){
		this.amount=amount;
	}
	
	public void addAmount(int amount) {
		this.amount += amount;
	}
}
