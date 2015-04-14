import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Assignment 6 - Yelp! Restaurant Data Application
 * Copyright (c) 2015 Jamison Bryant
 * 
 * Application Class
 * Main application class
 * 
 * @author Jamison Bryant (jbryan46@montgomerycollege.edu)
 */
public class Application extends JFrame implements ActionListener {
	private BestFoodManager manager;
	
	/**
	 * Starts the application
	 * 
	 * @param args An array of command-line arguments
	 */
	public static void main(String[] args) {
		Application app = new Application();
	}
	
	/**
	 * Constructs the application
	 */
	public Application() {
		// Create GUI window
		setTitle("Best Food Manager");
		setSize(800, 500);
		setLocationRelativeTo(null);
		
		// Create main panels
		JPanel dataPanel = new JPanel();
		JPanel controlPanel = new JPanel();
		
		// Create subpanels
		JPanel categoriesPanel = new JPanel();
		categoriesPanel.setPreferredSize(new Dimension(150, 400));
		
		JPanel restaurantsPanel = new JPanel();
		restaurantsPanel.setPreferredSize(new Dimension(450, 400));		
		
		JPanel ratingsPanel = new JPanel();		
		ratingsPanel.setPreferredSize(new Dimension(150, 400));
		
		// Create buttons
		JButton readButton = new JButton("Read");
		JButton bestButton = new JButton("Best");
		JButton writeButton = new JButton("Write");		
		JButton exitButton = new JButton("Exit");
		
		// Add actions to buttons
		readButton.setActionCommand("READ");
		readButton.addActionListener(this);
		
		bestButton.setActionCommand("BEST");
		bestButton.addActionListener(this);
		
		writeButton.setActionCommand("WRITE");
		writeButton.addActionListener(this);
		
		exitButton.setActionCommand("EXIT");
		exitButton.addActionListener(this);
		
		// Add labels to top panels
		categoriesPanel.setBorder(
			BorderFactory.createTitledBorder("Categories"));
		
		restaurantsPanel.setBorder(
			BorderFactory.createTitledBorder("Restaurants"));
		
		ratingsPanel.setBorder(
			BorderFactory.createTitledBorder("Ratings"));
		
		// Add subpanels to data panel
		dataPanel.add(categoriesPanel);
		dataPanel.add(restaurantsPanel);
		dataPanel.add(ratingsPanel);

		// Add buttons to control panel
		controlPanel.add(readButton);
		controlPanel.add(bestButton);
		controlPanel.add(writeButton);
		controlPanel.add(exitButton);		
		
		// Add main panels to frame
		add(dataPanel, BorderLayout.PAGE_START);
		add(controlPanel, BorderLayout.PAGE_END);
		
		// Show GUI window
		setVisible(true);
	}

	/**
	 * Performs a task based on event that occurs
	 * 
	 * @param event The event that occurred
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub		
	}
}