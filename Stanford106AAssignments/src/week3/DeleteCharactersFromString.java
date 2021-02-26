package week3;

import acm.program.ConsoleProgram;
public class DeleteCharactersFromString extends ConsoleProgram {
	
	public void run() {
		String str = readLine("Please, enter a String or a text: ");
		println("Input a character: ");   
		char ch = readLine().charAt(0);   
		println("The program will now remove the character "+ch+" from the string");
        String newString = removeCharacter(str, ch);
        println(newString);
	}
private String removeCharacter(String str, char ch) {
	String newString = "";
	for(int i=0; i<str.length(); i++) {
		if(str.charAt(i) != ch) 
			newString += str.charAt(i);
	}		
	return newString;			
 }
}


