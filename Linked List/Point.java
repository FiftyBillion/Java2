public class Point implements Comparable<Point> {
   private int x;
   private int y;
   private int z;
   public Point() {
      x = 0;
      y = 0;
      z = 0;
   }
   public Point(int x, int y, int z) {
      this.x = x;
      this.y = y;
      this.z = z;
   }
   public int getX() { 
      return x;}
   public int getY() { 
      return y;}
   public int getZ() { 
      return z;}
   public double getDistance() {
      double temp = Math.pow(x,2)+ Math.pow(y,2) + Math.pow(z,2);
      return Math.sqrt(temp);
   }
   public String toString() {
      String temp = "("+x+","+y+","+z+")";
      return temp;
   }
   public int compareTo(Point other) {
      double d = getDistance() - other.getDistance();
      if(d>0) 
         return 1;
      if(d<0) 
         return -1;
      else return 0;
   }
}