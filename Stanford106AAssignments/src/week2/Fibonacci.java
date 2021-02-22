package week2;

import acm.program.*;

public class Fibonacci extends ConsoleProgram {
	
	/*    Variables   and Constants   */
    private static final int MAX_TERM_VALUE = 10000;
    int term = 0;
    int n = 0;
    
	public void run() {
		
		
		while(Fib(n) < MAX_TERM_VALUE) {
			term  = Fib(n);
			println(term);
			n++;
		}
		
		

	}
	
	/* The Fibonacci suite if a recursing method*/
	private int Fib(int n) {
		if(n <= 1)
		   return n;
		
		else return Fib(n-1) + Fib(n-2);
		
	}
}
