package testing;

import org.junit.Before;
import org.junit.Test;

import model.BioController;

public class TestFileHandling {

	private BioController controller;
	
	@Before
	public void before(){
		controller = new BioController();
	}
	
	@Test
	public void testSaving(){
		controller.saveCurrentBiomorphsToFile("test");
	}
}
