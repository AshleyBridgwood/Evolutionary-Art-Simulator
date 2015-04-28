/**
 * Log of all important main activities which happen during the execution of the program
 * 
 * @author Ashley Bridgwood
 *
 */

package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {
	
	private static String logData = ""; //Stores the log data
	private static Date date; //Stores the current date
	private static SimpleDateFormat dateFormat; //Used to format the date into a human readable date
	
	public static void add(String data){
		//Initalise the fields
		date = new Date();
		dateFormat = new SimpleDateFormat("dd.MM.yyyy'@'hh:mm:ss");
		String finalTimeDate = dateFormat.format(date);
		
		logData = logData + "(" + finalTimeDate + ") " + data + "\r\n";
	}
	
	/**
	 * Gets the log data
	 * @return String All of the data stored in the log
	 */
	public static String getLog(){
		return logData;
	}
	
	/**
	 * Clears all of the data within the log
	 */
	private static void clearLog(){
		logData = "";
	}
	
	/**
	 * Exports the log to file
	 */
	public static void exportLogToFile(){
		Log.add("Writing Log to File...");
		FileHandler.writeToFile("/Log/log.txt", logData);
		clearLog();
	}
}
