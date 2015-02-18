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
		Log.exportLogToFile();
	}
	
}

