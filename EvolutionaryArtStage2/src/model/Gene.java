/**
 * DESCRIPTION OF THE CLASS
 * 
 * @author Ashley Bridgwood
 *
 */

package model;

public class Gene {
	private int g;
	private boolean branch = false;
	
	public Gene() {
		g = Factory.generateGeneValue(); 
	}
	
	public Gene(boolean isBranch) {
		g = Factory.generateBranchValue(); 
		branch = isBranch;
	}
	
	public int getValue(){
		return g;
	}
	
	public void setValue(int g){
		this.g = g;
	}
	


}
