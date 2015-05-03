/**
 * DESCRIPTION OF THE CLASS
 * 
 * @author Ashley Bridgwood
 *
 */

package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import view.UserInterface;

public class Export extends FileHandler {
	static String png = ".png";
	
	public static void export(String fileName, BufferedImage pingImage){	
		try{ImageIO.write(pingImage,"png",new File(fileName + png));
		UserInterface.exported(true);
		}catch (Exception e) {
			UserInterface.exported(false);
		};

	}
}
