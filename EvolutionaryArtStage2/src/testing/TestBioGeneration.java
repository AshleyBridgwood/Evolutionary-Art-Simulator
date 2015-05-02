package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import model.BioController;
import model.BioGeneration;
import model.Line;

import org.junit.Before;
import org.junit.Test;

public class TestBioGeneration {
	
	private BioController controller;
	private BioGeneration generation;
	
	@Before
	public void before(){
		controller =  new BioController();
		generation = new BioGeneration(controller.newBiomorph());
	}
	
	@Test
	public void testCorrectNumberOfBiomorphsGenerated(){
		ArrayList<ArrayList<Line>> biomorphs = generation.getAllBiomorphs();
		assertEquals(10, biomorphs.size());
		ArrayList<ArrayList<Line>> generateJustChildren = generation.getChildrenFromParent(biomorphs.get(0));
		assertEquals(10, generateJustChildren.size());
		ArrayList<ArrayList<Line>> parent = new ArrayList<ArrayList<Line>>();
		parent.add(generation.makeParentBiomorph());
		assertEquals(1, parent.size());
	}
	
	@Test
	public void testUniqueGeneration(){
		ArrayList<ArrayList<Line>> biomorphs = generation.getAllBiomorphs();
		for(int i = 0; i < biomorphs.size() - 1; i++){
			assertNotSame(biomorphs.get(i).toString(), biomorphs.get(i+1).toString());
		}
	}
	
	@Test
	public void testCombiningBiomorphs(){
		ArrayList<ArrayList<Line>> biomorphs = generation.getAllBiomorphs();
		ArrayList<Line> combinationBiomorphs = generation.combineBiomorphs(biomorphs.get(2), biomorphs.get(6));
		assertNotSame(biomorphs.get(2), combinationBiomorphs);
		assertNotSame(biomorphs.get(6), combinationBiomorphs);
	}
	
	@Test
	public void testChildCreation(){
		ArrayList<ArrayList<Line>> data = generation.getAllBiomorphs();
		ArrayList<Line> parent = data.get(0);
		ArrayList<Line> child1 = generation.createChild(parent);
		assertNotSame(parent, child1);
	}
	
}
