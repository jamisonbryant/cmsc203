/**
 * Office Enum
 * 
 * Represents one of the four types of offices a student can hold.
 * 
 * @author Jamison Bryant (jbryan46@montgomerycollege.edu)
 */
public enum Office {
	PRESIDENT ("President"), 
	SECRETARY ("Secretary"), 
	TREASURER ("Treasurer"), 
	REPRESENTATIVE ("Representative");
	
	private String name;
	
	/**
	 * Creates a new Office
	 * 
	 * @param name The name of the office
	 */
	Office(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
}
