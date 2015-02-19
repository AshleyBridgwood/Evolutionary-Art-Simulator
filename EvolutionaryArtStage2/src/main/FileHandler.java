/**
 * DESCRIPTION OF THE CLASS
 * 
 * @author Ashley Bridgwood
 *
 */

package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
	
	public static String EvolutionaryArtFolderLocation = null;
	
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
		}
		
		return dir;
		
	}
	
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
		} else {
			//If OS is not Windows or Linux, pass error message about failed folder creation
			Log.add("Unable to create Evolutionary Art folder in: " + EvolutionaryArtFolderLocation + ". Some functions may not perform correctly!");
		}
			
	}
}
