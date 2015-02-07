import javax.swing.JOptionPane;


public class EstimateDriver { 
	public static final String WINDOW_TITLE = "Handy Estimate Tool";
		
	public static void main(String[] args) {
		// Declare array of choices
		// TODO: Why can't we use arrays in this assignment?
		String[] tasks = {"Painting", "Carpeting"};
		
		// Display choice dialog
		String choice = (String) JOptionPane.showInputDialog(null, 
			"Choose a task to calculate an estimate for:\n\n",
				WINDOW_TITLE, JOptionPane.QUESTION_MESSAGE, null, tasks, 
					"Painting"
		);
	}
}
