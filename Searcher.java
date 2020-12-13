// ***************************************************************************************************************************
// CLASS: Searcher
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

public class Searcher {

   /*
    * binary search method call to search through sorted
    * list.
    */
   public static int search(ArrayList<Student> pList , String pKey) {

      int start = 0;
      int end = pList.size() - 1;

      while ( start <= end ) {
         int middle = (start + end) / 2;

         if ( (pList.get( middle ).getLastName()).equals( pKey ) ) {
            return middle;
         }
         else if ( pList.get( middle ).getLastName().compareTo( pKey ) < 0 ) {
            start = middle + 1;
         }
         else {
            end = middle - 1;
         }
      }
      return -1;
   }
}