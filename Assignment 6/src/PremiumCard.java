/**
 * CS 145 Assignment 6
 * PremiumCard class extends from Card
 * this is a advanced card
 * only override "toString" method
 * @author Po-I Wu
 * @version 20170516
 */
public class PremiumCard extends Card{
	
	// call parent constructors
	public PremiumCard() {
		super();
	}
	public PremiumCard(int x) {
		super(x);
	}
	public PremiumCard(int Power, int Toughness) {
		super(Power, Toughness);
	}
	
	//only override this method
	public String toString() {
		return "{{" + getPower() + "/" + getToughness() + "}}";
	}
}
