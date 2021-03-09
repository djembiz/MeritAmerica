/** Name:  Djeme Doli
 * Date: 03/09/2021
 * Program: Read a file and count the number of LINES, WORDS, and CHARACTERS.
 *          If the file doesn't exist or cannot be found, a new file will be created
 *          and read
 */
package week4;

import java.io.*;
import java.util.*;
import acm.program.*;

public class WordCount extends ConsoleProgram {
	
	
	public void run() {
		/* *** Read a file, if exception thrown, create and write the file *****/
		try {
			rd = new BufferedReader(new FileReader("lear.txt"));
			countFile();
		} 
		catch (IOException ex) {
			println("File cannot be found, Creating a new file.....\n");
			createWriteFile();	
			countFile();
			}
			
	}
		
	
private BufferedReader rd;
private PrintWriter wr;

/* **** Method to create and write a new file ***/
private void createWriteFile() {
	try{
		wr = new PrintWriter(new FileWriter("lear.txt"));
		
		println("Type the new file");
		
		while(true) {
		String line = readLine();
		if(line.equals("")) break;
		wr.write(line + "\n");
	    }
		/* ** Close the file written, then open it to READ mode **/
		wr.close();
		rd = new BufferedReader(new FileReader("lear.txt"));
	}
	catch (IOException e) {
		println();
	}	
}

/* **** Method to count lines, words and characters ******/
private void countFile() {
	int lineCount = 0, wordCount = 0, characterCount = 0;
	String delimiters = "[\\s ']";
	while(true) {
		try{
			String line= rd.readLine();
		    if(line==null) break;
		    else{		
		    	 lineCount+=1;
		    	 characterCount += line.length();
		         String[] arr = line.split(delimiters);
		         wordCount+= arr.length;	       
		        } 
		    }
		 catch(IOException e)
		    {
			 println("Exception");
		    }
	}
	println("Lines: " +lineCount + "\n" + "Words: " +wordCount +"\n" + "Chars: " +characterCount +"\n");		
}//End Method

}

