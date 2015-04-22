/**
 * DESCRIPTION OF THE CLASS
 * 
 * @author Ashley Bridgwood
 *
 */

package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Load extends FileHandler {
	
	@SuppressWarnings("unchecked")
	public static ArrayList<ArrayList<Line>> loadBiomorphs(String fileName){
		ArrayList<ArrayList<Line>> data = null;
		
		try {
			FileInputStream fileInput = new FileInputStream(EvolutionaryArtFolderLocation + "\\Saved Biomorphs\\" + fileName + ".biomorph");
			try {
				ObjectInputStream input = new ObjectInputStream(fileInput);
				try {
					data = (ArrayList<ArrayList<Line>>) input.readObject();
					input.close();
					fileInput.close();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return data;
	}
	
	public static Object loadBiomorphold(String fileName){
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
