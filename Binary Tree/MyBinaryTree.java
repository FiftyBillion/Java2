import java.util.*;

public class MyBinaryTree {
   private TreeNode root;
   
   public MyBinaryTree() {
      root = null;
   }
   
   public int getMin() {
      if(root == null) throw new NoSuchElementException();
      return getMin(root);
   }
   
   private int getMin(TreeNode subroot) {
      if(subroot.left == null) return subroot.data;
      else return getMin(subroot.left);
   }
   
   public boolean contains(int value) {
      return contains(value, root);
   }
   
   private boolean contains(int value, TreeNode subroot) {
      if(subroot == null) return false;
      if(subroot.data == value) return true;
      if(subroot.data < value) return contains(value, subroot.right);
      if(subroot.data > value) return contains(value, subroot.left);
      return false;
   }
   
   public void printSideways() {
      printSideways(root, "");
   }
   
   private void printSideways(TreeNode subroot, String space) {
      if(subroot == null) return;
      
      printSideways(subroot.right, space + "    ");
      System.out.println(subroot.data);
      printSideways(subroot.left, space + "    ");
   }
   
   public void print() {
      System.out.print("Tree: ");
      print(root);
      System.out.println();
   }
   
   private void print(TreeNode subroot) {
      if(subroot == null) 
         return;
      print(subroot.left);
      System.out.print(subroot.data + " ");
      print(subroot.right);
   }
   
   public void add(int value) {
      root = add(value, root);
   } 
   private TreeNode add(int value, TreeNode subroot) {
      if(subroot == null) {
         TreeNode temp = new TreeNode(value);
         return temp;
      }
      if (subroot.data > value) {
         subroot.left = add(value, subroot.left);
         return subroot;
      }
      if (subroot.data < value) {
         subroot.right = add(value, subroot.right);
         return subroot;
      }
      return subroot;
   }
   private class TreeNode {
      private int data;
      private TreeNode left;
      private TreeNode right;
      
      private TreeNode() {
         data = 0;
         left = null;
         right = null;
      }
      private TreeNode(int p) {
         data = p;
         left = null;
         right = null;
      }
   }
}