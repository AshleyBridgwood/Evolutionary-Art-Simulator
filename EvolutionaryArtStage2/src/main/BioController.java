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
		System.out.println("First Data: " + biomorphs.get(0).get(0).toString());
		//BioCache.push(biomorphs);
		
		new UserInterface().getFrame().setVisible(true);
		Log.add("User Interface Initiated");	
	}
	
	public static void nextRandomBiomorph(){
		new BioGeneration(newBiomorph());
		biomorphs = BioGeneration.getAllBiomorphs();
		System.out.println("Second Data: " + biomorphs.get(0).get(0).toString());
		System.out.println("New Biomorph Created");
		//BioCache.push(biomorphs);
	}
	
	public static BioDraw displayParent(){
		return new BioDraw(biomorphs.get(0), false);
	}
	
	public static BioDraw displayChildren(int childNumber){
		return new BioDraw(biomorphs.get(childNumber), true);
	}
	
	public static Biomorph newBiomorph(){
		Biomorph b = new Biomorph();
		return b;
	}
	
	public void exportLogToFile(){
		Log.exportLogToFile();
	}
	
}