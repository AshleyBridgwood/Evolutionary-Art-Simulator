/**
 * DESCRIPTION OF THE CLASS
 * 
 * @author Ashley Bridgwood
 *
 */

package main;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {
	
	private static String logData = "";
	private static Date date;
	private static SimpleDateFormat dateFormat;
	
	public static void add(String data){
		date = new Date();
		dateFormat = new SimpleDateFormat("dd.MM.yyyy'@'hh:mm:ss");
		String finalTimeDate = dateFormat.format(date);
		
		logData = logData + "(" + finalTimeDate + ") " + data + "\r\n";
	}
	
	public static String getLog(){
		return logData;
	}
	
	//Private so the log cannot be cleared outside of the class
	private static void clearLog(){
		logData = "";
	}
	
	public static void exportLogToFile(){
		Log.add("Writing Log to File...");
		FileHandler.writeToFile("/Log/log.txt", logData);
		clearLog();
	}
}
