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
		
		new BioCache();
		Log.add("BioCache Initiated");
		Log.exportLogToFile();
	}
	
}

