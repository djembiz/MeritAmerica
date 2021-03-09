package week4;
import java.util.*;
import acm.program.ConsoleProgram;

public class NameCounts extends ConsoleProgram {
	
	public void run() {
		while(true) {
		    Integer count =0;
			String name = readLine("Enter name: ");
			if(name.equals("")) break;
			
		    if(namesMap.containsKey(name)) {
			   count = namesMap.get(name)+1;
			   namesMap.put(name, count);
		    }
		    else {
		       count+=1;
		       namesMap.put(name, count);
			  }
			}
		for(String name:namesMap.keySet()) {
			println("\nEntry "+name +" has count " +namesMap.get(name));
			
		}

	}
	private HashMap<String, Integer> namesMap = new HashMap <String, Integer>();
}
