package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import model.BioGeneration;
import model.Biomorph;
import model.FileHandler;
import model.Line;
import model.Load;
import model.Save;

import org.junit.Before;
import org.junit.Test;

public class TestFileHandling {

	private ArrayList<ArrayList<Line>> data;
	
	@SuppressWarnings("static-access")
	@Before
	public void setUp(){
		BioGeneration b = new BioGeneration(new Biomorph());
		data = b.getAllBiomorphs();
		FileHandler.checkForMainWorkingFolder();
	}
	
	@Test
	public void testSaveLoad(){
		Save.saveBiomorphs("Test", data);
		assertNotNull("Failed to save data", Load.loadAllBiomorphs("Test.biomorph"));
	}
}
