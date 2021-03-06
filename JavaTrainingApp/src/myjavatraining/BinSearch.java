package myjavatraining;

import static org.junit.Assert.*;

/**
 * 
 * 
 * @author ntchris@hotmail.com
 * 
 *         Chris
 * 
 *         28 Oct 2015
 *
 */

public class BinSearch {

   static public int binSearch(int[] list, int val) {
      return binSearch(list, val, 0, list.length - 1);
   };

   static public int binSearch(int[] list, int val, int start, int end) {

      System.out.println("Searching " + val + " from list [" + start + " : " + end + "]");

      if (end >= list.length) {
         return -1;
      }

      if (end < start) {
         return -1;
      }

      // there is only one data member to check, end of recurse
      if (start == end) {
         int toTest = list[start];

         if (val == toTest) {
            return start;
         } else {
            if (list[start] < val) {
               System.out.println("Should be in here ? +1 " + (start + 1));
            } else
               System.out.println("Should be in here ? " + start);
            return -1;
         }
      }

      // check mid value
      int midIndex = (start + end) / 2;
      int midVal = list[midIndex];

      // if the midIndex is the first index

      if (val == midVal) {
         return midIndex;

      } else if (val < midVal) {

         return binSearch(list, val, start, midIndex - 1);

      } else if (val > midVal) {
         return binSearch(list, val, midIndex + 1, end);

      }

      return -1;
   };

   static public void test() {
      int[] array = new int[5];
      array[0] = 0;
      array[1] = 1;
      array[2] = 1;
      array[3] = 4;
      array[4] = 5;
      // array[5] = 16;

      int resultIndex = binSearch(array, 4);
      System.out.println(resultIndex);
      // assertEquals(0, resultIndex);
      /*
       * resultIndex = binSearch(array, 11); assertEquals(1, resultIndex);
       * 
       * resultIndex = binSearch(array, 12); assertEquals(2, resultIndex);
       * 
       * 
       * resultIndex = binSearch(array, 15); assertEquals(-1, resultIndex);
       */
   }
}
