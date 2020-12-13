// ***************************************************************************************************************************
// CLASS: Student
//
// CSE 205: Object Oriented Programming and Data Structures
// Session A Fall 2018
// Project 3
//
// AUTHOR
// Bradley McGarvin
// ***************************************************************************************************************************

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

/**
 * The Student class stores the grade information for one
 * Student.
 */
public class Student implements Comparable<Student> {

   // Declare the instance variables. See the UML class
   // diagram for Student.
   private ArrayList<Integer> mExamList;

   private String             mFirstName;

   private ArrayList<Integer> mHomeworkList;

   private String             mLastName;

   /**
    * Student()
    *
    * PSEUDOCODE:
    * Save pFirstName and pLastName into instance variables.
    * Create mExamList
    * Create mHomeworkList
    */
   public Student(String pFirstName, String pLastName) {
      mFirstName = pFirstName;
      mLastName = pLastName;
      mExamList = new ArrayList<Integer>();
      mHomeworkList = new ArrayList<Integer>();
   }

   /**
    * addExam()
    *
    * PSEUDOCODE:
    * Call add(pScore) on getExamList() to add a new exam
    * score to the list of exam scores.
    */
   public void addExam(int pScore) {
      getExamList().add( pScore );
   }

   /**
    * addHomework()
    *
    * PSEUDOCODE:
    * Call add(pScore) on getHomeworkList() to add a new
    * homework score to the list of homework scores.
    */
   public void addHomework(int pScore) {
      getHomeworkList().add( pScore );
   }

   /**
    * compareTo()
    * PSEUDOCODE:
    * Return: -1 if the last name of this Student is < the
    * last name of pStudent
    * Return: 0 if the last name of this Student is = the
    * last name of pStudent
    * Return: 1 if the last name of this Student is > the
    * last name of pStudent
    * Hint: the last names are Strings.
    */
   @Override
   public int compareTo(Student pStudent) {
      int value = this.getLastName().compareTo( pStudent.getLastName() );

      if ( value > 0 ) {
         return 1;
      }
      else if ( value < 0 ) {
         return -1;
      }
      else {
         return 0;
      }
   }

   /**
    * getExam()
    *
    * Accessor method to retreive an exam score from the
    * list of exams.
    */
   public int getExam(int pNum) {
      return getExamList().get( pNum );
   }

   /**
    * getExamList()
    *
    * Accessor method for mExamList.
    */
   protected ArrayList<Integer> getExamList() {
      return mExamList;
   }

   /**
    * getFirstName()
    *
    * Accessor method for mFirstName.
    */
   public String getFirstName() {
      return mFirstName;
   }

   /**
    * getHomework()
    *
    * Accessor method to retrieve a homework score from the
    * list of homeworks.
    */
   public int getHomework(int pNum) {
      return getHomeworkList().get( pNum );
   }

   /**
    * getHomeworkList()
    *
    * Accessor method for mHomeworkList.
    */
   protected ArrayList<Integer> getHomeworkList() {
      return mHomeworkList;
   }

   /**
    * getLastname()
    *
    * Accessor method for mLastName.
    */
   public String getLastName() {
      return mLastName;
   }

   /**
    * setExam()
    *
    * Mutator method to store an exam score into the list of
    * exam scores.
    */
   public void setExam(int pNum , int pScore) {
      getExamList().set( pNum, pScore );
   }

   /**
    * setExamList()
    *
    * Mutator method for mExamList.
    */
   protected void setExamList(ArrayList<Integer> pExamList) {
      mExamList = pExamList;
   }

   /**
    * setFirstName()
    *
    * Mutator method for mFirstName.
    */
   public void setFirstName(String pFirstName) {
      mFirstName = pFirstName;
   }

   /**
    * setHomework()
    *
    * Mutator method to store a homework score into the list
    * of homework scores.
    */
   public void setHomework(int pNum , int pScore) {
      getHomeworkList().set( pNum, pScore );
   }

   /**
    * setHomeworkList()
    *
    * Mutator method for mHomeworkList.
    */
   protected void setHomeworkList(ArrayList<Integer> pHomeworkList) {
      mHomeworkList = pHomeworkList;
   }

   /**
    * setLastname()
    *
    * Mutator method for mLastName.
    */
   public void setLastName(String pLastName) {
      mLastName = pLastName;
   }

   /**
    * toString()
    *
    * Returns a String representation of this Student. The
    * format of the returned string shall be such that the
    * Student
    * information can be printed to the output file, i.e:
    *
    * lastname firstname hw1 hw2 hw3 hw4 exam1 exam2
    */

   @Override
   public String toString() {
      super.toString();
      return mLastName + " " + mFirstName + " " + getHomework( 0 ) + " "
            + getHomework( 1 ) + " " + getHomework( 2 ) + " " + getHomework( 3 )
            + " " + getExam( 0 ) + " " + getExam( 1 );

   }
}
