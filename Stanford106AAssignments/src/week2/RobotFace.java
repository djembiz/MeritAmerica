/**
 * Program: RobaotFace
 *          Create a GCompound consisting of a face
 *          with two eyes and a mouth
 * Name: Djeme Doli
 * Date: 02/22/2021
 */
package week2;

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class RobotFace extends GraphicsProgram {
	
	private static final int HEAD_WIDTH = 260;
	private static final int HEAD_HEIGHT = 350;
	
	public void run() {
		
		/* HERE, WE CREATE A NEW OBJECT CALLED "myRobotFace" 
		 * "myRobotFace" IS AN INSTANCE OF THE CLASS "Face" IN THE PACKAGE
		 * NO NEED TO IMPORT THE CLASS BECAUSE WE ARE IN THE SAME PACKAGE
		 */
		Face myRobotFace = new Face(HEAD_WIDTH, HEAD_HEIGHT);
		
		/*  WE WANT TO CENTER THE NEW OBJECT IN THE CANVAS   */
		add(myRobotFace, (getWidth() - HEAD_WIDTH)/2, (getHeight() - HEAD_HEIGHT)/2);
	}
	
}
