/**
 * DESCRIPTION OF THE CLASS
 * 
 * @author Ashley Bridgwood
 *
 */

package main;

public class BioGeneration {
	
	private Gene g1;
	private Gene g2;
	private Gene g3;
	
	private String seed; //Seed Structure: {SEED; PARENT; CHILD1; CHILD2; CHILD3; CHILD4; CHILD5, CHILD6; CHILD7; CHILD8; CHILD9;}
	private String bioData;
	
	public BioGeneration(Biomorph b){
		//Take values out of the biomorph passed in
		g1 = b.getG1();
		g2 = b.getG2();
		g3 = b.getG3();
		seed = b.getSeed();
		
		//Set the bioData value
		bioData = "";
		
		//Set the first value in the bioData (The seed)
		bioData = seed + ":";
		
		//Generate the parent biomorph data
		
		//Generate the children biomorph data (9 of them)
		
		
	}
	
	public String getBioData(){
		return bioData;
	}
	
	
	
	
}
