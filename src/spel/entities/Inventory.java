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
	Vector<Resource> items = new Vector<Resource>();

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

	public void addItem(Resource item) {
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

	public boolean payCost(int woodCost, int stoneCost, int nailCost) {
		boolean canPay = true;
		for(int i=0;i<items.size();i++){
			Resource res = items.elementAt(i);
			if(res.getClass().getSimpleName().equals("Wood")){
				if(!(res.getAmount()>=woodCost))
					canPay = false;
			} else if(res.getClass().getSimpleName().equals("Stone")){
				if(!(res.getAmount()>=stoneCost))
					canPay = false;
			} else if(res.getClass().getSimpleName().equals("IronNails")){
				if(!(res.getAmount()>=nailCost))
					canPay = false;
			} 
		}
		if(canPay) {
			for(int i=0;i<items.size();i++){
				Resource res = items.elementAt(i);
				if(res.getClass().getSimpleName().equals("Wood")){
					items.elementAt(i).addAmount(-woodCost);
				} else if(res.getClass().getSimpleName().equals("Stone")){
					items.elementAt(i).addAmount(-stoneCost);
				} else if(res.getClass().getSimpleName().equals("IronNails")){
					items.elementAt(i).addAmount(-nailCost);
				} 
			}
		}
		return canPay;
	}
}
