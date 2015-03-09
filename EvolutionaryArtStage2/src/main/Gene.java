/**
 * DESCRIPTION OF THE CLASS
 * 
 * @author Ashley Bridgwood
 *
 */

package main;

public class Gene {
	private int g;
	
	public Gene(int seed) {
		g = Factory.generateGeneValues(seed); 
	}
	
	public int getValue(){
		return g;
	}
	
	public void setValue(int g){
		this.g = g;
	}
	


}
