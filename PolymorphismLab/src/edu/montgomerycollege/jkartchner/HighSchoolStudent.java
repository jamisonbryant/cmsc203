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
public class HighSchoolStudent extends Student
{
    private String school;
    private String counselor; 
    private int year; 
    private double gpa; 
  
    public HighSchoolStudent(String name, int age, String address, 
    						 String school, String counselor, int year,  
    						 double gpa) 
    { 
        // Call parent constructor 
        super(name, age, address); 
         
        // Store student data 
        this.school = school; 
        this.counselor = counselor; 
        this.year = year; 
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
     
    public String getCounselor() 
    { 
        return counselor; 
    }
    
    public void setCounselor(String counselor) 
    { 
        this.counselor = counselor;
    } 
    
    public int getYear() 
    { 
        return year; 
    }
    
    public void setYear(int year) 
    {
    	this.year = year;
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
        String details = "Name: " + getName() + ", Age: " + getAge() +  
              ", School: " + school + ", Counselor: " + counselor +  
              ", Year: " + year + ", GPA: " + gpa; 
          
         return details; 
    } 
}
