/*
 * CS 145
 * In class assignment 1
 * parking ticket class implements from Ticket interface
 * @author Po-I Wu
 * @version 20170407
 */

public class ParkingTicket implements Ticket {
   private int fine;
   public ParkingTicket(int fine) {
      this.fine = fine;
   }
   public void printMe() {
       System.out.println("This parking Ticket was $"+fine+".");
   }
   public int getFine() {
      return fine;
   }
}