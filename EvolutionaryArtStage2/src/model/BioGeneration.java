/**
 * DESCRIPTION OF THE CLASS
 * 
 * @author Ashley Bridgwood
 * 
 * First value is branching, this must always be positive.
 * Right now there are only two other values, the second being length and the third being width.
 * Width is x axis, Length is y axis.
 *
 */

package model;

import java.util.ArrayList;
import java.util.Random;

import model.Tree.TreeNode;

public class BioGeneration {
	
	private Gene g0;
	private Gene g1;
	private Gene g2;
	private static int tempIdCounter = 0;

	private static ArrayList<ArrayList<Line>> finishedBiomorphs;
	
	public BioGeneration(Biomorph b){
		//Take values out of the Biomorph values passed in
		g0 = b.getGenes().get(0);
		g1 = b.getGenes().get(1);
		g2 = b.getGenes().get(2);
		finishedBiomorphs = new ArrayList<>();
		
		//Generate the parent
		ArrayList<Line> parent = makeParentBiomorph();
		finishedBiomorphs.add(parent);
		
		//Generate the children from the parent (9 of them)
		for(int i = 0; i <  9; i++){
			finishedBiomorphs.add(createChild(parent));
		}
	}
	
	public static ArrayList<ArrayList<Line>> getChildrenFromParent(ArrayList<Line> parent){
		ArrayList<ArrayList<Line>> data = new ArrayList<ArrayList<Line>>();
		data.add(parent);
		
		for(int i = 0; i < 9; i++){
			data.add(createChild(parent));
		}
		
		return data;
	}
	
	public static ArrayList<ArrayList<Line>> getAllBiomorphs(){
		return finishedBiomorphs;
	}
	
	public ArrayList<Line> makeParentBiomorph(){
		int branching = g0.getValue();
		int currentNumberOfLegs = 0;
		int numberOfLines = 20;
		int nodeId = 1;
		Random rand = new Random();
		//Creating the root node (TOP NODE) - Always needs to be created
		Point data = new Point(nodeId,0,0);
		nodeId++;
		TreeNode<Point> root = new TreeNode<Point>(data);
		Tree biomorphTree = new Tree(root);
		root.setParent(root);
		
		while(currentNumberOfLegs < numberOfLines){
			TreeNode<Point> parentNode = null;
			int randomNum = rand.nextInt((nodeId - 1) + 1) + 1;
			//If the nodeID is the same as the random number, if errors, so code to fix that
			if(randomNum == nodeId){
				randomNum--;
			}
				parentNode = biomorphTree.findTreeNode(root, randomNum);
			//System.out.println("Parent node ID found: " + parentNode.getElement().getID());
			//int x =  rand.nextInt((200-50) + 1) + 50;
			//int y = rand.nextInt((200-50) + 1) + 50;			
			
			int x = rand.nextInt((100-25) + 1) + (g1.getValue()*2);
			int y = rand.nextInt((100-25) + 1) + (g2.getValue()*2);
			
			//int x = rand.nextInt((100-25) + 1) + 25;
			//int y = rand.nextInt((100-25) + 1) + 25;

			
			TreeNode<Point> newNode = new TreeNode<Point>(new Point(nodeId, x, y));
			parentNode.addChild(newNode);
			nodeId++;

			currentNumberOfLegs++;
		}	
			return generateLineInformation(biomorphTree.getPreOrderTraversal());
	}
	
	public static ArrayList<Line> createChild(ArrayList<Line> parent){
		ArrayList<Line> parentTree = parent;
		// for the amount of children 
		//for(int i = 0; i<9; i++){

			//make a copy of the tree
			ArrayList<Line> tempTree = parentTree;
			//iterate through tree			
			for(int j = 0; j < tempTree.size(); j++)
			{
				//chance it will mutate
				//when this is working need to change it so probabilities change according to slider.
				Random rand = new Random();
				int num = rand.nextInt(100);
				//if it does mutate change x or y by certain amount				
				if(num <= 49)
				{
					//which point to change:
					int pointDecider = rand.nextInt(99)+1;
					
					if(pointDecider == 0 && pointDecider <= 25)
					{
						// change x1
						//TODO: generate random variable between 0 and what is chosen on slider and insert instead of "+2"
						Random newRan = new Random();
						int changeRan = newRan.nextInt(100)+50; // change 100 to what has been selected on slider.
						tempTree.get(j).setX1(tempTree.get(j).getX1() + changeRan); //TODO: change "+2" to amount on slider.
						
					} 
					else if(pointDecider > 25 && pointDecider <= 50)
					{
						// change y1
						//TODO: generate random variable between 0 and what is chosen on slider and insert instead of "+2"
						Random newRan = new Random();
						int changeRan = newRan.nextInt(100)+50; // change 100 to what has been selected on slider.
						
						//System.out.println("Hit mid mutation point");
						//System.out.println(tempTree.get(j).toString());
						tempTree.get(j).setY1(tempTree.get(j).getY1() + changeRan);
						//System.out.println(tempTree.get(j).toString());
					} 
					else if(pointDecider > 50  && pointDecider <= 75)
					{
						// change x2
						//TODO: generate random variable between 0 and what is chosen on slider and insert instead of "+2"
						Random newRan = new Random();
						int changeRan = newRan.nextInt(100)+50; // change 100 to what has been selected on slider.
						tempTree.get(j).setX2(tempTree.get(j).getX2() + changeRan); //TODO: change "+2" to amount on slider.
					} 
					else 
					{
						//change y2
						//TODO: generate random variable between 0 and what is chosen on slider and insert instead of "+2"
						Random newRan = new Random();
						int changeRan = newRan.nextInt(100)+50; // change 100 to what has been selected on slider.
						tempTree.get(j).setY2(tempTree.get(j).getY2() +changeRan); //TODO: change "+2" to amount on slider.
					}
				}
				
			}
			
			
			return tempTree;			

			//if(tempIdCounter == 0){
			//	System.out.println("Parent: " + parent.toString());
			//}
			//System.out.println("Child " + tempIdCounter + ": " + tempTree.toString());
			//tempIdCounter++;
			//return tempTree;

	}
	
	public Biomorph combineBiomorphs(Biomorph a, Biomorph b)
	{
		
		//create new biomorph object
		Biomorph offspring = new Biomorph();
		// each biomorph should always have the same amount of genes
		if(a.getGenes().size() == b.getGenes().size())
		{
			for(int i = 0; i<a.getGenes().size(); i++)
			{
				// for each gene in the new offspring biomorph take the corresponding gene out of a and b and average it.
				offspring.changeGene(i,((a.getGenes().get(i).getValue()) + (b.getGenes().get(i).getValue()))/2);
			}
		}
		
		return offspring;
	}
	
	public ArrayList<Line> generateLineInformation(ArrayList<TreeNode<Point>> data){
		ArrayList<Line> lines = new ArrayList<Line>();
		
		for(int i = 0; i < data.size(); i++){
			int x1 = data.get(i).getParent().getElement().getX();
			int y1 = data.get(i).getParent().getElement().getY();
			int x2 = data.get(i).getElement().getX();
			int y2 = data.get(i).getElement().getY();
			lines.add(new Line(x1, y1, x2, y2));
		}
		
		return lines;
	}
}
