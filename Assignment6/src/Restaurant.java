/**
 * Assignment 6 - Yelp! Restaurant Data Application
 * Copyright (c) 2015 Jamison Bryant
 * 
 * Restaurant Class
 * Data class for a restaurant, containing the restaurants name and rating.  
 * 
 * @author Jamison Bryant (jbryan46@montgomerycollege.edu)
 */
public class Restaurant implements Comparable<Restaurant> {
	private String name;
	private double rating;
	
	/**
	 * Constructs a new restaurant
	 */
	public Restaurant() {
		this.name = "";
		this.rating = 0.0;
	}

	/**
	 * Constructs a new restaurant
	 * 
	 * @param name   The restaurant's name
	 * @param rating The restaurant's rating
	 */
	public Restaurant(String name, double rating) {
		this.name = name;
		this.rating = rating;
	}

	/**
	 * Compares the restaurant to another restaurant
	 * 
	 * @param  A restaurant to compare this restaurant against
	 * @return The result of the comparison
	 */
	@Override
	public int compareTo(Restaurant other) {
		// Declare variables for comparison result
		int worse = -1;
		int same = 0;
		int better = 1;
		
		// Check how the two restaurant's ratings compare
		// If ratings are not comparable throw an exception
		if (this.rating < other.rating) {
			return better;
		} else if (this.rating == other.rating) {
			return same;
		} else if (this.rating > other.rating) {
			return worse;
		} else {
			throw new RuntimeException("Restaurant types are not comparable");
		}
	}
	
	/**
	 * Gets the restaurant's name
	 * 
	 * @return The restaurant's name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the restaurant's name
	 * 
	 * @param name The name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the restaurant's rating
	 * 
	 * @return The restaurant's rating
	 */
	public double getRating() {
		return rating;
	}
	
	/**
	 * Sets the restaurant's rating
	 * 
	 * @param rating The rating to set
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	/**
	 * Returns a representation of the restaurant as a string
	 * 
	 * @return The restaurant as a string
	 */
	@Override
	public String toString() {
		return name + ": " + rating;
	}
}
