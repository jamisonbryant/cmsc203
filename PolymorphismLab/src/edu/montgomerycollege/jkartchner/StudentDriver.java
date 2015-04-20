package edu.montgomerycollege.jkartchner;
import java.util.ArrayList;
import java.util.Scanner;

/** Polymorphism Lab
 *  Student Driver class
 *  Uses the CollegeStudent, ElementarySchoolStudent, HighSchoolStudent and Student classes
 * @author JWISNIEW
 *
 */

public class StudentDriver {
	/**
	 * Prints a menu
	 * Print the following menu:
	 * Choose one of the following:
	 * 1.	Create an Elementary School Student
	 * 2.	Create a High School Student
	 * 3.	Create a College Student
	 * 4.	Print out all students
	 * 5.	Exit
	 * When user selectes menu item 1 - 3
	 * Prompts user for data needed for type of student selected
	 * Creates an object of student type user selected
	 * Puts object into the ArrayList
	 * When the user selects menu item 4 - the students in the Arraylist are printed to the console
	 * When the user selects menu item 5 - the application terminates
	 * @param args - not used
	 */
   public static void main(String[] args)
   {
	   ArrayList</* STUDENT: Put in the appropriate data type */> students;
	   Scanner in = new Scanner(System.in);
	   
     // 1.  print out menu
     // 2.  user selects to create elementary
     //     school, college or high school student
     // 3.  prompts user for appropriate information
     // 4.  creates the appropriate object (calls constructor)
	 // 5.  put object into ArrayList students
     // 6.  print out all students when user selects 4. from the menu
	 // 7.  repeat until user selects “Exit” from menu
	   

		System.out.println("Please select type of object to create:");
		System.out.println(
				"1) Elementry School\n2) High School\n3) College Student\n4)Print out all students\n5)Exit");
		int menuItem = Integer.parseInt(in.nextLine());
		while (menuItem != 5) {
			if (menuItem == 1) {
				System.out.println(
						"You have selected to create a profile of a Elementry School Kid ..... ");
				System.out.println("Please enter the full name: ");
				String name = in.nextLine();
				System.out.println("Please enter the Age: ");
				int age = Integer.parseInt(in.nextLine());
				System.out.println(
						"Please enter the name of the Elementry School: ");
				String eschool = in.nextLine();
				System.out.println("Please enter the Address: ");
				String address = in.nextLine();
				System.out.println("Please enter the name of the Teacher: ");
				String tname = in.nextLine();
				System.out.println("Please enter the Room No.: ");
				int rno = Integer.parseInt(in.nextLine());
				students.add(new ElementarySchoolStudent(name, age, address, eschool,
						tname, rno));
			}
			
			// STUDENT: complete the rest of main
   }

  
   /**
    * Prints out the student object in the arraylist using the printStudent method defined in each class
    * @param students The arraylist of students entered by the user
    */
   public static void printReport(ArrayList</* STUDENT: Put in the appropriate data type */> students)
   {
      for(Student current : students)
	   System.out.println(current.printStudent());
   }
}