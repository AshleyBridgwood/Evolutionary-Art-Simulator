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

package main;

import java.util.ArrayList;
import java.util.Random;

import main.Tree.TreeNode;

public class BioGeneration {
	
	private int tempID;
	
	private Gene g0;
	private Gene g1;
	private Gene g2;
	
	private long seed; 
	//private String bioData; //bioData Structure: {SEED; PARENT; CHILD1; CHILD2; CHILD3; CHILD4; CHILD5, CHILD6; CHILD7; CHILD8; CHILD9;}
	private static ArrayList<ArrayList<Line>> finishedBiomorphs;
	
	public BioGeneration(Biomorph b){
		//Take values out of the biomorph passed in
		g0 = b.getGenes().get(0);
		g1 = b.getGenes().get(1);
		g2 = b.getGenes().get(2);
		seed = b.getSeed();
		finishedBiomorphs = new ArrayList<>();
		
		//Generate the parent biomorph data
		ArrayList<Line> parent = makeParentBiomorph();
		Log.add("Parent Biomorph Generated");
		finishedBiomorphs.add(parent);
		
		System.out.println(finishedBiomorphs.size());
		//Generate the children biomorph data (9 of them)
	}
	
	public static ArrayList<ArrayList<Line>> getAllBiomorphs(){
		return finishedBiomorphs;
	}
	
	public ArrayList<Line> makeParentBiomorph(){
		int branching = g0.getValue();
		int currentNumberOfLegs = 0;
		int numberOfLegs = 10;
		int nodeId = 1;
		Random rand = new Random();
		//Creating the root node (TOP NODE) - Always needs to be created
		Point data = new Point(nodeId,0,0);
		nodeId++;
		TreeNode<Point> root = new TreeNode<Point>(data);
		Tree biomorphTree = new Tree(root);
		root.setParent(root);
		
		while(currentNumberOfLegs < numberOfLegs){
			TreeNode<Point> parentNode = null;
			int randomNum = rand.nextInt((nodeId - 1) + 1) + 1;
			parentNode = biomorphTree.findTreeNode(root, randomNum);
			System.out.println("Total number of nodes: " + nodeId);
			System.out.println("Parent Node: " + parentNode.getElement().getID());
			int x =  rand.nextInt((200-50) + 1) + 50;
			int y = rand.nextInt((200-50) + 1) + 50;
			
			TreeNode<Point> newNode = new TreeNode<Point>(new Point(nodeId, x, y));
			parentNode.addChild(newNode);
			nodeId++;

			currentNumberOfLegs++;
		}
			ArrayList<TreeNode<Point>> finalTree = biomorphTree.getPreOrderTraversal();
			String id_in_line = "";
			for(int i = 0; i < finalTree.size(); i++){
				System.out.println("ID: " + finalTree.get(i).getElement().getID());
				System.out.println("X: " + finalTree.get(i).getElement().getX());
				System.out.println("Y: " + finalTree.get(i).getElement().getY());
				System.out.println("Parent ID: " + finalTree.get(i).getParent().getElement().getID());
				System.out.println("------------------");
				id_in_line += finalTree.get(i).getElement().getID() + ", ";
			}
			System.out.println("Id's in-line: " + id_in_line);
			
			return generateLineInformation(finalTree);
	}
	
	public ArrayList<ArrayList<Line>> createChildren(){
		
		ArrayList<ArrayList<Line>> children = new ArrayList<ArrayList<Line>>();
		// for the amount of children 
		for(int i = 0; i<9; i++){
			//make a copy of the tree
			ArrayList<Line> tempTree = makeParentBiomorph();
			
			//iterate through tree
			for(int j = 0; j<tempTree.size(); j++){
				//chance it will mutate
				//when this is working need to change it so probabilities change according to slider.
				Random rand = new Random();
				int num = rand.nextInt(100);
				//if it does mutate change x or y by certain amount
				if(num <= 49){
					//which point to change:
					int pointDecider = rand.nextInt(99)+1;
					if(pointDecider == 0 && pointDecider <= 25){
						// change x1
						tempTree.get(j).setX1(tempTree.get(j).getX1() +2); //TODO: change "+2" to amount on slider.
						
					} else if(pointDecider > 25 && pointDecider <= 50){
						// change y1
						tempTree.get(j).setY1(tempTree.get(j).getY1() +2); //TODO: change "+2" to amount on slider.
					} else if(pointDecider > 50  && pointDecider <= 75){
						// change x2
						tempTree.get(j).setX2(tempTree.get(j).getX2() +2); //TODO: change "+2" to amount on slider.
					} else {
						//change y2
						tempTree.get(j).setY2(tempTree.get(j).getY2() +2); //TODO: change "+2" to amount on slider.
					}
				}
				
			}
			//add to list of trees.
			children.add(tempTree);
		}
		return children;
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
