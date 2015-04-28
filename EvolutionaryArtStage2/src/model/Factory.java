/**
 * Factory - Creates the values for producing the biomorphs
 * 
 * @author Ashley Bridgwood
 * @author Matthew Gould
 */

package model;

import java.util.Random;

public class Factory {

	private static Random rnd = new Random(); //Random number generator
	private static int value; //Stores the gene value
	private static int branch; //Stores the branch value

	/**
	 * Generates the seed
	 * @return long the randomly generated seed
	 */
	public static long generateSeed() {
		long seed = System.currentTimeMillis();
		rnd.setSeed(seed);
		return seed;
	}

	/**
	 * Generates the seed from a given seed
	 * @param customSeed custom seed to pass in
	 * @return long the seed
	 */
	public static long generateSeed(long customSeed) {
		rnd.setSeed(customSeed);
		return customSeed;
	}

	/**
	 * Generate random numbers for setting gene values
	 * 
	 * @return int
	 */
	public static int generateGeneValue() {
		do {
			value = rnd.nextInt(7) - 3;
		} while (value == 0);

		return value;
	}

	/**
	 * Generate the branch value
	 * @return int the randomly generated value
	 */
	public static int generateBranchValue() {

		do {
			branch = generateGeneValue();

		} while (branch < 0);
		return branch;
	}
}
