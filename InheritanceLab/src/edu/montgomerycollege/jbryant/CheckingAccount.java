package edu.montgomerycollege.jbryant;

import edu.montgomerycollege.jkartchner.BankAccount;

/**
 * Inheritance Lab
 * Copyright (c) 2015 Jamison Bryant
 * 
 * Checking Account class
 * Data class for bank account accessed via a debit card
 * 
 * @author Jamison Bryant (jbryan46@montgomerycollege.edu) 
 */
public class CheckingAccount extends BankAccount 
{
	public static double FEE = 0.15;
	private String accountNumber;
	
	public CheckingAccount(String name, double balance) 
	{
		// Call parent class constructor
		super(name, balance);
		
		// Set account number
		accountNumber = super.getAccountNumber() + "-10";
	}
	
	public boolean withdraw(double amount) {
		// Add withdrawal fee
		amount += FEE;
		
		return super.withdraw(amount);
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
}
