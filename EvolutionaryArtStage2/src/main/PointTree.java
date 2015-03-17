package main;

import java.util.ArrayList;

public class PointTree {
	
	// the root of the point tree.
	private Node<Point> root; 
	
	
	public PointTree(Point p, int ID){
		
		root = new Node<Point>(p, ID);	// initialise the root of the tree data structure
		
	}
	
	public void addNode(int ID, Point newPoint1, Point newPoint2)
	{
		int n1ID = ID+1;
		int n2ID = ID+2;
		Node<Point> n1 = new Node<Point>(newPoint1,n1ID);
		Node<Point> n2 = new Node<Point>(newPoint2,n2ID);
		
		// if these are the first children, add them to the root.
		if (root.getChildren().isEmpty())
		{
			root.add(newPoint1,n1ID, newPoint2,n2ID);
		}
		
		else
		{
			find(ID,root).add(newPoint1, n1ID, newPoint2, n2ID);
		}
		
		
		
	}
	
	public Point find(int target)
	{
		Node<Point> tmp = find(target, root);
		if (tmp == null) return null;
		else return tmp.getPoint();
	}
	
	protected Node<Point> find(int target, Node<Point> point)
	{
		if (point == null) return null;
		else if(target == (point.getPoint().getID()))
		{
			return point;
		}
		
		Node<Point> tmp = find(target, point.getChildren().get(1));
		return tmp;
			}
	
	public Point getRoot()
	{
		return root.getPoint();
	}
	

	
	public static class Node<Point> 
	{
		//S point object
		public Point point;
		// the collection of nodes this node keeps track of as children
		public ArrayList<Node<Point>> children;
		public int ID;
		
		
				
		public Node(Point p,int ID) 
		{
			point = p;
			children = new ArrayList<Node<Point>>();
			this.ID = ID;
		}
		
		public void add(Point p1, int p1ID, Point p2, int p2ID)
		{
			Node<Point> n1 = new Node<Point>(p1, p1ID);
			Node<Point> n2 = new Node<Point>(p2, p2ID);
			
			if(children.get(0)==null && children.get(1)==null )
			{
				children.add(n1);
				children.add(n2);
			}
			else 
			{
				for(Node<Point> n : children)
				{
					children.add(n1);
					children.add(n2);
				}
			}
		}
		
		public ArrayList<Node<Point>> getChildren()
		{
			return children;
		}
		
		
		public String toString()
		{
			String output = "";
			for(Node<Point> n : children)
			{
				output += n.getPoint().toString();
				ArrayList<Node<Point>> newList = n.getChildren();
				for(Node<Point> m : newList)
				{
					output += m.getPoint().toString();
				}
				
			}
			return output;
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
