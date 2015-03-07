/**
 * DESCRIPTION OF THE CLASS
 * 
 * @author Ashley Bridgwood
 *
 */

package main;

import java.util.ArrayList;

public class Biomorph {
	Gene g1;
	Gene g2;
	Gene g3;
	String seed;
	
	public Biomorph() {
		g1 = new Gene();
		g2 = new Gene();
		g3 = new Gene();
		seed = "440460446534165";
	}
	
	public String getSeed(){
		return seed;
	}
	
	
	public String getStringGeneValue(){
		return g1.getValue() + ", " + g2.getValue() + ", " + g3.getValue();
	}
	
	public Gene getG1(){
		return g1;
	}
	
	public Gene getG2(){
		return g2;
	}
	
	public Gene getG3(){
		return g3;
	}
}
