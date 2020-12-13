// ***************************************************************************************************************************
// CLASS: Project3.java
//
// Description: This program will read a text file, sort the
// provided student details into ascending order.
// This program will also permit the user to interact with
// the gradebook for each student through a GUI. This
// GUI will allow a user to search for a student, change
// student grades, and save or create a new gradebook
// upon closing the program. After searching, the Students
// grades should appear, you can clear all grades if
// so desired.
//
// CSE 205: Object Oriented Programming and Data Structures
// Session A Fall 2018
// Project 3
//
//
// AUTHOR
// Bradley McGarvin
// ***************************************************************************************************************************

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import javax.swing.JFrame;

/**
 * The Main class containing the main() and run() methods.
 */
public class Project3 {

   // The Roster of students that is read from
   // "gradebook.txt".
   private Roster mRoster;

   // A reference to the View object.
   private View   mView;

   /**
    * This is where execution starts. Instantiate a Main
    * object and then call run().
    */
   public static void main(String[] pArgs) {

      new Project3().run();
   }

   /**
    * exit() is called when the Exit button in the View is
    * clicked.
    */
   public void exit() {
      try {
         GradebookWriter gbWriter = new GradebookWriter( "gradebook.txt" );
         gbWriter.writeGradebook( getRoster() );
         System.exit( 0 );
      }
      catch (FileNotFoundException pExcept) {
         getView().messageBox(
               "Could not open gradebook.txt for writing. Exiting without saving." );
         System.exit( -1 );
      }
   }

   /**
    * Accessor method for mRoster.
    */
   public Roster getRoster() {
      return mRoster;
   }

   /**
    * Accessor method for mView.
    */
   public View getView() {
      return mView;
   }

   /**
    * run() is the main routine.
    */
   private void run() {
      JFrame.setDefaultLookAndFeelDecorated( true );
      setView( new View( this ) );
      try {
         GradebookReader gbReader = new GradebookReader( "gradebook.txt" );
         setRoster( gbReader.readGradebook() );
      }
      catch (FileNotFoundException pExcept) {
         mView.messageBox(
               "Could not open gradebook.txt for reading. Exiting." );
         System.exit( -1 );
      }
   }

   /**
    * search() is called when the Search button is clicked
    * on the View. The input parameter is the non-empty last
    * name
    * of the Student to locate. Call getStudent(pLastName)
    * on the Roster object to get a reference to the Student
    * with
    * that last name. If the student is not located,
    * getStudent() returns null.
    */
   public Student search(String pLastName) {
      return getRoster().getStudent( pLastName );
   }

   /**
    * Mutator method for mRoster.
    */
   public void setRoster(Roster pRoster) {
      mRoster = pRoster;
   }

   /**
    * Mutator method for mView.
    */
   public void setView(View pView) {
      mView = pView;
   }
}