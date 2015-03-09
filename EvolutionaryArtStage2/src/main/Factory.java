/**
 * DESCRIPTION OF THE CLASS
 * 
 * @author Ashley Bridgwood
 * @author Matthew Gould
 */

package main;

import java.util.Random;

public class Factory {

	private static Random rnd = new Random();
	private static int value;
	
	// generates random seed for project
	public static long generateSeed() {
		long seed = System.currentTimeMillis();
		rnd.setSeed(seed);
		return seed;
	}

	// assigns custom seed for project
	public static long generateSeed(long customSeed) {
		rnd.setSeed(customSeed);
		return customSeed;
	}

	/**
	 * Generate random numbers for setting gene values
	 * 
	 * @return int
	 */
	public static int generateGeneValues() {
		do {
			value = rnd.nextInt(7) - 3;
		} while (value == 0);

		return value;
	}
}
