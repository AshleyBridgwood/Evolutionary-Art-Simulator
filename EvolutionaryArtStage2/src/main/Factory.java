/**
 * DESCRIPTION OF THE CLASS
 * 
 * @author Ashley Bridgwood
 *
 */

package main;

import java.util.Random;

public class Factory {
	
	private static Random r;
	
	/**
	 * Generate random numbers for setting gene values
	 * @return int
	 */
	public static int generateGeneValues(){
		r = new Random();
		int value;
		
		do{
			value = r.nextInt(7) -3;
		} while(value == 0);
		
		return value;	
	}
}
