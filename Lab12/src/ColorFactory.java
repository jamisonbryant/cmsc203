import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class ColorFactory extends JFrame {
	public static int WIDTH = 500;
	public static int HEIGHT = 300;
	private String title = "Color Factory";
	private JLabel instructions;
	
	public static void main(String[] args) {
		// Initialize application
		ColorFactory cf = new ColorFactory();
	}
	
	public ColorFactory() {
		// Set window title and size
		setTitle(title);
		setSize(WIDTH, HEIGHT);
		
		// Set close operation (exit)
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Set window layout
		setLayout(new BorderLayout());
		
		// Build top panel
		JPanel topPanel = buildTopPanel();
		
		// Add panel to window
		add(topPanel, BorderLayout.NORTH);
		
		// Build bottom panel
		JPanel bottomPanel = buildBottomPanel();
		
		// Add panel to window
		add(bottomPanel, BorderLayout.SOUTH);
		
		// Build instructions label
		instructions = new JLabel("Top buttons change the panel color and " +
				"bottom radio buttons change the text color!");
		
		// Add label to window
		add(instructions, BorderLayout.CENTER);
		
		// Pack and display frame
		pack();
		setVisible(true);
	}
	
	private JPanel buildTopPanel() {
		// Create panel
		JPanel topPanel = new JPanel(new FlowLayout());
		
		// Set panel background color
		topPanel.setBackground(Color.WHITE);
		
		// Create buttons
		JButton redButton = new JButton("Red");
		JButton orangeButton = new JButton("Orange");
		JButton yellowButton = new JButton("Yellow");
		
		// Set button background colors
		redButton.setBackground(Color.RED);
		orangeButton.setBackground(Color.ORANGE);
		yellowButton.setBackground(Color.YELLOW);
		
		// Set button actions
		ButtonListener listener = new ButtonListener(this);
		redButton.setActionCommand("R");
		redButton.addActionListener(listener);
		orangeButton.setActionCommand("O");
		orangeButton.addActionListener(listener);
		yellowButton.setActionCommand("Y");
		yellowButton.addActionListener(listener);
		
		// Group buttons together
		ButtonGroup buttons = new ButtonGroup();
		buttons.add(redButton);
		buttons.add(orangeButton);
		buttons.add(yellowButton);
		
		// Add buttons to panel
		topPanel.add(redButton);
		topPanel.add(orangeButton);
		topPanel.add(yellowButton);
		
		// Return built panel
		return topPanel;
	}
	
	private JPanel buildBottomPanel() {
		// Create panel
		JPanel bottomPanel = new JPanel(new FlowLayout());
		
		// Set panel background color
		bottomPanel.setBackground(Color.WHITE);
		
		// Create radio buttons
		JRadioButton greenRadioButton = new JRadioButton("Green");
		JRadioButton blueRadioButton = new JRadioButton("Blue");
		JRadioButton cyanRadioButton = new JRadioButton("Cyan");
		
		// Set radio button text colors
		greenRadioButton.setForeground(Color.GREEN);
		blueRadioButton.setForeground(Color.BLUE);
		cyanRadioButton.setForeground(Color.CYAN);
		
		// Set radio button actions
		RadioButtonListener listener = new RadioButtonListener(this);
		greenRadioButton.setActionCommand("G");
		greenRadioButton.addActionListener(listener);
		blueRadioButton.setActionCommand("B");
		blueRadioButton.addActionListener(listener);
		cyanRadioButton.setActionCommand("C");
		cyanRadioButton.addActionListener(listener);
		
		// Group radio buttons together
		ButtonGroup radioButtons = new ButtonGroup();
		radioButtons.add(greenRadioButton);
		radioButtons.add(blueRadioButton);
		radioButtons.add(cyanRadioButton);
		
		// Add radio buttons to panel
		bottomPanel.add(greenRadioButton);
		bottomPanel.add(blueRadioButton);
		bottomPanel.add(cyanRadioButton);
		
		// Return built panel
		return bottomPanel;
	}
	
	class ButtonListener implements ActionListener {
		private ColorFactory window;
		
		public ButtonListener(ColorFactory factory) {
			window = factory;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			
			if(command.equals("R")) {
				window.getContentPane().setBackground(Color.RED);
			} else if(command.equals("O")) {
				window.getContentPane().setBackground(Color.ORANGE);
			} else if(command.equals("Y")) {
				window.getContentPane().setBackground(Color.YELLOW);
			} else {
				System.err.println("Unrecognized command \"" + command + "\"!");
			}
		}	
	}

	class RadioButtonListener implements ActionListener {
		private ColorFactory window;
		
		public RadioButtonListener(ColorFactory factory) {
			window = factory;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			
			if(command.equals("G")) {
				window.instructions.setForeground(Color.GREEN);
			} else if(command.equals("B")) {
				window.instructions.setForeground(Color.BLUE);
			} else if(command.equals("C")) {
				window.instructions.setForeground(Color.CYAN);
			} else {
				System.err.println("Unrecognized command \"" + command + "\"!");
			}
		}
	}
}