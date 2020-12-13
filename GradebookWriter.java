// ***************************************************************************************************************************
// CLASS: GradebookWriter
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
 * GradebookWriter inherits from PrintWriter and writes the
 * gradebook info to the file name passed to the ctor.
 */
public class GradebookWriter extends PrintWriter {

   /**
    * GradebookWriter()
    * Call the super class ctor that takes a String.
    */
   public GradebookWriter(String pFname) throws FileNotFoundException {
      super( pFname );
   }

   /**
    * writeGradebook()
    * Writes the gradebook info to the file, which was
    * opened in the ctor.
    *
    * PSEUDOCODE:
    * EnhancedFor each student in pRoster.getStudentList()
    * Do
    * Call println(student)
    * End For
    * Call close()
    */
   public void writeGradebook(Roster pRoster) throws FileNotFoundException {

      PrintWriter out = new PrintWriter( new File( "gradebook.txt" ) );
      for ( Student student : pRoster.getStudentList() ) {
         out.println( student );
      }
      out.close();

   }
}
