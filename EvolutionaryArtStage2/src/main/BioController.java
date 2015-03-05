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
		Log.add("User Interface Initiated");
		
		//Testing biomorphs
		Biomorph b = new Biomorph();
		System.out.println(b.getGeneValue());
		
		Log.exportLogToFile();
	
		
	}
	
}

