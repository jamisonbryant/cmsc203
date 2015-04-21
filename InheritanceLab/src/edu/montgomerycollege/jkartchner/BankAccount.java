package edu.montgomerycollege.jkartchner;

/**
 * Inheritance Project
 * Copyright (c) 2015 Jeannette Kartchner
 * 
 * Bank Account class
 * Generic data type for bank account classes
 * 
 * @author Jeannette Kartchner (jeannette.kartchner@montgomerycollege.edu)
 * @author Jamison Bryant (jbryan46@montgomerycollege.edu)
 */
public abstract class BankAccount
{
	/**
	 * Number of accounts
	 */
	protected static int numberOfAccounts = 100001;

	/**
	 * Monetary balance of account
	 */
	private double balance;
	
	/**
	 * Account owner's name
	 */
	private String owner;
	
	/**
	 * Unique account identifier
	 */
	private String accountNumber;

	/**
	 * Default constructor
	 */
	public BankAccount()
	{
		balance = 0;
		accountNumber = numberOfAccounts + "";
		numberOfAccounts++;
	}

	/**
	 * Standard constructor
	 * 
	 * @param name Account owner's name
	 * @param amount Account balance
	 */
	public BankAccount(String name, double amount)
	{
		owner = name;
		balance = amount;
		accountNumber = numberOfAccounts + "";
		numberOfAccounts++;
	}

	/**
	 * Copy constructor
	 * 
	 * @param oldAccount Account to copy
	 * @param amount Balance of new account
	 */
	public BankAccount(BankAccount oldAccount, double amount)
	{
		owner = oldAccount.owner;
		balance = amount;
		accountNumber = oldAccount.accountNumber;
	}

	/**
	 * Deposit method
	 * 
	 * Adds money to the account
	 * 
	 * @param amount Amount to deposit
	 */
	public void deposit(double amount)
	{
		balance = balance + amount;
	}

	/**
	 * Withdraw method
	 * 
	 * Removes money from the account if enough money is available
	 * 
	 * @param amount Amount to withdraw
	 * @return true, or false if insufficient balance
	 */
	public boolean withdraw(double amount)
	{
		boolean completed = true;

		if (amount <= balance)
		{
			balance = balance - amount;
		}
		else
		{
			completed = false;
		}
		
		return completed;
	}
	
	public double getBalance()
	{
		return balance;
	}

	public String getOwner()
	{
		return owner;
	}

	public String getAccountNumber()
	{
		return accountNumber;
	}

	public void setBalance(double newBalance)
	{
		balance = newBalance;
	}
	
	public void setOwner(String newOwner) 
	{
		owner = newOwner;
	}

	public void setAccountNumber(String newAccountNumber)
	{
		accountNumber = newAccountNumber;
	}
}