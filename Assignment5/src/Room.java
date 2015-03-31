import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * Room Class
 * 
 * Represents a room that contains many officers.
 * 
 * @author Jamison Bryant (jbryan46@montgomerycollege.edu)
 */
public class Room {
	private static int MAX_PRESIDENTS = 1;
	private static int MAX_SECRETARIES = 1;
	private static int MAX_TREASURERS = 1;
	private static int MAX_REPRESENTATIVES = 2;
	
	private String name;
	private ArrayList<Officer> officers;
	private static int officerCount;	
	private	int numPresidents;
	private int numSecretaries;
	private int numTreasurers;
	private int numRepresentatives;
	
	/**
	 * Creates a Room object
	 */
	public Room() {
		officers = new ArrayList<Officer>();
		officerCount = 0;
		numPresidents = 0;
		numSecretaries = 0;
		numTreasurers = 0;
		numRepresentatives = 0;
	}
	
	/**
	 * Creates a Room object
	 * 
	 * @param name The name of the room
	 */
	public Room(String name) {
		this.name = name; 
		officers = new ArrayList<Officer>();
		officerCount = 0;
		numPresidents = 0;
		numSecretaries = 0;
		numTreasurers = 0;
		numRepresentatives = 0;
	}
	
	/**
	 * Adds an officer to a room
	 * 
	 * @param officer The officer to add
	 * @return Null (if successful) or an error message (if unsuccessful)
	 */
	public String addOfficer(Officer officer) {
		String result = null;
		
		// Check if correct number of officers have been added
		switch (officer.getOffice()) {
			case "President":
				if (numPresidents < MAX_PRESIDENTS) {
					numPresidents++;
					officers.add(officer);
					officerCount++;
				} else {
					JOptionPane.showMessageDialog(null, "Maximum number of presidents reached", "Error", JOptionPane.ERROR_MESSAGE);
					result = "ERROR: Maximum number of presidents reached";
				}
				
				break;
			case "Secretary":
				if (numSecretaries < MAX_SECRETARIES) {
					numSecretaries++;
					officers.add(officer);
					officerCount++;
				} else {
					JOptionPane.showMessageDialog(null, "Maximum number of secretaries reached", "Error", JOptionPane.ERROR_MESSAGE);
					result = "ERROR: Maximum number of secretaries reached";
				}
				
				break;
			case "Treasurer":
				if (numTreasurers < MAX_TREASURERS) {
					numTreasurers++;
					officers.add(officer);
					officerCount++;
				} else {
					JOptionPane.showMessageDialog(null, "Maximum number of treasurers reached", "Error", JOptionPane.ERROR_MESSAGE);
					result = "ERROR: Maximum number of treasurers reached";
				}
				
				break;
			case "Representative":
				if (numRepresentatives < MAX_REPRESENTATIVES) {
					numRepresentatives++;
					officers.add(officer);
					officerCount++;
				} else {
					JOptionPane.showMessageDialog(null, "Maximum number of representatives reached", "Error", JOptionPane.ERROR_MESSAGE);
					result = "ERROR: Maximum number of representatives reached";
				}
				
				break;
		}
		
		return result;
	}
	
	/**
	 * Alias for addOfficer() method
	 * 
	 * @param firstName The officer's first name
	 * @param lastName The officer's last name
	 * @param office The officer's office
	 * @return Null (if successful) or an error message (if unsuccessful)
	 */
	public String addOfficer(String firstName, String lastName, String office) {
		Office o = null;
		
		if (office.toUpperCase().equals("PRESIDENT")) {
			o = Office.PRESIDENT;
		} else if (office.toUpperCase().equals("SECRETARY")) {
			o = Office.SECRETARY;
		} else if (office.toUpperCase().equals("TREASURER")) {
			o = Office.TREASURER;
		} else if (office.toUpperCase().equals("REPRESENTATIVE")) {
			o = Office.REPRESENTATIVE;
		}
		
		return addOfficer(new Officer(firstName, lastName, o));
	}
	
	/**
	 * Returns the number of officers in the room
	 * 
	 * @return The number of officers
	 */
	public static int getOfficerCount() {
		return officerCount;
	}
	
	/**
	 * An alias for the getOfficeCount() method
	 * 
	 * @return Then number of officers
	 */
	public int getNumOfficers() {
		return getOfficerCount();
	}
	
	/**
	 * Prints the room details
	 * 
	 * @return The room details as a string
	 */
	public String printRoom() {
		return this.toString();
	}
	
	/**
	 * Sets the room's name
	 * 
	 * @param name The room name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		String meta = "";
		
		meta += this.name + "\n\n";
		meta += "Officers\n";
		
		for (Officer officer : officers) {
			meta += officer.toString() + "\n";
		}
		
		return meta;
	}	
}
