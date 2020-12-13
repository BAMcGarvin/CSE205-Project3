// ***************************************************************************************************************************
// CLASS: Sorter
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

public class Sorter {

   /*
    * Partition method to divide list. When pFromIdx crosses
    * pToIds, partitioning stops
    */
   private static int partition(ArrayList<Student> pList , int pFromIdx ,
         int pToIdx) {
      String pivotPoint = pList.get( pFromIdx ).getLastName();
      pFromIdx--;
      pToIdx++;

      while ( pFromIdx < pToIdx ) {
         pFromIdx++;
         while ( ((pList.get( pFromIdx ).getLastName())
               .compareTo( pivotPoint )) < 0 ) {
            pFromIdx++;
         }
         pToIdx--;
         while ( ((pList.get( pToIdx ).getLastName())
               .compareTo( pivotPoint )) > 0 ) {
            pToIdx--;
         }
         if ( pFromIdx < pToIdx ) {
            swap( pList, pFromIdx, pToIdx );
         }
      }
      return pToIdx;
   }

   /*
    * quickSort() method call
    */
   private static void quickSort(ArrayList<Student> pList , int pFromIdx ,
         int pToIdx) {

      if ( pFromIdx >= pToIdx ) {
         return;
      }
      int partitionIdx = partition( pList, pFromIdx, pToIdx );
      quickSort( pList, pFromIdx, partitionIdx );
      quickSort( pList, partitionIdx + 1, pToIdx );
   }

   public static void sort(ArrayList<Student> pList) {
      if ( pList.size() == 0 ) {
         return;
      }
      quickSort( pList, 0, pList.size() - 1 );
   }

   /*
    * Method to swap array elements.
    */
   private static void swap(ArrayList<Student> pList , int pIdx1 , int pIdx2) {
      Student holder = pList.get( pIdx1 );
      pList.set( pIdx1, pList.get( pIdx2 ) );
      pList.set( pIdx2, holder );
   }
}
