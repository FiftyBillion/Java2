/**
 * CS 145 Assignment 6
 * Card class implement Comparable interface
 * it create a card, allow user to get card info
 * it compare two cards by Cost->Power->toughness
 * Card will be added to Array List
 * @author Po-I Wu
 * @version 20170516
 */

import java.util.*;

// implement Comparable interface in order to compare with other cards
// Card generate power and toughness
// user can use these two pieces information to compare with other Card
public class Card implements Comparable<Card> {
	
	private int power;
	private int toughness;
	
	// Constructor
	// if no given parameter, generate random number for power and toughness
	// between 1 - 1000
	public Card()	{
		Random rand = new Random();
		power = rand.nextInt(1000) + 1;
		toughness = rand.nextInt(1000) + 1;
	}
	
	// Constructor
	// set power and toughness equal to the given value
	public Card(int x) {
		if(x > 1000) throw new IllegalArgumentException("Should be less than 1000");
		power = x;
		toughness = x;
	}
	
	// Constructor
	// set power and toughness manually my user
	public Card(int Power, int Toughness) {
		if(Power > 1000 || Toughness > 1000) throw new IllegalArgumentException("Should be less than 1000");
		power = Power;
		toughness = Toughness;
	}
	public int getPower() {
		return power;
	}
	public int getToughness() {
		return toughness;
	}
	
	// calculate the cost by using formula: sqrt(1.5*power + 0.9*toughness)
	// and round UP to integer
	public int getCost() {
		int cost = (int)Math.ceil(Math.sqrt(1.5 * power + 0.9 * toughness));
		return cost;
	}
	public String toString() {
		return "[" + power + "/" + toughness + "]";
	}
	
	// CompareTo method
	// it will compare the cost of two cards
	// if same cost, then compare power
	// if same power, then compare toughness
	// if same toughness, then two cards are equal
	public int compareTo(Card x) {
		int compare = getCost() - x.getCost();
		if(compare != 0) return compare;
		else {
			compare = getPower() - x.getPower();
			if(compare != 0) return compare;
			else {
				compare = getToughness() - x.getToughness();
				if(compare != 0) return compare;
				else return 0;
			}
		}
	}
	
	// power and toughness times 0.9 (10% off)
	public void weaken() {
		power = (int)(power * 0.9);
		toughness = (int)(toughness * 0.9);
	}
	
	// power and toughness times 1.1 (add 10%)
	public void boost() {
		power = (int)(power * 1.1);
		toughness = (int)(toughness * 1.1);
	}
}
