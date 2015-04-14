import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BestFoodManagerTest {
	private BestFoodManager foodManager;

	@Before
	public void setUp() throws Exception {
		PrintWriter output = new PrintWriter("testFile.txt");
		output.println("Mexican;Taco Bar: 4.5;Al Carbon: 4.0;Tortacos: 4.2;El Mariachi: 3.5;");
		output.println("Thai;Thai Cuisine: 4.0;Thai House: 4.5;Amina Thai: 4.2;");
		output.println("American (Traditional);Coastal Flats: 4.0;Urban BBQ: 3.5;");
		output.println("American (New);Potomac Grill: 4.5;Dogfish Head Alehouse: 4.0;Chef Geoff's: 3.5;");
		output.println("Greek;Cava Mezze: 4.5;Mykonos Grill: 4.2;Apollo Restaurant: 4.0;Vasilis Med Grill: 4.1;");
		output.println("Chinese;Sichuan Jin River: 3.5;Joe's Noodle House: 4.5;");
		output.println("Italian;Il Pizzico: 4.5;Sugo Osteria: 4.0;Vignola Gourmet: 4.4;");
		output.println("Vietnamese;Pho Nom Nom: 4.2;Mi La Cay: 4.5;Mr Banh Mi: 4.0;Pho 75: 4.1;Pho Eatery: 3.5;");
		output.close();
		foodManager = new BestFoodManager();
	}

	@After
	public void tearDown() throws Exception {
		foodManager = null;
	}

	@Test
	public void testReadFromFile() {
		Restaurant[][] rData = null;
		File testFile = new File("testFile.txt");
		try {
			rData = foodManager.readFromFile(testFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			assertEquals("El Mariachi",rData[0][3].getName());
			assertEquals("Amina Thai",rData[1][2].getName());
			assertEquals("no value",rData[0][5].getName());
			fail("Should have thrown an ArrayIndexOutOfBoundsException");
		}
		catch (ArrayIndexOutOfBoundsException e) {
			assertTrue("testReadFromFile() correctly threw an ArrayIndexOutOfBoundsException", true);
		}
	}

	@Test
	public void testReadFromFileSTUDENT() {
		fail("Not implemented yet.");
	}
	
	@Test
	public void testSetBestRestaurants() {
		Restaurant[][] rData = null;
		Restaurant[][] bestRData = null;
		File testFile = new File("testFile.txt");
		try {
			rData = foodManager.readFromFile(testFile);
			foodManager.setBestRestaurants(rData);
			bestRData = foodManager.getBestRestaurants();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			assertEquals("Taco Bar",bestRData[0][0].getName());
			assertEquals("Thai House",bestRData[1][0].getName());
			assertEquals("no value",bestRData[1][4].getName());
			fail("Should have thrown an ArrayIndexOutOfBoundsException");
		}
		catch (ArrayIndexOutOfBoundsException e) {
			assertTrue("Correctly threw an ArrayIndexOutOfBoundsException", true);
		}
	
	}
	
	@Test
	public void testSetBestRestaurantsA() {
		Restaurant[][] rData = null;
		Restaurant[][] bestRData = null;
		Restaurant[] expectedBestAmTradData = {new Restaurant("Coastal Flats", 4.0), new Restaurant("Urban BBQ", 3.5)};
		Restaurant[] expectedBestItalianData = {new Restaurant("Il Pizzico", 4.5), new Restaurant("Vignola Gourmet", 4.4), new Restaurant("Sugo Osteria", 4.0)};
		File testFile = new File("testFile.txt");
		
		try {
			rData = foodManager.readFromFile(testFile);					
			foodManager.setBestRestaurants(rData);
			bestRData = foodManager.getBestRestaurants();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			assertArrayEquals("Incorrect Amer Traditional Array Results", expectedBestAmTradData, bestRData[2]);
			assertArrayEquals("Incorrect Italian Array Results", expectedBestItalianData, bestRData[6]);
		}
		catch (ArrayIndexOutOfBoundsException e) {
			assertFalse("Threw an ArrayIndexOutOfBoundsException", true);
		}
	
	}
	
	@Test
	public void testSetBestRestaurantsSTUDENT() {
		fail("Not implemented yet.");
	}

	@Test
	public void testGetAverages() {
		Restaurant[][] rData = null;
		Restaurant[][] bestRData = null;
		double[] avgs = null;
		File testFile = new File("testFile.txt");
		try {
			rData = foodManager.readFromFile(testFile);
			foodManager.setBestRestaurants(rData);
			bestRData = foodManager.getBestRestaurants();
			avgs = foodManager.getAverages();
		} catch (IOException e) {
			fail(e.getMessage());
		}
		assertEquals(4.05,avgs[0],0.0001);
		assertEquals(4.3,avgs[6],0.0001);
	}

	@Test
	public void testWriteToFile() {
		String inLine="";
		String[] elements=null;
		int index = 0;
		Restaurant[][] rData = null;
		Restaurant[][] bestRData = null;
		File testFile = new File("testFile.txt");
		try {
			rData = foodManager.readFromFile(testFile);
			foodManager.setBestRestaurants(rData);
			bestRData = foodManager.getBestRestaurants();
		} catch (IOException e) {
			e.printStackTrace();
		}
		File testOutFile = new File("testOutFile.txt");
		try {
			foodManager.writeToFile(testOutFile);
			Scanner fileScan = new Scanner(testOutFile);
			while (fileScan.hasNext()) {
				inLine = fileScan.nextLine();  //read one line 
				elements = inLine.split(";");
				if (index==0) {	//zero-th line contains Categories; Best Restaurants in Rockville; Average Rating
					assertEquals("Categories", elements[0]);
				}
				else if (index==5) { //1st thru 7th lines contain Category; Restaurant; Restaurant;...;Average
					assertEquals("Greek", elements[0]);
					assertEquals(" Mykonos Grill",elements[2]);
					assertEquals(4.19999,Double.parseDouble(elements[5]),0.001);
				}
				index++;
			}
		} catch (FileNotFoundException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetCategories() {
		Restaurant[][] rData = new Restaurant[2][];
		File testFile = new File("testFile.txt");
		try {
			rData = foodManager.readFromFile(testFile);
		} catch (IOException e) {
			e.printStackTrace();
		}//categories[index]
		String[] categories = foodManager.getCategories();
		assertEquals("Mexican",categories[0]);
		assertEquals("Greek",categories[4]);
	}

}
