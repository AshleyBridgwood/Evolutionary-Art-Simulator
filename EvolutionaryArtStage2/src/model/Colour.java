/**
 * Colour - Used for storing the different colours which are used with the colouring of the biomorphs
 * 
 * @author James Langford
 *
 */

package model;

import java.awt.Color;
import java.util.Random;

public class Colour {
	
	private static final String[] colours = {"red","yellow","blue","orange","pink","cyan","magenta","black","lightGrey","darkGrey"};
	private static final Color[] reds = {new Color(255,0,0), new Color(255,153,0), new Color(255,204,0), new Color(255,255,102)};
	private static final Color[] blues = {new Color(0,0,68), new Color(0,51,102), new Color(102,153,204), new Color(192,192,192)};
	private static final Color[] greens = {new Color(0,255,0), new Color(4,193,4), new Color(1,128,1), new Color(0,50,0)};
	private static final Color[] greyscale = {new Color(0,0,0), new Color(105,105,105), new Color(128,128,128), new Color(169,169,169)};
	private static final Color[][] colourSchemes = {reds,blues,greens,greyscale};

	
	public Colour(){

	}
	
	/**
	 * Gets a random colour from the selection
	 * @return Color the random colour
	 */
	public Color getRandomColour(){
		Random rand = new Random();
		int randNum = rand.nextInt(colours.length-1);
		String chosen = colours[randNum];
		Color chosenColor=null;
		
		switch (chosen){
			case "red" : chosenColor =  Color.RED;
			break;
			case "yellow": chosenColor = Color.YELLOW;
			break;
			case "blue": chosenColor = Color.BLUE;
			break;
			case "orange": chosenColor = Color.ORANGE;
			break;
			case "pink": chosenColor = Color.PINK;
			break;
			case "cyan": chosenColor = Color.CYAN;
			break;
			case "magenta": chosenColor = Color.MAGENTA;
			break;
			case "white": chosenColor = Color.WHITE;
			break;
			case "grey": chosenColor = Color.GRAY;
			break;
			case "lightGrey": chosenColor = Color.lightGray;
			break;
			case "darkGrey": chosenColor = Color.darkGray;
			break;
			default: chosenColor = Color.BLACK;
			break;
		}
		return chosenColor;
	}
	
	/**
	 * Gets a random colour scheme
	 * @param choice Choice of random colour scheme
	 * @return Color random Colour scheme
	 */
	public Color getRandomColourFromScheme(int choice){
		System.out.println(choice);
		/*
		 * 0 - reds
		 * 1 - blues
		 * 2 - greens
		 * 3 - greyscale
		 */
		
		Color[] arrayChosen = colourSchemes[choice];
		Random rand = new Random();
		int randColour = rand.nextInt(4);
	
		return arrayChosen[randColour];
	}
}
	


