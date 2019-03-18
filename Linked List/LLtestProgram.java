public class LLtestProgram {
   public static void main(String[] args) {
      Point a = new Point();
      Point b = new Point(1,2,2);
      Point c = new Point(0,3,0);
      Point d = new Point(5,5,5);
      
      Node head = null;
      head = new Node(a);
      
      add(b, head);
      add(c, head);
      add(d, head);
      
      Node trans = head;
      System.out.println("[");
      while(trans != null) {
         System.out.print(trans.payload);
         trans = trans.next;
      }
      System.out.println("]");
      
      remove(head,3);
   }
   
   public static int size(Node start) {
      int s = 0;
      Node trans = start;
      while(trans != null) {
         trans = trans.next;
      }
      return s;
   }
   
   public static void add(Point p, Node start, int index) {
      if(start == null) {
         System.err.println("This list doesn't exist");
      }
      Node trans;
      trans = start;
      int numNode = 0;
      while(trans.next != null && numNode < index-1) {
         trans = trans.next;
         numNode++;
      }
      Node tempNode = new Node(p);
      tempNode.next = trans.next;
      trans.next = tempNode;
   }
   
   public static void add(Point p, Node start) {
      if(start == null) {
         start = new Node(p);
      } else {
         Node trans = start;
         while(trans != null) {
            trans = trans.next;
         }
         trans.next = new Node(p);
         
      }
   }
   public static void remove(Node start, int index) {
      Node trans = start;
      int nodeNum = 0;
      while(trans.next != null  && nodeNum < index -1) {
         trans = trans.next;
         nodeNum++;
      }
      if(nodeNum == index-1) {
         trans.next = trans.next.next;
      }
   }
}