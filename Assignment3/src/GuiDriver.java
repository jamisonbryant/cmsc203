import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * Creates the GUI and handles the user interaction of the application.
 *
 * @author  Jamison Bryant (jbryan46@montgomerycollege.edu)
 * @version 1.2
 */
public class GuiDriver extends JPanel {
	/**
	 * The order being built.
	 */
	private BurgerOrder order;
	
	/**
	 * A convenience variable for accessing the GUI subtotal text field.
	 */
	private JTextField subtotalTextField;
	
	/**
	 * A convenience variable for accessing the GUI tax text field.
	 */
	private JTextField taxTextField;
	
	/**
	 * A convenience variable for accessing the GUI total text field.
	 */
	private JTextField totalTextField;
	
	/**
	 * Creates the GUI of the application.
	 */
	public GuiDriver() {
		// Create GUI
		super(new BorderLayout());
		
		// Create order
		order = new BurgerOrder();
		
		// Create master panels
		JPanel topMasterPanel = new JPanel();
		JPanel bottomMasterPanel = new JPanel();
		
		// Create meal panel
		JPanel mealPanel = new JPanel();
		mealPanel.setLayout(new BoxLayout(mealPanel, BoxLayout.Y_AXIS));
		mealPanel.setBorder(BorderFactory.createTitledBorder("Meal Type"));
		
			// Create meal radio buttons
			MealRadioButtonListener listener = new MealRadioButtonListener(this);
		
			JRadioButton hamburgerButton = new JRadioButton("Hamburger");
			hamburgerButton.setSelected(true);
			hamburgerButton.setActionCommand("hamburger");
			hamburgerButton.addActionListener(listener);
			
			JRadioButton cheeseburgerButton = new JRadioButton("Cheeseburger");
			cheeseburgerButton.setActionCommand("cheeseburger");
			cheeseburgerButton.addActionListener(listener);
			
			JRadioButton doubleCheeseburgerButton = new JRadioButton("Double Cheeseburger");
			doubleCheeseburgerButton.setActionCommand("double_cheeseburger");
			doubleCheeseburgerButton.addActionListener(listener);
			
			// Add meal radio buttons to button group
			ButtonGroup mealTypeButtonGroup = new ButtonGroup();
			mealTypeButtonGroup.add(hamburgerButton);
			mealTypeButtonGroup.add(cheeseburgerButton);
			mealTypeButtonGroup.add(doubleCheeseburgerButton);
		
		// Add meal radio buttons to panel
		mealPanel.add(hamburgerButton);
		mealPanel.add(cheeseburgerButton);
		mealPanel.add(doubleCheeseburgerButton);
			
		// Create condiments panel
		JPanel condimentsPanel = new JPanel();
		condimentsPanel.setBorder(BorderFactory.createTitledBorder("Condiments"));
		
			// Create condiments subpanels
			JPanel vegetableCondimentsPanel = new JPanel();
			vegetableCondimentsPanel.setLayout(new BoxLayout(vegetableCondimentsPanel, BoxLayout.Y_AXIS));
			JPanel sauceCondimentsPanel = new JPanel();
			sauceCondimentsPanel.setLayout(new BoxLayout(sauceCondimentsPanel, BoxLayout.Y_AXIS));
		
			// Create condiments checkboxes
			JCheckBox lettuceCheckbox = new JCheckBox("Lettuce");
			lettuceCheckbox.setActionCommand("lettuce");
			lettuceCheckbox.addActionListener(new CondimentsCheckboxListener(this, lettuceCheckbox));
			
			JCheckBox tomatoesCheckbox = new JCheckBox("Tomatoes");
			tomatoesCheckbox.setActionCommand("tomatoes");
			tomatoesCheckbox.addActionListener(new CondimentsCheckboxListener(this, tomatoesCheckbox));
			
			JCheckBox onionsCheckbox = new JCheckBox("Onions");
			onionsCheckbox.setActionCommand("onions");
			onionsCheckbox.addActionListener(new CondimentsCheckboxListener(this, onionsCheckbox));
			
			JCheckBox mayoCheckbox = new JCheckBox("Mayonnaise");
			mayoCheckbox.setActionCommand("mayo");
			mayoCheckbox.addActionListener(new CondimentsCheckboxListener(this, mayoCheckbox));
			
			JCheckBox ketchupCheckbox = new JCheckBox("Ketchup");
			ketchupCheckbox.setActionCommand("ketchup");
			ketchupCheckbox.addActionListener(new CondimentsCheckboxListener(this, ketchupCheckbox));
			
			JCheckBox mustardCheckbox = new JCheckBox("Mustard");
			mustardCheckbox.setActionCommand("Mustard");
			mustardCheckbox.addActionListener(new CondimentsCheckboxListener(this, mustardCheckbox));
			
			// Add condiments checkboxes to subpanels
			vegetableCondimentsPanel.add(lettuceCheckbox);
			vegetableCondimentsPanel.add(tomatoesCheckbox);
			vegetableCondimentsPanel.add(onionsCheckbox);
			
			sauceCondimentsPanel.add(mayoCheckbox);
			sauceCondimentsPanel.add(ketchupCheckbox);
			sauceCondimentsPanel.add(mustardCheckbox);
			
		// Add condiments radio buttons to panel
		condimentsPanel.add(vegetableCondimentsPanel);
		condimentsPanel.add(sauceCondimentsPanel);	
		
		// Create action buttons panel
		JPanel buttonsPanel = new JPanel();
		
			// Create action buttons
			JButton getTotalButton = new JButton("Get Total");
			getTotalButton.setActionCommand("get_total");
			getTotalButton.addActionListener(new ActionButtonListener(this));
			
			JButton printReceiptButton = new JButton("Print Receipt");
			printReceiptButton.setActionCommand("print_receipt");
			printReceiptButton.addActionListener(new ActionButtonListener(this));
			
			JButton exitButton = new JButton("Exit");
			exitButton.setActionCommand("exit");
			exitButton.addActionListener(new ActionButtonListener(this));
			
			// Add action buttons to button group
			ButtonGroup actionButtonButtonGroup = new ButtonGroup();
			actionButtonButtonGroup.add(getTotalButton);
			actionButtonButtonGroup.add(printReceiptButton);
			actionButtonButtonGroup.add(exitButton);
			
		// Add action buttons to panel
		buttonsPanel.add(getTotalButton, BorderLayout.PAGE_START);
		buttonsPanel.add(printReceiptButton, BorderLayout.CENTER);
		buttonsPanel.add(exitButton, BorderLayout.PAGE_END);
		
		// Create results panel
		JPanel resultsPanel = new JPanel();
		
			// Create result types subpanels
			JPanel subtotalResultsPanel = new JPanel();
			JPanel taxResultsPanel = new JPanel();
			JPanel totalResultsPanel = new JPanel();
			
			// Create results labels
			JLabel subtotalLabel = new JLabel("Subtotal");
			JLabel taxLabel = new JLabel("Tax");
			JLabel totalLabel = new JLabel("Total");
			
			// Create results text fields
			subtotalTextField = new JTextField("$0.00");
			subtotalTextField.setEditable(false);
			
			taxTextField = new JTextField("$0.00");
			taxTextField.setEditable(false);
			
			totalTextField = new JTextField("$0.00");
			totalTextField.setEditable(false);
			
			// Add results controls to results subpanels
			subtotalResultsPanel.add(subtotalLabel, BorderLayout.LINE_START);
			subtotalResultsPanel.add(subtotalTextField, BorderLayout.CENTER);
			
			taxResultsPanel.add(taxLabel, BorderLayout.LINE_START);
			taxResultsPanel.add(taxTextField, BorderLayout.CENTER);
			
			totalResultsPanel.add(totalLabel, BorderLayout.LINE_START);
			totalResultsPanel.add(totalTextField, BorderLayout.CENTER);
			
		// Add results controls to results panels
		resultsPanel.add(subtotalResultsPanel, BorderLayout.PAGE_START);
		resultsPanel.add(taxResultsPanel, BorderLayout.CENTER);
		resultsPanel.add(totalResultsPanel, BorderLayout.PAGE_END);
		
		// Add GUI controls to master panels
		topMasterPanel.add(mealPanel, BorderLayout.LINE_START);
		topMasterPanel.add(condimentsPanel, BorderLayout.LINE_END);
		bottomMasterPanel.add(buttonsPanel, BorderLayout.LINE_START);
		bottomMasterPanel.add(resultsPanel, BorderLayout.LINE_END);
		
		// Add GUI controls to GUI
		add(topMasterPanel, BorderLayout.PAGE_START);
		add(bottomMasterPanel, BorderLayout.PAGE_END);
	}
	
	/**
	 * Handles the action fired by clicking a meal radio button.
	 *
	 * @author Jamison Bryant (jbryan46@montgomerycollege.edu)
	 */
	public class MealRadioButtonListener implements ActionListener {
		private GuiDriver driver;
		
		/**
		 * Instantiates the action listener.
		 * 
		 * @param driver The GUI driver master class
		 */
		public MealRadioButtonListener(GuiDriver driver) {
			this.driver = driver;
		}
		
		/**
		 * Does the action required when a radio button is clicked.
		 * 
		 * Passes the action command of the selected radio button to the GUI's
		 * order, which uses it as an internal identifier for the meal type
		 * and it's price.
		 */
		public void actionPerformed(ActionEvent e) {
			String actionCommand = e.getActionCommand();
			
			if(actionCommand.equals("hamburger")) {
				driver.order.setMeal("hamburger");
			} else if(actionCommand.equals("cheeseburger")) {
				driver.order.setMeal("cheeseburger");
			} else if(actionCommand.equals("double_cheeseburger")) {
				driver.order.setMeal("double_cheeseburger");
			}
		}
	}
	
	/**
	 * Handles the action fired by clicking a condiment checkbox.
	 *
	 * @author Jamison Bryant (jbryan46@montgomerycollege.edu)
	 */
	public class CondimentsCheckboxListener implements ActionListener {
		private GuiDriver driver;
		private JCheckBox checkbox;
		
		/**
		 * Instantiates the action listener.
		 * 
		 * @param driver   The GUI driver master class
		 * @param checkbox The checkbox being checked/unchecked
		 */
		public CondimentsCheckboxListener(GuiDriver driver, JCheckBox checkbox) {
			this.driver = driver;
			this.checkbox = checkbox;
		}
		
		/**
		 * Does the action required when a checkbox is clicked.
		 * 
		 * If the checkbox is selected, the order's internal condiments counter 
		 * is incremented by 1. If the checkbox is not selected, the order's 
		 * internal condiments counter is decremented by 1.
		 */
		public void actionPerformed(ActionEvent e) {
			if(checkbox.isSelected()) {
				driver.order.addCondiment();			
			} else {
				driver.order.removeCondiment();
			}
		}
	}
	
	/**
	 * Handles the action fired by clicking an action button.
	 *
	 * @author Jamison Bryant (jbryan46@montgomerycollege.edu)
	 */
	public class ActionButtonListener implements ActionListener {
		private GuiDriver driver;
		
		/**
		 * Instantiates the action listener.
		 * 
		 * @param driver The GUI driver master class
		 */
		public ActionButtonListener(GuiDriver driver) {
			this.driver = driver;
		}
		
		/**
		 * Does the action required when an action button is pressed.
		 * 
		 * If the "Get Total" button is pressed (identified by the action
		 * command "get_total") then the currently selected form controls are
		 * passed to the GUI's order object and the subtotal is calculated,
		 * then the GUI's text fields are updated.
		 * 
		 * If the "Print Receipt" button is pressed (identified by the action
		 * command "print_receipt") then data about the order is fetched and
		 * a newline-delimited string is built and displayed to the user in an
		 * alert box.
		 * 
		 * Finally, if the "Exit" button is pressed (identified by the action
		 * command "exit"), the application is terminated. Without benefits.
		 */
		public void actionPerformed(ActionEvent e) {
			String actionCommand = e.getActionCommand();
			
			if(actionCommand.equals("get_total")) {
				// Get order data
				double subtotal = driver.order.getSubtotal();
				double tax = driver.order.getTax();
				double total = driver.order.getTotal();
				
				// Set up currency formatter
				Currency usd = Currency.getInstance("USD");
				NumberFormat money = NumberFormat.getCurrencyInstance(Locale.US);
				money.setCurrency(usd);
				
				// Update text fields
				driver.subtotalTextField.setText(money.format(subtotal));
				driver.taxTextField.setText(money.format(tax));
				driver.totalTextField.setText(money.format(total));
			} else if(actionCommand.equals("print_receipt")) {
				// Display receipt dialog box
				JOptionPane.showMessageDialog(this.driver, driver.order.getReceipt());
			} else if(actionCommand.equals("exit")) {
				System.exit(0);
			}			
		}
	}
	
	/**
	 * Launches the application.
	 * 
	 * @param args An array of command-line arguments
	 */
	public static void main(String[] args) {
		// Create window
		JFrame gui = new JFrame("Hartatak Burger App");
		
		// Configure window
		gui.setSize(800, 600);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.getContentPane().add(new GuiDriver());
		
		// Show window
		gui.pack();
		gui.setLocationRelativeTo(null);
		gui.setVisible(true);
	}
}
	