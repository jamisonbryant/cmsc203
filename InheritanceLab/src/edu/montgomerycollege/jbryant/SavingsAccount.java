package edu.montgomerycollege.jbryant;

import edu.montgomerycollege.jkartchner.BankAccount;

/**
 * Inheritance Lab
 * Copyright (c) 2015 Jamison Bryant
 * 
 * Savings Account class
 * Data class for bank account intended for saving money
 * 
 * @author Jamison Bryant (jbryan46@montgomerycollege.edu) 
 */
public class SavingsAccount extends BankAccount 
{
	private double rate = 0.025;
	private int identifier = 0;
	private String accountNumber;
	
	public SavingsAccount(String name, double balance) 
	{
		super(name, balance);
		
		// Set account number
		this.accountNumber = super.getAccountNumber() + "-" + identifier;
	}
	
	public SavingsAccount(SavingsAccount account, double balance)
	{
		// Call parent constructor
		super(account, balance);
		
		// Set new account number
		identifier++;
		accountNumber = super.getAccountNumber() + "-" + identifier;
	}

	/**
	 * Post interest method
	 * 
	 * Deposits the appropriate amount of interest into the account
	 */
	public void postInterest() {
		// Calculate interest
		double balance = getBalance();
		double interest = balance * (1 + (rate / 12));
		
		// Set new balance
		setBalance(interest);
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
}
