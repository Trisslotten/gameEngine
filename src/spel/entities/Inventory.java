package spel.entities;

import java.util.Vector;

import spel.entities.items.Item;
import spel.entities.items.resources.Resource;

public class Inventory {

	Vector<Item> items = new Vector<Item>();

	public void addResource(Resource res) {
		Item item = null;
		for (int i = 0; i < items.size(); i++) {
			if (items.elementAt(i).getClass().getSimpleName().equals(res.getClass().getSimpleName())) {
				item = items.elementAt(i);
				Resource res1 = (Resource) item;
				res1.addAmount(res.getAmount());
				items.remove(i);
				items.add(res1);
				return;
			}
		}
		addItem(res);
	}

	public void addItem(Item item) {
		items.add(item);
	}

	public void render() {
		
	}

}
