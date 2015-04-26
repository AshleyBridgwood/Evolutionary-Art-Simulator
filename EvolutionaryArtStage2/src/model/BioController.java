/**
 * DESCRIPTION OF THE CLASS
 * 
 * @author Ashley Bridgwood
 *
 */

package model;

import java.io.IOException;
import java.util.ArrayList;

import view.StartScreen;
import view.UserInterface;

public class BioController {
	private static ArrayList<ArrayList<Line>> biomorphs;
	private static ArrayList<ArrayList<Line>> hallOfFameBiomorphs;
	private static int currentlySelectedToMutate;
	
	public BioController() {
		hallOfFameBiomorphs = new ArrayList<ArrayList<Line>>();
		biomorphs = new ArrayList<ArrayList<Line>>();
		currentlySelectedToMutate = 0;
		new BioCache(); //Start the cache for the undo feature

		Log.add("Bio Controller Initiated");
		FileHandler.checkForMainWorkingFolder();
		
		new StartScreen(); //Start the main menu screen
		Log.add("Start menu loaded");
	}
	
	public static void startMainScreen(){
		try {
			loadHallOfFameBiomorphs();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new UserInterface().getFrame().setVisible(true);
		Log.add("User Interface Initiated");
		
	}
	
	//Loading of a biomorph
	/**
	public static void loadBiomorphs(String fileName){
		biomorphs = Load.loadBiomorphs(fileName);
	}
	*/
	
	//Save the parent, and the children
	public static void saveCurrentBiomorphs(String name){
		Save.saveBiomorph(name, biomorphs);
	}
	
	public static void saveCurrentParentToHallOfFame() throws IOException{
		hallOfFameBiomorphs.add(biomorphs.get(0));
		Save.saveBiomorphToHallOfFame("b" + hallOfFameBiomorphs.size(), biomorphs.get(0));
	}
	
	public static void loadHallOfFameBiomorphs() throws IOException{
		for(int i = 1; i < FileHandler.getNumberOfHallOfFameBiomorphs(); i++){
			System.out.println("NUMBER OF HALL OF FAME INIT BROTHER: " + FileHandler.getNumberOfHallOfFameBiomorphs());
			hallOfFameBiomorphs.add(Load.loadHallOfFameBiomorph("b" + i));
		}
	}
	
	public static void generateBiomorphs(){
		new BioGeneration(newBiomorph());
		biomorphs = BioGeneration.getAllBiomorphs();
		BioCache.push(biomorphs);
	}
	
	public static BioDraw displayHallOfFameBiomorph(int number){
		return new BioDraw(hallOfFameBiomorphs.get(number), true);
	}

	public static BioDraw displayParent(){
		//System.out.println("Parent Displayed: " + biomorphs.get(0).toString());
		return new BioDraw(biomorphs.get(0), false);
	}
	
	public static BioDraw displayChildren(int childNumber){
		//System.out.println("Child " + childNumber + ": " + biomorphs.get(childNumber).toString());
		return new BioDraw(biomorphs.get(childNumber), true);
	}
	
	public static void mutuateBiomorphOne(){
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