/**
 * DESCRIPTION OF THE CLASS
 * 
 * @author Ashley Bridgwood
 *
 */

package main;

import java.io.File;

public class BioController {
	
/*
 * Notes - DO NOT REMOVE
 * 
 * Class needs to do the following:
 * - Start the UI
 * - Check if directory file is there
 * - Link to BioGeneration and file handler
 * - link to log
 */

	public BioController() {
		System.out.println("Bio Controller Initiated");
		checkFiles();
	}
	
	//Eventually will be moved to fileHandler.java
	private void checkFiles(){
		
		String dir = null;
		
		//Checking which Operating system the user is running (either Windows/Linux)
		if(System.getProperty("os.name").equals("Windows 7")){
			System.out.println("Operating System detected: Windows 7");
			 dir = System.getProperty("user.home") + File.separator + "My Documents";
		} else if(System.getProperty("os.name").equals("Windows 8")){
			System.out.println("Operating System detected: Windows 8");
			dir = System.getProperty("user.home") + File.separator + "Documents";
		} else if(System.getProperty("os.name").equals("Linux")){
			System.out.println("Operating System detected: Linux");
			dir = System.getProperty("user.home");
		}
			
		if(dir != null){
			File defaultDir = new File(dir,"Evolutionary Art");
			File logDir = new File(dir + File.separator + "Evolutionary Art", "Log");
			File videoDir = new File(dir + File.separator + "Evolutionary Art", "Videos");
			File exportDir = new File(dir + File.separator + "Evolutionary Art", "Exported Biomorphs");
			File savedDir = new File(dir + File.separator + "Evolutionary Art", "Saved Biomorphs");
			
			//Check and/or create the main folder
			if(!defaultDir.isDirectory()){
				defaultDir.mkdirs();
				System.out.println("Folder created: Evolutionary Art");
			}
				
			//Check and/or create the log folder
			if(!logDir.isDirectory()){
				logDir.mkdirs();
				System.out.println("Folder Created in Evolutionary Art: Log");		
			}
			
			//Check and/or create the videos folder
			if(!videoDir.isDirectory()){
				videoDir.mkdirs();
				System.out.println("Folder Created in Evolutionary Art: Videos");
			}
			
			//Check and/or create the exported Biomorph's folder
			if(!exportDir.isDirectory()){
				exportDir.mkdirs();
				System.out.println("Folder Created in Evolutionary Art: Exported Biomorphs");
			}
			
			//Check and/or create the Saved Biomorph's folder
			if(!savedDir.isDirectory()){
				savedDir.mkdirs();
				System.out.println("Folder Created in Evolutionary Art: Saved Biomorphs");
			}
		}
			
	}
}

