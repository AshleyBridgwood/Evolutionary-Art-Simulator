/**
 * DESCRIPTION OF THE CLASS
 * 
 * @author Ashley Bridgwood
 *
 */

package main;

public class Save extends FileHandler {
	
	public static void saveBiomorph(String name, String bioData){
		Log.add("Saving Biomorph...");
		writeToFile("/Saved Biomorphs/" + name + ".biomorph", bioData);
		Log.add("Biomorph saved: " + EvolutionaryArtFolderLocation + "\\Saved Biomorphs");
	}
}
