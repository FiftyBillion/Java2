/**
 * CS 145
 * Assignment 3
 * this is HangmanManager.class
 * it will find the words which is matched the length user want
 * and sort the words to pattern depend on given letters
 * keep narrowing down the group of answer
 * it will also determine how many words are correct or no correct
 * @author Po-I Wu
 * @version 20170422
 */

import java.util.*;

public class HangmanManager {
	private int guessLeft;
	private String showPattern = "";
	private SortedSet<Character> guessesWord = new TreeSet<Character>();
	private Set<String> possibleAnswer = new TreeSet<String>();
	
	public HangmanManager(List<String> dictionary, int length, int max) {
		if(length < 1) {
			throw new IllegalArgumentException("Length cannot be less than 1");
		} else if(max < 0) {
			throw new IllegalArgumentException("Maximum guess cannot be less than 0");
		} else {
			guessLeft = max;
			for(String x: dictionary) {			// put the words which match given length to the set
				if(x.length() == length) {
					possibleAnswer.add(x);		// this set will change due to narrowing down the possible answer
				}
			}
			for(int i = 0; i < length; i++) {
				showPattern += "-";			// initial pattern will only contain "-" as long as given length
			}
		}
	}
	public Set<String> words() {
		return possibleAnswer;
	}
	public int guessesLeft() {
		return guessLeft;
	}
	public SortedSet<Character> guesses() {
		return guessesWord;
	}
	public String pattern() {
		if(possibleAnswer.isEmpty()) throw new IllegalStateException();
			return addSpace(showPattern);		// modify the patter (add space)
	}
	public int record(char guess) {
		if(guessesLeft() < 1) {
			throw new IllegalStateException("You have no chance !");
		} else if(!possibleAnswer.isEmpty() && guessesWord.contains(guess)) {
			throw new IllegalArgumentException("You have guessed this before");
		} else {
			guessesWord.add(guess);
			// create a set as a value of set
			Map<String, Set<String>> patternCollect = new TreeMap<String, Set<String>>();
			Set<String> answerGroup;
			for(String x: possibleAnswer) {
				if(!patternCollect.containsKey(getPattern(x, guessesWord))) {		// if first time, new a TreeSet
					patternCollect.put(getPattern(x, guessesWord), new TreeSet<String>());
				}
				//then add the word to the set
				answerGroup = patternCollect.get(getPattern(x, guessesWord));
				answerGroup.add(x);
			}
			// find the highest occurrence of the pattern
			int occurrence = 0;
			for(String x: patternCollect.keySet()) {
				if(patternCollect.get(x).size() > occurrence) {
					answerGroup = patternCollect.get(getPattern(x, guessesWord));
					occurrence = patternCollect.get(x).size();
					// replace possibleAnswer with the higher occurrence pattern of words
					possibleAnswer = answerGroup;
					showPattern = x;
				}
			}
			// count the letter appears in the pattern
			int countLetter = 0;
			for(int i = 0; i < showPattern.length(); i++) {
				if(showPattern.charAt(i) == guess) {
					countLetter++;
				}
			}
			// if not appears in the pattern, chance of guess -1
			if(countLetter == 0)
				guessLeft--;
			return countLetter;
		}
	}
	
	// parameter: String and SortedSet<Character>
	// change the word to the pattern which only contain the letters
	// for example: apple, p  ----> "-pp--"
	private static String getPattern(String myWord, SortedSet<Character> letter) {
		String output = "";
		for(int i = 0; i < myWord.length(); i++) {
			if(letter.contains(myWord.charAt(i))) {
				output += myWord.charAt(i);
			} else {
				output += "-";
			}
		}
		return output;
	}
	
	// parameter: String
	// this method add space between letter
	// no beginning space and trailing space
	private static String addSpace(String str) {
		String output = "";
		for(int i = 0; i < str.length(); i++) {
			output += str.charAt(i);
			if(i < str.length()-1) {
				output += " ";
			}
		}
		return output;
	}
}