/**
 * Line - Stores the X and Y values of the start and end of the line which will be drawn on the panels.
 * Implements Serializable so that we can Serialize the class during the saving process 
 * 
 * @author Ashley Bridgwood
 * 
 */

package model;

import java.io.Serializable;

public class Line implements Serializable, Cloneable {

	private static final long serialVersionUID = 134125651624063636L;
	
	private int x1; //X coordinate of the start of the line
	private int y1; //Y coordinate of the start of the line
	private int x2; //X coordinate of the end of the line
	private int y2; //Y coordinate of the end of the line
	
	/**
	 * Constructor for creating a new line
	 * @param x1 X coordinate of the start of the line
	 * @param y1 Y coordinate of the start of the line
	 * @param x2 X coordinate of the end of the line
	 * @param y2 Y coordinate of the end of the line
	 */
	public Line(int x1, int y1, int x2, int y2){
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	/**
	 * Returns the X coordinate of the start of the line
	 * @return int 
	 */
	public int getX1(){
		return x1;
	}
	
	/**
	 * Returns the Y coordinate of the start of the line
	 * @return int 
	 */
	public int getY1(){
		return y1;
	}
	
	/**
	 * Returns the X coordinate of the end of the line
	 * @return int 
	 */
	public int getX2(){
		return x2;
	}
	
	/**
	 * Returns the Y coordinate of the end of the line
	 * @return int 
	 */
	public int getY2(){
		return y2;
	}
	
	/**
	 * Sets the X value of the start of the line
	 * @param change value to set the X
	 */
	public void setX1(int change){
		x1 = change;
	}
	
	/**
	 * Sets the Y value of the start of the line
	 * @param change value to set the Y
	 */
	public void setY1(int change){
		y1 = change;
	}
	
	/**
	 * Sets the X value of the end of the line
	 * @param change value to set the X
	 */
	public void setX2(int change){
		x2 = change;
	}
	
	/**
	 * Sets the Y value of the end of the line
	 * @param change value to set the Y
	 */
	public void setY2(int change){
		y2 = change;
	}
	
	/**
	 * Prints out all of the coordinates
	 */
	public String toString(){
		return x1 + ", " + y1 + ", " + x2 + ", " + y2;
	}
	
	/**
	 * Clones the Line
	 * @return Object A new line object
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new Line(x1, y1, x2, y2);
	}
}
