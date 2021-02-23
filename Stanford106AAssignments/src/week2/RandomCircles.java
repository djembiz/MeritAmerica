package week2;

import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.awt.*;

public class RandomCircles extends GraphicsProgram {
	
	public void run() {
		
		for (int i=0; i<10; i++) {
		double radius = rgen.nextDouble(5.0, 50.0);
		GOval circle = randomCircle(radius);
		Color randomColor = circleColor.nextColor();
		circle.setFillColor(randomColor);
		circle.setFilled(true);
		
		/* Add circle on Canvas, at Random Position Coordinates */
		
		add(circle, randomX(), randomY());
		}
		
	}
	
	/* **** RANDOM NUMBER GENERATORS ****** */
	private RandomGenerator rgen = RandomGenerator.getInstance();
	private RandomGenerator circleColor = RandomGenerator.getInstance();
	
	/* ***** METOHD TO CREATE A CIRCLE ***** */
	private GOval randomCircle(double radius) {
		GOval circle = new GOval(2 * radius, 2 * radius);
		return circle;
	}
	private int randomX() {
		/* Generate a random double value that will be our X coordinate */
		RandomGenerator X = RandomGenerator.getInstance();
		return X.nextInt(0, getWidth());
	}
	private int randomY() {
		/* Generate a random double value that will be our Y coordinate */
		RandomGenerator Y = RandomGenerator.getInstance();
		return Y.nextInt(0, getHeight());
	}
}
