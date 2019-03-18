/**
 * CS 145 Assignment 5
 * Word.class    implements Comparable interface
 * This is a supporting class of AnagramManager
 * It will convert the given word to canonical form and store both
 * @author Po-I Wu
 * @version 20170511
 */

import java.util.*;

public class Word implements Comparable<Word> {
	
	private String givenWord;
	private String canonicalForm;
	
	// convert the given word to canonical form (letter in alphabet order)
	public Word(String x) {
		givenWord = x.toLowerCase();
		char[] reformed = x.toLowerCase().toCharArray();	// split the String to char Array (letter)
		Arrays.sort(reformed);		// sort the letters in alphabet order
		canonicalForm = String.valueOf(reformed);	// put it back to String
	}
	public String getWord() {
		return givenWord;
	}
	public String getForm() {
		return canonicalForm;
	}
	public String toString() {
		return "[" + givenWord + "=" + canonicalForm + "]";
	}
	
	// if two Word type objects have same canonical form, return 0
	public int compareTo(Word x) {
		if(getForm().equals(x.getForm())) return 0;
		else if(getForm().compareTo(x.getForm()) < 0) return -1;
		else return 1;
	}
}
