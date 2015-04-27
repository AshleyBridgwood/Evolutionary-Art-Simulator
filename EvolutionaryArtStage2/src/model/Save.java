/**
 * DESCRIPTION OF THE CLASS
 * 
 * @author Ashley Bridgwood
 *
 */

package model;

import java.io.IOException;
import java.util.ArrayList;

public class Save extends FileHandler {
	
	public static void saveBiomorphs(String name, ArrayList<ArrayList<Line>> bioData){
		Log.add("Saving Biomorph...");
		try {
			saveObjectToFile("/Saved Biomorphs/" + name + ".biomorph", bioData);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//writeToFile("/Saved Biomorphs/" + name + ".biomorph", bioData);
		Log.add("Biomorph saved: " + EvolutionaryArtFolderLocation + "\\Saved Biomorphs");
	}
	
	public static void saveBiomorphToHallOfFame(String name, ArrayList<Line> bioData){
		try {
			FileHandler.saveBiomorphToHallOfFame("/Hall Of Fame/" + name + ".biomorph",  bioData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
