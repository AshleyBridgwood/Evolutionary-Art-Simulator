/**
 * Stores the parent and children biomorphs of each process in the program
 * 
 * @author Ashley Bridgwood
 *
 */

package model;

public class BioCache {

	private static Object[] stack; //Stores the stack used for the undo feature
	private static int defaultValue; //Number of undo's which the program allows
	private static int top; //Stores the number of items in the stack
	
	public BioCache() {
		//Initialise the fields
		top = -1;
		defaultValue = 1000;
		stack = new Object[defaultValue];
	}
	
	/**
	 * Pushes a new set of parent and children biomorphs onto the stack
	 * @param newValue Parent and child biomorphs to be added
	 */
	public static void push(Object newValue){
		stack[++top] = newValue;
	}
	
	/**
	 * Removes the data on the top of the stack
	 * @return Object The data which has been removed
	 */
	public static Object pop(){
		return stack[top--];
	}
	
	/**
	 * Checks to see if the stack is empty
	 * @return Boolean true is empty, false if not
	 */
	public static boolean isEmpty(){
		return (top == -1);
	}
	
	/**
	 * Checks to see if the stack is full
	 * @return Boolean true if full, false if not
	 */
	public static boolean isFull(){
		return (top == defaultValue -1);
	}
	
	/**
	 * Gets the top value of the stack without removing it
	 * @return Object The parent and children at the top of the stack
	 */
	public static Object peek(){
		return stack[top];
	}
	
	/**
	 * Gets the number of items which are on the stack
	 * @return int The numnber of items in the stack
	 */
	public static int getNumberOfItemsOnStack(){
		return top;
	}
	
	/**
	 * Gets the stack
	 * @return Object[] the current stack
	 */
	public static Object[] getStack(){
		return stack;
	}
}
