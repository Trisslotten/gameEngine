package spel.entities;

import java.io.Serializable;
import java.util.Random;

import org.lwjgl.input.Mouse;

import spel.Game;
import spel.entities.gui.SpriteCollection;
import spel.entities.items.resources.*;
import spel.entities.items.resources.Wood;
import spel.entities.structures.Structure;
import spel.entities.structures.Buildings.Fireplace;
import spel.entities.structures.Buildings.Hut;
import spel.entities.structures.vegetation.Vegetation;
import spel.tileMap.tiles.GrassTile;
import spel.utils.Sound;

public class Player extends Entity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8501459826523145529L;
	public int Ty = 0;
	public int Tx = 0;
	public int windowWidth, windowHeight;
	int pointerindex = 0;
	int hunger = 100;
	double timer;
	int tick = 0;
	boolean drawWPointer = false, standframe = false;
	double velocity, deltaSum, deltaTimer;
	int direction = 0, walkframe = 0;
	boolean walking = false;
	public boolean collided, harvesting;
	public Vegetation harvest;
	public boolean hasAxe = false, hasPickaxe = false, hasHammer = false;
	public boolean hutSelected = false, fireplaceSelected = false, shelterSelected = false;

	public Inventory inventory;
	public boolean vegetationClicked;
	private double radius;
	public boolean placedHut = false;

	public Player(double xpos, double ypos, Game game) {
		super(xpos, ypos);
		windowWidth = game.getWidth();
		windowHeight = game.getHeight();
		velocity = 256;
		this.height = SpriteCollection.player.height;
		this.width = SpriteCollection.player.width;
		deltaSum = 0;
		inventory = new Inventory();
		collided = false;
		radius = 10;
		
		//debug
		inventory.addResource(new Wood(101));
		inventory.addResource(new Food(101));
		inventory.addResource(new Iron(101));
		inventory.addResource(new IronNails(101));
		inventory.addResource(new Stone(101));
	}

	public void update(double dt, Game game) {
		deltaSum++;
		Random rand = new Random();
		if (tick >= 360) {
			hunger--;
			tick = 0;
		}
		tick++;
		double interval = 10;
		if (deltaSum > deltaTimer + interval) {
			deltaTimer += interval;
			standframe = !standframe;
			if (standframe) {
				if (walkframe > 1)
					walkframe--;
				else
					walkframe++;
			}
		}

		timer++;
		if (timer >= 4) {
			pointerindex++;
			timer = 0;
			if (pointerindex > 8) {
				pointerindex = 0;
			}
		}

		if (Mouse.isButtonDown(1) && !game.saveGame.level.getNPCclicked()) {
			Ty = (int) ((int) (ypos - windowHeight / 2) + game.cursor.getYpos());
			Tx = (int) ((int) (xpos - windowWidth / 2) + game.cursor.getXpos());

			if (game.saveGame.level.isWaterTile(Tx, Ty)) {
				Ty = (int) ypos;
				Tx = (int) xpos;
			}

		}
		if (Math.abs(xpos - Tx) >= 10 && Tx != 0 && Ty != 0
				|| Math.abs(ypos - (Ty)) >= 10 && Tx != 0 && Ty != 0) {
			walking = true;
			drawWPointer = true;
			double dx = xpos - Tx;
			double dy = ypos - Ty;
			double angle = Math.atan2(dy, dx);
			xspd = Math.cos(angle) * velocity;
			yspd = Math.sin(angle) * velocity;
			/*
			 * angle += Math.PI / 8; for (int i = 0; i < 8; i++) { double d =
			 * (double) i; if (angle > d * Math.PI / 4 && angle <= d * Math.PI /
			 * 4 + Math.PI / 4) { direction = i; } }
			 */

			for (int i = 0; i < 9; i++) {
				double d = (double) i;
				if (angle < d * (Math.PI / 8) && angle > -d * (Math.PI / 8)) {
					direction = i;
					if (d == 1) {
						direction = 4;
					} else if (d == 2 || d == 3) {
						if (Ty > ypos) {
							direction = 3;
						} else {
							direction = 5;
						}
					} else if (d == 4 || d == 5) {
						if (Ty > ypos) {
							direction = 2;
						} else {
							direction = 6;
						}
					} else if (d == 6 || d == 7) {
						if (Ty > ypos) {
							direction = 1;
						} else {
							direction = 7;
						}
					} else if (d == 8) {
						direction = 0;
					}
					break;
				}
			}
		} else {
			drawWPointer = false;
			xspd = 0;
			yspd = 0;
			walking = false;
		}

		// check collisions
		for (Vegetation v : game.saveGame.level.plants) {
			if (v.xdraw + v.width > 0 && v.ydraw + v.height > 0
					&& v.xdraw < game.getWidth() && v.ydraw < game.getHeight()) {
				double deltax = v.collx - (xpos);
				double deltay = v.colly - (ypos);

				double circleDistance = Math.sqrt(deltax * deltax + deltay
						* deltay);
				if (circleDistance < v.radius + radius) {
					collided = true;
					double[] v1 = rotateVector(deltax, deltay, Math.PI / 2);
					double[] v2 = rotateVector(deltax, deltay, -Math.PI / 2);
					double dx1 = v1[0] + xpos - Tx;
					double dy1 = v1[1] + ypos - Ty;
					double dx2 = v2[0] + xpos - Tx;
					double dy2 = v2[1] + ypos - Ty;
					double distance1 = Math.sqrt(dx1 * dx1 + dy1 * dy1);
					double distance2 = Math.sqrt(dx2 * dx2 + dy2 * dy2);
					if (distance2 < distance1) {
						double angle3 = Math.atan2(v1[1], v1[0]);
						xspd = Math.cos(angle3) * velocity;
						yspd = Math.sin(angle3) * velocity;
					} else {
						double angle3 = Math.atan2(v2[1], v2[0]);
						xspd = Math.cos(angle3) * velocity;
						yspd = Math.sin(angle3) * velocity;
					}

				} else {
					collided = false;
				}
			}
		}

		xpos -= xspd * dt / 1000;
		ypos -= yspd * dt / 1000;

		xdraw = xpos;
		ydraw = ypos;
		vegetationClicked = false;
	}

	public double getDrawBottom() {
		return (windowHeight / 2) - 87 + height;
	}

	public double[] rotateVector(double x, double y, double rads) {
		double[] vector = new double[2];
		vector[0] = x * Math.cos(rads) - y * Math.sin(rads);
		vector[1] = x * Math.sin(rads) + y * Math.cos(rads);
		return vector;
	}

	public void render(double interpolation, Game game) {
		interpolation /= 1000;
		xdraw -= xspd * interpolation;
		ydraw -= yspd * interpolation;
		if (drawWPointer) {
			SpriteCollection.WPointer[pointerindex].render(Tx - xpos
					+ windowWidth / 2 - 32, Ty - ypos + windowHeight / 2 - 40);
		}
		if (walking) {
			if (standframe) {
				SpriteCollection.playerWalking[direction][0].render(
						(windowWidth / 2) - 32, (windowHeight / 2) - 87);
			} else {
				SpriteCollection.playerWalking[direction][walkframe].render(
						(windowWidth / 2) - 32, (windowHeight / 2) - 87);
			}

		} else {
			SpriteCollection.player.render((windowWidth / 2) - 32,
					(windowHeight / 2) - 87);
		}

		inventory.render(game);
	}
	
	public void craftFireplace(Game game) {
		if (game.cursor.buttonClicked(0)&&hutSelected) {
			int x = (int) (xpos) + (int) game.cursor.getXdraw() - game.getWidth() / 2;
			int y = (int) (ypos) + (int) game.cursor.getYdraw() - game.getHeight() / 2;
			Structure fireplace = new Fireplace(x, y, SpriteCollection.hut.width, SpriteCollection.hut.height, false, false, game);
			if (!placedHut) {
				if (fireplace.payCost(game)) {
					game.saveGame.level.structures.add(fireplace);
					placedHut = true;
				}
			}
		}
	}

	public void craftHut(Game game) {
		if (game.cursor.buttonClicked(0)&&game.saveGame.player.hutSelected) {
			int x = (int) (xpos) + (int) game.cursor.getXdraw() - game.getWidth() / 2;
			int y = (int) (ypos) + (int) game.cursor.getYdraw() - game.getHeight() / 2;
			Structure hut = new Hut(x, y, SpriteCollection.hut.width, SpriteCollection.hut.height, true, true, game);
			if (!game.saveGame.player.placedHut) {
				if (hut.payCost(game)) {
					game.saveGame.level.structures.add(hut);
					placedHut = true;
				}
			}
		}
	}
	
	public void craftAxe() {
		if(inventory.payCost(2, 2, 0)) {
			this.hasAxe = true;
		}
	}
	
	public void craftPickaxe() {
		if(inventory.payCost(5, 5, 0)) {
			this.hasAxe = true;
		}
	}
	public void craftHammer() {
		if(inventory.payCost(5, 1, 0)) {
			this.hasAxe = true;
		}
	}
	
	public int getrange(double xpos, double ypos) {
		int r = (int) Math.sqrt(Math.pow(this.xpos - xpos, 2)
				+ Math.pow(this.ypos - ypos, 2));
		return r;
	}

	public void vegetationClicked() {
		this.vegetationClicked = true;
	}

	public void harvest(Vegetation vegetation) {
		vegetationClicked();
		harvesting = true;
		this.harvest = vegetation;
	}

	public void setTx(int Tx) {
		this.Tx = Tx;
	}

	public void setTy(int Ty) {
		this.Ty = Ty;
	}

	public int getypos() {
		return (int) ypos;
	}

	public int getxpos() {
		return (int) xpos;
	}

	public void eat(int amount) {
		hunger += amount;
	}

}
