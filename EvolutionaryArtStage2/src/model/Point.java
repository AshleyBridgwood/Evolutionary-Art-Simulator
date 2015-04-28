/**
 * Point - Stores a ID, X and Y value, used for storing the data of the biomorph
 * 
 * @author Ashley Bridgwood
 * @author James Langford
 *
 */

package model;

public class Point {
	int ID; //Stores the ID of the Point
	int x; //Stores the X value of the Point
	int y; //Stores the Y value of the Point
	
	/**
	 * Constructor for creating a Point
	 * @param ID Unique ID
	 * @param x Pass in the X value
	 * @param y Pass in the Y value
	 */
	public Point(int ID, int x, int y){
		this.ID = ID;
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Gets the X value
	 * @return int X value
	 */
	public int getX(){
		return x;
	}
	
	/**
	 * Gets the Y value
	 * @return int Y value
	 */
	public int getY(){
		return y;
	}
	
	/**
	 * Gets the ID value
	 * @return int ID value
	 */
	public int getID(){
		return ID;
	}

	/**
	 * Prints out the X and Y values
	 * @return String Value of X and Y
	 */
	public String toString(){
		return ""+x+","+y+" : ";
	}
}
