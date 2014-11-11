package spel.entities;

import java.io.Serializable;
import java.util.Vector;

import org.newdawn.slick.Color;

import spel.Game;
import spel.entities.items.Item;
import spel.entities.items.resources.Resource;
import spel.utils.Sound;

public class Inventory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1472282108566202597L;
	Vector<Item> items = new Vector<Item>();

	public void addResource(Resource res) {
		System.out.println("adding resource " + res.getClass().getSimpleName());
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

	public void render(Game game) {
		for (int i = 0; i < items.size(); i++) {
			Resource res = (Resource) items.elementAt(i);
			String str = res.getAmount() + " " + res.getClass().getSimpleName();
			game.text.render(51, 201 + i * 20, str, Color.black);
			game.text.render(50, 200 + i * 20, str, Color.red);
		}
	}

	public void payCost(int woodCost, int stoneCost, int nailCost) {
		for (int i = 0; i < items.size(); i++) {
			Resource res = (Resource) items.elementAt(i);
			String str = res.getClass().getSimpleName();
			if (str.equals("Wood")) {
				if (woodCost > 0 && res.getAmount() > woodCost) {
					res.addAmount(-woodCost);
					items.remove(i);
					items.add(res);
				}
			} else if (str.equals("Stone")) {
				if (stoneCost > 0 && res.getAmount() > stoneCost) {
					res.addAmount(-stoneCost);
					items.remove(i);
					items.add(res);
				}
			} else if (str.equals("IronNails")) {
				if (nailCost > 0 && res.getAmount() > nailCost) {
					res.addAmount(nailCost);
					items.remove(i);
					items.add(res);
				}
			}
		}
	}
}
