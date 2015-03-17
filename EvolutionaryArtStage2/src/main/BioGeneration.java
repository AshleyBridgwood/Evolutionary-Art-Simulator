/**
 * DESCRIPTION OF THE CLASS
 * 
 * @author Ashley Bridgwood
 * 
 * First value is branching, this must always be positive.
 * Right now there are only two other values, the second being length and the third being width.
 * Width is x axis, Length is y axis.
 *
 */

package main;

import java.util.ArrayList;

import main.BinaryTree.BinaryTreeNode;

public class BioGeneration {
	
	private int tempID;
	
	private Gene g0;
	private Gene g1;
	private Gene g2;
	
	private long seed; 
	private String bioData; //bioData Structure: {SEED; PARENT; CHILD1; CHILD2; CHILD3; CHILD4; CHILD5, CHILD6; CHILD7; CHILD8; CHILD9;}
	
	public BioGeneration(Biomorph b){
		//Take values out of the biomorph passed in
		g0 = b.getGenes().get(0);
		g1 = b.getGenes().get(1);
		g2 = b.getGenes().get(2);
		seed = b.getSeed();
		
		//Set the bioData value
		bioData = "";
		
		//Set the first value in the bioData (The seed)
		bioData = seed + ":";
		
		//Generate the parent biomorph data
		
		
		//recursively generate points and their children for the amount of branching
		// (which is currently gene 2)
		
		
		//Generate the children biomorph data (9 of them)
		
		
		
	}
	
	// I don't think this method will work straight away but when we implement a draw function
	// it will be easier for us to visualise what this produces and how we can change it.
	// I'm presuming this will only generate a certain branch of the bio-morph.
	
	public BinaryTree makeChildren(int branching, Point oldPoint)
	{
		branching = 0;
		//point One is right point so:
		//Point one x = oldPoint x + value of gene 1.
		//Point one y = oldPoint y + value of gene 2.
		Point pointOne = new Point(tempID,oldPoint.getX()+g1.getValue(),oldPoint.getY()+g2.getValue());
		tempID++;
		
		//Point two x = oldPoint x - value of gene 1.
		//Point two y = oldPoint y + value of gene 2.
		Point pointTwo = new Point(tempID,oldPoint.getX()-g1.getValue(),oldPoint.getY()+g2.getValue());
		tempID++;
		
		// new binary tree
		BinaryTree<Point> bt = new BinaryTree<Point>();
		
		if(branching == g0.getValue())
		{
			// make two new children and thats it.
			addNode(oldPoint, pointOne);
			addNode(oldPoint, pointTwo);			
		}
		else
		{
			// make child1 call recursive method
			addNode(oldPoint, pointOne);
			makeChildren(branching, pointOne);
			
			
			// make child2 call recursive method
			// increment branching 
			addNode(oldPoint, pointTwo);
			makeChildren(branching, pointTwo);
			branching++;
		}
		
		return bt;
		
	}
	
	public void addNode(Point oldPoint, Point newPoint)
	{
		//search through the tree for the old point
		BinaryTreeNode<Point> focusNode = find(oldPoint);
		if(focusNode.right == null)
		{
			BinaryTreeNode<Point> newNode = null;
			newNode.element = newPoint;
			focusNode.right = newNode;
		}
		else 
		{
			BinaryTreeNode<Point> newNode = null;
			newNode.element = newPoint;
			focusNode.left = newNode;
		}
		//add newPoint as left node
		//if left node is not null add it as right node.
	}
	
	public BinaryTreeNode<Point> find(Point oldPoint)
	{
		int id = oldPoint.getID();
		return null;
	}
	
	
	
	public String getBioData(){
		return bioData;
	}



	public void paintComponent() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
