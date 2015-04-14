import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Specifies the methods required for the restaurant ranking data manager
 * @author ralexander
 *
 */
public interface BestFoodManagerInterface {

	/**
	 * Reads from a file with one line per food category and a set of restaurant names and ratings.
	 * For each name/rating pair a Restaurant object is created and added to the 2D array of restaurants.
	 * A 1D array of categories is also created and held in the manager instance
	 * @param inFile of type File containing 8 lines of text in the following format:
	 * Category;Restaurant Name: Rating; Restaurant Name: Rating; Restaurant Name: Rating; 
	 * Example: American (Traditional);Coastal Flats: 4.0;Quincy's South: 4.5;
	 * Note that each line of text may contain a different number of restaurant/rating pairs
	 * @return a 2D array of restaurants, each row being of a single category
	 * @throws IOException if inFile is not found or not readable
	 */
	public Restaurant[][] readFromFile(File inFile) throws IOException;

	/**
	 * Sorts each row of restaurants in rdata according to its rating, from highest to lowest ratings.
	 * This sorted array is held by the manager instance.
	 * @param rdata the 2D array of restaurants read in from the input file.
	 */
	public void setBestRestaurants(Restaurant[][] rdata);
	
	/**
	 * Gets an array of Restaurants sorted by rating within each category
	 * @return the sorted 2D array of Restaurants
	 */
	public Restaurant[][] getBestRestaurants();

	/**
	 * Writes the sorted set of restaurants to a file, with a header, in the following format:
	 * Categories; Best Restaurants in Rockville; Average Rating
	 * Mexican; Taco Bar; Tortacos; Al Carbon; El Mariachi; 4.05
	 * <next lines of category/restaurants/average rating>
	 * @param outFile the file that will be written to
	 * @throws FileNotFoundException
	 */
	public void writeToFile(File outFile) throws FileNotFoundException;
	
	/**
	 * retrieves the category names (e.g., Mexican, Thai, etc)
	 * @return a 1D array of Strings that contain the category names
	 */
	public String[] getCategories();

}
