package myjavatraining;

import java.util.Random;

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

public class MyQuickSort {

   static public int[] generateDescList(int size) {
      int[] list = new int[size];
      for (int i = 0; i < size; i++) {
         list[i] = size - i - 1;
      }
      return list;
   }

   static public int[] generateRandomList(int size) {
      Random rand = new Random();
      int[] list = new int[size];
      for (int i = 0; i < size; i++) {
         list[i] = rand.nextInt(100);
      }
      return list;
   }

   static public void swap(int array[], int index, int index2) {
      if (index == index2)
         return;

      // System.out.println("swapping " + array[index] + " and " +
      // array[index2]);
      int temp = array[index];
      array[index] = array[index2];
      array[index2] = temp;
      System.out.print("Swaping: ");
      showList(array);
   }

   static public void quickSort(int[] array) {
      quickSort(array, 0, array.length - 1);
      // quickSortNewArray(array, 0, array.length - 1);
   }

   static public void quickSort(int[] array, int start, int end) {

      // choose the mid member as pivot
      System.out.print("Quick Sort for: ");
      showList(array, start, end);

      if (start == end) {
         return;
      }

      /*
       * if (start + 1 == end) { // only two data members. if (array[start] >
       * array[end]) { swap(array, start, end); } return; }
       *
       */
      int pivotIndex = end;

      int pivot = array[pivotIndex];

      System.out.println("Pivot is " + pivot);

      // we have two array, left[start to leftEnd], right[rightStart to end]

      int leftEnd = start, rightStart = end - 1;

      // move all smaller numbers to left side and bigger number to right side
      while (leftEnd < rightStart) {
         // choose next left side big value to swap
         while (array[leftEnd] <= pivot && leftEnd < rightStart) {
            // skip and do not swap this one because it's small
            leftEnd++;
         }

         // choose next right side small value to swap
         while (array[rightStart] >= pivot && leftEnd < rightStart) {
            // skip and do not switch this one because it's big
            rightStart--;
         }
         if (array[leftEnd] > array[rightStart]) {
            swap(array, leftEnd, rightStart);
         }

      }
      if (array[leftEnd] > array[end]) {
         swap(array, leftEnd, end);
      }

      quickSort(array, start, leftEnd);
      quickSort(array, rightStart + 1, end);

   }

   static public void showList(int[] list) {
      for (int i = 0; i < list.length; i++) {
         System.out.print(list[i] + " ");
      }
      System.out.println();
   }

   static public void showList(int[] list, int start, int end) {
      if (end < start)
         return;

      for (int i = start; i <= end; i++) {
         if (i < list.length) {
            System.out.print(list[i] + " ");
         }

      }
      System.out.println();
   }

   static void test() {

      int[] array1 = new int[2];
      array1[0] = 1;
      quickSort(array1);
      showList(array1);

      System.out.println();
      System.out.println();
      int[] array2a = new int[2];
      array2a[1] = 1;
      quickSort(array2a);
      showList(array2a);

      System.out.println();
      System.out.println();

      int[] array2 = new int[3];
      array2[0] = 2;
      array2[2] = 1;
      quickSort(array2);
      showList(array2);

      System.out.println();
      System.out.println();

      int[] array4 = new int[4];
      array4[0] = 1;
      array4[1] = 0;
      array4[2] = 3;
      array4[3] = 2;

      quickSort(array4);
      showList(array4);
      System.out.println();
      System.out.println();

      int[] array3 = new int[3];
      array3[0] = 2;
      array3[1] = 1;
      quickSort(array3);
      showList(array3);

      System.out.println();
      System.out.println();

      int[] array100 = generateRandomList(5);

      quickSort(array100);
      showList(array100);

   }

}
