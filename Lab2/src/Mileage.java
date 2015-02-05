import java.util.Scanner;

public class Mileage {
	public static void main(String[] args) {
		// Declare variables
		double miles, gallons;
		double mpg;
		Scanner scanner = new Scanner(System.in);
		
		// Display program intro
		System.out.println("This program calculates MPG (miles per gallon)");
		System.out.println();
		
		// Prompt for miles driven
		System.out.println("Enter miles driven: ");
		miles = scanner.nextDouble();
		
		// Prompt for gallons used
		System.out.println("Enter gallons used: ");
		gallons = scanner.nextDouble();
		
		// Calculate MPG
		mpg = miles / gallons;
		
		// Print results
		System.out.println("Miles: " + miles);
		System.out.println("Gallons: " + gallons);
		System.out.println("MPG: " + mpg);
	}
}
