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

package model;

import java.util.ArrayList;

public class Biomorph {
	ArrayList<Gene> genes = new ArrayList<Gene>(); //Create a new arraylist of genes
	private long seed; //Stores the seed of creating the biomorph data

	/**
	 * Constructor for creating a new biomorph
	 */
	public Biomorph(){
		String testStr = "\nThis bio-morphs genes are: ";
		Gene first_gene;

		this.seed = Factory.generateSeed(); //Generate the seed value

		//generate first gene value
		first_gene = new Gene(true);
		genes.add(first_gene);

		//generate second and third gene values
		for (int i = 1; i < 3; i++){
			Gene g = new Gene();
			genes.add(g);
		}
		testStr += getStringGeneValues(); //print gene values
	}
	
	/**
	 * Gets the seed from the Biomorph
	 * @return long the seed
	 */
	public long getSeed(){
		return seed;
	}

	/**
	 * Gets the string value of the genes
	 * @return String gene value
	 */
	public String getStringGeneValues(){
		String genesString = "";
		for (int i = 0; i < genes.size(); i++) {
			genesString = genesString + genes.get(i).getValue() + ", ";
		}
		return genesString;
	}

	/**
	 * Gets the gene values
	 * @return ArrayList<Gene> gene values
	 */
	public ArrayList<Gene> getGenes() {
		return genes;
	}
	
	/**
	 * Changes the gene values
	 * @param index gene to change
	 * @param value sets the value of the gene
	 */
	public void changeGene(int index, int value){
		genes.get(index).setValue(value);
	}
}
