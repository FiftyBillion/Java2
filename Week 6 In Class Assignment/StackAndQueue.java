/**
 * CS 145
 * Week 6 Inclass Assignment
 * This class shows two methods which is just using Stack and Queue
 * @author Po-I Wu
 * @version 20170510
 */

import java.util.*;

public class StackAndQueue {

   // main method setup the Queues
   public static void main(String[] args) {
      Queue<Integer> numberQueue = new LinkedList<>();
      Queue<String> stringQueue = new LinkedList<>();
      numberQueue.add(1);
      numberQueue.add(2);
      numberQueue.add(3);
      stringQueue.add("a");
      stringQueue.add("b");
      stringQueue.add("c");
      System.out.println("Before stutter:");
      System.out.println(numberQueue);
      System.out.println("After stutter:");
      stutter(numberQueue);
      System.out.println(numberQueue);
      System.out.println("Before mirror:");
      System.out.println(stringQueue);
      System.out.println("After mirror:");
      mirror(stringQueue);
      System.out.println(stringQueue);
   }
   
   // this method will duplicate the elements
   // 123 will become 112233
   public static void stutter(Queue<Integer> myQueue) {
      Queue<Integer> tempQueue = new LinkedList<>();
      while(myQueue.size() > 0) {
         tempQueue.add(myQueue.peek());
         tempQueue.add(myQueue.remove());
      }
      
      // Cannot use tempQueue = myQueue
      // so use while loop to transfer
      while(tempQueue.size() > 0) {
         myQueue.add(tempQueue.remove());
      }
   }
   
   // this method will add the element with reverse order
   // abc will become abccba
   public static void mirror(Queue<String> myQueue) {
      Stack<String> tempStack = new Stack<>();
      Queue<String> tempQueue = new LinkedList<>();
      
      // tempStack will be abc
      // tempQueue will be abc
      while(myQueue.size() > 0) {
         tempStack.push(myQueue.peek());
         tempQueue.add(myQueue.remove());
      }
      
      // put it back by usign Queue to maintain same order abc
      while(!(tempQueue.size() == 0)) {
         myQueue.add(tempQueue.remove());
      }
      
      // then using stack to get the order cba
      while(!(tempStack.size() == 0)) {
         myQueue.add(tempStack.pop());
      }
   }
}