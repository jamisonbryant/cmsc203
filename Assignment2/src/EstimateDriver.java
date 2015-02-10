import javax.swing.JOptionPane;


public class EstimateDriver { 
	private static final String title = "Handy Estimate Calculator";
	
	public static void main(String[] args) {
		boolean valid;
		String input;
		String choice;
		int footage;
		
		// Prompt user for task choice
		valid = false;
		do {
			input = JOptionPane.showInputDialog(null, 
				"Enter a task to calculate an estimate for:\n(either " +
				"\"painting\" or \"carpeting\")\n", title, 
				JOptionPane.QUESTION_MESSAGE);
			
			// Validate user input
			if(input.equals("painting") || input.equals("carpeting")) {
				choice = input;
				valid = true;
			} else {
				JOptionPane.showMessageDialog(null, "\"" + input + "\" is " +
					"not a valid task!", title, JOptionPane.ERROR_MESSAGE);
			}
		} while(!valid);
		
		// Prompt user for square footage
		valid = false;
		do {
			// Prompt user for task choice
			input = JOptionPane.showInputDialog(null, 
				"Enter the square footage that will be painted/carpeted: ", 
				title, JOptionPane.QUESTION_MESSAGE);
			
			// Validate user input
			try {
				footage = Integer.parseInt(input);
				
				if(footage <= 0) {
					throw new NumberFormatException();
				}
				
				valid = true;
			} catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "\"" + input + "\" is " +
					"not a valid number!", title, JOptionPane.ERROR_MESSAGE);
			}
		} while(!valid);
	}
}
