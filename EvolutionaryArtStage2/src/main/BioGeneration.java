/**
 * DESCRIPTION OF THE CLASS
 * 
 * @author Ashley Bridgwood
 * 
 * First value is branching, this must always be positive.
 * Right now there are only two other values, the second being length and the third being width.
 * Width is x axis, Length is y axis.
 *
 */

package main;

import java.util.ArrayList;

public class BioGeneration {
	
	private Gene g0;
	private Gene g1;
	private Gene g2;
	
	private int seed; 
	private String bioData; //bioData Structure: {SEED; PARENT; CHILD1; CHILD2; CHILD3; CHILD4; CHILD5, CHILD6; CHILD7; CHILD8; CHILD9;}
	
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
	
	public PointTree generate(Biomorph b){
		
		
		// create node thats root (0,0);
		Point root = new Point(0,0,0);
		//PointTree pt = new PointTree(root);
		//g1 is length(y), and g2 is width(x).
		
		
		
		//pt.add(new Point(0,0),new Point(0,0));
		
		//for amount of branches
		//iterate through children
		//iterate through childrens children adding new points according to the genes	
		//}
		return null;
		
	}
	
	
	
	
	public String getBioData(){
		return bioData;
	}



	public void paintComponent() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
