public class Node {
   public Point payload;
   public Node next;
   
   public Node() {
      payload = null;
      next = null;
      System.err.println("THIS IS AN ERROR"); 
   }
   public Node(Point p) {
      payload = p;
      next = null;
   }
}