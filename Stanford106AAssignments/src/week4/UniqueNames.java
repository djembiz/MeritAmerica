package week4;

import java.util.*;
import acm.program.ConsoleProgram;

public class UniqueNames extends ConsoleProgram {
	
	public void run() {
		while(true) {
		   varName = readLine("Enter name: ");
		   if (varName.equals("")) break;
		   namesList.add(varName);
		}
		
			for (int i=0;i<namesList.size()-2;i++) {
		       for(int j=(namesList.size() - 1);j> i; j--) 
		        {
			      if(namesList.get(i).equals(namesList.get(j)))
				   {namesList.remove(j);}
				}
	         }
          println("Unique names list contains:\n");
          for(String name:namesList) println( name);  	
	}
private ArrayList<String> namesList = new ArrayList<String>();
private String varName;
}
