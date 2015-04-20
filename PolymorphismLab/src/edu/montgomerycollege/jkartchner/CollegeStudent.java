package edu.montgomerycollege.jkartchner;
 
 /**
  * Polymorphism Lab
  * Copyright (c) 2015 Jamison Bryant
  * 
  * High School Student class
  * A data class representing a student in high school
  * 
  * @author Jeannette Myers-Kartchner (jeannette.myers@montgomerycollege.edu)
  */
 public class CollegeStudent extends Student
 {
    private String school;
    private String major;
    private double gpa;
 
    public CollegeStudent(String name, int age, String address,
                                 String college, String major, double gpa)
    {
        // Call parent constructor
       super(name, age, address);
 
       // Store student data
       this.school = college;
       this.major = major;
       this.gpa = gpa; 
    }
    
    public String getSchool() 
    {
        return school;
    }
    
    public void setSchool(String school) 
    {
    	this.school = school;
    }
 
    public String getMajor()
    {
        return major;
    }
    
    public void setMajor(String major) 
    {
    	this.major = major;
    }
    
    public double getGpa()
    {
        return gpa;
    }
    
    public void setGpa(double gpa) 
    {
    	this.gpa = gpa;
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
        String report = "Name: " + getName() + ", Age: " + getAge() +
                        ", College: " + school + ", Major: " + major +
                        ", GPA: " + gpa;
           
        return report;
    }
}
