/**
 * CS 145, Assignment 4
 * this is GrammarSolver.class
 * it will sort the content to Arrays and generate the words if it is non-terminal
 * if it is non-terminal, then it will do recursion
 * @author Po-I Wu
 * @version 20170428
 */

import java.util.*;

public class GrammarSolver {
	
	private Map<String, String[]> grammarMap = new TreeMap<String, String[]>();
	
	// constructor split out the symbol and the content which is linked to the symbol
	public GrammarSolver(List<String> rule) {
		if(rule == null || rule.isEmpty()) throw new IllegalArgumentException("Nothing in the file.");
		for(int i = 0; i < rule.size(); i++) {
			String[] splitted = rule.get(i).split("::=");
			if(grammarMap.containsKey(splitted[0]))
				throw new IllegalArgumentException("Two same non-terminal symbols.");
			else
				grammarMap.put(splitted[0], splitted[1].trim().split("[|]"));	// split the second part with "|"
		}
	}
	
	// parameter: String symbol
	// return: boolean, determine the symbol is exist in the key of map
	public boolean contains(String symbol) {
		if(symbol == null || symbol.isEmpty()) throw new IllegalArgumentException("Symbol is empty.");
		return grammarMap.containsKey(symbol);
		
	}
	
	// return the KeySet of grammarMap
	public Set<String> getSymbols() {
		return grammarMap.keySet();
	}
	
	// parameter: String symbol
	// return: String output, if the symbol is not in the KeySet of the map, then just return the symbol
	// it split the Arrays if it is non-terminal (recursion)
	public String generate(String symbol) {
		if(symbol == null || symbol.isEmpty()) throw new IllegalArgumentException("Symbol is empty");
		if(contains(symbol)) {
			String output = "";
			Random rand = new Random();
			String[] body = grammarMap.get(symbol)[rand.nextInt(grammarMap.get(symbol).length)].trim().split("[ \t]+");
			for(int i = 0; i < body.length; i++) {
				if(i == 0)		// do not add space to the first word
					output += generate(body[i]);
				else			// otherwise, add space
					output += " " + generate(body[i]);
			}
			return output;
		}
		else
			return symbol;
	}
}
