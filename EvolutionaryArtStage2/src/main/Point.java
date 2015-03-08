/**
 * DESCRIPTION OF THE CLASS
 * 
 * @author Ashley Bridgwood
 *
 */

package main;

public class Point {
	int x;
	int y;
	Point leftChild;
	Point rightChild;
	
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void setLeftChild(int x, int y)
	{
		leftChild = new Point(x,y);
	}
	
	public void setRightChild(int x, int y)
	{
		rightChild = new Point(x,y);
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}

}
