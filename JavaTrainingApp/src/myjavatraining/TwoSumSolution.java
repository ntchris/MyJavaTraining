
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
/*
 * 
 * Given an array of integers, find two numbers such that they add up to a
 * specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * 
 * add up to the target, where index1 must be less than index
 * 
 * 2. Please note that your returned answers (both index1 and index2) are not
 * zero-based.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
 * 
 * 
 */

public class TwoSumSolution {
   static public int[] twoSum(int[] nums, int target) {
      int[] answer = null;
      for (int index1 = 0; index1 < nums.length; index1++) {
         for (int index2 = 1; index2 < nums.length; index2++) {
            
            //Note, index2 and index1 can not be the same.
            if(index1 == index2) continue;
            if (nums[index1] + nums[index2] == target) {
               answer = new int[2];
               answer[0] = index1+1;
               answer[1] = index2+1;
               return answer;

            }
         }

      }

      return answer;

   }
   
   
   static void testTwoSum() {
      int[] array = new int[5];

      array[0] = 3;
      array[1] = 5;
      array[2] = 4;
      array[3] = 1;
      array[4] = 2;

      int[] answer = TwoSumSolution.twoSum(array, 6);
      if (answer == null) {
         System.out.println("answer not found , null");
      } else {

         System.out.println("answer is " + answer[0] + " , " + answer[1]);
      }
   }
   
   static public void test()
   {
      int []array=  {
       
      2,1,9,4,4,56,90,3};
      
      int []answer = twoSum(array, 8);
      assertEquals(4, answer[0]);
      assertEquals(5, answer[1]);
      
   }
}
