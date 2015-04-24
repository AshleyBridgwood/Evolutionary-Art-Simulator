/**
 * DESCRIPTION OF THE CLASS
 * 
 * @author Ashley Bridgwood
 *
 */

package model;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Export extends FileHandler {
	static String png = ".png";
	
	public static void export(String fileName, BufferedImage pingImage){	
		try{ImageIO.write(pingImage,"png",new File(fileName + png));}catch (Exception e) {};

	}

}
