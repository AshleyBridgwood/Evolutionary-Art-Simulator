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
		
		
		//System.out.println("*****************");
		//System.out.println("****"+Color.RED.toString()+"*******");
		//System.out.println("*****************");
		
		return chosenColor;
	}
	

}
