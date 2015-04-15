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

import main.Tree.TreeNode;

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
		
		//Generate the parent biomorph data
		makeBiomorph();
		
		//recursively generate points and their children for the amount of branching
		// (which is currently gene 2)
		
		
		//Generate the children biomorph data (9 of them)
		
			
	}
	
	public void makeBiomorph(){
		int branching = 2;
		int treeId = 1;
		
		//Creating the root node (TOP NODE) - Always needs to be created
		Point data = new Point(0,123,321);
		TreeNode<Point> root = new TreeNode<Point>(data);
		Tree biomorphTree = new Tree(root);
		
		if(branching == 1){
			TreeNode<Point> child1 = new TreeNode<Point>(new Point(1,1,1));
			biomorphTree.root.addChild(child1);
			TreeNode<Point> child2 = new TreeNode<Point>(new Point(2,2,2));
			biomorphTree.root.addChild(child2);
			TreeNode<Point> child3 = new TreeNode<Point>(new Point(3,3,3));
			biomorphTree.root.addChild(child3);
		} else {
			
			branching++;
		}
			ArrayList<TreeNode<Point>> finalTree = biomorphTree.getPreOrderTraversal();
			
			for(int i = 0; i < finalTree.size(); i++){
				System.out.println("ID: " + finalTree.get(i).getElement().getID());
				System.out.println("X: " + finalTree.get(i).getElement().getX());
				System.out.println("Y: " + finalTree.get(i).getElement().getY());
				System.out.println("------------------");
			}
	}
			
	// I don't think this method will work straight away but when we implement a draw function
	// it will be easier for us to visualise what this produces and how we can change it.
	// I'm presuming this will only generate a certain branch of the bio-morph.
	
	/**public Tree makeTree(int branching, Point oldPoint)
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
		Tree bt = new Tree();
		
		if(branching == g0.getValue()){
			// make two new children and thats it.
			//addNode(bt, oldPoint, pointOne);
			//addNode(bt, oldPoint, pointTwo);			
		} else {
			// making of child1
			//Create the parent node
			//addNode(bt, oldPoint, pointOne);
			//Make the child off that node
			makeTree(branching, pointOne);
			
			
			// make child2 call recursive method
			// increment branching 
			//addNode(bt, oldPoint, pointTwo);
			makeTree(branching, pointTwo);
			branching++;
		}
		
		return bt;
		
	}
	*/
	//public 
	
	//NEW - BINARY TREE THOUGH
	/**
	public void addNode(BinaryTreeNode<Point> root, int key, Point newValue){
		BinaryTreeNode<Point> newNode = new BinaryTreeNode<Point>(newValue);
		
		if(root == null){
			root = newNode;
		} else {
			BinaryTreeNode<Point> focusNode = root;
			
			BinaryTreeNode<Point> parent;
			
			while(true){
				parent = focusNode;
				
				if(key < focusNode.element.getID()){
					focusNode = focusNode.left;
					
					if(focusNode == null){
						parent.left = newNode;
						return;
					}
				} else {
					focusNode = focusNode.right;
					
					if(focusNode == null){
						parent.right = newNode;
						return;
					}
				}
			}
		}
	}
	
	public BinaryTreeNode<Point> find(BinaryTreeNode<Point> p, Point pointToFind){
		BinaryTreeNode<Point> focusNode = p;
		
		while(focusNode.element.getID() != pointToFind.getID()){
			if(pointToFind.getID() < focusNode.element.getID()){
				focusNode = focusNode.left;
			} else {
				focusNode = focusNode.right;
			}
			
			if(focusNode == null){
				return null;
			}
		}
		return focusNode;
	}
	
	public void inOrderTraverseTree(BinaryTreeNode<Point> focusNode){
		if(focusNode != null){
			inOrderTraverseTree(focusNode.left);
			System.out.println("ID IS: " + focusNode.element.getID());
			
			inOrderTraverseTree(focusNode.right);
			System.out.println("ID IS: " + focusNode.element.getID());
		}
	}
	*/
	/**public void addNode(BinaryTreeNode<Point> bt, Point oldPoint, Point newPoint){
		//search through the tree for the old point
		BinaryTreeNode<Point> focusNode = find(bt, oldPoint);
		if(focusNode.right == null)
		{
			BinaryTreeNode<Point> newNode = null;
			newNode.element = newPoint;
			focusNode.right = newNode;
			
		} else {
			BinaryTreeNode<Point> newNode = null;
			newNode.element = newPoint;
			focusNode.left = newNode;
		}
		//add newPoint as left node
		//if left node is not null add it as right node.
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
			
		} else {
			BinaryTreeNode<Point> newNode = null;
			newNode.element = newPoint;
			focusNode.left = newNode;
		}
		//add newPoint as left node
		//if left node is not null add it as right node.
	}
	
	*/
	
	
	/**private <T> BinaryTreeNode<Point> find(BinaryTreeNode<Point> node, Point oldPoint){
		
		if(node == null){
			return null;	
		} else if(node.element.getID() == oldPoint.getID()){
			return node;
		} else {
			if(find(node.left, oldPoint).element.getID() == oldPoint.getID())
				
				{
				return node.left;
				}
			
			else if(find(node.right, oldPoint).element.getID() == oldPoint.getID())
				{
				return node.right;
				}
		} 
			
		return null;
	}
	*/
	//public Point find(Point oldPoint){
	//	return elementAt(oldPoint);
	//}
	
	//public Point elementAt(Point t){
	//	return t == null? null : t;
	//}
	
	//private Point elementAt(BinaryTreeNode<Point> t){
	//	return t == null ? null : t.element;
	//}
	
	//public Point find(BinaryTreeNode<Point> oldPoint){
		//return elementAt(oldPoint);
	//}	
	
	public String getBioData(){
		return bioData;
	}	
}
