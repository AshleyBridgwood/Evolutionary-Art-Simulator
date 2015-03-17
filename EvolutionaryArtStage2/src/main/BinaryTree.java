package main;
import java.util.Iterator;

public class BinaryTree<T> implements Iterable<T> {
	
	protected BinaryTreeNode<T> root;

	// constructs an empty tree
	public BinaryTree() 
	{
		root = null;
	}
	
	// constructs a tree with just a root node
	public BinaryTree(T element) 
	{
		root = new BinaryTreeNode<T>(element);
	}
	
	// reset the tree to empty state
	public void clear() 
	{
		root = null;
	}
	
	@Override
	public Iterator<T> iterator() 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	

protected static class BinaryTreeNode<T> {
	
	public T element;
	public BinaryTreeNode<T> left;
	public BinaryTreeNode<T> right;
	
	// Constructor for creating a leaf node
	public BinaryTreeNode(T element)
	{
		this.element = element;
		left = null; 
		right = null; // no children
	}
	
	// Constructor for creating a parent node
	public BinaryTreeNode(T element, BinaryTreeNode<T> left, BinaryTreeNode<T> right) 
	{
		this.element = element;
		this.left = left; 
		this.right = right;
	}
	
	public boolean isLeaf() 
	{
		// will only be true if both nodes are null
		return (left == null && right == null);
	}
	
	
	}


}
