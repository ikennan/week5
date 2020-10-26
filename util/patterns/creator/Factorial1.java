package util.patterns.creator;
import java.util.Scanner;

public class Factorial1 {

	public static long factorial (Long f) {
		//the recursion keeps running until m =1
		if (f == 1)
			return 1;
		
		else
			return f*factorial (f-1);
	}
	
	public static void main(String[] args, char[] factorial1) {
		System.out.print("input factorial here: ");
		Scanner scan = new Scanner(System.in);
		Long f = scan.nextLong();
				System.out.println(factorial(f));

	}
}

