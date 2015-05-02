/**
 * Tree implementation for use creating each Biomorph
 * 
 * @author Ashley Bridgwood
 *
 */

package model;

import model.Point;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tree {
	
	protected TreeNode<Point> root; //stores the root node

	/**
	 * Constructs and empty tree
	 * @param root Sets the root not of the tree
	 */
	public Tree(TreeNode<Point> root){
		this.root = root;
	}
	
	
	/**
	 * Clears the tree
	 */
	public void clear(){
		root = null;
	}
	
	/**
	 * Gets the root of the tree
	 * @return TreeNode<Point> The root node of the tree
	 */
	public TreeNode<Point> getRoot(){
		return root;
	}
	/**
	 * Checks to see if a given key exists within the tree
	 * @param key Key to search - ID of the node
	 * @return Boolean True if found, false if not
	 */
	public boolean exists(int key){
		return find(root, key);
	}
	
	/**
	 * Checks to see if a given key is in a given node
	 * @param node Tree node which needs searching
	 * @param key Find the key within the tree
	 * @return Boolean True if found, false if not
	 */
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
	
	/**
	 * Gets the tree in an order
	 * @return ArrayList<TreeNode<Point>> The ordered tree
	 */
	public ArrayList<TreeNode<Point>> getPreOrderTraversal(){
		ArrayList<TreeNode<Point>> list = new ArrayList<TreeNode<Point>>();
		buildPreOrder(root, list);
		return list;
	}
	
	/**
	 * Sorts the tree in an order
	 * @param node Is the node which needs sorting
	 * @param preOrder The existing order tree
	 */
	private void buildPreOrder(TreeNode<Point> node, ArrayList<TreeNode<Point>> preOrder){
		preOrder.add(node);
		for(TreeNode<Point> child : node.getChildren()){
			buildPreOrder(child, preOrder);
		}
	}
	
	/**
	 * Finds and returns a tree node
	 * @param node Node to search
	 * @param key Key to find within the tree
	 * @return TreeNode<Point> the node which needed to be found
	 */
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
	
	//Inner class for the TreeNode
	public static class TreeNode<Point> {
		
		private Point element; //Data which is stored within each TreeNode
		private List<TreeNode<Point>> children; //A list of all children which are connected to the TreeNode
		private TreeNode<Point> parent; //Parent TreeNode of the current TreeNode
		private int numberOfChildren; //Number of children which the TreeNode has
		
		/**
		 * Constructor for the new TreeNode
		 * @param element 
		 */
		public TreeNode(Point element){
			this.element = element;
			children = new ArrayList<TreeNode<Point>>();
		}
		
		/**
		 * Constructor for a new TreeNode
		 * @param node Set the new node the same as the node passed in
		 */
		public TreeNode(TreeNode<Point> node){
			this.element = node.element;
			numberOfChildren = 0;
			children = new ArrayList<TreeNode<Point>>();
		}
		
		/**
		 * Sets the element within the TreeNode
		 * @param element Data which needs to be set
		 */
		public void setElement(Point element){
			this.element = element;
		}
		
		/**
		 * Gets the element out of the TreeNode
		 * @return the element out of the TreeNode
		 */
		public Point getElement(){
			return element;
		}
		
		/**
		 * Adds a child to the TreeNode
		 * @param child Child TreeNode which needs adding to the TreeNode
		 */
		public void addChild(TreeNode<Point> child){
			child.setParent(this);
			children.add(child);
			numberOfChildren++;
		}
		
		/**
		 * Gets the parent from the TreeNode
		 * @return the parent from the TreeNode
		 */
		public TreeNode<Point> getParent(){
			return this.parent;
		}
		
		/**
		 * Gets the child from the TreeNode
		 * @return a list of TreeNode containing the children
		 */
		public List<TreeNode<Point>> getChildren(){
			return this.children;
		}
		
		/**
		 * Sets the children of the TreeNode
		 * @param children List of children which will be assigned to the TreeNode
		 */
		public void setChildren(List<TreeNode<Point>> children){
			for(TreeNode<Point> child : children){
				child.setParent(this);
			}
			this.children = children;
		}
		
		/**
		 * Sets the parent of the TreeNode
		 * @param parent TreeNode to be set as the Parent of the TreeNode
		 */
		public void setParent(TreeNode<Point> parent){
			this.parent = parent;
		}
	}
}
