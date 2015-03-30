import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradeBookTest {
	private GradeBook gradebook1;
	private GradeBook gradebook2;
	
	@Before
	public void setUp() {
		// Initialize gradebooks
		gradebook1 = new GradeBook(2);
		gradebook2 = new GradeBook(3);
		
		// Add scores
		gradebook1.addScore(89.0);
		gradebook1.addScore(93.0);
		gradebook2.addScore(55.0);
		gradebook2.addScore(82.0);
		gradebook2.addScore(90.0);
	}
	
	@After
	public void tearDown() {
		// De-initialize gradebooks
		gradebook1 = null;
		gradebook2 = null;
	}
	
	@Test
	public void testAddScore() {
		String expectedScores1 = "89.0 93.0";
		String actualScores1 = gradebook1.toString();
		String expectedScores2 = "55.0 82.0 90.0";
		String actualScores2 = gradebook2.toString();
		int expectedSize1 = 2;
		int actualSize1 = gradebook1.getScoresSize();
		int expectedSize2 = 3;
		int actualSize2 = gradebook2.getScoresSize();
		
		assertTrue(expectedScores1.equals(actualScores1));
		assertTrue(expectedScores2.equals(actualScores2));
		assertTrue(expectedSize1 == actualSize1);
		assertTrue(expectedSize2 == actualSize2);
	}

	@Test
	public void testSum() {
		double expectedSum1 = 182.0;
		double actualSum1 = gradebook1.sum();
		double expectedSum2 = 227.0;
		double actualSum2 = gradebook2.sum();
		
		assertTrue(expectedSum1 == actualSum1);
		assertTrue(expectedSum2 == actualSum2);
	}

	@Test
	public void testMinimum() {
		double expectedMinimum1 = 89.0;
		double actualMinimum1 = gradebook1.minimum();
		double expectedMinimum2 = 55.0;
		double actualMinimum2 = gradebook2.minimum();
		
		assertTrue(expectedMinimum1 == actualMinimum1);
		assertTrue(expectedMinimum2 == actualMinimum2);
	}

	@Test
	public void testFinalScore() {
		double expectedScore1 = 93.0;
		double actualScore1 = gradebook1.finalScore();
		double expectedScore2 = 172.0;
		double actualScore2 = gradebook2.finalScore();
		
		assertTrue(expectedScore1 == actualScore1);
		assertTrue(expectedScore2 == actualScore2);
	}

}
