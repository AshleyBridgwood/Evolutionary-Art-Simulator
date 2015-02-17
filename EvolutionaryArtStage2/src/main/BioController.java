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
	
	private void checkFiles(){
		
		String dir = System.getProperty("user.home") + File.separator + "My Documents";
		File defaultDir = new File(dir,"Evolutionary Art");
		File logDir = new File(dir + File.separator + "Evolutionary Art", "Log");
		
		if(!defaultDir.isDirectory()){
			defaultDir.mkdirs();
		}
			
		if(!logDir.isDirectory()){
			logDir.mkdirs();
		}
		
	}
}
