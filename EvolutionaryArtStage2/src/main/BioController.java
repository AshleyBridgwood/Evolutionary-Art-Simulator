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
		
		Save.saveBiomorph("Test", "1841653102515205");
		
		new BioCache();
		Log.add("BioCache Initiated");
		Log.exportLogToFile();
	}
	
}

