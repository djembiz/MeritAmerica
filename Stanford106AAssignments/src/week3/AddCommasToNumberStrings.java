package week3;

import acm.program.*;
/* **** Method **** */


public class AddCommasToNumberStrings extends ConsoleProgram {
	public void run() {
	
		     digits = readLine("Enter a numeric string: ");
		     String newDigit = addCommasToNumericString(digits);
		     println(newDigit);
	 }
	
		
/* ****** Instance Variables ********* */
	private String digits = "";

	/* ****** METHOD DECLARATION ***** */
	
private String addCommasToNumericString(String str) {
	int len = str.length();
	String tempDigits = "";
	while(len > 3) {
	int start = len - 3;
	tempDigits = ","+ str.substring(start, len) + tempDigits;
	len = start;	
	}
	return (str.substring(0, len) + tempDigits);
 }		
}
