/**
 * CS 145 Assignment 7
 * QuestionTree class (private class: QuestionNode)
 * This binary tree will grow bigger after learning
 * it allow user to load the previous game, play with it
 * and learn new things
 * it can also save the total game data in to ".txt" file
 * @author Po-I Wu
 * @version 20170603
 */

import java.util.*;
import java.io.*;

public class QuestionTree
{

  UserInterface my;
  private QuestionNode root;
  private int totalGames;
  private int wonGames;

  public QuestionTree (UserInterface ui)
  {
	  root = new QuestionNode("computer");		// default data
	  my = ui;
	  totalGames = 0;
	  wonGames = 0;
  }
  
  public void play()
  {
	  root = play(root);
	  totalGames++;
  }
  
  /*
   * play game
   * keep asking question
   * if there is nothing below
   * then call learn method to learn new things
   */
  private QuestionNode play(QuestionNode node) {
	  if(node.notThingBelow()) {
		  my.print("Would your object happen to be " + node + "?");
		  if(my.nextBoolean()) {
			  my.println("I win!");
			  wonGames++;
		  } else {
			  node = learn(node);	// call learn method to add new things
		  }
	  } else {	// keep asking questions
		  my.print(node.toString());
		  if(my.nextBoolean()) {
			  node.left = play(node.left);
		  } else {
			  node.right = play(node.right);
		  }
	  }
	  return node;
  }
  
  /*
   * learn new things
   * return the node(after learning) to original node
   */
  private QuestionNode learn(QuestionNode node) {
	  my.print("I lose. What is your object? ");
	  String userObject = my.nextLine();
	  QuestionNode theAnswer = new QuestionNode(userObject);
	  my.print("Type a yes/no question to distinguish your item from " + node + " : ");
	  String userQuestion = my.nextLine();
	  my.print("And what is the answer for your object?");
	  if(my.nextBoolean()) {	// determine user's answer and put the answer or question to the node
		  node = new QuestionNode(theAnswer, node, userQuestion);
	  } else {
		  node = new QuestionNode(node, theAnswer, userQuestion);
	  }
	  return node;
  }
  
  public void save(PrintStream output)
  {
	  save(output, root);
  }
  
  // save the tree data in preorder
  private void save(PrintStream output, QuestionNode node) {
	  if(node.notThingBelow()) {
		  output.println("A:" + node);
	  } else {		// if it is a question, keep going down
		  output.println("Q:" + node);
		  save(output, node.left);
		  save(output, node.right);
	  }
  }
  
  public void load(Scanner input)
  {	
	  if(input == null) throw new IllegalArgumentException("Input is null");
	  root = load(input, root);
  }
  
  /*
   * load the previous game
   * determine if it is an answer or a question
   */
  private QuestionNode load(Scanner input, QuestionNode node) {
	  if(input.hasNextLine()) {
		  String nextLine = input.nextLine();	// the whole line
		  String type = nextLine.substring(0,1);	// Q or A
		  String data = nextLine.substring(2);		// the content
		  QuestionNode newRoot = new QuestionNode(data);
		  if(type.equals("Q")) {	// if it is Q, keep going down
			  newRoot.left = load(input, node);
			  newRoot.right = load(input, node);
		  }
		  return newRoot;
	  }
	  return node;
  }
  
  public int totalGames()
  {
    return totalGames;
  }
  
  public int gamesWon()
  {
    return wonGames;
  }
  
  /*
   * QuestionNode
   * private class
   * it has left node, right node, and data
   */
  private class QuestionNode {
	  
	  public QuestionNode left;
	  public QuestionNode right;
	  private String data;
	  
	  public QuestionNode(String data) {
		  this.data = data;
	  }
	  
	  public QuestionNode(QuestionNode left, QuestionNode right, String data) {	// for switching yes, no
		  this.left = left;
		  this.right = right;
		  this.data = data;
	  }
	  
	  // left and right are null return true (answer)
	  // otherwise return false
	  public boolean notThingBelow() {
		  if(left == null && right == null) return true;
		  else return false;
	  }
	  
	  public String toString() {
		  return data;
	  }
  }
}