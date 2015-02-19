import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JOptionPane;

/**
 * Handy Estimate Driver
 * 
 * Calculates the cost of a task (either painting or carpeting) and
 * also the cost of a job that includes multiple tasks.
 * 
 * Utilizes the Estimate class to calculate estimates.
 * 
 * @author Jamison Bryant <jbryan46@montgomerycollege.edu>
 *
 */
public class EstimateDriver { 
	private static final String GUI_TITLE = "Handy Estimate Calculator";
	
	public static void main(String[] args) {
		boolean valid;
		String input;
		int option;
		String task = "";
		double cost = 0.0;
		double footage = 0.0;
		double taskTotal = 0.0;
		double jobTotal = 0.0;
		
		do {
			// Prompt user for task choice
			valid = false;
			
			do {
				input = JOptionPane.showInputDialog(null, 
					"Enter a task to calculate an estimate for:\n(either " +
					"\"paint\" or \"carpet\")\n", GUI_TITLE, 
					JOptionPane.QUESTION_MESSAGE);
				
				// Validate user input
				if(input == null) {
					System.err.println("Application terminated by user!");
					System.exit(0);
				} else if(input.toLowerCase().equals("paint") || 
					input.toLowerCase().equals("carpet")) {
					task = input;
					valid = true;
				} else {
					JOptionPane.showMessageDialog(null, "\"" + input + "\" is " +
						"not a valid task!", GUI_TITLE, 
						JOptionPane.ERROR_MESSAGE);
				}
			} while(!valid);
			
			// Prompt user for square footage
			valid = false;
			
			do {
				input = JOptionPane.showInputDialog(null, 
					"Enter the square footage that will be " + task + "ed: ", 
					GUI_TITLE, JOptionPane.QUESTION_MESSAGE);
				
				if(input == null) {
					System.err.println("Application terminated by user!");
					System.exit(0);
				} else {
					// Validate user input
					try {
						footage = Double.parseDouble(input);
						
						if(footage <= 0.0) {
							throw new NumberFormatException();
						}
						
						valid = true;
					} catch(NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "\"" + input + 
							"\" is not a valid number!", GUI_TITLE, 
							JOptionPane.ERROR_MESSAGE);
					}
				}
			} while(!valid);
			
			// Prompt user for cost of materials
			valid = false;
			
			do {
				if(task.equals("paint")) {
					input = JOptionPane.showInputDialog(null, 
						"Enter the cost of one gallon of paint:", 
						GUI_TITLE, JOptionPane.QUESTION_MESSAGE);
				} else if(task.equals("carpet")) {
					input = JOptionPane.showInputDialog(null, 
						"Enter the cost of one square yard of carpet:", 
						GUI_TITLE, JOptionPane.QUESTION_MESSAGE);
				}
				
				if(input == null) {
					System.err.println("Application terminated by user!");
					System.exit(0);
				} else {
					// Validate user input
					try {
						cost = Double.parseDouble(input);
						
						if(cost <= 0.0) {
							throw new NumberFormatException();
						}
						
						valid = true;
					} catch(NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "\"" + input + 
							"\" is not a valid number!", GUI_TITLE, 
							JOptionPane.ERROR_MESSAGE);
					}
				}
			} while(!valid);
			
			// Perform estimate
			Estimate estimate = new Estimate();
			estimate.setTask(task);
			estimate.setSize(footage);
			estimate.setCost(cost);
			taskTotal = estimate.getTotal(); 
			jobTotal += taskTotal;
			
			// Format total as currency
			NumberFormat number = 
				NumberFormat.getCurrencyInstance(Locale.US);
			
			// Display estimate
			JOptionPane.showMessageDialog(null, "The cost of this task will " + 
				"be " + number.format(new Double(taskTotal)) + "\n" +
				"The cost of the job is " + number.format(new Double(jobTotal)), 
				GUI_TITLE, 
				JOptionPane.INFORMATION_MESSAGE);
			
			// Prompt for another estimate
			option = JOptionPane.showConfirmDialog(null, "Would you like to " +
				"calculate another estimate?", GUI_TITLE, 
				JOptionPane.YES_NO_OPTION);
		} while(option == JOptionPane.YES_OPTION);
		
		// Display the total job cost
	}
}
