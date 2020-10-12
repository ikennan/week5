
import acm.program.*;


public class addCommasToNumericString extends ConsoleProgram{
	
    //private String addCommasToNumericString (String digits) {
	
	public void run () {
	String output = "";
	String numbers = readLine ("Enter a numeric string: ");
	
	int len = numbers.length();
	int nDigits = 0; {
	for (int i = len - 1; i >= 0; i--) 
	{
	output = numbers.charAt(i) + output;
	nDigits++;
	if (((nDigits % 3) == 0) && (i > 0)) {
	output = "," + output;
	}
	System.out.println(output);
	
	}
	return;
	
	}

}
	
}

