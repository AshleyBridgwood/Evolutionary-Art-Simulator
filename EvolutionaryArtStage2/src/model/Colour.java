package model;

import java.awt.Color;
import java.util.Random;

public class Colour {
	
	private static final String[] colours = {"red","yellow","blue","orange","pink","cyan","magenta","black","lightGrey","darkGrey"};
	
	public Colour()
	{
		
	}
	
	public Color getRandomColour()
	{
		Random rand = new Random();
		int randNum = rand.nextInt(colours.length-1);
		String chosen = colours[randNum];
		Color chosenColor=null;
		
		switch (chosen)
		{
		case "red": chosenColor =  Color.RED;
		case "yellow": chosenColor = Color.YELLOW;
		case "blue": chosenColor = Color.BLUE;
		case "orange": chosenColor = Color.ORANGE;
		case "pink": chosenColor = Color.PINK;
		case "cyan": chosenColor = Color.CYAN;
		case "magenta": chosenColor = Color.MAGENTA;
		case "black": chosenColor = Color.BLACK;
		case "white": chosenColor = Color.WHITE;
		case "grey": chosenColor = Color.GRAY;
		case "lightGrey": chosenColor = Color.lightGray;
		case "darkGrey": chosenColor = Color.darkGray;
		}
		
		
		//System.out.println("*****************");
		//System.out.println("****"+Color.RED.toString()+"*******");
		//System.out.println("*****************");
		
		return chosenColor;
	}
	

}
