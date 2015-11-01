package myjavatraining;

import static org.junit.Assert.*;

public class ArraySolution {

   /*
    * Given a sorted array, remove the duplicates in place such that each
    * element appear only once and return the new length.
    * 
    * Do not allocate extra space for another array, you must do this in place
    * with constant memory.
    * 
    * For example, Given input array nums = [1,1,2],
    * 
    * Your function should return length = 2, with the first two elements of
    * nums being 1 and 2 respectively. It doesn't matter what you leave beyond
    * the new length.
    */

   static public int removeDuplicates(int[] nums) {
      int oldLen = nums.length;
      int newIdx = 0;
      int oldIdx = 1;
      do {
         if ((oldIdx + 1) > oldLen) break;

         if (nums[oldIdx] != nums[newIdx]) {
            newIdx++;
            nums[newIdx] = nums[oldIdx];
            oldIdx++;
         } else {
            oldIdx++;
         }

      } while (true);
      return newIdx + 1;

   }

   static public void testremoveDuplicates() {

      int[] array = new int[2];
      array[0] = 1;
      array[1] = 2;

      int newLen = removeDuplicates(array);
      assertEquals(2, newLen);
      System.out.println("new array is ");
      for (int i = 0; i < newLen; i++)
         System.out.print("  " + array[i]);

      
      System.out.println();
      
      int[] array2 = new int[4];
      array2[0] = 1;
      array2[1] = 3;
      array2[2] = 3;
      array2[3] = 4;

      newLen = removeDuplicates(array2);
      assertEquals(3, newLen);
      System.out.println("new array is ");
      for (int i = 0; i < newLen; i++)
         System.out.print("  " + array2[i]);

   }
}
