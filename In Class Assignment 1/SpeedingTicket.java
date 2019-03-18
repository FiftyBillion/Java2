/*
 * CS 145
 * In class assignment 1
 * speeding ticket class implements from Ticket interface
 * @author Po-I Wu
 * @version 20170407
 */

public class SpeedingTicket implements Ticket {
   private int carSpeed;
   private int limit;
   private int fine;
   public SpeedingTicket(int carSpeed, int limit) {
      this.carSpeed = carSpeed;
      this.limit = limit;
      if (carSpeed > limit) {
         fine = (int)Math.pow((carSpeed - limit), 2);
      }
      else
         fine = 0;
   }
   public void printMe() {
      System.out.println("This speeding Ticket was $"+fine+".");
   }
   public int getFine() {
      return fine;
   }
}