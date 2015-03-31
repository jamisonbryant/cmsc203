/**
 * Officer Class
 * 
 * Represents a student that holds an office.
 * 
 * @author Jamison Bryant (jbryan46@montgomerycollege.edu)
 */
public class Officer {
	private String firstName;
	private String lastName;
	private Office office;
	
	/**
	 * Creates a new officer
	 * 
	 * @param firstName The officer's first name
	 * @param lastName The officer's last name
	 * @param office The officer's office
	 */
	public Officer(String firstName, String lastName, Office office) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.office = office;
	}
	
	/**
	 * Gets the officer's first name
	 * 
	 * @return String The officer's first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the officer's first name
	 * 
	 * @param firstName The officer's first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the officer's last name
	 * 
	 * @return The officer's last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the officer's last name
	 * 
	 * @param lastName The officer's last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Sets the officer's office as a string
	 * 
	 * @param o The office to set
	 */
	public void setOffice(String o) {
		if (o.toUpperCase().equals("PRESIDENT")) {
			office = Office.PRESIDENT;
		} else if (o.toUpperCase().equals("SECRETARY")) {
			office = Office.SECRETARY;
		} else if (o.toUpperCase().equals("TREASURER")) {
			office = Office.TREASURER;
		} else if (o.toUpperCase().equals("REPRESENTATIVE")) {
			office = Office.REPRESENTATIVE;
		}
	}
	
	/**
	 * Returns the officer's office as a string
	 * 
	 * @return The officer's office
	 */
	public String getOffice() {
		return office.toString();
	}

	/**
	 * Converts information about the officer to a string
	 * 
	 * @return Officer details
	 */
	public String toString() {
		return firstName + " " + lastName + " (" + office.toString() + ")";
	}
}
