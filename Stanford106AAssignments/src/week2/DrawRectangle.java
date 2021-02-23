package week2;

import java.awt.event.*;
import acm.graphics.*;
import acm.program.*;
/** This class allows users to drag rectangles on the canvas */
public class DrawRectangle extends GraphicsProgram {
/** Runs the program */
public void run() {
addMouseListeners();
}
/** Called on mouse press to record the starting coordinates */
public void mousePressed(MouseEvent e) {
startX = e.getX();
startY = e.getY();
currentRect = new GRect(startX, startY, 0, 0);
currentRect.setFilled(true);
add(currentRect);
}
/** Called on mouse drag to reshape the current rectangle */
public void mouseDragged(MouseEvent e) {
double x = Math.min(e.getX(), startX);
double y = Math.min(e.getY(), startY);
double width = Math.abs(e.getX() - startX);
double height = Math.abs(e.getY() - startY);
currentRect.setBounds(x, y, width, height);
}
/* Private state */
private GRect currentRect; /* The current rectangle */
private double startX;  /* The initial mouse X position */
private double startY;  /* The initial mouse Y position */

}





