package main;

import main.Point;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tree {
	
	protected TreeNode<Point> root;

	// constructs an empty tree
	public Tree(TreeNode<Point> root){
		this.root = root;
	}
	
	
	// reset the tree to empty state
	public void clear(){
		root = null;
	}
	
	//Gets the root
	public TreeNode<Point> getRoot(){
		return root;
	}
	
	public boolean exists(int key){
		return find(root, key);
	}
	
	private boolean find(TreeNode<Point> node, int key){
		boolean result = false;
		if(node.element.getID() == key){
			result = true;
		} else {
			for(TreeNode<Point> child : node.getChildren()){
				if(find(node, key)){
					result = true;
				}
			}
		}
		return result;
	}
	
	
	public ArrayList<TreeNode<Point>> getPreOrderTraversal(){
		ArrayList<TreeNode<Point>> list = new ArrayList<TreeNode<Point>>();
		buildPreOrder(root, list);
		return list;
	}
	
	private void buildPreOrder(TreeNode<Point> node, ArrayList<TreeNode<Point>> preOrder){
		preOrder.add(node);
		for(TreeNode<Point> child : node.getChildren()){
			buildPreOrder(child, preOrder);
		}
	}
	
	public TreeNode<Point> findTreeNode(TreeNode<Point> node, int key){
		if(node== null){
			return null;
		}
		
		if(node.element.getID() == key){
			return node;
		} else {
			TreeNode<Point> newNode = null;
			for(TreeNode<Point> child : node.getChildren()){
				if((newNode = findTreeNode(child, key)) != null){
					return newNode;
				}
			}
		}
		return null;
	}
	
	

	
	public ArrayList<Line> getLineInformation(){
		ArrayList<Line> lines = new ArrayList<Line>();
		
		if(root != null){
			
		}
			
		return lines;
	}
	
	protected static class TreeNode<Point> {
		
		private Point element;
		private List<TreeNode<Point>> children;
		private TreeNode<Point> parent;
		
		// Constructor for creating a leaf node
		public TreeNode(Point element){
			this.element = element;
			children = new ArrayList<TreeNode<Point>>();
		}
		
		// Constructor for creating a parent node
		public TreeNode(TreeNode<Point> node){
			this.element = node.element;
			children = new ArrayList<TreeNode<Point>>();
		}
		
		public void setElement(Point element){
			this.element = element;
		}
		
		public Point getElement(){
			return element;
		}
		
		public void addChild(TreeNode<Point> child){
			child.setParent(this);
			children.add(child);
		}
		
		public TreeNode<Point> getParent(){
			return this.parent;
		}
		
		public List<TreeNode<Point>> getChildren(){
			return this.children;
		}
		
		public void setChildren(List<TreeNode<Point>> children){
			for(TreeNode<Point> child : children){
				child.setParent(this);
			}
			this.children = children;
		}
		
		
		public void setParent(TreeNode<Point> parent){
			this.parent = parent;
		}
		
	}

}
