import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests the Officer class
 * 
 * @author Jamison (jbryan46@montgomerycollege.edu)
 *
 */
public class OfficerTest {
	@Test
	/**
	 * Test that the officer string is built correctly
	 */
	public void testToString() {
		Officer officer = new Officer("Jamison", "Bryant", Office.PRESIDENT);
		assertEquals("Jamison Bryant (President)", officer.toString());
	}

	@Test
	/**
	 * Test that the office string is set correctly
	 */
	public void testOffice() {
		Officer officer = new Officer("Jamison", "Bryant", Office.PRESIDENT);
		assertEquals(officer.getOffice(), "President");
	}
}
