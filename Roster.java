// ***************************************************************************************************************************
// CLASS: Roster
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
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

/**
 * The Roster class encapsulates an ArrayList<Student> which
 * stores the information for each student in the gradebook.
 */
public class Roster {

   // Declare mStudentList
   private ArrayList<Student> mStudentList;

   /**
    * Roster()
    *
    * PSEUDOCODE:
    * Create mStudentList.
    */
   public Roster() {
      mStudentList = new ArrayList<Student>();
      setStudentList( mStudentList );
   }

   /**
    * addStudent()
    *
    * PSEUDOCODE:
    * Add (append) pStudent to mStudentList.
    */
   public void addStudent(Student pStudent) {
      mStudentList.add( pStudent );
   }

   /**
    * getStudent()
    * Searches mStudentList for a Student with pLastName.
    *
    * PSEUDOCODE:
    * index = Call Searcher.search(getStudentList(),
    * pLastName)
    * If index == -1 Then Return null
    * Else return the Student object in mStudentList at
    * index
    */
   public Student getStudent(String pLastName) {

      int index = Searcher.search( getStudentList(), pLastName );

      if ( index == -1 ) {
         return null;
      }
      else {
         return mStudentList.get( index );
      }
   }

   /**
    * getStudentList()
    * Accessor method for mStudentList.
    */
   public ArrayList<Student> getStudentList() {
      return mStudentList;
   }

   /**
    * setStudentList()
    * Mutator method for mStudentList.
    */
   private void setStudentList(ArrayList<Student> pStudentList) {
      mStudentList = pStudentList;
   }

   /**
    * sortRoster()
    * Called to sort the roster by last name.
    *
    * PSEUDOCODE:
    * Call Sorter.sort() passing the list of students
    */
   public void sortRoster() {
      Sorter.sort( getStudentList() );
   }

   /**
    * Returns a String representation of this Roster. Handy
    * for debugging.
    */
   @Override
   public String toString() {
      String result = "";
      for ( Student student : getStudentList() ) {
         result += student + "\n";
      }
      return result;
   }
}
