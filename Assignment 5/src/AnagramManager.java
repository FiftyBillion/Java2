/**
 * CS 145 Assignment 5
 * AnagramManager.class
 * It will store two forms of words in Array of "Word" type object
 * and sort it if needed
 * It will show the words which have the same canonical form
 * @author Po-I Wu
 * @version 20170511
 */

import java.util.*;

public class AnagramManager {
	
	private Word[] manager;
	
	// constructor create a Array of "Word" type object
	public AnagramManager(List<String> list) {
		if(list == null || list.isEmpty()) throw new IllegalArgumentException("Nothing in the list.");
		manager = new Word[list.size()];
		for(int i = 0; i < list.size(); i++) {
			manager[i] = new Word(list.get(i));		// set the parameters go through the list
		}
	}
	
	// sort the words by initial word
	// insertion sort
	public void sortByWord() {
		for(int i = 1; i < manager.length; i++) {
			Word temp = manager[i];
			int j;
			for(j = i - 1; j >= 0 && (temp.getWord().compareTo(manager[j].getWord()) < 0); j--) {
				manager[j+1] = manager[j];		// copy the content from the front index
			}
			manager[j+1] = temp;		// because of "j--", set "j+1"
		}
	}
	
	// sort the words by canonical form of words
	public void sortByForm() {
		Arrays.sort(manager);
	}
	
	// find the word which have same canonical form
	// and return one of the words (random choose)
	public String getAnagram(String x) {
		Random rand = new Random();
		Word currentWord = new Word(x);
		List<Integer> index = new ArrayList<>();	// store the index of the word which have same canonical form
		for(int i = 0; i < manager.length; i++) {
			if(manager[i].compareTo(currentWord) == 0) {	// if canonical form are equal, store index to ArrayList
				index.add(i);
			}
		}
		if(index.size() == 0) return "";	// if no words is found, return empty String
		else return manager[index.get(rand.nextInt(index.size()))].getWord();
	}
	
	// find the group of words which have same canonical form
	// store them as a Set and return the Set
	public Set<String> getAnagrams(String x) {
		Set<String> sameCanonical = new TreeSet<>();
		Word currentWord = new Word(x);
		for(int i = 0; i < manager.length; i++) {
			if(manager[i].compareTo(currentWord) == 0) {	// if canonical form are equal, store the word to Set
				sameCanonical.add(manager[i].getWord());
			}
		}
		return sameCanonical;
	}
	
	// return the first five and last five elements of the manager Array
	public String toString() {
		String output = "";
		for(int i = 0; i < 5; i++) {
			output += manager[i];
		}
		output += "[...]";
		for(int i = manager.length - 5; i < manager.length; i++) {
			output += manager[i];
		}
		return output;
	}
}
