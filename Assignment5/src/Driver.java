import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * Driver Class
 * 
 * Creates the assignment GUI and allows the user to enter data.
 * 
 * @author Jamison Bryant (jbryan46@montgomerycollege.edu)
 */
public class Driver extends JFrame implements ActionListener {
	private ArrayList<Room> rooms;
	private Room room;
	private JTextField roomField;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JRadioButton presidentButton;
	private JRadioButton secretaryButton;
	private JRadioButton treasurerButton;
	private JRadioButton representativeButton;
	
	private Office office;
	
	/**
	 * Bootstraps the program
	 * 
	 * @param args Command-line arguments
	 */
	public static void main(String[] args) {
		Driver driver = new Driver();
	}
	
	/**
	 * Builds the GUI
	 */
	public Driver() {
		// Initialize rooms
		room = new Room();
		rooms = new ArrayList<Room>();
		
		// Create GUI
		setTitle("Hickory Hollow Elementary School");
		setSize(600, 500);
		setLocationRelativeTo(null);
		
		// Prompt user for room
		String roomName = getRoom();
		room.setName(roomName);
		
		// Create main panel
		JPanel mainPanel = new JPanel(new BorderLayout());
		
		// Create room panel
		JPanel roomPanel = new JPanel();
		JLabel roomLabel = new JLabel("Room and Grade");
		roomField = new JTextField(roomName);
		roomField.setColumns(15);
		roomField.setEditable(false);
		roomPanel.add(roomLabel);
		roomPanel.add(roomField);
		
		// Create controls panel
		JPanel controlsPanel = new JPanel(new BorderLayout());
		
			// Create image panel
			JPanel imagePanel = new JPanel();
			BufferedImage logoImage;
			JLabel imageLabel = null;
			
			try {
				logoImage = ImageIO.read(new File("img/logo.jpg"));
				imageLabel = new JLabel(new ImageIcon(logoImage));
			} catch (IOException e) {
				System.err.println("Unable to load application logo image asset");
				e.printStackTrace();
				System.exit(-1);
			}
			
			imagePanel.add(imageLabel);
			
			// Create form panel
			JPanel formPanel = new JPanel(new BorderLayout());
			
				// Create name panels
				JPanel namesPanel = new JPanel(new BorderLayout());
				
				JPanel firstNamePanel = new JPanel();
				JLabel firstNameLabel = new JLabel("First name: ");
				firstNameField = new JTextField();
				firstNameField.setColumns(15);
				firstNamePanel.add(firstNameLabel);
				firstNamePanel.add(firstNameField);
				
				JPanel lastNamePanel = new JPanel();
				JLabel lastNameLabel = new JLabel("Last name: ");
				lastNameField = new JTextField();
				lastNameField.setColumns(15);
				lastNamePanel.add(lastNameLabel);
				lastNamePanel.add(lastNameField);
				
				namesPanel.add(firstNamePanel, BorderLayout.PAGE_START);
				namesPanel.add(lastNamePanel, BorderLayout.PAGE_END);
			
				// Create officers panel
				JPanel officesPanel = new JPanel();
				officesPanel.setBorder(BorderFactory.createTitledBorder("Office"));
				ButtonGroup officesGroup = new ButtonGroup();
				
				presidentButton = new JRadioButton("President");
				presidentButton.addActionListener(new AbstractAction("PresidentButton") {
					@Override
					public void actionPerformed(ActionEvent e) {
						office = Office.PRESIDENT;
					}
				});
				
				secretaryButton = new JRadioButton("Secretary");
				secretaryButton.addActionListener(new AbstractAction("SecretaryButton") {
					@Override
					public void actionPerformed(ActionEvent e) {
						office = Office.SECRETARY;
					}
				});
				
				treasurerButton = new JRadioButton("Treasurer");
				treasurerButton.addActionListener(new AbstractAction("TreasurerButton") {
					@Override
					public void actionPerformed(ActionEvent e) {
						office = Office.TREASURER;
					}
				});
				
				representativeButton = new JRadioButton("Representative");
				representativeButton.addActionListener(new AbstractAction("RepresentativeButton") {
					@Override
					public void actionPerformed(ActionEvent e) {
						office = Office.REPRESENTATIVE;
					}
				});
				
				officesGroup.add(presidentButton);
				officesGroup.add(secretaryButton);
				officesGroup.add(treasurerButton);
				officesGroup.add(representativeButton);
				officesPanel.add(presidentButton);
				officesPanel.add(secretaryButton);
				officesPanel.add(treasurerButton);
				officesPanel.add(representativeButton);
				
			formPanel.add(namesPanel, BorderLayout.PAGE_START);
			formPanel.add(officesPanel, BorderLayout.CENTER);
			
			// Add panels to panel
			controlsPanel.add(imagePanel, BorderLayout.LINE_START);
			controlsPanel.add(formPanel, BorderLayout.LINE_END);
		
		// Create button panel
		JPanel buttonPanel = new JPanel();
		
		JButton newButton = new JButton("New Room");
		newButton.setActionCommand("NEW_ROOM");
		newButton.addActionListener(this);
		
		JButton addButton = new JButton("Add Officer");
		addButton.setActionCommand("ADD_OFFICER");
		addButton.addActionListener(this);
		
		JButton printButton = new JButton("Print Room");
		printButton.setActionCommand("PRINT_ROOM");
		printButton.addActionListener(this);
		
		JButton saveButton = new JButton("Save Room");
		saveButton.setActionCommand("SAVE_ROOM");
		saveButton.addActionListener(this);
		
		JButton exitButton = new JButton("Exit");
		exitButton.setActionCommand("EXIT");
		exitButton.addActionListener(this);
		
		buttonPanel.add(newButton);
		buttonPanel.add(addButton);
		buttonPanel.add(printButton);
		buttonPanel.add(saveButton);
		buttonPanel.add(exitButton);
		
		// Assemble GUI
		mainPanel.add(roomPanel, BorderLayout.PAGE_START);
		mainPanel.add(controlsPanel, BorderLayout.CENTER);
		mainPanel.add(buttonPanel, BorderLayout.PAGE_END);
		
		// Show GUI
		add(mainPanel);
		setVisible(true);
	}

	/**
	 * Gets the room and grade from the user
	 * 
	 * @return The user's input
	 */
	private String getRoom() {
		boolean validInput = false;
		String input = "";
		
		// Declare validation regex
		Pattern regex = Pattern.compile("Room \\d+ Grade \\d+");
		Matcher matcher;
		
		do {
			input = (String) JOptionPane.showInputDialog(null, "Room and grade (e.g. Room 3 Grade 4)");
			
			if (input.equals("")) {
				JOptionPane.showMessageDialog(null, "Please check your input and try again.", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				matcher = regex.matcher(input);
			
				if (!matcher.matches()) {
					JOptionPane.showMessageDialog(null, "Please check your input and try again.", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					validInput = true;
				}
			}
		} while (!validInput);
		
		return input;
	}
	
	/**
     * Saves room details to a file
     */
	private void saveRoom() {
		// Assemble room details
		String roomDetails = "";
		
		if (rooms.size() != 0) {
			for (Room r : rooms) {
				roomDetails += r.toString();	
			}
			
			roomDetails += room.toString() + "\n";
		} else {
			roomDetails += room.toString() + "\n";
		}
		
		// Prompt for file to save to
		JFileChooser chooser = new JFileChooser();
		
		// Prompt user to choose file
		int response = chooser.showOpenDialog(this);
		File chosenFile = null;
		
		// Parse chosen file
		if(response == JFileChooser.APPROVE_OPTION) {
			chosenFile = chooser.getSelectedFile();
		}
		
		// Save room details
		try {
			PrintWriter writer = new PrintWriter(chosenFile.getAbsoluteFile(), "UTF-8");
			writer.println(roomDetails);
			writer.close();
		} catch (FileNotFoundException e) {
			System.err.println("ERROR: Selected file was unavailable, not found, or not write-enabled");
			JOptionPane.showMessageDialog(null, "Could not access requested file", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			System.exit(-1);
		} catch (UnsupportedEncodingException e) {
			System.err.println("ERROR: UTF-8 character encoding not supported on host system");
			JOptionPane.showMessageDialog(null, "UTF-8 encoding not supported", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			System.exit(-1);
		}
		
		// Display room details
		JOptionPane.showMessageDialog(null, "Room details saved!", "Success", JOptionPane.INFORMATION_MESSAGE);
	}

	private void printRoom() {
		// Assemble room details
		String roomDetails = room.toString();
		
		// Display room details
		JOptionPane.showMessageDialog(null, roomDetails, "Room Details", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Handles actions triggered by buttons
	 *
	 * @param e The action to handle
	 */
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		switch (command) {
			case "NEW_ROOM":
				rooms.add(room);
				room = new Room();
				
				// Reset form
				roomField.setText("");
				firstNameField.setText("");
				lastNameField.setText("");
				presidentButton.setSelected(false);
				secretaryButton.setSelected(false);
				treasurerButton.setSelected(false);
				representativeButton.setSelected(false);
				
				// Get new room
				String roomName = getRoom();
				room.setName(roomName);
				roomField.setText(roomName);
				
				break;
				
			case "ADD_OFFICER":
				if(!firstNameField.getText().equals("") && !lastNameField.getText().equals("")) {
					if(presidentButton.isSelected() || secretaryButton.isSelected() || treasurerButton.isSelected() || representativeButton.isSelected()) {
						room.addOfficer(new Officer(firstNameField.getText(), lastNameField.getText(), office));
					
						// Reset form
						firstNameField.setText("");
						lastNameField.setText("");
						presidentButton.setSelected(false);
						secretaryButton.setSelected(false);
						treasurerButton.setSelected(false);
						representativeButton.setSelected(false);
					} else {
						JOptionPane.showMessageDialog(null, "Please select an office title", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please specify a first and last name", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				break;
				
			case "PRINT_ROOM":
				printRoom();
				break;
				
			case "SAVE_ROOM":
				saveRoom();
				break;
				
			case "EXIT":
				System.exit(0);
				break;
		}
	}
}
