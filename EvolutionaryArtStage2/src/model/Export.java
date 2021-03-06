/**
 * DESCRIPTION OF THE CLASS
 * 
 * @author Ibrahim Farah
 *
 */

package model;

import java.awt.image.BufferedImage;
import java.io.File;
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
