/**
 * Gives the user information on the efficiency (measured in MPG)
 * of the engine of their car, given a number of miles driven and
 * the gallons of gas used to drive the distance.
 * 
 * Author: Jamison Bryant
 * Date: 2/5/2015
 */

import java.util.Scanner;

public class Mileage {
	public static void main(String[] args) {
		// Declare variables
		double miles;								// Miles driven
		double gallons;								// Gallons (of gas) used
		double mpg;									// MPG
		Scanner scanner = new Scanner(System.in);	// User input getter
		
		// Display program intro
		System.out.println("This program calculates MPG (miles per gallon)");
		System.out.println();
		System.out.println("=== TASK 5 ===");
		
		// Prompt for miles driven
		System.out.println("Enter miles driven: ");
		miles = scanner.nextDouble();
		
		// Prompt for gallons used
		System.out.println("Enter gallons used: ");
		gallons = scanner.nextDouble();
		
		// Calculate MPG
		// The purpose of this calculation is to determine the efficiency
		// of the user's engine. The higher the MPG, the more efficient
		// the engine (because less gas is used to go further).
		mpg = miles / gallons;
		
		// Print results
		System.out.println("Miles: " + miles);
		System.out.println("Gallons: " + gallons);
		System.out.println("MPG: " + mpg);
	}
}
