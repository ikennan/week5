import acm.program.*;

public class FindsTheSecondLargestNumber extends ConsoleProgram {

private static final int endofInputlist = 0;
	
	public void run() {
		println("Enter value" + endofInputlist);
		println("this is the end of the list of numbers. Thank you");
		
		
		int ThisIsThelargestNumber = 0;
		int ThisIsTheSecondLargest = -1;
		while (true) {
			int number = readInt("?");
			if (number == endofInputlist) {
				
				
				if (ThisIsThelargestNumber == -1 || ThisIsTheSecondLargest == -1) {
					println ("You cannot enter the last number as the first or second number");
					break;
				}
				else {
					println("The is the largest value  " + ThisIsThelargestNumber);
					println("The is second largest  " + ThisIsTheSecondLargest);
					break;
				}
			}
			
			if (number > ThisIsThelargestNumber) {
				ThisIsTheSecondLargest = ThisIsThelargestNumber;
				ThisIsThelargestNumber = number;
			}
			else if (number > ThisIsTheSecondLargest) {
				ThisIsTheSecondLargest = number;
			}
		}
	}	
}
