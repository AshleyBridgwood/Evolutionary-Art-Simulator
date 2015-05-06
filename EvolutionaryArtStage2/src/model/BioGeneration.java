/**
 * DESCRIPTION OF THE CLASS
 * 
 * @author Ashley Bridgwood
 * @author James Langford
 * 
 * First value is branching, this must always be positive.
 * Right now there are only two other values, the second being length and the third being width.
 * Width is x axis, Length is y axis.
 *
 */

package model;

import java.util.ArrayList;
import java.util.Random;

import view.BiomorphStartUp;
import view.UserInterface;
import model.Tree.TreeNode;

public class BioGeneration {
	
	//private Gene g0; //Stores the value for the first gene
	private Gene g1; //Stores the value for the second gene
	private Gene g2; //Stores the value of the third gene

	private static ArrayList<ArrayList<Line>> finishedBiomorphs; //Stores the finished biomorphs which are created - used for the
																 // when creating a whole new parent and related children
	
	public BioGeneration(Biomorph b){
		//Initialise the fields
		//g0 = b.getGenes().get(0);
		g1 = b.getGenes().get(1);
		g2 = b.getGenes().get(2);
		finishedBiomorphs = new ArrayList<ArrayList<Line>>();
		
		//Generate the parent
		ArrayList<Line> parent = makeParentBiomorph();
		finishedBiomorphs.add(parent);
		
		//Generate the children from the parent (9 of them)
		for(int i = 0; i < 9; i++){
			finishedBiomorphs.add(createChild(parent));
		}
	}
	
	/**
	 * Generates children from a given parent
	 * @param parent children will be based upon this parent
	 * @return ArrayList<ArrayList<Line>> parent and child data to be printed
	 */
	public static ArrayList<ArrayList<Line>> getChildrenFromParent(ArrayList<Line> parent){
		ArrayList<ArrayList<Line>> data = new ArrayList<ArrayList<Line>>();
		data.add(parent);
		
		for(int i = 0; i < 9; i++){
			data.add(createChild(parent));
		}
		return data;
	}
	
	/**
	 * Gets all the biomorphs which have been generated
	 * @return ArrayList<ArrayList<Line>> the finished parent and children
	 */
	public static ArrayList<ArrayList<Line>> getAllBiomorphs(){
		return finishedBiomorphs;
	}
	
	/**
	 * Generates a parent Biomorph
	 * @return ArrayList<Line> the generated parent
	 */
	public ArrayList<Line> makeParentBiomorph(){
		int currentNumberOfLegs = 0;
		int numberOfLines = BiomorphStartUp.getSliderValue();
		int nodeId = 1;
		Random rand = new Random(); //Creates a random number
		
		Point data = new Point(nodeId,0,0); //Creating the root node (TOP NODE) - Always needs to be created
		nodeId++;
		TreeNode<Point> root = new TreeNode<Point>(data); //Sets the root node
		Tree biomorphTree = new Tree(root); //Creates a new tree with the newly created root node
		root.setParent(root); //Sets the parent of the root, to itself
		
		while(currentNumberOfLegs < numberOfLines){
			TreeNode<Point> parentNode = null;
			int randomNum = rand.nextInt((nodeId - 1) + 1) + 1; //Generates a random number for selecting a random node
			//If the nodeID is the same as the random number, if errors, so code to fix that
			if(randomNum == nodeId){
				randomNum--;
			}
				parentNode = biomorphTree.findTreeNode(root, randomNum);
			
			int x = rand.nextInt((125 - (g1.getValue() * 2 )) + 1) + (g1.getValue() * 2); //Generates the X value
			int y = rand.nextInt((125 - (g2.getValue() * 2 )) + 1) + (g2.getValue() * 2); //Generate the Y value
			
			TreeNode<Point> newNode = new TreeNode<Point>(new Point(nodeId, x, y)); //Creates a new TreeNode
			parentNode.addChild(newNode); //Adds the new TreeNode to the randomly selected parent TreeNode
			nodeId++; //Increment the NodeId so that the newly generates node can become a parent in the next cycle

			currentNumberOfLegs++; //Increment the number of legs 
		}	
			return generateLineInformation(biomorphTree.getPreOrderTraversal()); //Returns the tree to the line creator method
	}
	
	/**
	 * Creates a single child from a given parent
	 * @param parent child will be a slightly different from the parent
	 * @return ArrayList<Line> the newly created child
	 */
	public static ArrayList<Line> createChild(ArrayList<Line> parent){
		ArrayList<Line> parentTree = cloneData(parent); //Makes a copy of the parent tree
	
			ArrayList<Line> tempTree = cloneData(parentTree); //Make another copy of the tree, used for editing
			//iterate through tree			
			for(int j = 0; j < tempTree.size(); j++){
				Random rand = new Random();
				int chance = UserInterface.getProbOfChange();
				int num = rand.nextInt(chance);
				int changeRanVal = UserInterface.getAmountOfChange();
				int upOrDown = rand.nextInt(100);
				boolean up = false;
				
				if(upOrDown >= 0 && upOrDown <= 50){
					up = false;
				} else {
					up = true;
				}
				
				//if it does mutate change x or y by certain amount				
				if(num <= (chance/2)-1){
					//which point to change:
					int pointDecider = rand.nextInt(99)+1;
					
					if(pointDecider == 0 && pointDecider <= 25){
						// change x1
						//TODO: generate random variable between 0 and what is chosen on slider and insert instead of "+2"
						Random newRan = new Random();
						int changeRan = newRan.nextInt(changeRanVal); // change 100 to what has been selected on slider.
						if(!up){
							tempTree.get(j).setX1(tempTree.get(j).getX1() + changeRan); //TODO: change "+2" to amount on slider.
						} else {
							tempTree.get(j).setX1(tempTree.get(j).getX1() - changeRan);
						}
					} else if(pointDecider > 25 && pointDecider <= 50){
						// change y1
						//TODO: generate random variable between 0 and what is chosen on slider and insert instead of "+2"
						Random newRan = new Random();
						int changeRan = newRan.nextInt(changeRanVal); // change 100 to what has been selected on slider.
						if(!up){
							tempTree.get(j).setY1(tempTree.get(j).getY1() + changeRan);
						} else {
							tempTree.get(j).setY1(tempTree.get(j).getY1() - changeRan);
						}
					} else if(pointDecider > 50  && pointDecider <= 75){
						// change x2
						//TODO: generate random variable between 0 and what is chosen on slider and insert instead of "+2"
						Random newRan = new Random();
						int changeRan = newRan.nextInt(changeRanVal); // change 100 to what has been selected on slider.
						if(!up){
							tempTree.get(j).setX2(tempTree.get(j).getX2() + changeRan); //TODO: change "+2" to amount on slider.
						} else {
							tempTree.get(j).setX2(tempTree.get(j).getX2() - changeRan); //TODO: change "+2" to amount on slider.
						}
					} else {
						//change y2
						//TODO: generate random variable between 0 and what is chosen on slider and insert instead of "+2"
						Random newRan = new Random();
						int changeRan = newRan.nextInt(changeRanVal); // change 100 to what has been selected on slider.
						if(!up){
							tempTree.get(j).setY2(tempTree.get(j).getY2() +changeRan); //TODO: change "+2" to amount on slider.
						} else {
							tempTree.get(j).setY2(tempTree.get(j).getY2() -changeRan); //TODO: change "+2" to amount on slider.
						}
					}
				}
			}
		return tempTree;
	}
	
	/**
	 * Combines two Biomorphs together
	 * @param a first biomorph which will be combined together with the other
	 * @param b second biomorph which will be combined together with the other
	 * @return ArrayList<Line> the newly created combined biomorph
	 */
	public static ArrayList<Line> combineBiomorphs(ArrayList<Line> a, ArrayList<Line> b){
		ArrayList<Line> newBiomorph = new ArrayList<Line>();
		if(a.size() != b.size()){
			//do nothing, throw exception?
		} else {
			for(int i = 0; i<a.size(); i++){
				int newX1 = (a.get(i).getX1() + b.get(i).getX1()) / 2;
				int newX2 = (a.get(i).getX2() + b.get(i).getX2()) / 2;
				int newY1 = (a.get(i).getY1() + b.get(i).getY1()) / 2;
				int newY2 = (a.get(i).getY2() + b.get(i).getY2()) / 2;
				Line newLine = new Line(newX1, newY1, newX2, newY2);
				newBiomorph.add(newLine);
			}
		}
		return newBiomorph;
	}
	
	/**
	 * Clones a Biomorph data
	 * @param data Biomorph to be cloned
	 * @return ArrayList<Line> newly cloned data
	 */
	private static ArrayList<Line> cloneData(ArrayList<Line> data){
		ArrayList<Line> newList = new ArrayList<Line>(data.size());
		
		for(Line line : data){
			try {
				newList.add((Line) line.clone());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}	
		return newList;
	} 
	
	/**
	 * Generates the line information from the raw Biomorph data
	 * @param data raw Biomorph which need be converted into line data
	 * @return ArrayList<Line> the newly generated line information generated from the raw tree data
	 */
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
