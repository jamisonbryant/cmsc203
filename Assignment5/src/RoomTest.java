import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a JUnit test program to test the Room in Project 5.
 * 
 * The following classes must be defined and implemented:
 * 
 * Office - enumeration
 * Officer - data element
 * Room - data manager
 * 
 * @author Professor Justh
 * @author Jamison Bryant (jbryan46@montgomerycollege.edu)
 *
 */
public class RoomTest {
	// Room objects used for testing
	Room room, studentRoom;
	
	@Before
	/** 
	 * This method is run before each individual test. Creates an object of Room and adds three
	 * Officers to the Room.
	 * 
	 * @throws Exception
	 */
	public void setUp() throws Exception {
		room = new Room("New Room");
		room.addOfficer("John", "Smith", "representative");
		room.addOfficer("Bob", "Brown", "treasurer");
		room.addOfficer("Harold", "Jones", "secretary");
				
		studentRoom = new Room("Student Room");
		studentRoom.addOfficer(new Officer("Arthur", "Adams", Office.PRESIDENT));
		studentRoom.addOfficer(new Officer("Bruce", "Bryant", Office.SECRETARY));
		studentRoom.addOfficer(new Officer("Charlie", "Cheese", Office.TREASURER));
	}

	@After
	/** 
	 * This method is run after each individual test. It sets the Room reference to null so the garbage
	 * collector can reclaim the memory used for the Room object.
	 * 
	 * @throws Exception
	 */
	public void tearDown() throws Exception {
		room = null;
	}

	@Test
	/**
	 * Test to check if the number of officers is originally 3
	 */
	public void testGetNumOfficers() {
		assertEquals(3, room.getNumOfficers());
	}

	@Test
	/**
	 * Test to check if the number of officers is incremented by 1 after adding an officer
	 */
	public void testGetNumOfficersSTUDENT() {
		int officerCount = Room.getOfficerCount();
		studentRoom.addOfficer(new Officer("Theodore", "Roosevelt", Office.REPRESENTATIVE));
		int newOfficerCount = Room.getOfficerCount();
		assertTrue(officerCount + 1 == newOfficerCount);
	}
	
	
	@Test
	/**
	 * Test to
	 * 1.  add a new Officer as a president
	 *     add another new Officer as a president
	 *     check if recognizes there is already a president
	 * 2.  add a new Officer as a secretary
	 *     check if recognizes there is already a secretary
	 * 3.  add a new Officer as a representative --Officer is added
	 *     check if recognizes there are already 2 representatives
	 */
	public void testAddOfficer() {
		String result;
		result = room.addOfficer("George", "Jones", "president");
		
		// Add another president - already 1 president - return error message
		result = room.addOfficer("Albert", "Pine", "president");
		assertEquals("ERROR: Maximum number of presidents reached", result);
		
		// Add another secretary - already 1 secretary - return error message
		result = room.addOfficer("Susie", "Smith", "secretary");
		assertEquals("ERROR: Maximum number of secretaries reached", result);
			
		// Add another representative - officer added
		result = room.addOfficer("Susie", "Smith", "representative");
		assertEquals(null, result);
		
		assertEquals(5, room.getNumOfficers());
	}
	
	@Test
	/**
	 * Test to
	 * 1.  add a new Officer is a representative
	 *     check if recognizes there are already 2 representatives
	 * 2.  add a new Officer as a treasurer
	 *     check if recognizes there is already a treasurer
	 * 3.  add a new Officer as a president
	 *     check if recognizes there is already a president
	 */
	public void testAddOfficerSTUDENT() {
		String result;
		studentRoom.addOfficer(new Officer("Daniel", "Day", Office.REPRESENTATIVE));
		studentRoom.addOfficer(new Officer("Eddie", "English", Office.REPRESENTATIVE));
		
		// Add another representative - already 1 representative - return error message
		result = studentRoom.addOfficer(new Officer("Albert", "Pine", Office.REPRESENTATIVE));
		assertEquals("ERROR: Maximum number of representatives reached", result);
		
		// Add another secretary - already 1 secretary - return error message
		result = studentRoom.addOfficer(new Officer("Susie", "Smith", Office.SECRETARY));
		assertEquals("ERROR: Maximum number of secretaries reached", result);
			
		// Add another president - officer added
		result = studentRoom.addOfficer(new Officer("Susie", "Smith", Office.PRESIDENT));
		assertEquals("ERROR: Maximum number of presidents reached", result);
		
		assertEquals(5, studentRoom.getNumOfficers());
	}

	@Test
	/**
	 * Test to:
	 * 1.  Check if the name "New Room" is on the first line
	 * 2.  Check if "Officers" is on the second line
	 * 3.  Check if John is on the third line
	 * 4.  Check if Bob is on the fourth line
	 * 5.  Check if Harold is on the fifth line
	 */
	public void testPrintRoom() {
		String result = room.printRoom();
		Scanner room = new Scanner(result);
		
		assertEquals("New Room", room.nextLine()); 
		assertEquals("Officers", room.next());
		
		room.nextLine();  
		assertEquals("John", room.next());
		
		room.nextLine();  
		assertEquals("Bob", room.next()); 
		
		room.nextLine();  
		assertEquals("Harold", room.next());
		
		room.close();
	}

	@Test
	/**
	 * Test to:
	 * 1.  Check if the room is on the first line
	 * 2.  Check if other officers are in order as entered
	 */
	public void testPrintRoomSTUDENT() {
		String result = studentRoom.printRoom();
		Scanner room = new Scanner(result);
		
		assertEquals("Student Room", room.nextLine()); 
		assertEquals("Officers", room.next());
		
		room.nextLine();  
		assertEquals("Arthur", room.next());
		
		room.nextLine();  
		assertEquals("Bruce", room.next()); 
		
		room.nextLine();  
		assertEquals("Charlie", room.next());
		
		room.close();
	}
}
