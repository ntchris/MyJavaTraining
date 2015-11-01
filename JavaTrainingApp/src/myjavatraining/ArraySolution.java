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

   /*
    * Given an array and a value, remove all instances of that value in place
    * and return the new length.
    * 
    * The order of elements can be changed. It doesn't matter what you leave
    * beyond the new length.
    */

   static public int removeElement(int[] nums, int val) {
      int newLen = 0;
      int maxLen = nums.length;
      int oldIndex = 0;

      while (oldIndex < maxLen) {
         if (nums[oldIndex] != val) {
            if (newLen != oldIndex) nums[newLen] = nums[oldIndex];

            newLen++;
            oldIndex++;

         } else {
            oldIndex++;
            if (oldIndex >= maxLen) break;
            nums[newLen] = nums[oldIndex];

         }
      }
      return newLen;
   }

   static public void testRemoveTargetElement() {

      int[] array1234 = new int[4];
      array1234[0] = 1;
      array1234[1] = 2;
      array1234[2] = 3;
      array1234[3] = 4;

      int answer1234 = removeElement(array1234, 1);
      assertEquals(3, answer1234);
      for (int i = 0; i < answer1234; i++)
         System.out.print("  " + array1234[i]);

      System.out.println();

      int[] array45 = new int[2];
      array45[0] = 4;
      array45[1] = 5;
      int answer45 = removeElement(array45, 4);
      assertEquals(1, answer45);
      for (int i = 0; i < answer45; i++)
         System.out.print("  " + array45[i]);

      System.out.println();

      int[] array33 = new int[2];
      array33[0] = 3;
      array33[1] = 3;
      int answer33 = removeElement(array33, 3);
      assertEquals(0, answer33);
      for (int i = 0; i < answer33; i++)
         System.out.print("  " + array33[i]);

      System.out.println();

      int[] array = new int[1];
      int answer0 = removeElement(array, 0);
      assertEquals(0, answer0);
      for (int i = 0; i < answer0; i++)
         System.out.print("  " + array[i]);

      System.out.println();

      int[] array1 = new int[2];
      array1[0] = 1;
      array1[1] = 2;
      int answer1 = removeElement(array1, 1);
      assertEquals(1, answer1);
      for (int i = 0; i < answer1; i++)
         System.out.print("  " + array1[i]);
      System.out.println();

      int[] array2 = new int[3];
      array2[0] = 1;
      array2[1] = 2;
      array2[2] = 3;

      int answer2 = removeElement(array2, 2);
      assertEquals(2, answer2);
      for (int i = 0; i < answer2; i++)
         System.out.print("  " + array2[i]);
      System.out.println();

   }

}
