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
	private Restaurant[][] restaurants;
	private ArrayList<String> categories;
	
	/**
	 * Reads restaurant data from a file
	 * 
	 * @param  The file to read data from
	 * @return A 2-dimensional array of restaurants
	 * @throws IOException
	 */
	@Override
	public Restaurant[][] readFromFile(File file) throws IOException {
		Restaurant[] restaurants = null;
		Restaurant[][] allRestaurants = null;
		
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line = null;
			int lines = 0;
			
			while ((line = reader.readLine()) != null) {
				// Increment line count
				lines++;
				
				// Parse category data
				String[] parts = line.split(";");
				String category = parts[0];
				categories.add(category);				
				
				// Create array for restaurants
				restaurants = new Restaurant[parts.length - 1];
							
				for (int i = 1; i < parts.length; i++) {
					// Parse restaurant data					
					String[] chunks = parts[i].split(":");
					
					// Create restaurant
					Restaurant restaurant = new Restaurant(chunks[0], 
						Double.parseDouble(chunks[1]));
					
					// Add restaurant to array
					restaurants[i - 1] = restaurant;
				}			
			}
			
			// Add restaurants to complete array
			allRestaurants = new Restaurant[lines][];
			
			for (int i = 0; i < lines; i++) {
				allRestaurants[i] = restaurants;
			}
		}
		
		return restaurantArray;
	}

	@Override
	public void setBestRestaurants(Restaurant[][] rdata) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Restaurant[][] getBestRestaurants() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void writeToFile(File outFile) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String[] getCategories() {
		// TODO Auto-generated method stub
		return null;
	}
}