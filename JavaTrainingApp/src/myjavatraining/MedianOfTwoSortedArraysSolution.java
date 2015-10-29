package myjavatraining;

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

public class MedianOfTwoSortedArraysSolution {

   static public int[] mergeTwoSortedArrays(int[] array1, int[] array2) {
      int size1 = array1.length;
      int size2 = array2.length;

      int size3 = size1 + size2;
      int index1 = 0, index2 = 0, index3 = 0;

      int[] array3 = new int[size3];

      do {

         if (array1[index1] < array2[index2]) {
            array3[index3] = array1[index1];
            // array1 remove one number, so array1 move to next index
            index1++;
            index3++;
         } else {
            // array2 remove one number, so array2 move to next index

            array3[index3] = array2[index2];
            index2++;
            index3++;
         }

      } while (index1 < array1.length && index2 < array2.length);

      int[] notDoneArray = null;
      int notDoneIndex = 0;
      if (index1 < array1.length) {
         notDoneArray = array1;
         notDoneIndex = index1;
      } else if (index2 < array2.length) {
         notDoneArray = array2;
         notDoneIndex = index2;
      }

      for (int i = notDoneIndex; i < notDoneArray.length; i++) {
         array3[index3] = notDoneArray[i];
         index3++;
      }

      // get med
      printArray(array3);

      return array3;
   }

   static public double findMedianSortedArrays(int[] array1, int[] array2) {
      double med = 0;

      // step 1 merge two array
      // step 2 get median

      int[] array3 = mergeTwoSortedArrays(array1, array2);

      int size3 = array3.length;
      if (size3 <= 1) {
         return array3[0];
      }

      if (size3 % 2 != 0) {
         med = array3[size3 / 2];
      } else {
         med = (array3[size3 / 2 - 1] + array3[size3 / 2]) / 2.0;

      }
      return med;

   }

   static void test() {
      int[] array1 = new int[3];
      int[] array2 = new int[3];

      array1[0] = 1;
      array1[1] = 3;
      array1[2] = 5;

      array2[0] = 2;
      array2[1] = 4;
      array2[2] = 6;
      // array2[3] = 8;

      double med = findMedianSortedArrays(array1, array2);
      System.out.println("med is " + med);
   }

   static void printArray(int[] array) {
      for (int i = 0; i < array.length; i++)
         System.out.print(array[i] + " ");
   }

   static void testpointer() {
      Object o = null;
      if (o == null) {

      }

   }

}
