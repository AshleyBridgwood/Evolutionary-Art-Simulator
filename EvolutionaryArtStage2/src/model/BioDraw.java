/**
 * Turns the line data into a draw biomorph
 * 
 * @author Ashley Bridgwood
 * @author James Langford
 *
 */

package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import view.UserInterface;

public class BioDraw extends JPanel {
	
	private static final long serialVersionUID = -3393400647955424411L;
	private int canvasSize; //The size of the canvas - Dependent on if it is a parent or child
	private static final double PARENT_SCALING = 1.25; //Scaling of the parent on the canvas
	private static final double CHILD_SCALING  =  0.8; //Scaling of the child on the canvas
	
	private boolean isChild; //Stores if the data passed in belongs to a parent of child
	ArrayList<Line> data; //Stores the data about the biomorph currently being printed
	
	public BioDraw(ArrayList<Line> data, boolean isChild) {
		//Initalise the fields
		this.data = data;
		this.isChild = isChild;
		canvasSize = 0;
		//Determines the canvas size dependent if it is a parent or a child
		if(isChild){
			canvasSize = 120;
		} else {
			canvasSize = 160;
		}
	}
	
	/**
	 * Set the preferred size of the canvas. This is dependent on if it is a parent or a child
	 * @return Dimension
	 */
	@Override
     public Dimension getPreferredSize() {
         return new Dimension(canvasSize, canvasSize);
    }
	
	/**
	 * Actually draws the biomorph
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
	
		
		
		for(int i = 0; i < data.size(); i++){ //Loops through the data to be printed
			if(UserInterface.getColourChoice() < 0){ //Setting the colour
				g.setColor(Color.BLACK);
			} else {
				Colour colour = new Colour();
				Color toUse = colour.getRandomColourFromScheme(UserInterface.getColourChoice());
				g.setColor(toUse);
				
			}
			
			g2.setStroke(new BasicStroke(UserInterface.getLineThickness()));
			
			//Drawing of the parent and child with scaling applied
			if(isChild){
				g2.drawLine((int) (data.get(i).getX1() * CHILD_SCALING), (int) (data.get(i).getY1()* CHILD_SCALING), (int) (data.get(i).getX2()* CHILD_SCALING), (int) (data.get(i).getY2()* CHILD_SCALING));
				g2.drawLine((int) (canvasSize - data.get(i).getX1()* CHILD_SCALING),(int) (data.get(i).getY1()* CHILD_SCALING),(int) (canvasSize-data.get(i).getX2()* CHILD_SCALING),(int) (data.get(i).getY2()* CHILD_SCALING));
			} else {
				g2.drawLine((int) (data.get(i).getX1() * PARENT_SCALING), (int) (data.get(i).getY1()* PARENT_SCALING), (int) (data.get(i).getX2()* PARENT_SCALING), (int) (data.get(i).getY2()* PARENT_SCALING));
				g2.drawLine((int) (canvasSize - data.get(i).getX1()* PARENT_SCALING),(int) (data.get(i).getY1()* PARENT_SCALING),(int) (canvasSize-data.get(i).getX2()* PARENT_SCALING),(int) (data.get(i).getY2()* PARENT_SCALING));
			}
		}
	}
}
