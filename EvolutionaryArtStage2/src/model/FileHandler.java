/**
 * FileHandler - Deals with all reading and writing of data to and from the users computer
 * 
 * @author Ashley Bridgwood
 *
 */

package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.util.ArrayList;

public class FileHandler {
	
	public static String EvolutionaryArtFolderLocation = null; //Stores the main working folder
	
	public static void clearHallOfFameBiomorphs(String name){
		File file = new File(EvolutionaryArtFolderLocation + "/Hall Of Fame/" + name + ".biomorph");
		try{
			file.delete();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Loads the hall of fame biomorph from file
	 * @param locationWithFolder Location within the working folder
	 * @return ArrayList<Line> the Biomorph data
	 */
	public static ArrayList<Line> loadHallOfFameBiomorph(String locationWithinFolder){
		try{
			FileInputStream fileIn = new FileInputStream(EvolutionaryArtFolderLocation + locationWithinFolder);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			ArrayList<Line> data = (ArrayList<Line>) in.readObject();
			fileIn.close();
			return data;
		} catch (ClassNotFoundException | IOException e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Loads the parent and children data from file
	 * @param locationWithinFolder Location within the working folder
	 * @return ArrayList<ArrayList<Line>> the parent and children biomorph data
	 */
	public static ArrayList<ArrayList<Line>> loadBiomorphs(String locationWithinFolder) {
		try{
			FileInputStream fileIn = new FileInputStream(EvolutionaryArtFolderLocation + locationWithinFolder);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			ArrayList<ArrayList<Line>> data = (ArrayList<ArrayList<Line>>) in.readObject();
			fileIn.close();
			return data;
		} catch (ClassNotFoundException | IOException e){
			e.printStackTrace();
		}
		return null;
		
	}
	
	/**
	 * Saved the parent biomorph to hall of fame
	 * @param locationWithinFolder Location within the working folder
	 * @param data Data being saved to the file
	 */
	public static void saveBiomorphToHallOfFame(String locationWithinFolder, ArrayList<Line> data) throws IOException{
		FileOutputStream fileOut = new FileOutputStream(EvolutionaryArtFolderLocation + locationWithinFolder);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(data);
		out.close();
		fileOut.close();
	}
	
	/**
	 * Saves the parent and children biomorph data to file
	 * @param locationWithinFolder Location within the working folder
	 * @param data Data being saved to the file
	 */
	public static void saveObjectToFile(String locationWithinFolder, ArrayList<ArrayList<Line>> data) throws IOException{
		FileOutputStream fileOut = new FileOutputStream(EvolutionaryArtFolderLocation + locationWithinFolder);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(data);
		out.close();
		fileOut.close();
	}
	
	/**
	 * Gets the number of hall of fame biomorphs in the folder
	 * @return Int number of hall of fame biomorphs saved
	 */
	public static int getNumberOfHallOfFameBiomorphs(){
		return new File(EvolutionaryArtFolderLocation + "/Hall Of Fame/").listFiles().length;
	}
	
	/**
	 * Gets the number of saved biomorphs in the folder
	 * @return int number of biomorphs saved
	 */
	public static int getNumberOfSavedBiomorphs(){
		return new File(EvolutionaryArtFolderLocation + "/Saved Biomorphs/").listFiles().length;
	}
	
	/**
	 * Writes data to a file
	 * @param locationWithinFolder Location within the main working folder
	 * @param data Data to be written to the file
	 */
	public static void writeToFile(String locationWithinFolder, String data){
		if(EvolutionaryArtFolderLocation != null){
			try{
				File file = new File(EvolutionaryArtFolderLocation + locationWithinFolder);
				
				if(!file.exists()){
					file.createNewFile();
				}
				
				FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
				bufferWriter.write(data);
				bufferWriter.close();
			} catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Checks for the operating system of the users computer
	 * @return String The home directory of the users computer
	 */
	public static String checkForOS(){
		String dir = null;
		
		//Checking which Operating system the user is running (either Windows/Linux)
		if(System.getProperty("os.name").equals("Windows 7")){
			Log.add("Operating System detected: Windows 7");
			 dir = System.getProperty("user.home") + File.separator + "My Documents";
		} else if(System.getProperty("os.name").equals("Windows 8")){
			Log.add("Operating System detected: Windows 8");
			dir = System.getProperty("user.home") + File.separator + "Documents";
		} else if(System.getProperty("os.name").equals("Linux")){
			Log.add("Operating System detected: Linux");
			dir = System.getProperty("user.home");
		} else if(System.getProperty("os.name").equals("Windows 8.1")){
			dir = System.getProperty("user.home") + File.separator + "Documents";

		}
		
		return dir;
		
	}
	
	/**
	 * Checks for the main working folder, if not there, attempts to create one
	 */
	public static void checkForMainWorkingFolder(){
		
		String dir = checkForOS();
		
		//If a correct OS is being used, continue with making main folder
		if(dir != null){
			File defaultDir = new File(dir,"Evolutionary Art");
			EvolutionaryArtFolderLocation = dir + File.separator + "Evolutionary Art";
			File logDir = new File(dir + File.separator + "Evolutionary Art", "Log");
			File videoDir = new File(dir + File.separator + "Evolutionary Art", "Videos");
			File exportDir = new File(dir + File.separator + "Evolutionary Art", "Exported Biomorphs");
			File savedDir = new File(dir + File.separator + "Evolutionary Art", "Saved Biomorphs");
			File hallOfFameDir = new File(dir + File.separator + "Evolutionary Art", "Hall Of Fame");
			
			//Check and/or create the main folder
			if(!defaultDir.isDirectory()){
				defaultDir.mkdirs();
				Log.add("Folder created: Evolutionary Art");
			}
				
			//Check and/or create the log folder
			if(!logDir.isDirectory()){
				logDir.mkdirs();
				Log.add("Folder Created in Evolutionary Art: Log");		
			}
			
			//Check and/or create the videos folder
			if(!videoDir.isDirectory()){
				videoDir.mkdirs();
				Log.add("Folder Created in Evolutionary Art: Videos");
			}
			
			//Check and/or create the exported Biomorph's folder
			if(!exportDir.isDirectory()){
				exportDir.mkdirs();
				Log.add("Folder Created in Evolutionary Art: Exported Biomorphs");
			}
			
			//Check and/or create the Saved Biomorph's folder
			if(!savedDir.isDirectory()){
				savedDir.mkdirs();
				Log.add("Folder Created in Evolutionary Art: Saved Biomorphs");
			}
			
			if(!hallOfFameDir.isDirectory()){
				hallOfFameDir.mkdirs();
				Log.add("Folder Created in Evolutionary Art: Hall Of Fame");
			}
		} else {
			//If OS is not Windows or Linux, pass error message about failed folder creation
			Log.add("Unable to create Evolutionary Art folder in: " + EvolutionaryArtFolderLocation + ". Some functions may not perform correctly!");
		}	
	}
}
