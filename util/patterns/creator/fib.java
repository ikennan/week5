package util.patterns.creator;

public class fib {
	public static long fib(long number) {
	      if ((number == 0) || (number == 1))
	         return number;
	      else
	         return fib(number - 1) + fib(number - 2);
	   }
	   public static void main(String[] args) {
		   
		   
		   System.out.println("The number at 0 is: " + fib (0));
		   System.out.println("The number at 7 is: " + fib (7));
	   }

}
