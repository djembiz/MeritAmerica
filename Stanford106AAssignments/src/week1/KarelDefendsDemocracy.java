/**
 * Program: KarelDefendsDemiocracy
 * Author: Djeme Doli
 * Date: 02/15/2021
 * 
 *  The absence of a beeper in the middle square indicates the intent of the voter to cast a vote,
 *  Karel will thus remove any existing chad in the other squares. 
 *  But If there is a beeper in the middle square, Karel must assume that the voter did not intend
 *  to cast a vote in that column and move on to the next.
 *  **/
package week1;
import stanford.karel.*;

public class KarelDefendsDemocracy extends SuperKarel {

	public void run() {
	 do {	
		 /*Karel can move immediately into the voting area 
		  * as it is facing the hole directly at the center of the rectangles. 
		  */ 
		move(); 
		if(beepersPresent()) //Check if there is a beeper in the middle square
		{
			move();
		}
		else {
		clearRectangle();
		exitRectangle();
		}
	 }
	 while(frontIsClear());
		
				
	}
/*####################################  DEFINING METHODS  ###################################*/

private void clearRectangle()   
{
/* If there is no beeper in the middle square, Karel will check and remove any other existing
 * beeper, starting with the top square
 * */
	turnLeft();  //To face North
	move();
	clearBeepers();
	turnAround(); //To face South and make two move toward the bottom square
	move();
	move();
	clearBeepers(); 
}
		
private void clearBeepers()      
{
	/* As long as there is a beeper, pick it up */
	while(beepersPresent()) {pickBeeper();}
}
                    
private void exitRectangle()     
{
	/* Karel is facing South after cleaning the bottom square,
	 * turn around to face North 
	 * */
	turnAround();
	move();
	while(notFacingEast()) {turnLeft();} //Karel must face East to exit the rectangle
	move();
}


}