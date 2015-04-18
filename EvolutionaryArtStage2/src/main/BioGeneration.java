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
import java.util.Random;

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
		makeParentBiomorph();
		
		//Generate the children biomorph data (9 of them)
		
			
	}
	
	public ArrayList<Line> makeParentBiomorph(){
		int branching = g0.getValue();
		int currentNumberOfLegs = 0;
		int numberOfLegs = 10;
		int nodeId = 1;
		Random rand = new Random();
		//Creating the root node (TOP NODE) - Always needs to be created
		Point data = new Point(nodeId,0,0);
		nodeId++;
		TreeNode<Point> root = new TreeNode<Point>(data);
		Tree biomorphTree = new Tree(root);
		root.setParent(root);
		
		while(currentNumberOfLegs < numberOfLegs){
			TreeNode<Point> parentNode = null;
			int randomNum = rand.nextInt((nodeId - 1) + 1) + 1;
			parentNode = biomorphTree.findTreeNode(root, randomNum);
			System.out.println("Total number of nodes: " + nodeId);
			System.out.println("Parent Node: " + parentNode.getElement().getID());
			int x =  rand.nextInt((200-50) + 1) + 50;
			int y = rand.nextInt((200-50) + 1) + 50;
			
			TreeNode<Point> newNode = new TreeNode<Point>(new Point(nodeId, x, y));
			parentNode.addChild(newNode);
			nodeId++;

			currentNumberOfLegs++;
		}
			ArrayList<TreeNode<Point>> finalTree = biomorphTree.getPreOrderTraversal();
			String id_in_line = "";
			for(int i = 0; i < finalTree.size(); i++){
				System.out.println("ID: " + finalTree.get(i).getElement().getID());
				System.out.println("X: " + finalTree.get(i).getElement().getX());
				System.out.println("Y: " + finalTree.get(i).getElement().getY());
				System.out.println("Parent ID: " + finalTree.get(i).getParent().getElement().getID());
				System.out.println("------------------");
				id_in_line += finalTree.get(i).getElement().getID() + ", ";
			}
			System.out.println("Id's in-line: " + id_in_line);
			
			return generateLineInformation(finalTree);
	}
	
	public ArrayList<ArrayList<Line>> createChildren()
	{
		
		ArrayList<ArrayList<Line>> children = new ArrayList<ArrayList<Line>>();
		// for the amount of children 
		for(int i = 0; i<9; i++)
		{
			//make a copy of the tree
			ArrayList<Line> tempTree = makeParentBiomorph();
			
			//iterate through tree
			for(int j = 0; j<tempTree.size(); j++)
			{
				//chance it will mutate
				//when this is working need to change it so probabilities change according to slider.
				Random rand = new Random();
				int num = rand.nextInt(100);
				//if it does mutate change x or y by certain amount
				if(num <= 49)
				{
					//which point to change:
					int pointDecider = rand.nextInt(99)+1;
					if(pointDecider == 0 && pointDecider <= 25)
					{
						// change x1
						tempTree.get(j).setX1(tempTree.get(j).getX1() +2); //TODO: change "+2" to amount on slider.
						
					}
					else if(pointDecider > 25 && pointDecider <= 50)
					{
						// change y1
						tempTree.get(j).setY1(tempTree.get(j).getY1() +2); //TODO: change "+2" to amount on slider.
					}
					else if(pointDecider > 50  && pointDecider <= 75)
					{
						// change x2
						tempTree.get(j).setX2(tempTree.get(j).getX2() +2); //TODO: change "+2" to amount on slider.
					}
					else
					{
						//change y2
						tempTree.get(j).setY2(tempTree.get(j).getY2() +2); //TODO: change "+2" to amount on slider.
					}
				}
				
			}
			
			
			//add to list of trees.
			children.add(tempTree);
		}
		return children;
	}
	
	public ArrayList<Line> generateLineInformation(ArrayList<TreeNode<Point>> data){
		ArrayList<Line> lines = new ArrayList<Line>();
		
		for(int i = 0; i < data.size(); i++){
			int x1 = data.get(i).getElement().getX();
			int y1 = data.get(i).getElement().getY();
			int x2 = data.get(i+1).getElement().getX();
			int y2 = data.get(i+1).getElement().getY();
			lines.add(new Line(x1, y1, x2, y2));
		}
		
		return lines;
	}
			
	// I don't think this method will work straight away but when we implement a draw function
	// it will be easier for us to visualise what this produces and how we can change it.
	// I'm presuming this will only generate a certain branch of the bio-morph.
	
	/**
	 * 				//TreeNode<Point> child1 = new TreeNode<Point>(new Point(nodeId,1,1));
				//nodeId++;
				//root.addChild(child1);
				//TreeNode<Point> child2 = new TreeNode<Point>(new Point(2,2,2));
				//root.addChild(child2);
				//TreeNode<Point> child3 = new TreeNode<Point>(new Point(3,3,3));
				//root.addChild(child3);
				
				
				//TreeNode<Point> newNode = biomorphTree.findTreeNode(child3, 3);
				//TreeNode<Point> child4 = new TreeNode<Point>(new Point(4,9,9));
				//newNode.addChild(child4);
				
				//TreeNode<Point> newNode1 = biomorphTree.findTreeNode(child4, 4);
				//TreeNode<Point> child5 = new TreeNode<Point>(new Point(5,9,9));
				//newNode1.addChild(child5);
				
	 * 
	 * 
	 * 
	 * public Tree makeTree(int branching, Point oldPoint)
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
