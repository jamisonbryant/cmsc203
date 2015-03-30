import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * The GUI for the proctor to enter the student's answers and grade them.
 *
 * @author Jamison Bryant (jbryan46@montgomerycollege.edu)
 */
public class ProctorGUI extends JFrame implements ActionListener {
	private ArrayList<JTextField> textFields;
	
	/**
	 * Bootstraps the software
	 * 
	 * @param args Command-line arguments
	 */
	public static void main(String[] args) {
		ProctorGUI gui = new ProctorGUI();
	}
	
	/**
	 * Builds the GUI
	 */
	public ProctorGUI() {
		// Instantiate fields
		textFields = new ArrayList<JTextField>();
		
		// Create GUI
		setTitle("Driving Exam Grader");
		setSize(500, 300);
		setLocationRelativeTo(null);
		
		// Create panel
		JPanel panel = new JPanel(new BorderLayout());
		
		// Create banner
		JPanel bannerPanel = new JPanel();
		bannerPanel.setBackground(Color.yellow);
		JLabel bannerLabel = 
			new JLabel("Driver's License Exam Grader", SwingConstants.CENTER);
		bannerLabel.setPreferredSize(new Dimension(getWidth(), 20));
		bannerPanel.add(bannerLabel, BorderLayout.CENTER);
		
		// Create input panel
		JPanel inputPanel = new JPanel();
		
		// Create name field
		JPanel namePanel = new JPanel();
		JLabel nameLabel = new JLabel("Name: ");
		JTextField nameField = new JTextField(20);
		textFields.add(nameField);
		namePanel.add(nameLabel);
		namePanel.add(nameField);
		
		// Create answer fields
		//
		// Answer fields are separated into four columns of 5 fields each.
		// The GridLayout is used to keep the fields and their labels in line
		// (give or take a few pixels).
		JPanel answersPanel = new JPanel();
		JPanel column1AnswersPanel = new JPanel(new GridLayout(5, 1));
		JPanel column2AnswersPanel = new JPanel(new GridLayout(5, 1));
		JPanel column3AnswersPanel = new JPanel(new GridLayout(5, 1));
		JPanel column4AnswersPanel = new JPanel(new GridLayout(5, 1));
		
		JPanel question1Panel = new JPanel();
		JLabel question1Label = new JLabel("1. ", SwingConstants.RIGHT);
		JTextField question1TextField = new JTextField(5);
		textFields.add(question1TextField);
		question1Panel.add(question1Label);
		question1Panel.add(question1TextField);
		
		JPanel question2Panel = new JPanel();
		JLabel question2Label = new JLabel("2. ", SwingConstants.RIGHT);
		JTextField question2TextField = new JTextField(5);
		textFields.add(question2TextField);
		question2Panel.add(question2Label);
		question2Panel.add(question2TextField);
		
		JPanel question3Panel = new JPanel();
		JLabel question3Label = new JLabel("3. ", SwingConstants.RIGHT);
		JTextField question3TextField = new JTextField(5);
		textFields.add(question3TextField);
		question3Panel.add(question3Label);
		question3Panel.add(question3TextField);
		
		JPanel question4Panel = new JPanel();
		JLabel question4Label = new JLabel("4. ", SwingConstants.RIGHT);
		JTextField question4TextField = new JTextField(5);
		textFields.add(question4TextField);
		question4Panel.add(question4Label);
		question4Panel.add(question4TextField);
		
		JPanel question5Panel = new JPanel();
		JLabel question5Label = new JLabel("5. ", SwingConstants.RIGHT);
		JTextField question5TextField = new JTextField(5);
		textFields.add(question5TextField);
		question5Panel.add(question5Label);
		question5Panel.add(question5TextField);
		
		column1AnswersPanel.add(question1Panel);
		column1AnswersPanel.add(question2Panel);
		column1AnswersPanel.add(question3Panel);
		column1AnswersPanel.add(question4Panel);
		column1AnswersPanel.add(question5Panel);
		
		JPanel question6Panel = new JPanel();
		JLabel question6Label = new JLabel("6. ", SwingConstants.RIGHT);
		JTextField question6TextField = new JTextField(5);
		textFields.add(question6TextField);
		question6Panel.add(question6Label);
		question6Panel.add(question6TextField);
		
		JPanel question7Panel = new JPanel();
		JLabel question7Label = new JLabel("7. ", SwingConstants.RIGHT);
		JTextField question7TextField = new JTextField(5);
		textFields.add(question7TextField);
		question7Panel.add(question7Label);
		question7Panel.add(question7TextField);
		
		JPanel question8Panel = new JPanel();
		JLabel question8Label = new JLabel("8. ", SwingConstants.RIGHT);
		JTextField question8TextField = new JTextField(5);
		textFields.add(question8TextField);
		question8Panel.add(question8Label);
		question8Panel.add(question8TextField);
		
		JPanel question9Panel = new JPanel();
		JLabel question9Label = new JLabel("9. ", SwingConstants.RIGHT);
		JTextField question9TextField = new JTextField(5);
		textFields.add(question9TextField);
		question9Panel.add(question9Label);
		question9Panel.add(question9TextField);
		
		JPanel question10Panel = new JPanel();
		JLabel question10Label = new JLabel("10. ", SwingConstants.RIGHT);
		JTextField question10TextField = new JTextField(5);
		textFields.add(question10TextField);
		question10Panel.add(question10Label);
		question10Panel.add(question10TextField);
	 
		column2AnswersPanel.add(question6Panel);
		column2AnswersPanel.add(question7Panel);
		column2AnswersPanel.add(question8Panel);
		column2AnswersPanel.add(question9Panel);    
		column2AnswersPanel.add(question10Panel);
		
		JPanel question11Panel = new JPanel();
		JLabel question11Label = new JLabel("11. ", SwingConstants.RIGHT);
		JTextField question11TextField = new JTextField(5);
		textFields.add(question11TextField);
		question11Panel.add(question11Label);
		question11Panel.add(question11TextField);
		
		JPanel question12Panel = new JPanel();
		JLabel question12Label = new JLabel("12. ", SwingConstants.RIGHT);
		JTextField question12TextField = new JTextField(5);
		textFields.add(question12TextField);
		question12Panel.add(question12Label);
		question12Panel.add(question12TextField);
		
		JPanel question13Panel = new JPanel();
		JLabel question13Label = new JLabel("13. ", SwingConstants.RIGHT);
		JTextField question13TextField = new JTextField(5);
		textFields.add(question13TextField);
		question13Panel.add(question13Label);
		question13Panel.add(question13TextField);
		
		JPanel question14Panel = new JPanel();
		JLabel question14Label = new JLabel("14. ", SwingConstants.RIGHT);
		JTextField question14TextField = new JTextField(5);
		textFields.add(question14TextField);
		question14Panel.add(question14Label);
		question14Panel.add(question14TextField);
		
		JPanel question15Panel = new JPanel();
		JLabel question15Label = new JLabel("15. ", SwingConstants.RIGHT);
		JTextField question15TextField = new JTextField(5);
		textFields.add(question15TextField);
		question15Panel.add(question15Label);
		question15Panel.add(question15TextField);
		
		column3AnswersPanel.add(question11Panel);
		column3AnswersPanel.add(question12Panel);
		column3AnswersPanel.add(question13Panel);
		column3AnswersPanel.add(question14Panel);
		column3AnswersPanel.add(question15Panel);

		JPanel question16Panel = new JPanel();
		JLabel question16Label = new JLabel("16. ", SwingConstants.RIGHT);
		JTextField question16TextField = new JTextField(5);
		textFields.add(question16TextField);
		question16Panel.add(question16Label);
		question16Panel.add(question16TextField);
		
		JPanel question17Panel = new JPanel();
		JLabel question17Label = new JLabel("17. ", SwingConstants.RIGHT);
		JTextField question17TextField = new JTextField(5);
		textFields.add(question17TextField);
		question17Panel.add(question17Label);
		question17Panel.add(question17TextField);
		
		JPanel question18Panel = new JPanel();
		JLabel question18Label = new JLabel("18. ", SwingConstants.RIGHT);
		JTextField question18TextField = new JTextField(5);
		textFields.add(question18TextField);
		question18Panel.add(question18Label);
		question18Panel.add(question18TextField);
		
		JPanel question19Panel = new JPanel();
		JLabel question19Label = new JLabel("19. ", SwingConstants.RIGHT);
		JTextField question19TextField = new JTextField(5);
		textFields.add(question19TextField);
		question19Panel.add(question19Label);
		question19Panel.add(question19TextField);
		
		JPanel question20Panel = new JPanel();
		JLabel question20Label = new JLabel("20. ", SwingConstants.RIGHT);
		JTextField question20TextField = new JTextField(5);
		textFields.add(question20TextField);
		question20Panel.add(question20Label);
		question20Panel.add(question20TextField);
	 
		column4AnswersPanel.add(question16Panel);
		column4AnswersPanel.add(question17Panel);
		column4AnswersPanel.add(question18Panel);
		column4AnswersPanel.add(question19Panel);    
		column4AnswersPanel.add(question20Panel);
		
		answersPanel.add(column1AnswersPanel);
		answersPanel.add(column2AnswersPanel);
		answersPanel.add(column3AnswersPanel);
		answersPanel.add(column4AnswersPanel);
		
		inputPanel.add(namePanel);
		inputPanel.add(answersPanel);
		
		// Create buttons panel
		JPanel buttonsPanel = new JPanel();
		
		JButton gradeButton = new JButton("Grade");
		gradeButton.setActionCommand("grade");
		gradeButton.addActionListener(this);
		
		JButton readButton = new JButton("Read File");
		readButton.setActionCommand("read");
		readButton.addActionListener(this);
		
		JButton exitButton = new JButton("Exit");
		exitButton.setActionCommand("exit");
		exitButton.addActionListener(this);
		
		buttonsPanel.add(gradeButton);
		buttonsPanel.add(readButton);
		buttonsPanel.add(exitButton);

		// Assemble GUI
		panel.add(bannerPanel, BorderLayout.PAGE_START);
		panel.add(inputPanel, BorderLayout.CENTER);
		panel.add(buttonsPanel, BorderLayout.PAGE_END);
		
		// Show GUI
		add(panel);
		setVisible(true);
	}
	
	/**
	 * Handles actions triggered by user interaction with the GUI
	 */
	public void actionPerformed(ActionEvent e) {
		// Get action command
		String command = e.getActionCommand();
		
		// Perform action based on command
		if(command.equals("grade")) {
			// Collect exam data
			String name = textFields.get(0).getText();
			char[] answers = new char[20];
			boolean inputError = false;
			
			// Process and validate answers
			for(int i = 0; i < answers.length; i++) {
				String answer = textFields.get(i + 1).getText();
				
				if(answer.matches("[A-D]{1}")) {
					answers[i] = answer.charAt(0);
				} else {
					JOptionPane.showMessageDialog(this, "Invalid answer for " +
						"question " + (i + 1) + ".", 
						"Fatal Error", JOptionPane.ERROR_MESSAGE);
					
					inputError = true;
					break;
				}
			}
			
			if(!inputError) {
				// Grade exam
				DriverExam grader = new DriverExam();
				
				// Display results
				JOptionPane.showMessageDialog(this, 
					grader.report(name, answers), "Test Results", 
					JOptionPane.INFORMATION_MESSAGE);
			}
		} else if(command.equals("read")) {
			// Create file chooser
			JFileChooser chooser = new JFileChooser();
			chooser.addChoosableFileFilter(
				new FileNameExtensionFilter(".txt", "txt"));
			
			// Prompt user to choose file
			int response = chooser.showOpenDialog(ProctorGUI.this);
			
			// Parse chosen file
			if(response == JFileChooser.APPROVE_OPTION) {
				File chosenFile = chooser.getSelectedFile();
				
				// Read file line-by-line
				try(BufferedReader reader = 
					new BufferedReader(new FileReader(chosenFile))) {
					String line;
					int counter = 0;
					
					while((line = reader.readLine()) != null) {
						if(counter == 0) {
							// Parse first line
							textFields.get(0).setText(line);
							counter++;
						} else if(counter == 1) {
							// Parse second line
							String[] answers = line.split(" ");
							
							for(int i = 0; i < answers.length; i++) {
								String answer = answers[i];								
								textFields.get(i + 1).setText(answer);
							}
							
							counter++;
							break;
						}
					}
					
					// Refresh GUI
					revalidate();
				} catch(IOException ex) {
					JOptionPane.showMessageDialog(this, "Unable to read file.", 
						"Fatal Error", JOptionPane.ERROR_MESSAGE);
					
					System.err.println("Unable to read file. Exception was:");
					System.err.println(ex);
					
					System.exit(-1);
				}
			}
		} else if(command.equals("exit")) {
			System.exit(0);
		}
	}
}
