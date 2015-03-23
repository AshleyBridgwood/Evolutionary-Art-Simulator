package main;

import main.Point;

import java.util.Iterator;

public class BinaryTree {
	
	protected BinaryTreeNode<Point> root;

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
		while(t!=null){
			// if t.element is what we are looking for
			if(){
				
			}
			
		}
		return null;
	}
	
	protected BinaryTreeNode<Point> insert(Point oldPoint, BinaryTreeNode<Point> t){
		if(){
			t = new BinaryTreeNode<Point>(oldPoint);
		} else if(false){
			t.left = insert(oldPoint,t.left);
		} else if(false){
			t.right = insert(oldPoint,t.right);
		} else {
			//throw exception
		}
		return null;
	}
	
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
