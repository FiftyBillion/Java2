/**
 * Week 9 in class assignment
 * finish the rest method of BST
 * Eiditor: Po-I Wu
 * Date: 20170530
 */


import java.util.NoSuchElementException;

/****************************************************
 * Main Class MyBinaryTree
 ****************************************************/

public class MyBinaryTree<E extends Comparable<E> >
{


       /****************************************************
        * Helper Class TreeNode
        * Note that this is a class inside the tree
        ****************************************************/
        private class TreeNode<E>
        {
          public E payload;
          public TreeNode<E> left;
          public TreeNode<E> right;
          
          public TreeNode (E data)
          {
            payload = data;
          }
        }  


  // Root of the Main tree
  private TreeNode<E> root;
  
  /************************************
   * Constructor (Default)
   ************************************/
   
  public MyBinaryTree()
  {
    root = null;
  }
  
  /*****************************************************
   * toString Method (starter method)
   *****************************************************/
 
  public String toString()
  {
    if (root == null)
    {
      return "";
    }
    
    return toString(root);
  }

  /*****************************************************
   * toString Method (recursive method)
   *****************************************************/
  private String toString(TreeNode<E> tempRoot)
  {
     if (tempRoot == null)  return "";
     
     return toString(tempRoot.left) + " " 
          + tempRoot.payload.toString() + " " 
          + toString(tempRoot.right);
          
    
  }   
  /*****************************************************
   * printSideways Method (starter method)
   ***************************************************/
public void printSideways()
{
  if (root == null)
  {
     System.out.println("Null Tree");
     return;
  }
  printSideways(root,"");
}
  /*****************************************************
   * printSideways Method (recursive method)
   ***************************************************/

private void printSideways(TreeNode<E> tempRoot, String indent)
{
  if (tempRoot == null) return;  
  printSideways(tempRoot.right,"    "+indent);
  System.out.println(indent + tempRoot.payload.toString() );
  printSideways(tempRoot.left,"    "+indent);
}
  
  
  
  /*****************************************************
   * add Method (starter method)
   ***************************************************/
  public void add(E data)
  {
    root = add(root, data);
  }
  
  /*****************************************************
   * printSideways Method (recursive method)
   ***************************************************/

  
  private TreeNode<E> add(TreeNode<E> tempRoot, E data)
  {
      if (tempRoot == null)
      {
        TreeNode<E> temp = new TreeNode<E>(data);
        return temp;
      }
      
      if (tempRoot.payload.compareTo(data) > 0)
      {
        tempRoot.left = add(tempRoot.left,data);
      }
      if (tempRoot.payload.compareTo(data) < 0)
      {
        tempRoot.right = add(tempRoot.right,data);
      }          
      return tempRoot;
  }
  /*****************************************************
   * contains Method (starter method)
   ***************************************************/
  public boolean contains(E lookFor)
  {
    // Need to implement this.
    return contains(lookFor, root);
  }  
 
  /*****************************************************
   * contains Method (recursive method)
   ***************************************************/

  public boolean contains(E lookFor, TreeNode<E> temproot)
  {
    // need this to help with above
    if(temproot == null) return false;
    else {
       if(lookFor.compareTo(temproot.payload) == 0) return true;
       else if(lookFor.compareTo(temproot.payload) < 0) return contains(lookFor, temproot.left);
       else return contains(lookFor, temproot.right);
    }
  }   

  /*****************************************************
   * getMin Method (starter method)
   ***************************************************/
  public E getMin()
  {
    // Need to implement this.
    return getMin(root);
  }  
 
  /*****************************************************
   * remove Method (recursive method)
   ***************************************************/

  public E getMin(TreeNode<E> temproot)
  {
    // need this to help with above
    if(temproot == null) return null;
    else if(temproot.left == null) return temproot.payload;
    else return getMin(temproot.left);    // keep going left until the find the min
  }  

  /*****************************************************
   * remove Method (starter method)
   ***************************************************/
  public void remove(E lookFor)
  {
    // Need to implement this.
    root = remove(lookFor, root);  // pass the adress to the root
  }  
 
  /*****************************************************
   * remove Method (recursive method)
   ***************************************************/

  private TreeNode<E> remove(E lookFor, TreeNode<E> temproot)
  {
    // need this to help with above
    if(temproot == null) return temproot;
    else {
      if(lookFor.compareTo(temproot.payload) < 0)
         temproot.left = remove(lookFor, temproot.left);
      else if(lookFor.compareTo(temproot.payload) > 0)
         temproot.right = remove(lookFor, temproot.right);
      else if(temproot.left != null && temproot.right != null) {  // if 2 nodes
         temproot.payload = getMin(temproot.right);
         temproot.right = remove(temproot.payload, temproot.right);
      } else if(temproot.left != null) {  // if only left node
         temproot = temproot.left;
      } else if(temproot.right != null) { // if only right node
         temproot = temproot.right;
      } else {
         temproot = null;
      }
      return temproot;
    }
  }
  
  /*****************************************************
   * size Method (starter method)
   ***************************************************/
  public int size()
  {
    // Need to implement this.
    return size(root);
  }  
 
  /*****************************************************
   * size Method (recursive method)
   ***************************************************/

  public int size(TreeNode<E> temproot)
  {
    // need this to help with above
    if(temproot == null) return 0;
    else return 1 + size(temproot.left) + size(temproot.right); // add one and check left and right;
  }  
  
  public int countLeftChildren() {
   return countLeftChildren(root);
   }
   private int countLeftChildren(Node temproot) {
      if(temproot == null) return 0;
      if(temproot.left != null) return 1+countLeftChildren;
   }
}


