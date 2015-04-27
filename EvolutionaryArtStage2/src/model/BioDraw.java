/**
 * Receives data from the BioGeneration and separates the data
 * so it can either be displayed as a Parent or Children
 * 
 * @author Ashley Bridgwood
 *
 */

package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class BioDraw extends JPanel {
	
	private int canvasSize;
	private static final double CHILD_SCALING  =  0.8;
	private static final double PARENT_SCALING = 1.25;
	
	private boolean isChild;
	ArrayList<Line> data;
	
	public BioDraw(ArrayList<Line> data, boolean isChild) {
		this.data = data;
		this.isChild = isChild;
		canvasSize = 0;
		if(isChild){
			canvasSize = 120;
		} else {
			canvasSize = 160;
		}
	}
	
	/**
	 * Set the preferred size of the canvas. This is dependent on if it is a parent or a child
	 * 
	 * @return Dimension
	 */
	@Override
     public Dimension getPreferredSize() {
         return new Dimension(canvasSize, canvasSize);
    }
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//!!! COMPLETE THE DRAWING OF THE BIOMORPH BELOW !!!\\
		
		Colour colour = new Colour();
		Color toUse = colour.getRandomColour();
		g.setColor(Color.BLACK);
		//g.setColor(toUse);
		for(int i = 0; i < data.size(); i++){
			if(isChild){
				g.drawLine((int) (data.get(i).getX1() * CHILD_SCALING), (int) (data.get(i).getY1()* CHILD_SCALING), (int) (data.get(i).getX2()* CHILD_SCALING), (int) (data.get(i).getY2()* CHILD_SCALING));
				g.drawLine((int) (canvasSize - data.get(i).getX1()* CHILD_SCALING),(int) (data.get(i).getY1()* CHILD_SCALING),(int) (canvasSize-data.get(i).getX2()* CHILD_SCALING),(int) (data.get(i).getY2()* CHILD_SCALING));
			} else {
				g.drawLine((int) (data.get(i).getX1() * PARENT_SCALING), (int) (data.get(i).getY1()* PARENT_SCALING), (int) (data.get(i).getX2()* PARENT_SCALING), (int) (data.get(i).getY2()* PARENT_SCALING));
				g.drawLine((int) (canvasSize - data.get(i).getX1()* PARENT_SCALING),(int) (data.get(i).getY1()* PARENT_SCALING),(int) (canvasSize-data.get(i).getX2()* PARENT_SCALING),(int) (data.get(i).getY2()* PARENT_SCALING));
				//g.drawLine(data.get(i).getX1(), data.get(i).getY1(),data.get(i).getX2(), data.get(i).getY2());
				//g.drawLine(canvasSize - data.get(i).getX1(), data.get(i).getY1(), canvasSize-data.get(i).getX2(), data.get(i).getY2());
			}
		}
	}
}
