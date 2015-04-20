package edu.montgomerycollege.jkartchner;
// College student definition

public class CollegeStudent extends Student{
   private String collegeName;
   private String major;
   private double gpa;

   public CollegeStudent(String n, int a, String add,
          String college, String mjr, double g)
   {
      super(n, a, add);
      collegeName = college;
      major = mjr;
      gpa = g; }

   public String getMajor(){return major;}
   public double getGpa(){return gpa;}
   public String getCollegeName() {return collegeName;}
   //public String toString(){}
   public String printStudent()
   {
     String report = getName() + "  Age: " + getAge()+
         "  Attends: " + collegeName +"  Major: " + major +
         "  GPA: " + gpa;
     return report;
   }
}
