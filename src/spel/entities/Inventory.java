package spel.entities;

import java.util.Vector;

import spel.entities.items.Item;
import spel.entities.items.resources.Resource;

public class Inventory {

	Vector<Item> items = new Vector<Item>();

	public void addResource(String className, int amount) {
		Item item = null;
		for (int i = 0; i < items.size(); i++) {
			if (items.elementAt(i).getClass().getSimpleName().equals(className)) {
				item = items.elementAt(i);
				Resource res = (Resource) item;
				res.addAmount(amount);
				items.remove(i);
				items.add(res);
			}
		}
	}

	public void addItem(Item item) {
		items.add(item);
	}

	public void render() {

	}

}
