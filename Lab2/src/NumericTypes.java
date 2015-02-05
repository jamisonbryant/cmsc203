/**
 * This program demonstrates how numeric types and operators behave in Java
 */

import java.util.Scanner;

public class NumericTypes {
	public static void main (String [] args) {
		// Create a scanner object
		Scanner scanner = new Scanner(System.in);
	
		// Identifiers
		final int NUMBER = 2;			// Number of scores
		final int SCORE1 = 100;			// First test score
		final int SCORE2 = 95;			// Second test score
		final int BOILING_IN_F = 212;	// The temperature (in F) to convert
		int fToC;						// The converted temperature (in C)
		double average;					// The calculated average
		String output;					// The output to print out
		String firstName;				// The user's first name
		String lastName;				// The user's last name
		String fullName;				// The user's full name
		char firstInitial;				// The user's first initial
		double diameter;				// The sphere's diameter
		double radius;					// The sphere's radius
		double volume;					// The sphere's volume

		// Find the average of two numbers
		System.out.println("=== TASK 1 ===");
		average = (int) (SCORE1 + SCORE2) / (double) NUMBER;
		output = SCORE1 + " and " + SCORE2 + " have an average of " + average;
		System.out.println(output);

		// Convert Fahrenheit to Celsius
		fToC = (int) (5.0/9.0 * (BOILING_IN_F - 32));
		output = BOILING_IN_F + " in Fahrenheit is " + fToC + " in Celsius.";
		System.out.println(output);
		System.out.println();

		// Prompt for and print the user's name
		System.out.println("=== TASK 2 ===");
		System.out.println("What is your first name? ");
		firstName = scanner.nextLine();
		System.out.println("What is your last name? ");
		lastName = scanner.nextLine();
		fullName = firstName + " " + lastName;
		System.out.println(fullName);

		System.out.println();
		
		// Modify the user's name
		System.out.println("=== TASK 3 ===");
		firstInitial = firstName.charAt(0);
		System.out.println("Your first initial: " + firstInitial);
		fullName = fullName.toUpperCase();
		System.out.println(fullName + " (your name) has " + fullName.length() + " characters");
		// get the first character from the user's first name
		// print out the user's first initial
		// convert the user's full name to all capital letters
		// print out the user's full name in all capital letters

		System.out.println();
		
		// Calculate the volume of a sphere
		System.out.println("=== TASK 4 ===");
		System.out.println("Enter a diameter (double): ");
		diameter = scanner.nextDouble();
		radius = diameter / 2.0;
		volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
		System.out.println("Volume of that sphere: " + volume);
	}	
}