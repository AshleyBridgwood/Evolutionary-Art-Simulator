/**
 * Load - Deal with loading of files and deserialising objects which are saved to file
 * 
 * @author Ashley Bridgwood
 *
 */

package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Load extends FileHandler {
	
	/**
	 * Retrieves a set of biomorphs from file
	 * @param fileName name of the file to be loaded
	 * @return ArrayList<ArrayList<Line>> the loaded parent and children data
	 */
	public static ArrayList<ArrayList<Line>> loadAllBiomorphs(String fileName){
		return FileHandler.loadBiomorphs("\\Saved Biomorphs\\" + fileName);
		//		return FileHandler.loadBiomorphs("\\Saved Biomorphs\\" + fileName + ".biomorph"); ..

	}
	
	/**
	 * Loads the hall of fame biomorphs from file
	 * @param fileName name of the file to be loaded
	 * @return ArrayList<Line> the loaded Biomorph
	 */
	public static ArrayList<Line> loadHallOfFameBiomorph(String fileName){
		return FileHandler.loadHallOfFameBiomorph("\\Hall Of Fame\\" + fileName + ".biomorph");
	}
	
	/**
	 * Loading of a file
	 * @param fileName name of the file to be loaded
	 * @return String data out of the file
	 */
	public static String loadFile(String fileName){
		String data = "";
		if(fileName != null){
			String location = EvolutionaryArtFolderLocation + "\\Saved Biomorphs\\" + fileName + ".biomorph";
			File file = new File(location);
			
			if(file.exists()){
				Log.add("Biomorph File '" + fileName + ".biomorph' found. Reading the file...");
				BufferedReader reader;
				try{
					String currentLine;
					reader =  new BufferedReader(new FileReader(location));
					
					while((currentLine = reader.readLine()) != null){
						data = data + currentLine;
					}
					Log.add("Reading of file '" + fileName + ".biomorph' successful.");
					
				} catch(IOException e){
					e.printStackTrace();
				}
				
			} else {
				Log.add("Loading of Biomorph failed - Invalid file name: " + fileName);
			}
		} else {
			Log.add("Loading of Biomorph failed - File name was left blank.");
		}
			return data;
	}
}
