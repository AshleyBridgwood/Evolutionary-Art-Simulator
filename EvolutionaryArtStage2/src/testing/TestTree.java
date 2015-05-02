package testing;

import static org.junit.Assert.*;

import java.util.Random;

import model.Point;
import model.Tree;
import model.Tree.TreeNode;

import org.junit.Before;
import org.junit.Test;

public class TestTree {
	
	private Tree tree;
	private TreeNode<Point> root;
	private int ID;
	private Random rand;
	
	@Before
	public void before(){
		rand = new Random();
		ID = 0;
		root = new TreeNode<Point>(new Point(ID, 0, 0));
		ID++;
		tree = new Tree(root);
		root.setParent(root);
	}
	
	@Test
	public void testStartup(){
		assertEquals(tree.getRoot().getElement().getID(), 0);
		assertEquals(tree.findTreeNode(root, 0).getElement().getID(), 0);
	}
	
	@Test
	public void testAddingXAmountToTree(){
		for(int i = 0; i < 10; i++){
			TreeNode<Point> parent = null;
			int randomNum = rand.nextInt((ID - 1) + 1) + 1;
			if(randomNum == ID){
				randomNum--;
			}
			parent = tree.findTreeNode(root, randomNum);
			
			TreeNode<Point> newChild = new TreeNode<Point>(new Point(ID, i*8, i*10));
			parent.addChild(newChild);
			ID++;
		}
		
		assertEquals(tree.findTreeNode(root, 9).getElement().getID(), 9);
	}
	
	
}
