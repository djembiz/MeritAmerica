package week4;
import java.io.*;
import java.util.*;

import acm.program.ConsoleProgram;

public class Histograms extends ConsoleProgram {
  public void run() {
	try{ 
	  BufferedReader rd = new BufferedReader(new FileReader("MidtermScores.txt"));
	  while(true) {
		  String line = rd.readLine();
		  if(line == null) break;
		  score = Integer.valueOf(line); 
		  recordDict(score); //Add records or update the HashMap
	   }
   //println(scoreMap.keySet());
   rd.close();				
     }
catch (IOException ex) {
			println("File does not exist");
} 
		displayHistograms(scoreMap);	
		
	}// End Run()
  
/* ****METHODS AND INSTANCE VARIABLES DECLARATION ****/

private void   displayHistograms(HashMap map) {
	for(int i=0;i<=100;i+=10) { 
		String key = toString(i);
		println(key +": " +map.get(key));
	}
}
private void recordDict(Integer score) {
	/* ** Determine the Key and add or update its value ****/
		for(int i=0;i<=100;i+=10) {
			if(i<= score && score < i+10) {
				String key = toString(i); //Return a string that is a key
				if(scoreMap.get(key)==null)
					scoreMap.put(key, "");
				 scoreMap.put(key, (scoreMap.get(key)+"*"));
				}
		}
			
			
}
public String toString(int i) {
	/* *** Constructs a String that will be a key for that HashMap *****/
	if(i==0) return i+""+i + "-"+ i+""+9;
	else if(i==100) return "  "+i;
	return i + "-" + (i+9);
}						 
private static HashMap<String, String> scoreMap = new HashMap<String, String>();
private Integer score;
}
