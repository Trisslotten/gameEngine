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
	public Vector<Resource> items = new Vector<Resource>();

	public void addResource(Resource res) {
		System.out.println("adding resource " + res.getClass().getSimpleName());
		Item item = null;
		for (int i = 0; i < items.size(); i++) {
			if (items.elementAt(i).getClass().getSimpleName().equals(res.getClass().getSimpleName())) {
				items.elementAt(i).addAmount(res.getAmount());
				return;
			}
		}
		addItem(res);
	}

	public void addItem(Resource item) {
		items.add(item);
	}

	public void render(Game game) {

	}

	public boolean payCost(int woodCost, int stoneCost, int nailCost, int ironCost) {
		boolean canPay = true, woodExists = false, stoneExists = false, nailsExists = false, ironExists = false;
		for (int i = 0; i < items.size(); i++) {
			Resource res = items.elementAt(i);
			if (res.getClass().getSimpleName().equals("Wood")) {
				woodExists = true;
				if(woodCost>res.getAmount()){
					canPay = false;
				}
			} else if (res.getClass().getSimpleName().equals("Stone")) {
				stoneExists = true;
				if(stoneCost>res.getAmount()){
					canPay = false;
				}
			} else if (res.getClass().getSimpleName().equals("IronNails")) {
				nailsExists = true;
				if(nailCost>res.getAmount()){
					canPay = false;
				}
			}  else if (res.getClass().getSimpleName().equals("Iron")) {
				ironExists = true;
				if(ironCost>res.getAmount()){
					canPay = false;
				}
			}
		}
		if(!woodExists&&woodCost>0) {
			canPay = false;
		}
		if(!stoneExists&&stoneCost>0) {
			canPay = false;
		}
		if(!nailsExists&&nailCost>0) {
			canPay = false;
		}
		if(!ironExists&&ironCost>0) {
			canPay = false;
		}
		if (canPay) {
			for (int i = 0; i < items.size(); i++) {
				Resource res = items.elementAt(i);
				if (res.getClass().getSimpleName().equals("Wood")) {
					items.elementAt(i).addAmount(-woodCost);
				} else if (res.getClass().getSimpleName().equals("Stone")) {
					items.elementAt(i).addAmount(-stoneCost);
				} else if (res.getClass().getSimpleName().equals("IronNails")) {
					items.elementAt(i).addAmount(-nailCost);
				}
			}
		}
		return canPay;
	}
}
