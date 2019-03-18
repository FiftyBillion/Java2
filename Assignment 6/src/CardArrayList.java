/**
 * CS 145 Assignment 6
 * CardArrayList class
 * this store the data as an array and allow user to add, remove, get, size, toString...
 * @author Po-I Wu
 * @version 20170516
 */

import java.util.*;

public class CardArrayList {
	
	private Card[] myCard;
	private int size;
	
	// Constructor
	// open a Card type array of size 10
	// set size as 0 which means the size current in used
	// this size != array.lenth
	public CardArrayList() {
		myCard = new Card[10];
		size = 0;
	}
	
	// Constructor
	// open a Card type array of user given size
	public CardArrayList(int x) {
		if(x < 1) throw new IllegalArgumentException("Can't be less than 1");
		myCard = new Card[x];
		size = 0;
	}
	public String toString() {
		if(size == 0) return "[0:  :0]";
		String output = "[0:";
		for(int i = 0; i < size; i++) {
			output += " " + myCard[i] + ",";
		}
		output = output.substring(0, output.length()-1) + " :" + size + "]";
		return output;
	}
	public int size() {
		return size;
	}
	
	// add Card to last empty spot
	// if there is no space too add, double the size (expand the array)
	public void add(Card x) {
		if(!isRoom()) expand();
		myCard[size] = x;
		size++;
	}
	
	// show and remove last card
	public Card remove() {
		size--;
		return myCard[size];
	}
	
	// find the card with given index
	public Card get(int x) {
		if(x > size) throw new IllegalArgumentException("Can't be over" + size);
		return myCard[x];
	}
	
	// find the insex of the card
	public int indexOf(Card x) {
		for(int i = 0; i < size; i++) {
			if(myCard[i].compareTo(x) == 0) return i;
		}
		return -1;
	}
	
	// add card to the given location
	public void add(int l, Card x) {
		for(int i = size; i >= l; i--) {
			myCard[i] = myCard[i-1];
		}
		myCard[l] = x;
		size++;
	}
	
	// remove the card of given index
	public Card remove(int j) {
		Card temp = myCard[j];
		for(int i = j; i < size-1; i++) {
			myCard[i] = myCard[i+1];
		}
		size--;
		return temp;
	}
	
	// sort the array (big to small)
	public void sort() {
		Card[] temp = Arrays.copyOf(myCard, size);
		Arrays.sort(temp, Collections.reverseOrder());
		for(int i = 0; i < size; i++) {
			myCard[i] = temp[i];
		}
	}
	
	// swap two random index 21 times as shuffle
	public void shuffle() {
		Random rand = new Random();
		for(int i = 0; i < 21; i++) {
			swap(rand.nextInt(size),rand.nextInt(size));
		}
	}
	
	// check if there is a spot to add a card
	private boolean isRoom() {
		if(size < myCard.length) return true;
		else return false;
	}
	
	// expand the array to double size
	private void expand() {
		Card[] temp = Arrays.copyOf(myCard, myCard.length); // copy the array to temp
		myCard = new Card[myCard.length*2];		// double original array
		for(int i = 0; i < temp.length; i++) {
			myCard[i] = temp[i];		// copy back
		}
	}
	
	// swap two elements with two given index
	private void swap(int a, int b) {
		Card temp = myCard[a];
		myCard[a] = myCard[b];
		myCard[b] = temp;	
	}
	
	// delete all element of array and set it to default
	public void clear() {
		myCard = new Card[10];
		size = 0;
	}
}
