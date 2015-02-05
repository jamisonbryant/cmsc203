/**
 * This program demonstrates how numeric types and operators behave in Java
 */

import java.util.Scanner;

public class NumericTypes {
	public static void main (String [] args) {
		// Create a scanner object
		Scanner scanner = new Scanner(System.in);
	
		// Identifiers
		final int NUMBER = 2;		// number of scores
		final int SCORE1 = 100;		// first test score
		final int SCORE2 = 95;		// second test score
		final int BOILING_IN_F = 212;  // freezing temperature
		int fToC;						// temperature in celsius
		double average;				// arithmetic average
		String output;					// line of output to print out
		//TASK #2 declare variables used here
		//TASK #3 declare variables used here
		//TASK #4 declare variables used here

		// Find the average of two numbers
		average = (int) (SCORE1 + SCORE2) / (double) NUMBER;
		output = SCORE1 + " and " + SCORE2 + " have an average of " + average;
		System.out.println(output);

		// Convert Fahrenheit to Celsius
		fToC = (int) (5.0/9.0 * (BOILING_IN_F - 32));
		output = BOILING_IN_F + " in Fahrenheit is " + fToC + " in Celsius.";
		System.out.println(output);
		System.out.println();

		// Prompt for and print the user's name
		String firstName, lastName, fullName = "";
		System.out.println("What is your first name? ");
		firstName = scanner.nextLine();
		System.out.println("What is your last name? ");
		lastName = scanner.nextLine();
		fullName = firstName + " " + lastName;
		System.out.println(fullName);

		System.out.println();
		
		// Modify the user's name
		char firstInitial = firstName.charAt(0);
		System.out.println("Your first initial: " + firstInitial);
		fullName = fullName.toUpperCase();
		System.out.println(fullName + " (your name) has " + fullName.length() + " characters");
		// get the first character from the user's first name
		// print out the user's first initial
		// convert the user's full name to all capital letters
		// print out the user's full name in all capital letters

		System.out.println();
		
		// Calculate the volume of a sphere
		double diameter, radius, volume;
		System.out.println("Enter a diameter (double): ");
		diameter = scanner.nextDouble();
		radius = diameter / 2.0;
		volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
		System.out.println("Volume of that sphere: " + volume);
	}	
}