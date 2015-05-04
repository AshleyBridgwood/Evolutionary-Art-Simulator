/**
 * Save - Saves data to file
 * 
 * @author Ashley Bridgwood
 *
 */

package model;

import java.io.IOException;
import java.util.ArrayList;

import view.SaveBiomorph;

public class Save extends FileHandler {
	
	/**
	 * Saves a parent and children Biomorphs to file
	 * @param name The file name to be saved
	 * @param bioData Data which is passed to be saved
	 */
	public static void saveBiomorphs(String name, ArrayList<ArrayList<Line>> bioData){
		Log.add("Saving Biomorph...");
		try {
			FileHandler.saveObjectToFile("/Saved Biomorphs/" + name + ".biomorph", bioData);
			SaveBiomorph.saved(true);
		} catch (IOException e) {
			SaveBiomorph.saved(false);
		}
		Log.add("Biomorph saved: " + EvolutionaryArtFolderLocation + "\\Saved Biomorphs");
	}
	
	/**
	 * Saved a parent Biomorph to the hall of fame folder
	 * @param name The file name to be saved
	 * @param bioData Data which is passed to be saved
	 */
	public static void saveBiomorphToHallOfFame(String name, ArrayList<Line> bioData){
		try {
			FileHandler.saveBiomorphToHallOfFame("/Hall Of Fame/" + name + ".biomorph",  bioData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
