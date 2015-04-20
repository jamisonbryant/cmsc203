package edu.montgomerycollege.jkartchner;
// high school class definition

public class HighSchoolStudent extends Student{
   private String highSchoolName;
   private String counselorName;
   private int yearOfGraduation;
   private double gpa;

   public HighSchoolStudent(String n, int a, String add,
          String highsch, String counselor,
          int year, double g)
   {
      super(n, a, add);
      highSchoolName = highsch;
      counselorName = counselor;
      yearOfGraduation = year;
      gpa = g; }
   public String getCounselor(){return counselorName;}
   public double getGpa(){return gpa;}
   public String getHighSchoolName() {return highSchoolName;}
   public int getGraduationYear() {return yearOfGraduation;}
   //public String toString(){}
   public String printStudent()
 {String report = getName() + "  Age: " + getAge()+
                 "  Attends: " + highSchoolName + "  High School Counselor: " + counselorName +
                 "  Year of Graduation: " + yearOfGraduation +
                 "  GPA: " + gpa;
  return report;}
}
