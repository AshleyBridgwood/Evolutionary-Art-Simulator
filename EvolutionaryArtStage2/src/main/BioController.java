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
		
		new StartScreen();
		Log.add("Start menu loaded");
	}
	
	public static void saveCurrentBiomorphs(String name){
		//Save the parent, and the children
		Save.saveBiomorph(name, biomorphs);
	}
	
	public static void start(){
		new BioGeneration(newBiomorph());
		Log.add("Generating new Biomorphs");
		
		//Get the newly generated biomorphs from the biogeneration class
		biomorphs = BioGeneration.getAllBiomorphs();
		
		new UserInterface().getFrame().setVisible(true);
		Log.add("User Interface Initiated");	
	}
	
	public static BioDraw displayParent(){
		return new BioDraw(biomorphs.get(0), false);
	}
	
	public static BioDraw displayChildren(int childNumber){
		return new BioDraw(biomorphs.get(childNumber), true);
	}
	
	/**
	 * Creates a new biomorph
	 * @return Biomorph
	 */
	public static Biomorph newBiomorph(){
		Biomorph b = new Biomorph();
		return b;
	}
	
	public void exportLogToFile(){
		Log.exportLogToFile();
	}
	
}

