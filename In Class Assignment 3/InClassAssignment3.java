/*
 * CS 145
 * In class Assignment 3
 * this program will read the file and count how many times the word appears
 * and also print out the words which are apear in the file
 * @author Po-I Wu
 * @version 20170419
 */
 
 import java.io.*;
 import java.util.*;
 
 public class InClassAssignment3 {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner data = new Scanner(new File("DataFile1.txt"));      // import file
      List<String> word = new ArrayList<String>();
      while (data.hasNext()) {         // add all the words into arraylist
         word.add(data.next());
      }
      Map<String, Integer> myMap = new TreeMap<String, Integer>();
      for(String x: word) {         // check all the word from arraylist
         if(myMap.containsKey(x)) {    // if it has been existed, value add 1
            myMap.put(x, myMap.get(x)+1);
         } else {       // if it is the first time, add the word to key and set value to 1
            myMap.put(x, 1);
         }
      }
      for(String x: myMap.keySet()) {     // go through the map, print out all the information
         System.out.println("There are "+ myMap.get(x) +" times \""+ x +"\" in this file.");
      }
   }
}
