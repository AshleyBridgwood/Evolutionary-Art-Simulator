/**
 * DESCRIPTION OF THE CLASS
 * 
 * @author Ashley Bridgwood
 * @author James Langford
 *
 */

package model;

public class Point {
	int ID;
	int x;
	int y;
	
	public Point(int ID, int x, int y){
		this.ID = ID;
		this.x = x;
		this.y = y;
	}
	
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getID(){
		return ID;
	}

	public String toString(){
		return ""+x+","+y+" : ";
	}

}
