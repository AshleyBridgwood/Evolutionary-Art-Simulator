/**
 * DESCRIPTION OF THE CLASS
 * 
 * @author Ashley Bridgwood
 *
 */

package main;

import java.io.File;

public class Log {
	
	private static String logData = "";
	
	public static void add(String data){
		logData = logData + data + "\n";
	}
	
	public static String getLog(){
		return logData;
	}
	
	public static void exportLogToFile(){
		File exportedLog = new File("");
	}
}
