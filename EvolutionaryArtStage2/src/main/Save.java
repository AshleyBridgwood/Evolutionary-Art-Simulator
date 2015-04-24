/**
 * DESCRIPTION OF THE CLASS
 * 
 * @author Ashley Bridgwood
 *
 */

package main;

import java.io.IOException;

public class Save extends FileHandler {
	
	public static void saveBiomorph(String name, Object bioData){
		Log.add("Saving Biomorph...");
		try {
			saveObjectToFile("/Saved Biomorphs/" + name + ".biomorph", bioData);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//writeToFile("/Saved Biomorphs/" + name + ".biomorph", bioData);
		Log.add("Biomorph saved: " + EvolutionaryArtFolderLocation + "\\Saved Biomorphs");
	}
	
	public static void saveBiomorphToHallOfFame(String name, Object bioData){
		try{
			saveObjectToFile("/Hall Of Fame/" + name + ".biomorph", bioData);
		} catch(IOException e){
			e.printStackTrace();
		}
	}
}
