/**
 * DESCRIPTION OF THE CLASS
 * 
 * @author Ashley Bridgwood
 *
 */

package main;

public class BioController {
	
	public BioController() {
		Log.add("Bio Controller Initiated");
		FileHandler.checkForMainWorkingFolder();
		
		Save.saveBiomorph("Test", "1841653102515205");
		System.out.println(Load.loadBiomorph("Test"));
		
		new BioCache();
		Log.add("BioCache Initiated");
		
		while(!BioCache.isEmpty()){
			String data = BioCache.pop();
			System.out.println(data);
		}
		
		Log.exportLogToFile();
	
		
	}
	
}

