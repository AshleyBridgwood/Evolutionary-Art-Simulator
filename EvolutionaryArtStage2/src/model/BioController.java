/**
 * DESCRIPTION OF THE CLASS
 * 
 * @author Ashley Bridgwood
 *
 */

package model;

import java.util.ArrayList;

import view.StartScreen;
import view.UserInterface;

public class BioController {
	private static ArrayList<ArrayList<Line>> biomorphs;
	private static ArrayList<ArrayList<Line>> hallOfFameBiomorphs;
	private static int currentlySelectedToMutate;
	
	public BioController() {
		hallOfFameBiomorphs = new ArrayList<ArrayList<Line>>();
		currentlySelectedToMutate = 0;
		new BioCache();
		
		//Load 3 hall of fame biomorphs here
		
		Log.add("Bio Controller Initiated");
		FileHandler.checkForMainWorkingFolder();
		
		new StartScreen();
		Log.add("Start menu loaded");
	}
	
	public static void startMainScreen(){
		new UserInterface().getFrame().setVisible(true);
		Log.add("User Interface Initiated");	
	}
	
	//Loading of a biomorph
	public static void loadBiomorphs(String fileName){
		biomorphs = Load.loadBiomorphs(fileName);
	}
	
	//Save the parent, and the children
	public static void saveCurrentBiomorphs(String name){
		Save.saveBiomorph(name, biomorphs);
	}
	
	public static void saveCurrentParentToHallOfFame(){
		hallOfFameBiomorphs.add(biomorphs.get(0));
		Save.saveBiomorphToHallOfFame("b" + hallOfFameBiomorphs.size(), biomorphs.get(0));
	}
	
	public static void loadHallOfFameBiomorph(String fileName){
		hallOfFameBiomorphs.add(Load.loadHallOfFameBiomorph(fileName));
	}
	
	public static void generateBiomorphs(){
		new BioGeneration(newBiomorph());
		Log.add("Generating new Biomorphs");
		//Get the newly generated biomorphs from the biogeneration class
		biomorphs = BioGeneration.getAllBiomorphs();
		BioCache.push(biomorphs);
		System.out.println("BioCache Size: " + BioCache.getNumberOfItemsOnStack());
	}
	
	public static BioDraw displayHallOfFame(int number){
		return new BioDraw(hallOfFameBiomorphs.get(number), true);
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
		System.out.println("CHILD 1 DATA: " + biomorphs.get(currentlySelectedToMutate).toString());
			System.out.println("BEFORE MUTATE DATA:" + biomorphs.get(currentlySelectedToMutate).toString());
		
		ArrayList<Line> data = new ArrayList<Line>();
		data = biomorphs.get(currentlySelectedToMutate);
		
		biomorphs = BioGeneration.getChildrenFromParent(data);
		System.out.println("New Parent DATA: " + biomorphs.get(0).toString());
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
	
	public static boolean isPanelPressed(){
		if(currentlySelectedToMutate == 0){
			return false;
		}
		return true;
	}
	
	public void exportLogToFile(){
		Log.exportLogToFile();
	}
	
}