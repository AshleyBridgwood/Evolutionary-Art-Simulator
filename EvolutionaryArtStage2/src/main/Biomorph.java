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
	
	public Biomorph() {
		g1 = new Gene();
		g2 = new Gene();
		g3 = new Gene();
	}
	
	//test only
	public String getGeneValue(){
		return g1.getValue() + ", " + g2.getValue() + ", " + g3.getValue();
	}
}
