/**
 * DESCRIPTION OF THE CLASS
 * 
 * @author Ashley Bridgwood
 *
 */

package main;

import java.util.Random;

public class Factory {
	public static int generateGeneValues(){
		Random r = new Random();
		int value;
		
		do{
			value = r.nextInt(3) -3;
		} while(value == 0);
		
		return value;	
	}
}
