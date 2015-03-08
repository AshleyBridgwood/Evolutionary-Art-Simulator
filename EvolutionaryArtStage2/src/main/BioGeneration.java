/**
 * DESCRIPTION OF THE CLASS
 * 
 * @author Ashley Bridgwood
 *
 */

package main;

import java.util.ArrayList;

public class BioGeneration {
	
	private Gene g0;
	private Gene g1;
	private Gene g2;
	
	private String seed; //Seed Structure: {SEED; PARENT; CHILD1; CHILD2; CHILD3; CHILD4; CHILD5, CHILD6; CHILD7; CHILD8; CHILD9;}
	private String bioData;
	
	public BioGeneration(Biomorph b){
		//Take values out of the biomorph passed in
		g0 = b.getGenes().get(0);
		g1 = b.getGenes().get(1);
		g2 = b.getGenes().get(2);
		seed = b.getSeed();
		
		//Set the bioData value
		bioData = "";
		
		//Set the first value in the bioData (The seed)
		bioData = seed + ":";
		
		//Generate the parent biomorph data
		
		//recursively generate points and their children for the amount of branching
		// (which is currently gene 2)
		
		
		//Generate the children biomorph data (9 of them)
		
		
		
	}
	
	
	
	public String getBioData(){
		return bioData;
	}
	
	
	
	
}
