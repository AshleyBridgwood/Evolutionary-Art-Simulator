/**
 * DESCRIPTION OF THE CLASS
 * 
 * @author Ashley Bridgwood
 *
 */

package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Load extends FileHandler {
	
	public static ArrayList<ArrayList<Line>> loadAllBiomorphs(String fileName){
		FileHandler.loadBiomorph("\\Hall")
	}
	
	public static ArrayList<Line> loadHallOfFameBiomorph(String fileName) throws IOException{
		return FileHandler.loadHallOfFameBiomorph("\\Hall Of Fame\\" + fileName + ".biomorph");
	}
	
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
