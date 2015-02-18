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

	public static void writeToFile(String evolFolderLocation, String locationWithinFolder, String data){
		if(evolFolderLocation != null){
			try{
				File exportedLog = new File(evolFolderLocation + locationWithinFolder);
				
				if(!exportedLog.exists()){
					exportedLog.createNewFile();
				}
				
				FileWriter fileWriter = new FileWriter(exportedLog.getAbsoluteFile());
				BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
				bufferWriter.write(data);
				bufferWriter.close();
				
			} catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}
