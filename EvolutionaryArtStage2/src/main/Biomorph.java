/**
 * DESCRIPTION OF THE CLASS
 * 
 * @author Ashley Bridgwood
 *
 */

package main;

import java.util.ArrayList;

public class Biomorph {
	ArrayList<Gene> genes = new ArrayList<Gene>();
	String seed;
	
	public Biomorph() {
		String testStr = "\n This bio-morphs genes are: ";
		
		for(int i = 0; i<3; i++){
			Gene g = new Gene();
			genes.add(g);
			testStr += g.getValue()+", " ;
		}
		System.out.print(testStr);
		
		//seed = "440460446534165";
	}
	
	public String getSeed(){
		return seed;
	}
	
	
	public String getStringGeneValue(){
		return genes.get(0).getValue() + ", " + genes.get(0).getValue() + ", " + genes.get(0).getValue();
	}
	
	public ArrayList<Gene> getGenes(){
		return genes;
	}
}
