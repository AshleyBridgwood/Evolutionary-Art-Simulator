package main;

import java.util.ArrayList;

public class PointTree {
	
	// the root of the point tree.
	private Node<Point> root;
	
	public PointTree(Point p){
		
		root = new Node<Point>(p);	// initialise the root of the tree data structure
		
	}
	
	public static class Node<Point> 
	{
		// point object
		public Point point;
		// the collection of nodes this node keeps track of as children
		public ArrayList<Node<Point>> children;
				
		public Node(Point p) 
		{
			children = new ArrayList<Node<Point>>();
			point = p;
		}
		
		/**
		 * Add a child to the collection of children nodes this object keeps track of.
		 * 
		 * @param n The component to add as a child node.
		 */
		public void addChild(Point n) 
		{
			Node<Point> newNode = new Node<Point>(n);
			children.add(newNode);
		}
			
		/**
		 * Retrieve the collection of child nodes this node keeps track of.
		 * 
		 * @return The children of this node.
		 */
		public ArrayList<Point> getChildren() 
		{
			ArrayList<Point> childPoints = new ArrayList<Point>();
			for (int i = 0; i < children.size(); i++) 
			{
				Point p = children.get(i).getPoint();
				childPoints.add(p);	
			}
			return childPoints;
		}
		
		
		/**
		 * Retrieve the point this node stores as an element.
		 * 
		 * @return The point stored in this node.
		 */
		public Point getPoint() 
		{
			return point;
		}
	}
	

}
