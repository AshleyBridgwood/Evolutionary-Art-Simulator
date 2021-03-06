/**
 * DESCRIPTION OF THE CLASS
 * 
 * @author James Langford
 * @author Ashley Bridgwood
 *
 */

package model;

public class Gene {
	
	private int g; //Gene value
	
	public Gene() {
		g = Factory.generateGeneValue(); 
	}
	
	public Gene(boolean isBranch) {
		g = Factory.generateBranchValue(); 
	}
	
	public int getValue(){
		return g;
	}
	
	public void setValue(int g){
		this.g = g;
	}
}
