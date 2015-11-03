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

// like {{1,1},2, {1,1}} sum=10
// 1*2+1*2 + 2 + 1*2+1*2= 10
// {2, {4, {6}}} 2*1 + 4*2 + 6*3 = 2+8+18=28
public class NestedListSumTest {
   static int getNestedListSum(String inputStr) {
      int sum = 0;
      int depth = 0;
      int i = 0;

      while (i < inputStr.length()) {
         char tempC = inputStr.charAt(i);
         if (tempC == '{')
            depth++;
         else if (tempC == '}')
            depth--;
         else if (tempC == ',' || tempC == ' ')
            ; // do nothing
         else if (tempC >= '0' && tempC <= '9') {
            int digit = Integer.parseInt("" + tempC);
            sum = sum + digit * depth;
         }
         i++;
      }
      return sum;
   }

   static void test() {
      int sum = getNestedListSum("{{1,1},2, {1,1}}");
      System.out.println(sum);
      assertEquals(10,  sum);

      sum = getNestedListSum("{2, {4, {6  }}}");
      System.out.println(sum);
      assertEquals(28,  sum);
      
      sum = getNestedListSum("{1,{4,{6}}}");
      System.out.println(sum);
      assertEquals(27,  sum);
      
      
   

   }

}
