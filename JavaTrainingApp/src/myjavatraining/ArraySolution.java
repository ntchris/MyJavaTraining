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

   /*
    * Given a sorted array and a target value, return the index if the target is
    * found. If not, return the index where it would be if it were inserted in
    * order.
    * 
    * You may assume no duplicates in the array.
    * 
    * Here are few examples. [1,3,5,6], 5 ¡ú 2 [1,3,5,6], 2 ¡ú 1 [1,3,5,6], 7 ¡ú 4
    * [1,3,5,6], 0 ¡ú 0
    */
   static public int searchInsert(int[] nums, int target) {

      int targetIndex = searchInsertRecurse(nums, 0, nums.length - 1, target);

      if (nums[targetIndex] < target) targetIndex++;
      return targetIndex;

   }

   static public int searchInsertRecurse(int[] nums, int fromIdx, int toIdx, int target) {

      // base case:
      if (fromIdx == toIdx) return fromIdx;
      if (fromIdx > toIdx) return fromIdx;

      int midIndex = (fromIdx + toIdx) / 2;
      int midValue = nums[midIndex];

      if (midValue == target)
         return midIndex;
      else if (midValue < target) {

         return searchInsertRecurse(nums, midIndex + 1, toIdx, target);

      } else {
         if (midIndex > 0)
            return searchInsertRecurse(nums, fromIdx, midIndex - 1, target);
         else
            return 0;
      }

   }

   static public void testSearchInsert() {
      int[] array1 = new int[5];
      array1[0] = 1;
      array1[1] = 3;
      array1[2] = 5;
      array1[3] = 7;
      array1[4] = 9;

      int targetIdx = searchInsert(array1, 0);
      assertEquals(0, targetIdx);

      targetIdx = searchInsert(array1, 2);
      assertEquals(1, targetIdx);

      targetIdx = searchInsert(array1, 4);
      assertEquals(2, targetIdx);

      targetIdx = searchInsert(array1, 6);
      assertEquals(3, targetIdx);
      targetIdx = searchInsert(array1, 8);
      assertEquals(4, targetIdx);
   }
}
