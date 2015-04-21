/**
 * DESCRIPTION OF THE CLASS
 * 
 * @author Ashley Bridgwood
 *
 */

package main;

import java.util.ArrayList;

public class BioController {
	static ArrayList<ArrayList<Line>> biomorphs;
	
	public BioController() {
		Log.add("Bio Controller Initiated");
		FileHandler.checkForMainWorkingFolder();
		
		
		
		
		//Start the start screen.
		new BioGeneration(newBiomorph());
		
		biomorphs = BioGeneration.getAllBiomorphs();
		new StartScreen();
		Log.add("User Interface Initiated");
		
		Log.exportLogToFile();
		
		
	}
	
	public static BioDraw displayParent(){
		return new BioDraw(biomorphs.get(0));
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

