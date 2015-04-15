/**
 * DESCRIPTION OF THE CLASS
 * 
 * @author Ashley Bridgwood
 *
 */

package main;

public class BioController {
	
	public BioController() {
		Log.add("Bio Controller Initiated");
		FileHandler.checkForMainWorkingFolder();
		
		//new UI(); <-- commented to speed up testing
		//Log.add("User Interface Initiated");
		
		//Start the start screen.
		new BioGeneration(newBiomorph());
		
			
	}
	
	/**
	 * Creates a new biomorph
	 * @return Biomorph
	 */
	public Biomorph newBiomorph(){
		Biomorph b = new Biomorph();
		return b;
	}
	
	public void exportLogToFile(){
		Log.exportLogToFile();
	}
	
}

