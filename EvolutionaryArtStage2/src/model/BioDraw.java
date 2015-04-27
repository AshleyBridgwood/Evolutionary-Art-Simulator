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
	ArrayList<Line> data;
	
	public BioDraw(ArrayList<Line> data, boolean isChild) {
		this.data = data;
		canvasSize = 0;
		if(isChild){
			canvasSize = 120;
		} else {
			//canvasSize = 160;
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
		//g.setColor(Color.BLACK);
		Colour colour = new Colour();
		Color toUse = colour.getRandomColour();
		System.out.print("***********");
		System.out.print(toUse.toString());
		System.out.print("***********");
		g.setColor(toUse);
		for(int i = 0; i < data.size(); i++){
			
			g.drawLine(data.get(i).getX1(), data.get(i).getY1(),data.get(i).getX2(), data.get(i).getY2());
			g.drawLine(canvasSize - data.get(i).getX1(), data.get(i).getY1(), canvasSize-data.get(i).getX2(), data.get(i).getY2());
		}
	}
}
