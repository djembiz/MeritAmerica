package week2;

import acm.program.*;
import acm.graphics.*;
import java.awt.*;
import java.awt.event.*;

public class DrawingLines extends GraphicsProgram {
	public void init() {
		addMouseListeners();	
	}
	
    
	/* MOUSE METHODS */
	
	/* Get the coordinates of the starting point when we press the mouse button */
public void mousePressed(MouseEvent a) {
         x0 = a.getX();
         y0 = a.getY();	        
}

/* Get the coordinates of the ending point while we drag the mouse */
public void mouseDragged(MouseEvent a) {
	x1 = a.getX();
	y1 = a.getY();
	line = new GLine(x0,y0, x1, y1);
	line.setColor(Color.BLACK);
	add(line);
}
private GLine line;
private int x0, y0, x1, y1;
}
