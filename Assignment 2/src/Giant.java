/*
 * Giant.class
 * this class is extended from Critter
 * the giant color will be gray
 * its icon will in this order: fee, fie, foe, fum. Each run for six times and repeat
 * it will infect the enemy in the front
 * if there is nothing in the front, it will hop
 * otherwise it will turn right
 * @author Po-I Wu
 * @version 20170413
 */

import java.awt.*;

public class Giant extends Critter{
	
	private int countMove = 0;
	
	public Giant() {
		
	}
	public Color getColor() {
		return Color.GRAY;
	}
	public String toString() {
		if (countMove <= 5) {		// first 6 will go "fee"
			return "fee";
		} else if (countMove > 5 && countMove <= 11) {		// next 6 will go "fie"
			return "fie";
		} else if (countMove > 11 && countMove <= 17) {		// then go "foe" for next 6
			return "foe";
		} else if (countMove > 17) {		// go "fum" for last 6
			if (countMove == 23) {		// repeat, so reset to 0
				countMove -= 23;
			}
			return "fum";
		} else {
			return null;
		}
	}
	public Action getMove(CritterInfo info) {
		countMove++;
		if (info.getFront() == Neighbor.OTHER) {
			return Action.INFECT;
		} else if (info.getFront() == Neighbor.EMPTY) {
			return Action.HOP;
		} else {
			return Action.RIGHT;
		}
	}
}
