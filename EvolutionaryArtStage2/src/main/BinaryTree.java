package main;

import main.Point;

import java.util.ArrayList;
import java.util.Iterator;

public class BinaryTree {
	
	protected  BinaryTreeNode<Point> root;

	// constructs an empty tree
	public BinaryTree(){
		root = null;
	}
	
	// constructs a tree with just a root node
	public BinaryTree(Point element){
		root = new BinaryTreeNode<Point>(element);
	}
	
	// reset the tree to empty state
	public void clear(){
		root = null;
	}
	
	
	public Point find(Point oldPoint){
		return find(oldPoint, root).element;
	}
	
	protected BinaryTreeNode<Point> find(Point oldPoint, BinaryTreeNode<Point> t){
		// if this node is the one we are looking for: return it
		if(t!=null)
		{
			if(t.element.getID() == oldPoint.getID())
			{
				return t;
			}
			else // else: call this method for the left and right nodes
			{
				find(oldPoint,t.left);
				find(oldPoint,t.right);
			}
		}
		return null;
		
		
		}
	
	protected void insert(Point oldPoint, BinaryTreeNode<Point> t){
		// use find to locate the parent node we want to add in, if left is empty add it there else add it to right
		if(find(oldPoint,t).left != null)
		{
			find(oldPoint,t).left = t; 
		}
		else
		{
			find(oldPoint,t).right = t;
		}
	}
	
//	public ArrayList<Line> getLineInformation(){
//		ArrayList<Line> lines = new ArrayList<Line>();
//		
//		if(root != null){
//			lines.add(root);
//		}
//			
//		return lines;
//	}
	
	protected static class BinaryTreeNode<Point> {
		
		public Point element;
		public BinaryTreeNode<Point> left;
		public BinaryTreeNode<Point> right;
		
		// Constructor for creating a leaf node
		public BinaryTreeNode(Point element){
			this.element = element;
			left = null; 
			right = null; // no children
		}
		
		// Constructor for creating a parent node
		public BinaryTreeNode(Point element, BinaryTreeNode<Point> left, BinaryTreeNode<Point> right){
			this.element = element;
			this.left = left; 
			this.right = right;
		}
		
		public boolean isLeaf(){
			// will only be true if both nodes are null
			return (left == null && right == null);
		}
		
	}

}
