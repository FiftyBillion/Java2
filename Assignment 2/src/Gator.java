/*
 * Gator.class
 * this class is extended from Critter
 * the Orange Gator: it has infected at least one enemy
 * the Green Gator: it hasn't infected any enemy yet
 * it will switch between "@" and "O" each move
 * it will infect if enemy is in the front
 * if there is a wall in the front, it will turn left or right randomly
 * if there is a gator in the front, it will check if there is a wall beside then turn
 * and it will follow the enemy if they are at the left or right
 * @author Po-I Wu
 * @version 20170413
 */

import java.awt.*;
import java.util.*;

public class Gator extends Critter {
	
	int countMove = 0;
	private Color gatorColor = Color.GREEN;		// set green as default color
	Random rand = new Random();
	
	public Gator() {
		
	}
	public Color getColor() {
			return gatorColor;
	}
	public String toString() {
		if (countMove == 0) {
			return "@";
		} else {				// in here, countMove will be 1
			countMove -= 2;		// set it to -1 and it will become back to 0 when next move
			return "O";
		}
	}
	public Action getMove(CritterInfo info) {
		countMove++;
		if (info.getFront() == Neighbor.OTHER) {
			gatorColor = Color.ORANGE;		// once infect other, change the color to orange
			return Action.INFECT;
		} else if (info.getFront() == Neighbor.WALL) {
			if (rand.nextInt(2) == 0) {		// turn left or right randomly
				return Action.LEFT;
			} else {
				return Action.RIGHT;
			}
		} else if (info.getFront() == Neighbor.SAME) {
			if (info.getFrontDirection() == Direction.NORTH) {
				
				// check if there is a wall beside them
				// if yes, turn against the wall
				// if no, turn left or right randomly
				if (info.getLeft() == Neighbor.WALL) {
					return Action.RIGHT;
				} else if (info.getRight() == Neighbor.WALL) {
					return Action.LEFT;
				} else {
					if (rand.nextInt(2) == 0) {
						return Action.LEFT;
					} else {
						return Action.RIGHT;
					}
				}
			} else if (info.getFrontDirection() == Direction.WEST) {
				
				// check if there is a wall beside them
				// if yes, turn against the wall
				// if no, turn left or right randomly
				if (info.getLeft() == Neighbor.WALL) {
					return Action.RIGHT;
				} else if (info.getRight() == Neighbor.WALL) {
					return Action.LEFT;
				} else {
					if (rand.nextInt(2) == 0) {
						return Action.LEFT;
					} else {
						return Action.RIGHT;
					}
				}
			} else if (info.getFrontDirection() == Direction.SOUTH) {
				
				// check if there is a wall beside them
				// if yes, turn against the wall
				// if no, turn left or right randomly
				if (info.getLeft() == Neighbor.WALL) {
					return Action.RIGHT;
				} else if (info.getRight() == Neighbor.WALL) {
					return Action.LEFT;
				} else {
					if (rand.nextInt(2) == 0) {
						return Action.LEFT;
					} else {
						return Action.RIGHT;
					}
				}
			} else {
				
				// check if there is a wall beside them
				// if yes, turn against the wall
				// if no, turn left or right randomly
				if (info.getLeft() == Neighbor.WALL) {
					return Action.RIGHT;
				} else if (info.getRight() == Neighbor.WALL) {
					return Action.LEFT;
				} else {
					if (rand.nextInt(2) == 0) {
						return Action.LEFT;
					} else {
						return Action.RIGHT;
					}
				}
			}
		} else if (info.getLeft() == Neighbor.OTHER) {		// if enemy is at the left, turn left
			return Action.LEFT;
		} else if (info.getRight() == Neighbor.OTHER) {		// if enemy is at the right, turn right
			return Action.RIGHT;
		} else {
			return Action.HOP;
		}
	}
}
