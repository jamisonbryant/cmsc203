import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.JOptionPane;

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
	private String[] categoryArray;
	private Restaurant[][] restaurantArray;
	private ArrayList<String> categoryList;
	private ArrayList<ArrayList<Restaurant>> restaurantList;
	
	/**
	 * Reads restaurant data from a file
	 * 
	 * @param file The file to read data from
	 * @return A 2-dimensional array of restaurants
	 * @throws IOException If the file cannot be opened
	 */
	@Override
	public Restaurant[][] readFromFile(File file) throws IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line = null;
			categoryList = new ArrayList<String>();
			restaurantList = new ArrayList<ArrayList<Restaurant>>();
			
			while ((line = reader.readLine()) != null) {
				// Parse category data
				String[] parts = line.split(";");
				String category = parts[0];
				
				// Create list for restaurants				;
				ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
				
				for (int i = 1; i < parts.length; i++) {
					// Parse restaurant data					
					String[] chunks = parts[i].split(":");
					
					// Create restaurant
					Restaurant restaurant = new Restaurant(chunks[0], 
						Double.parseDouble(chunks[1]));
					
					// Add restaurant to list	
					restaurants.add(restaurant);
				}
				
				// Store restaurant data in lists
				categoryList.add(category);
				restaurantList.add(restaurants);
			}
		}
		
		// Convert restaurant data to array
		int rows = categoryList.size();
		int columns = 0;
		
		categoryArray = new String[rows];
		
		for (int i = 0; i < categoryList.size(); i++) {
			categoryArray[i] = categoryList.get(i);
		}
		
		for (int i = 0; i < restaurantList.size(); i++) {
			if (columns < restaurantList.get(i).size()) {
				columns = restaurantList.get(i).size(); 
			}
		}
		
		restaurantArray = new Restaurant[rows][columns];
		
		for (int i = 0; i < restaurantList.size(); i++) {
			for (int j = 0; j < restaurantList.get(i).size(); j++) {
				restaurantArray[i][j] = restaurantList.get(i).get(j);
			}
		}
		
		// Return array of restaurants
		return restaurantArray;
	}

	@Override
	public void setBestRestaurants(Restaurant[][] restaurants) {
		restaurantArray = restaurants;
	}

	@Override
	public Restaurant[][] getBestRestaurants() {
		ArrayList<ArrayList<Restaurant>> bestRestaurants = 
			new ArrayList<ArrayList<Restaurant>>();
		
		for (int i = 0; i < restaurantList.size(); i++) {
			Collections.sort(restaurantList.get(i));
			bestRestaurants.add(restaurantList.get(i));
		}
		
		restaurantList = bestRestaurants;
		
		// Convert restaurant data to array
		int rows = categoryList.size();
		int columns = 0;
		
		for (int i = 0; i < restaurantList.size(); i++) {
			if (columns < restaurantList.get(i).size()) {
				columns = restaurantList.get(i).size(); 
			}
		}
		
		restaurantArray = new Restaurant[rows][columns];
		
		for (int i = 0; i < restaurantList.size(); i++) {
			for (int j = 0; j < restaurantList.get(i).size(); j++) {
				restaurantArray[i][j] = restaurantList.get(i).get(j);
			}
		}
		
		// Return array of restaurants
		return restaurantArray;
	}

	@Override
	/**
	 * Writes review data to file
	 * 
	 * @param file The file to write to
	 */
	public void writeToFile(File file) throws FileNotFoundException {
		// Prepare data file
		PrintWriter writer = new PrintWriter(file.getAbsoluteFile());
		
		// Write header line
		String line = "Categories; Best Restaurants in Rockville; Average Rating";
		writer.println(line);
		
		// Construct data line
		for (int i = 0; i < categoryList.size(); i++) {
			line = categoryList.get(i) + "; ";
			
			for (int j = 0; j < restaurantList.get(i).size(); j++) {
				line += restaurantList.get(i).get(j).toString() + ";";			
			}
			
			// Write line to file
			writer.println(line);
		}
		
		// Close file
		writer.close();
	}

	@Override
	public String[] getCategories() {
		return categoryArray;
	}

	public String[] getCategoryArray() {
		return categoryArray;
	}

	public Restaurant[][] getRestaurantArray() {
		return restaurantArray;
	}

	public ArrayList<String> getCategoryList() {
		return categoryList;
	}

	public ArrayList<ArrayList<Restaurant>> getRestaurantList() {
		return restaurantList;
	}

	/**
	 * Returns the averages of all of the restaurant's ratings
	 * 
	 * @return The average
	 */
	public double[] getAverages() {
		double[] averages = new double[categoryList.size()];
		double total = 0.0;
		
		for (int i = 0; i < categoryList.size(); i++) {
			total = 0.0;
			
			for (int j = 0; j < restaurantList.get(i).size(); j++) {
				total += restaurantList.get(i).get(j).getRating();				
			}
			
			averages[i] = total / restaurantList.get(i).size();;
		}
			
		return averages;
	}
}