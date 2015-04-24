/**
 * DESCRIPTION OF THE CLASS
 * 
 * @author Ashley Bridgwood
 * @author Matthew Gould
 */

package model;

import java.util.Random;

// Maybe global seed variable?

public class Factory {

	private static Random rnd = new Random();
	private static int value;
	private static int branch;

	// generates random seed for a biomorph
	public static long generateSeed() {
		long seed = System.currentTimeMillis();
		rnd.setSeed(seed);
		return seed;
	}

	// assigns custom seed for a biomorph
	public static long generateSeed(long customSeed) {
		rnd.setSeed(customSeed);
		return customSeed;
	}

	/**
	 * Generate random numbers for setting gene values
	 * 
	 * @return int
	 */
	// TODO:need to work out how to use the seed in the random number
	// generation.
	public static int generateGeneValue() {
		do {
			value = rnd.nextInt(7) - 3;
		} while (value == 0);

		return value;
	}

	public static int generateBranchValue() {

		do {
			branch = generateGeneValue();

		} while (branch < 0);
		return branch;
	}
}
