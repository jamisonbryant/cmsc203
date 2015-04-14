import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
	private Restaurant[][] restaurants;
	private boolean isFileRead;
	
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
		// Initialize fields
		manager = new BestFoodManager();
		isFileRead = false;
		
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
		
			if (!isFileRead) {
				bestButton.setEnabled(false);
			}
		
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
		// Get event action command
		String command = event.getActionCommand();
		
		if (command.equals("READ")) {
			// Prompt for file to read from
			JFileChooser chooser = new JFileChooser();			
			int response = chooser.showOpenDialog(null);
			
			// Pass file to manager
			if(response == JFileChooser.APPROVE_OPTION) {				
				try {
					restaurants = 
						manager.readFromFile(chooser.getSelectedFile());
				} catch(IOException ex) {
					JOptionPane.showMessageDialog(null, 
						"Could not read from chosen file", "Error", 
							JOptionPane.ERROR_MESSAGE);
				}
			}
			
			// Enable Best button
			isFileRead = true;
		} else if (command.equals("BEST")) {
			// Get best restaurants
			manager.setBestRestaurants(restaurants);
			restaurants = manager.getBestRestaurants();
		} else if (command.equals("WRITE")) {
			// Prompt for file to read from
			JFileChooser chooser = new JFileChooser();			
			int response = chooser.showOpenDialog(null);
			
			// Pass file to manager
			if(response == JFileChooser.APPROVE_OPTION) {				
				try {
					manager.writeToFile(chooser.getSelectedFile());
				} catch(IOException ex) {
					JOptionPane.showMessageDialog(null, 
						"Could not write to chosen file", "Error", 
							JOptionPane.ERROR_MESSAGE);
				}
			}						
		} else if (command.equals("EXIT")) {
			// Exit application
			System.exit(0);
		} else {
			throw new RuntimeException("Unrecognized event action command");
		}
	}
}