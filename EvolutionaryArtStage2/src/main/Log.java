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

public class Log {
	
	private static String logData = "";
	
	public static void add(String data){
		logData = logData + data + "\r\n";
	}
	
	public static String getLog(){
		return logData;
	}
	
	public static void exportLogToFile(String location){
		if(location != null){
			try{
				System.out.println("Location: " + location);
				File exportedLog = new File(location + "/Log/log.txt");
				
				if(!exportedLog.exists()){
					exportedLog.createNewFile();
				}
				
				FileWriter fileWriter = new FileWriter(exportedLog.getAbsoluteFile());
				BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
				bufferWriter.write(logData);
				bufferWriter.write("End of Log: Log written to file");
				bufferWriter.close();
				
			} catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}
