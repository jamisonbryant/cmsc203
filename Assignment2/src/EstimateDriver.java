import javax.swing.JOptionPane;


public class EstimateDriver { 
	private static final String title = "Handy Estimate Calculator";
	
	public static void main(String[] args) {
		boolean valid = false;
		String choice;
		
		do {
			// Prompt user for task choice
			choice = JOptionPane.showInputDialog(null, 
				"Enter a task to calculate an estimate for:\n(either " +
				"\"painting\" or \"carpeting\")\n", title, 
				JOptionPane.QUESTION_MESSAGE);
			
			// Validate user input
			if(choice.equals("painting") || choice.equals("carpeting")) {
				valid = true;
			} else {
				JOptionPane.showMessageDialog(null, "\"" + choice + "\" is " +
						"not a valid task!", title, JOptionPane.ERROR_MESSAGE);
			}
		} while(!valid);
	}
}
