import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Assignment 6 - Yelp! Restaurant Data Application
 * Copyright (c) 2015 Jamison Bryant
 * 
 * Best Food Manager Class
 * Data manager class for restaurants  
 * 
 * @author Jamison Bryant (jbryan46@montgomerycollege.edu)
 * @see    Restaurant
 */
public class BestFoodManager implements BestFoodManagerInterface {

	/**
	 * Reads restaurant data from a file
	 * 
	 * @param  The file to read data from
	 * @return A 2-dimensional array of restaurants
	 * @throws IOException
	 */
	@Override
	public Restaurant[][] readFromFile(File file) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Not sure what this does yet
	 * 
	 * @param A 2-dimensional array of restaurants
	 */
	@Override
	public void setBestRestaurants(Restaurant[][] restaurants) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Not sure what this does yet
	 * 
	 * @return A 2-dimensional array of restaurants
	 */
	@Override
	public Restaurant[][] getBestRestaurants() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Writes restaurant data to a file
	 * 
	 * @param  The file to write data to
	 * @throws FileNotFoundException
	 */
	@Override
	public void writeToFile(File file) throws FileNotFoundException {
		
	}

	/**
	 * Returns an array of restaurant categories
	 * 
	 * @return An array of categories
	 */
	@Override
	public String[] getCategories() {
		return null;
	}

}
