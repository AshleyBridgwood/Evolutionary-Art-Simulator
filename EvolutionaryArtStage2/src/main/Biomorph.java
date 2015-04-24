/**
 * DESCRIPTION OF THE CLASS
 * 
 * @author Ashley Bridgwood
 * @author Matthew Gould
 * 
 * First value is branching, this must always be positive.
 * Right now there are only two other values, the second being length and the third being width.
 *
 */

package main;

import java.util.ArrayList;

public class Biomorph {
	ArrayList<Gene> genes = new ArrayList<Gene>();
	private long seed;

	public Biomorph() {
		String testStr = "\nThis bio-morphs genes are: ";
		Gene first_gene;

		this.seed = Factory.generateSeed();

		// generate first gene value
		first_gene = new Gene(true);
		genes.add(first_gene);

		// generate second and third gene values
		for (int i = 1; i < 3; i++) {
			Gene g = new Gene();
			genes.add(g);
		}

		// print gene values
		testStr += getStringGeneValues();
	}

	public long getSeed() {
		return seed;
	}

	public String getStringGeneValues() {
		String genesString = "";
		for (int i = 0; i < genes.size(); i++) {
			genesString = genesString + genes.get(i).getValue() + ", ";
		}
		return genesString;
	}

	public ArrayList<Gene> getGenes() {
		return genes;
	}
	
	public void changeGene(int index, int value)
	{
		genes.get(index).setValue(value);
	}
}
