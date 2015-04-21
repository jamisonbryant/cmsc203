package edu.montgomerycollege.jkartchner;

import edu.montgomerycollege.jbryant.CheckingAccount;
import edu.montgomerycollege.jbryant.SavingsAccount;

import java.text.DecimalFormat;

/**
 * Inheritance Project
 * Copyright (c) 2015 Jeannette Kartchner
 * 
 * Account Driver class
 * Main class that runs the application using the other classes
 * 
 * @author Jeannette Kartchner (jeannette.kartchner@montgomerycollege.edu)
 * @author Jamison Bryant (jbryan46@montgomerycollege.edu)
 */
public class AccountDriver
{
	public static void main(String[] args)
	{
		double amountToDeposit = 500.0;
		double amountToWithdraw = 1000.0;

		DecimalFormat formatter;		

		// Create monetary value formatter
		formatter = new DecimalFormat("#.00");

		// Test checking account class
		CheckingAccount checkAcct1 =
			new CheckingAccount("Benjamin Franklin", 1000);
		
		System.out.println("Account number: " + checkAcct1.getAccountNumber() +
			" belonging to " + checkAcct1.getOwner());
				
		System.out.println("Initial balance: $" + 
			formatter.format(checkAcct1.getBalance()));
		
		checkAcct1.deposit(amountToDeposit);
		
		System.out.println("After deposit of $" + 
						   formatter.format(amountToDeposit) + 
						   ", balance: $" + 
						   formatter.format(checkAcct1.getBalance()));
		
		if (checkAcct1.withdraw(amountToWithdraw)) {
			System.out.println("After withdrawal of $" + 
							   formatter.format(amountToWithdraw) + 
							   ", balance: $" + 
							   formatter.format(checkAcct1.getBalance()));
		} else {
			System.out.println("Insuffient funds to withdraw $" + 
							   formatter.format(amountToWithdraw) + 
							   ", balance: $" + 
							   formatter.format(checkAcct1.getBalance()));
		}
		
		System.out.println();

		// Test savings account class
		SavingsAccount saveAcct1 =				
			new SavingsAccount("William Shakespeare", 400);
		
		System.out.println("Account number: " + saveAcct1.getAccountNumber() +
						   ", belonging to " + saveAcct1.getOwner());
				
		System.out.println("Initial balance: $" + 
							formatter.format(saveAcct1.getBalance()));
		
		saveAcct1.deposit(amountToDeposit);
		
		System.out.println("After deposit of $" + 
						   formatter.format(amountToDeposit) + ", balance: $" + 
						   formatter.format(saveAcct1.getBalance()));
		
		if (saveAcct1.withdraw(amountToWithdraw)) {
			System.out.println("After withdrawal of $" + 
							   formatter.format(amountToWithdraw) + 
							   ", balance:  $" + 
							   formatter.format(saveAcct1.getBalance()));
		} else {
			System.out.println("Insuffient funds to withdraw $" + 
							   formatter.format(amountToWithdraw) + 
							   ", balance: $" + 
							   formatter.format(saveAcct1.getBalance()));
		}
		
		saveAcct1.postInterest();
		
		System.out.println("After monthly interest has been posted" + 
						   ", balance: $" + 
						   formatter.format(saveAcct1.getBalance()));
		
		System.out.println();

		// Test copy constructor
		SavingsAccount saveAcct2 =
			new SavingsAccount(saveAcct1, 5);
		
		System.out.println("Account number: " + saveAcct2.getAccountNumber() + 
						   ", belonging to " + saveAcct2.getOwner());
		
		System.out.println("Initial balance: $" + 
						   formatter.format(saveAcct2.getBalance()));
		
		saveAcct2.deposit (amountToDeposit);

		System.out.println("After deposit of $" + 
						   formatter.format(amountToDeposit) + ", balance: $" + 
						   formatter.format(saveAcct2.getBalance()));
		
		if (saveAcct2.withdraw(amountToWithdraw)) {
			System.out.println("After withdrawal of $" + 
							   formatter.format(amountToWithdraw) + 
							   ", balance: $" + 
							   formatter.format(saveAcct2.getBalance()));
		} else {
			System.out.println("Insuffient funds to withdraw $" + 
							   formatter.format(amountToWithdraw) + 
							   ", balance: $" + 
							   formatter.format(saveAcct2.getBalance()));
		}
		
		System.out.println();

		// Test account numbering
		CheckingAccount checkAcct2 =
				new CheckingAccount("Issac Newton", 5000);
		
		System.out.println("Account number: " + checkAcct2.getAccountNumber() +
						   ", belonging to " + checkAcct2.getOwner());
	}
}
