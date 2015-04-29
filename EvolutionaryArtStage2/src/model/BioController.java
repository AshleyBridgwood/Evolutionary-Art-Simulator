/**
 * BioController - Links the user interface, the biomorph generation and file handling together. All of the
 * other classes speak to the controller, who then passes it to the User Interface if required.
 * 
 * @author Ashley Bridgwood
 * 
 */

package model;

import java.util.ArrayList;

import view.StartScreen;
import view.UserInterface;

public class BioController {
	private static ArrayList<ArrayList<Line>> biomorphs; //Stores the parent and child currently displaying on the UI
	private static ArrayList<ArrayList<Line>> hallOfFameBiomorphs; //Stores the biomorphs for the hall of fame
	private static int currentlySelectedToMutate; //Stores the ID of the next child to mutate
	
	public BioController() {
		//Initalise the starting fields
		hallOfFameBiomorphs = new ArrayList<ArrayList<Line>>();
		biomorphs = new ArrayList<ArrayList<Line>>();
		currentlySelectedToMutate = 0;
		
		new BioCache(); //Start the cache for the undo feature

		Log.add("Bio Controller Initiated");
		
		FileHandler.checkForMainWorkingFolder(); //Checks if Default folder has been generated. If not, create it
		
		new StartScreen(); //Start the main menu screen
		Log.add("Start menu loaded");
	}
	
	/**
	 * Loads the hall of fame biomorphs and starts the main user interface
	 */
	public static void startMainScreen(){
		loadHallOfFameBiomorphs();
		new UserInterface().getFrame().setVisible(true);
		Log.add("User Interface Initiated");
		
	}
	
	/**
	 * Saves the current parent and children to file
	 * @param fileName Name of the biomorph choosen by the user
	 */
	public static void saveCurrentBiomorphsToFile(String fileName){
		Save.saveBiomorphs(fileName, biomorphs);
		Log.add("Biomorph Successfully saved! (" + fileName + ".biomorph)");
	}
	
	/**
	 * Loads the a specified parent and children from file
	 * @param fileName Name of the file in need of loading
	 */
	public static void loadBiomorphsFromFile(String fileName){
		biomorphs = Load.loadAllBiomorphs(fileName);
	}
	
	/**
	 * Saves the current parent for use in the hall of fame
	 */
	public static void saveCurrentParentToHallOfFame(){
		Save.saveBiomorphToHallOfFame("b" + getCurrentHallOfFameNumber(), biomorphs.get(0));
		loadHallOfFameBiomorphs();
	}
	
	/**
	 * Loads in all of the files inside of the hall of fame folder
	 */
	public static void loadHallOfFameBiomorphs(){
		int numberToLoop = getCurrentHallOfFameNumber();
		for(int i = 0; i < numberToLoop; i++){
			hallOfFameBiomorphs.add(Load.loadHallOfFameBiomorph("b" + i));
		}
	}
	
	/**
	 * Generate a completely new parent and children biomorphs
	 */
	public static void generateBiomorphs(){
		new BioGeneration(newBiomorph());
		biomorphs = BioGeneration.getAllBiomorphs();
		BioCache.push(biomorphs);
	}
	
	/**
	 * Gets the current number of saved biomorphs in the hall of fame
	 * @return Number of biomorphs saved for use in the hall of fame
	 */
	public static int getCurrentHallOfFameNumber(){
		return FileHandler.getNumberOfHallOfFameBiomorphs();
	}
	
	/**
	 * Gets the number of saved biomorphs so they can be retrieved when on the load screen
	 * @return Number of biomorphs saved.
	 */
	public static int getNumOfSavedBiomorphs(){
		return FileHandler.getNumberOfSavedBiomorphs();
	}
	
	/**
	 * Displays the generated hall of fame biomorph
	 * @param number Represents both the childHOF number, and number within the hallOfFameBiomorphs array
	 * @return BioDraw The finished drawing of the biomorph
	 */
	public static BioDraw displayHallOfFameBiomorph(int number){
		return new BioDraw(hallOfFameBiomorphs.get(number), true);
	}
	
	/**
	 * Displays the parent biomorph
	 * @return BioDraw The finished drawing of the biomorph
	 */
	public static BioDraw displayParent(){
		return new BioDraw(biomorphs.get(0), false);
	}
	
	/**
	 * Displays the children biomorph
	 * @param childNumber Represents both the child number, and number within the biomorphs array
	 * @return BioDraw The finished drawing of the biomorph
	 */
	public static BioDraw displayChildren(int childNumber){
		return new BioDraw(biomorphs.get(childNumber), true);
	}
	
	/**
	 * Mutates the biomorph if only one child has been pressed
	 */
	public static void mutuateBiomorphOne(){
		ArrayList<Line> data = new ArrayList<Line>();
		data = biomorphs.get(currentlySelectedToMutate);
		biomorphs = null;
		biomorphs = BioGeneration.getChildrenFromParent(data);
		BioCache.push(biomorphs);
	}
	
	/**
	 * Clears the hall of fame biomorphs from file
	 */
	public static void clearHallOfFame(){
		int numberToLoop = getCurrentHallOfFameNumber();
		for(int i = 0; i < numberToLoop; i++){
			FileHandler.clearHallOfFameBiomorphs("b" + i);
			hallOfFameBiomorphs = null;
		}
	}
	
	/**
	 * Sets the next biomorph to be mutated
	 * @param data The ID of the next child to be mutated
	 */
	public static void setNextToMutate(int data){
		currentlySelectedToMutate = data;
	}
	
	/**
	 * Creates the basic values of a biomorph
	 * @return Biomorph Data
	 */
	public static Biomorph newBiomorph(){
		Biomorph b = new Biomorph();
		return b;
	}
	
	/**
	 * Sets the parent and children to the previously displayed parent and children
	 */
	@SuppressWarnings("unchecked")
	public static void undoOneBiomorph(){
		if(BioCache.getNumberOfItemsOnStack() > 0){
			BioCache.pop();
			biomorphs = (ArrayList<ArrayList<Line>>) BioCache.peek();
		}
	}
	
	/**
	 * Checks if the UI panel is pressed
	 * @return boolean If the panel is pressed or not
	 */
	public static boolean isPanelPressed(){
		if(currentlySelectedToMutate == 0){
			return false;
		}
		return true;
	}
	
	/**
	 * Exports the log to file
	 */
	public void exportLogToFile(){
		Log.exportLogToFile();
	}
	
}