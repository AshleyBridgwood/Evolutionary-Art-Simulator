/**
 * DESCRIPTION OF THE CLASS
 * 
 * @author Ashley Bridgwood
 *
 */

package main;

public class Point {
	int ID;
	int x;
	int y;
	
	public Point(int ID, int x, int y)
	{
		this.x = x;
		this.y = y;
		this.ID = ID;
	}
	
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public int getID()
	{
		return ID;
	}
	
	public String toString()
	{
		return ""+x+","+y+" : ";
	}

}
