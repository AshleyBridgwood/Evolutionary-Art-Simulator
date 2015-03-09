/**
 * DESCRIPTION OF THE CLASS
 * 
 * @author Ashley Bridgwood
 * @author Matthew Gould
 */

package main;

import java.util.Random;
// Maybe global seed variable?

public class Factory {

	private static Random rnd = new Random();
	private static int value;
	private static int branch;
	
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
	//TODO:need to work out how to use the seed in the random number generation.
	public static int generateGeneValues(int seed) {
		do {
			value = rnd.nextInt(7) - 3;
		} while (value == 0);

		return value;
	}
	
	public static int generateBranchValue(int seed){
		
		do {
			branch = generateGeneValues(seed);
			
	} while (branch<0);
		return branch;
	}
}
