/**
 * DESCRIPTION OF THE CLASS
 * 
 * @author Ashley Bridgwood
 *
 */

package main;

public class BioController {
	
/*
 * Notes - DO NOT REMOVE
 * 
 * Class needs to do the following:
 * - Start the UI
 * - Check if directory file is there
 * - Link to BioGeneration and file handler
 */

	public BioController() {
		Log.add("Bio Controller Initiated");
	
		FileHandler.checkForMainWorkingFolder();
		Log.exportLogToFile();
	}
	
}

