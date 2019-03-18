// CS145 
// In Class program #2
// Array List Practice
// Edited : Po-I Wu

import java.util.*;

public class CS145InClassArrayLists
{
   public static void main(String[] args)
   {
      ArrayList<String> myList = new ArrayList<String>();
      
      myList.add("Four");
      myList.add("score");
      myList.add("and");
      myList.add("seven");
      myList.add("years");
      myList.add("ago.");
   
      System.out.print("Before: ");
      System.out.println(myList);
      
   
      swapPairs(myList);
      
      System.out.print("After:  ");    
      System.out.println(myList);
   
      // Round 2 - Odd
      System.out.println();
      System.out.println("***********");
      System.out.println();
      
      myList.clear();
      
      myList.add("1");
      myList.add("2");
      myList.add("3");
      myList.add("4");
      myList.add("5");
      myList.add("6");
      myList.add("7");    
      myList.add("8");   
      myList.add("9");             
   
      System.out.print("Before: ");
      System.out.println(myList);
      
   
      swapPairs(myList);
      
      System.out.print("After:  ");    
      System.out.println(myList);
   
   }
   
   public static void swapPairs(ArrayList<String> list) {
      for (int i = 1; i < list.size(); i += 2) {   // set i = 1 instead of 0 in order to check last pair is existed
         list.add(i-1, list.get(i));     // add the second item of the pair to the first of the pair
         list.remove(i+1);    // remove the original second item of the pair
      }
   }
   
}
    
    
    
