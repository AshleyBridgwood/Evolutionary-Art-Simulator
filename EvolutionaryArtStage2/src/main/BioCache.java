/**
 * DESCRIPTION OF THE CLASS
 * 
 * @author Ashley Bridgwood
 *
 */

package main;

public class BioCache {

	private static Object[] stack;
	private static int defaultValue;
	private static int top;
	
	public BioCache() {
		top = -1;
		defaultValue = 15;
		stack = new Object[defaultValue];
	}
	
	public static void push(Object newValue){
		stack[++top] = newValue;
		Log.add("Biomorph data added to the cache");
	}
	
	public static Object pop(){
		Log.add("Biomorph data removed from the cache");
		return stack[top--];
	}
	
	public static boolean isEmpty(){
		return (top == -1);
	}
	
	public static boolean isFull(){
		return (top == defaultValue -1);
	}
	
	public static Object peek(){
		return stack[top];
	}
	
	public static int getNumberOfItemsOnStack(){
		return top;
	}
}
