package edu.montgomerycollege.jkartchner;
import java.util.ArrayList;
import java.util.Scanner;

import edu.montgomerycollege.jbryant.ElementarySchoolStudent;

/** 
 * Polymorphism Lab
 * Copyright (c) Jeannette Myers-Kartchner
 * 
 * Student Driver class
 * Creates and performs actions with the different types of Student classes
 * 
 * @author Jeannette Myers-Kartchner (jeannette.myers@montgomerycollege.edu)
 * @author Jamison Bryant (jbryan46@montgomerycollege.edu)
 */

public class StudentDriver {
	/**
	 * Main method
	 * 
	 * 1. Prints a menu
	 * 2. Waits for selection
	 * 3. If user selected student action, prompts user for data 
	 * 4. Creates an object of selected type and adds to list
	 * 5. If user selected print action, prints student data to console
	 * 6. If user selected exit action, application terminates
	 * 
	 * @param args Command-line arguments
	 */
   public static void main(String[] args)
   {
	   ArrayList<Student> students = new ArrayList<Student>();
	   Scanner in = new Scanner(System.in);
	   int selection;
	   String separator = "\n========================================";
	   
	   do {
		   // Print menu
		   System.out.println(separator);
		   System.out.println("Please select an operation:");
		   System.out.println("  1) Create Elementary School student");
		   System.out.println("  2) Create High School student");
		   System.out.println("  3) Create College student");
		   System.out.println("  4) Display student data");
		   System.out.println("  5) Exit");
		   System.out.println();
		   System.out.print("Choice: ");
		   
		   // Get selection and validate
		   selection = in.nextInt();
		   
		   /*
		    * NOTE: Java does not "consume" the newline at the end
		    * of the line of an integer input received from a call 
		    * to nextInt(). In order to keep further calls to 
		    * nextLine() from getting confused, we must eliminate 
		    * the orphaned newline manually.
		    */
		   in.nextLine();
		   
		   if (selection < 1 || selection > 5) {
			   System.err.println("Invalid choice. Please choose again.");			   
		   }
		   
		   // Perform requested action
		   boolean valid = false;
		   String name = "";
		   int age = 0;
		   String address = "";
		   String school = "";
		   String counselor = "";
		   String major = "";
		   int year = 0;
		   double gpa = 0.0;
		   
		   switch (selection) {
			   case 1:				   
				   System.out.println(separator);
				   System.out.println("Elementary School Student");				   
				   System.out.println();
				   
				   // Get name
				   do {
					   System.out.print("Name: ");
					   name = in.nextLine();
					   
					   if (name.equals("")) {
						   System.err.println("Name is a required field.");
						   name = "";
					   } else {
						   valid = true;
					   }
				   } while (!valid);
				   
				   // Get age
				   do {
					   System.out.print("Age: ");
					   age = in.nextInt();
					   
					   /*
					    * NOTE: Java does not "consume" the newline at the end
					    * of the line of an integer input received from a call 
					    * to nextInt(). In order to keep further calls to 
					    * nextLine() from getting confused, we must eliminate 
					    * the orphaned newline manually.
					    */
					   in.nextLine();
					   
					   if (age == 0) {
						   System.err.println("Age is a required field.");						   
					   } else if (age < 0) {
						   System.err.println("Age must be greater than 0.");
						   age = 0;
					   } else {
						   valid = true;
					   }
					   
				   } while (!valid);
				   
				   // Get address
				   valid = false;
				   
				   do {
					   System.out.print("Address: ");
					   address = in.nextLine();
					   
					   if (address.equals("")) {
						   System.err.println("Address is a required field.");
						   address = "";
					   } else {
						   valid = true;
					   }
				   } while (!valid);				   
				   
				   // Get school
				   System.out.print("School: ");
				   school = in.nextLine();
				   				   
				   // Get teacher
				   System.out.print("Teacher: ");
				   String teacher = in.nextLine();
				   
				   // Get room number
				   System.out.print("Room: ");
				   int room = in.nextInt();
				   
				   // Create student
				   Student elementarySchoolStudent = 
						   new ElementarySchoolStudent(name, age, address,
						   							   school, teacher, room);
				   
				   // Add student to list
				   students.add(elementarySchoolStudent);
				   
				   break;
				   
			   case 2:
				   System.out.println(separator);
				   System.out.println("High School Student");				   
				   System.out.println();
				   
				   // Get name
				   do {
					   System.out.print("Name: ");
					   name = in.nextLine();
					   
					   if (name.equals("")) {
						   System.err.println("Name is a required field.");
						   name = "";
					   } else {
						   valid = true;
					   }
				   } while (!valid);
				   
				   // Get age
				   do {
					   System.out.print("Age: ");
					   age = in.nextInt();
					   
					   /*
					    * NOTE: Java does not "consume" the newline at the end
					    * of the line of an integer input received from a call 
					    * to nextInt(). In order to keep further calls to 
					    * nextLine() from getting confused, we must eliminate 
					    * the orphaned newline manually.
					    */
					   in.nextLine();
					   
					   // Validate input
					   if (age == 0) {
						   System.err.println("Age is a required field.");						   
					   } else if (age < 0) {
						   System.err.println("Age must be greater than 0.");
						   age = 0;
					   } else {
						   valid = true;
					   }
				   } while (!valid);
				   
				   // Get address
				   do {
					   System.out.print("Address: ");
					   address = in.nextLine();
					   
					   if (address.equals("")) {
						   System.err.println("Address is a required field.");
						   address = "";
					   } else {
						   valid = true;
					   }
				   } while (!valid);
				   
				   // Get school
				   System.out.print("School: ");
				   school = in.nextLine();
				   
				   // Get teacher
				   System.out.print("Counselor: ");
				   counselor = in.nextLine();
				   
				   // Get year
				   System.out.print("Year: ");
				   year = in.nextInt();
				   
				   // Get GPA
				   System.out.print("GPA: ");
				   gpa = in.nextDouble();
				   
				   // Create student
				   Student highSchoolStudent = 
						   new HighSchoolStudent(name, age, address, school, 
								   				 counselor, year, gpa);
				   
				   // Add student to list
				   students.add(highSchoolStudent);
				   
				   break;
				   
			   case 3:
				   System.out.println(separator);
				   System.out.println("College Student");				   
				   System.out.println();
				   
				   // Get name
				   do {
					   System.out.print("Name: ");
					   name = in.nextLine();
					   
					   if (name.equals("")) {
						   System.err.println("Name is a required field.");
						   name = "";
					   } else {
						   valid = true;
					   }
				   } while (!valid);
				   

				   // Get age
				   do {
					   System.out.print("Age: ");
					   age = in.nextInt();
					   
					   /*
					    * NOTE: Java does not "consume" the newline at the end
					    * of the line of an integer input received from a call 
					    * to nextInt(). In order to keep further calls to 
					    * nextLine() from getting confused, we must eliminate 
					    * the orphaned newline manually.
					    */
					   in.nextLine();
					   
					   // Validate input
					   if (age == 0) {
						   System.err.println("Age is a required field.");						   
					   } else if (age < 0) {
						   System.err.println("Age must be greater than 0.");
						   age = 0;
					   } else {
						   valid = true;
					   }
				   } while (!valid);
				   
				   // Get address
				   do {
					   System.out.print("Address: ");
					   address = in.nextLine();
					   
					   if (address.equals("")) {
						   System.err.println("Address is a required field.");
						   address = "";
					   } else {
						   valid = true;
					   }
				   } while (address == null);
				   
				   // Get school
				   System.out.print("School: ");
				   school = in.nextLine();
				   
				   // Get major
				   System.out.print("Major: ");
				   major = in.nextLine();
				   
				   // Get GPA
				   System.out.print("GPA: ");
				   gpa = in.nextDouble();
				   
				   // Create student
				   Student collegeStudent = 
						   new CollegeStudent(name, age, address, school, major, 
						   					  gpa);
				   
				   // Add student to list
				   students.add(collegeStudent);
				   
				   break;
				   
			   case 4:
				   // Print student data
				   printReport(students);
				   
				   break;
				   
			   case 5:
				   // Free resources
				   in.close();
				   
				   // Exit application
				   System.exit(0);
				   
				   break;
		   }
	   } while (selection != 5);
   }

  
   /**
    * Print Report method
    * 
    * Displays student data by calling printStudent() for each student
    * 
    * @param students The list of students
    */
   public static void printReport(ArrayList<Student> students)
   {
      for (Student student : students) {
	      System.out.println(student.printStudent());
	  }
   }
}