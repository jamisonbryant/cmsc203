package edu.montgomerycollege.jbryant;

import edu.montgomerycollege.jkartchner.Student;

/**
 * Polymorphism Lab
 * Copyright (c) 2015 Jamison Bryant
 * 
 * Elementary School Student class
 * A data class representing a student in elementary school
 * 
 * @author Jamison Bryant (jbryan46@montgomerycollege.edu)
 */
public class ElementarySchoolStudent extends Student 
{
	private String school;
	private String teacher;
	private int room;
	
	public ElementarySchoolStudent() 
	{
		// Call parent constructor
		super("", 0, "");
	}

	public ElementarySchoolStudent(String name, int age, String address) 
	{
		// Call parent constructor
		super(name, age, address);		
	}

	public ElementarySchoolStudent(String name, int age, String address,
								   String school, String teacher, int room) 
	{
		// Call parent constructor
		super(name, age, address);
		
		// Store student data
		this.school = school;
		this.teacher = teacher;
		this.room = room;
	}
	
	public String getSchool() 
	{
		return school;
	}

	public void setSchool(String school) 
	{
		this.school = school;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) 
	{
		this.teacher = teacher;
	}

	public int getRoom() 
	{
		return room;
	}

	public void setRoom(int room) 
	{
		this.room = room;
	}
		
	public String toString() 
	{
		return printStudent();
	}

	/**
	 * Print Student method
	 * 
	 * Returns the student's details as a concatenated string
	 * 
	 * @return String
	 */
	public String printStudent() 
	{
		String details = "Name: " + getName() + ", Age: " + getAge() + 
						 ", School: " + school + ", Teacher: " + teacher + 
						 ", Room: " + room;
		
		return details;
	}

}
