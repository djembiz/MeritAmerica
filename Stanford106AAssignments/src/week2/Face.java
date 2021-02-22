
/**
 * Class: Face
 *        Create a GCompound and add a Head which is a rectangle
 *        two oval eyes, and a rectangular mouth
 * Name: Djeme Doli
 * Date: 02/22/2022
 */
package week2;

import acm.graphics.*;
import java.awt.*;

public class Face extends GCompound {
	/* ***** CONSTANTS ******/
	private static final double EYE_WIDTH = 0.10;
	private static final double EYE_HEIGHT = 0.10;
	private static final double MOUTH_WIDTH = 0.50;
	private static final double MOUTH_HEIGHT = 0.08	;
	
	/* ***** VARIABLES ******/
	private GRect head;
	private GOval leftEye, rightEye;
	private GRect mouth;
	private GPolygon nose;
	
	/*  FACE CONSTRUCTOR  
	 *  THE ORGANS SIZES ARE PROPORTIONAL TO THE HEAD SIZE  
	 *  */
	
	public Face(double HEAD_WIDTH, double HEAD_HEIGHT ) {
		
		head = new GRect(HEAD_WIDTH, HEAD_HEIGHT);
		leftEye = new GOval(EYE_WIDTH * HEAD_WIDTH, EYE_HEIGHT * HEAD_HEIGHT);
		rightEye = new GOval(EYE_WIDTH * HEAD_WIDTH, EYE_HEIGHT * HEAD_HEIGHT);
		mouth = new GRect(MOUTH_WIDTH * HEAD_WIDTH, MOUTH_HEIGHT * HEAD_HEIGHT);
		//nose = createNose(noseWidth, noseHeight);
	
	/* Add fill and color */
		head.setFilled(true);
		head.setFillColor(Color.DARK_GRAY);
		leftEye.setFilled(true);
		leftEye.setFillColor(Color.YELLOW);
		rightEye.setFilled(true);
		rightEye.setFillColor(Color.YELLOW);
		mouth.setFilled(true);
		mouth.setFillColor(Color.WHITE);
		
	/* Add elements to the compound */
		
		add(head, 0, 0);  //Our reference point is the center of the head with coordinates (0,0)
		/*  Left eye positioning*/
		add(leftEye, (HEAD_WIDTH * 0.25) - (EYE_WIDTH * HEAD_WIDTH)/2, 
				(HEAD_HEIGHT * 0.25) - (EYE_HEIGHT * HEAD_HEIGHT)/2 );
		/* Right eye positioning*/
		add(rightEye, (HEAD_WIDTH * 0.75)-(EYE_WIDTH * HEAD_WIDTH)/2, 
				 (HEAD_HEIGHT * 0.25 ) - (EYE_HEIGHT * HEAD_HEIGHT)/2 );
		/* Mouth positioning*/
		add(mouth, (HEAD_WIDTH * 0.5) - (MOUTH_WIDTH * HEAD_WIDTH)/2, 
				   (HEAD_HEIGHT * 0.75) - (MOUTH_HEIGHT * HEAD_HEIGHT)/2 );
		
	}
	/*private GPolygon createNose(double width, double height) {
		GPolygon nose = new GPolygon();
		nose.addVertex(-width/2, 0);
		nose.addVertex(0, -height*4/3);
		nose.addVertex(width/2, 0);
		return nose;
	} */

}
