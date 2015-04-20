package edu.montgomerycollege.jkartchner;
//abstract student class definition

public abstract class Student{
   private String name;
   private int age;
   private String address;

   public Student(String n, int a, String add)
   { name = n; age = a; address = add; }
   public String getName(){return name;}
   public int getAge(){return age;}
   public String getAddress(){return address;}
   //public String toString(){}
   public abstract String printStudent();
}
