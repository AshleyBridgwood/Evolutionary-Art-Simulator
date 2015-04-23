/**
 * DESCRIPTION OF THE CLASS
 * 
 * @author Ashley Bridgwood
 *
 */

package main;

import java.util.ArrayList;

public class BioController {
	private static ArrayList<ArrayList<Line>> biomorphs;
	private static int currentlySelectedToMutate;
	
	public BioController() {
		
		currentlySelectedToMutate = 0;
		new BioCache();
		
		Log.add("Bio Controller Initiated");
		FileHandler.checkForMainWorkingFolder();
		
		new StartScreen();
		Log.add("Start menu loaded");
	}
	
	public static void startMainScreen(){
		new UserInterface().getFrame().setVisible(true);
		Log.add("User Interface Initiated");	
	}
	
	public static void loadBiomorph(String fileName){
		biomorphs = Load.loadBiomorphs(fileName);
	}
	
	public static void saveCurrentBiomorphs(String name){
		//Save the parent, and the children
		Save.saveBiomorph(name, biomorphs);
	}
	
	public static void generateBiomorphs(){
		new BioGeneration(newBiomorph());
		Log.add("Generating new Biomorphs");
		//Get the newly generated biomorphs from the biogeneration class
		biomorphs = BioGeneration.getAllBiomorphs();
		BioCache.push(biomorphs);
		System.out.println("BioCache Size: " + BioCache.getNumberOfItemsOnStack());
		System.out.println("BioCache Data: " + biomorphs.get(0).get(1).toString());
	}

	public static BioDraw displayParent(){
		System.out.println("");
		return new BioDraw(biomorphs.get(0), false);
	}
	
	public static BioDraw displayChildren(int childNumber){
		return new BioDraw(biomorphs.get(childNumber), true);
	}
	
	public static void mutuateBiomorphOne(){
		System.out.println("CHILD SELECTED: " + currentlySelectedToMutate);
		ArrayList<Line> data = new ArrayList<Line>();
		data = biomorphs.get(currentlySelectedToMutate);
		
		biomorphs = BioGeneration.getChildrenFromParent(data);
	}
	
	public static void setNextToMutate(int data){
		currentlySelectedToMutate = data;
	}
	
	public static Biomorph newBiomorph(){
		Biomorph b = new Biomorph();
		return b;
	}
	
	@SuppressWarnings("unchecked")
	public static void undoOneBiomorph(){
		if(BioCache.getNumberOfItemsOnStack() > 0){
			BioCache.pop();
			biomorphs = (ArrayList<ArrayList<Line>>) BioCache.peek();
			System.out.println("UNDO - BioCache Size: " + BioCache.getNumberOfItemsOnStack());
			System.out.println("UNDO - BioCache Data: " + biomorphs.get(0).get(1).toString());
		}
	}
	
	public void exportLogToFile(){
		Log.exportLogToFile();
	}
	
}