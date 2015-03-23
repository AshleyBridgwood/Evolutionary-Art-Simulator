/**
 * Receives data from the BioGeneration and separates the data
 * so it can either be displayed as a Parent or Children
 * 
 * @author Ashley Bridgwood
 *
 */

package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class BioDraw extends JPanel {
	
	private int canvasSize;
	
	public BioDraw(String data, boolean isParent) {
		
		//Set the canvas size - Parent will be larger than 
		if(isParent){
			canvasSize = 350;
		} else {
			canvasSize = 150;
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
		g.setColor(Color.BLACK);
		g.drawLine(1, 1, 10, 10);
	}
}
