/**
 * Assignment 1: Program to Evaluate a Function
 * 
 * Prompts the user for an integer, then passes the integer to the calculate()
 * function where it is run through the formula given in the assignment. The
 * result is returned to the main method which displays it to the user.
 * 
 * @author Jamison Bryant <jbryan46@montgomerycollege.edu>
 */

import java.util.Scanner;

public class EvalFunction {
	public static void main(String[] args) {
		// Display program introduction
		System.out.println("Assignment 1: Program to Evaluate a Function");
		System.out.println("Given x, computes the value of the function f(x) = 2*x^3 - 5*x^2 - 12*x + 4");
//		System.out.println("CMSC 203 (Myers-Kartchner), Spring 2015");
//		System.out.println("Jamison Bryant <jbryan46@montgomerycollege.edu>");
		System.out.println();
		
		// Instantiate input scanner
		Scanner scanner = new Scanner(System.in);

		// Prompt user for integer
		System.out.print("Enter an integer value for x for which f(x) will be evaluated: ");
		String input = scanner.next();
		int var, result = 0;
		
		// Validate user's input/perform calculations/display result
		try {
			// Validate user's input by converting it to an int
			var = Integer.parseInt(input);
			
			// If we get here no exception was thrown -> input was valid
			result = calculate(var);
		} catch(NumberFormatException e) {
			// Display an error message and quit (abnormal exit status)
			System.err.println("That is not an integer!");
			System.exit(-1);
		}
		
		// Display user's input to user
		System.out.println();
		System.out.println("You entered: " + input);
		
		// Display result to user
		System.out.println("The result was: " + result);
		
		// Close input scanner
		scanner.close();
		
		// Display program conclusion
		System.out.println();
		System.out.println("Goodbye - Jamison Bryant");
	}
	
	private static int calculate(int x) {
		return (int) (2 * Math.pow(x, 3) - 5 * Math.pow(x, 2) - 12 * x + 4);
	}
}
