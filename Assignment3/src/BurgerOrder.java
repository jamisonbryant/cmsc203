import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

/**
 * Keeps track of the items in a Hartatak Burger order and calculates the 
 * order's subtotal, tax, and total.
 *
 * @author  Jamison Bryant (jbryan46@montgomerycollege.edu)
 * @version 1.1
 */
public class BurgerOrder {
	/**
	 * The price of a hamburger (${@value}) 
	 */
	public static final double HAMBURGER_PRICE = 4.95;
	
	/**
	 * The price of a cheeseburger (${@value}) 
	 */
	public static final double CHEESEBURGER_PRICE = 5.95;
	
	/**
	 * The price of a double cheeseburger (${@value}) 
	 */
	public static final double DOUBLE_CHEESEBURGER_PRICE = 6.95;
	
	/**
	 * The price of a condiment (${@value}) 
	 */
	public static final double CONDIMENT_PRICE = 0.25;
	
	/**
	 * The sales tax ({@value} cents/dollar) 
	 */
	public static final double SALES_TAX = 0.0785;
	
	/**
	 * The meal (hambuger, cheeseburger, or double cheeseburger)
	 */
	private String meal;
	
	/**
	 * The number of condiments
	 */
	private int condiments;
	
	/**
	 * The subtotal of the order
	 */
	private double subtotal;
	
	/**
	 * The tax on the order
	 */
	private double tax;
	
	/**
	 * The total of the order (subtotal plus tax)
	 */
	private double total;
	
	/**
	 * Constructs a BurgerOrder object
	 */
	public BurgerOrder() {
		meal = "hamburger";
		condiments = 0;
	}
	
	/**
	 * Constructs a BurgerOrder object given a meal
	 * 
	 * @param meal The meal (see {@link BurgerOrder#meal})
	 */
	public BurgerOrder(String meal) {
		this.meal = meal;
		condiments = 0;
	}
	
	/**
	 * Constructs a BurgerOrder object given a meal and the number of
	 * condiments
	 * 
	 * @param meal 		 The meal (see {@link BurgerOrder#meal})
	 * @param condiments The number of condiments
	 */
	public BurgerOrder(String meal, int condiments) {
		this.meal = meal;
		this.condiments = condiments;
	}

	/**
	 * Returns the order's meal
	 * 
	 * @return The meal
	 */
	public String getMeal() {
		if(meal.equals("hamburger")) {
			return "Hamburger";
		} else if(meal.equals("cheeseburger")) {
			return "Cheeseburger";
		} else if(meal.equals("double_cheeseburger")) {
			return "Double Cheeseburger";
		} else {
			throw new RuntimeException("Invalid meal type encountered: " + meal);
		}
	}
	
	/**
	 * Returns the price of the order's meal
	 * 
	 * @return The price of the meal
	 */
	public double getMealPrice() {
		if(meal.equals("hamburger")) {
			return HAMBURGER_PRICE;
		} else if(meal.equals("cheeseburger")) {
			return CHEESEBURGER_PRICE;
		} else if(meal.equals("double_cheeseburger")) {
			return DOUBLE_CHEESEBURGER_PRICE;
		} else {
			throw new RuntimeException("Invalid meal type encountered: " + meal);
		}
	}

	/**
	 * Sets the meal
	 * 
	 * @param meal The meal (see {@link BurgerOrder#meal})
	 */
	public void setMeal(String meal) {
		this.meal = meal;
	}

	/**
	 * Gets the number of condiments
	 * 
	 * @return The number of condiments
	 */
	public int getCondiments() {
		return condiments;
	}
	
	/**
	 * Returns the price of the order's condiments
	 * 
	 * @return The price of the meal
	 */
	public double getCondimentsPrice() {
		return condiments * 0.25;
	}

	/**
	 * Sets the number of condiments
	 * 
	 * @param condiments The number of condiments
	 */
	public void setCondiments(int condiments) {
		this.condiments = condiments;
	}
	
	/**
	 * Adds one condiment
	 */
	public void addCondiment() {
		condiments++;
	}
	
	/**
	 * Removes one condiment
	 */
	public void removeCondiment() {
		condiments--;
	}

	/**
	 * Gets the subtotal of the order
	 * 
	 * @return The subtotal of the order
	 */
	public double getSubtotal() {
		// Reset subtotal
		subtotal = 0;
		
		// Add meal price
		if(meal.equals("hamburger")) {
			subtotal += HAMBURGER_PRICE;
		} else if(meal.equals("cheeseburger")) {
			subtotal += CHEESEBURGER_PRICE;
		} else if(meal.equals("double_cheeseburger")) {
			subtotal += DOUBLE_CHEESEBURGER_PRICE;
		}
		
		// Add condiments
		subtotal += (condiments * 0.25);
		
		// Return result
		return subtotal;
	}

	/**
	 * Gets the tax on the order
	 * 
	 * @return The tax on the order
	 */
	public double getTax() {
		// Calculate tax
		tax = subtotal * SALES_TAX;
		
		// Return result
		return tax;
	}

	/**
	 * Gets the total of the order (see {@link BurgerOrder#total})
	 * 
	 * @return The total of the order
	 */
	public double getTotal() {
		// Calculate total
		total = subtotal + tax;
		
		// Return result
		return total;
	}
	
	/**
	 * Returns a reciept for the order
	 * 
	 * @return string The receiept
	 */
	public String getReceipt() {
		// Set up currency formatter
		Currency usd = Currency.getInstance("USD");
		NumberFormat money = NumberFormat.getCurrencyInstance(Locale.US);
		money.setCurrency(usd);
		
		// Build receipt string
		String receipt = "Thank you for choosing Hartatak Burgers!\n\n";
		receipt += "Your order was:\n";
		receipt += " - 1 " + meal + ": " + money.format(getMealPrice()) + "\n";
		receipt += " - " + condiments + " condiments: " + money.format(getCondimentsPrice()) + "\n\n";
		receipt += "Subtotal: " + money.format(subtotal) + "\n";
		receipt += "Tax: " + money.format(tax) + "\n";
		receipt += "Total: " + money.format(total) + "\n";
		
		return receipt;
	}
}
