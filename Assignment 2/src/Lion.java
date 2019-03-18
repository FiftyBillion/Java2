/*
 * Lion.class
 * this class is extended from Critter
 * it will have random color and the random color will run for three times
 * its icon will be "L"
 * it will infect the front if it is enemy
 * if there is a wall in the front or right, it will turn left
 * if the front is also a lion, it will turn right
 * otherwise hop
 * @author Po-I Wu
 * @version 20170413
 */

import java.awt.*;
import java.util.*;

public class Lion extends Critter {
	
	private int countMove = 0;
	private Color lionColor;
	Random rand = new Random();
	
	public Lion() {
		
	}
	public Color getColor() {
		int dicideColor = rand.nextInt(3);		// random number between 0, 1, 2
		if (countMove == 0) {			// pick a random color and set it as lionColor
			if (dicideColor == 0) {
			lionColor = Color.RED;
			} else if (dicideColor == 1) {
			lionColor = Color.GREEN;
			} else {
			lionColor = Color.BLUE;
			}
			return lionColor;
		} else if(countMove == 2) {		// if it is the third time
			countMove -= 3;				// set it to -1 (it will become 0 after move) 
			return lionColor;
		} else {		// keep run as the same color
			return lionColor;
		}
	}
	
	public String toString() {
		return "L";
	}
	public Action getMove(CritterInfo info) {
		countMove++;
		if (info.getFront() == Neighbor.OTHER) {
			return Action.INFECT;
		} else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
			return Action.LEFT;
		} else if (info.getFront() == Neighbor.SAME) {
			return Action.RIGHT;
		} else {
			return Action.HOP;
		}
	}
}
