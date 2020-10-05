/*
* File: Fibo.java
* --------------------
* This program lists the terms in the Fibonacci sequence up to
* a constant MAX_TERM_VALUE, (6765) which is the largest Fibonacci term
* the program will display.
*/




import acm.program.*;

public class Fibo extends ConsoleProgram {
	
	public void run () 
	
	{
		
		int f1 = 0;
		int f2 = 1;
		
		println ("This program will list the Fibonacci sequence.");
		
		while (f1 <= MAX_TERM_VALUE) 
		{
			println (f1);
			int f3 = f1 + f2;
			f1 = f2;
			f2 = f3;
		}
	}
	
	/*     */
	private static final int MAX_TERM_VALUE = 10000;
	

}
