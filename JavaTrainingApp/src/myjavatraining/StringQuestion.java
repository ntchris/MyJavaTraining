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

public class StringQuestion {

   // Question: No space at head or end or in between ?
   public static String comparessString(String inputStr) {
      StringBuffer output = new StringBuffer();
      int count = 0;
      char prevChar = 0;
      for (int i = 0; i < inputStr.length(); i++) {
         char thisChar = inputStr.charAt(i);
         if (prevChar == thisChar) {
            count++;

         } else {
            // start to deal with the new char
            prevChar = thisChar;
            // it's new, so the count is 1.
            count = 1;
         }

         String toAppend = "" + prevChar + count;
         // this is a new Char or no more
         if ((i + 1) >= inputStr.length()) {
            // append the previous info to result string
            output.append(toAppend);
            // break is not nece
         } else if (thisChar != inputStr.charAt(i + 1)) {
            // next char is diff so append now.
            output.append(toAppend);
         }

      }

      // compare the final result , if larger then give up, return the orig str.
      if (output.length() < inputStr.length()) {
         return output.toString();
      } else {
         return inputStr;
      }
   }

   static void testStringCompress(String input, String expectOutputStr) {
      System.out.println();
      System.out.print("Input is " + input);
      String output = comparessString(input);
      System.out.println(", Output is " + output);

      assertEquals(expectOutputStr, output);

   }

   static void test() {
      testStringCompress("a", "a");
      testStringCompress("ddd", "d3");

      testStringCompress("aabcddd", "aabcddd");

      testStringCompress("abcd", "abcd");
      testStringCompress("aabcd", "aabcd");

      testStringCompress("aaaabbbcdd", "a4b3c1d2");
      testStringCompress("aaaab", "a4b1");
      testStringCompress("aaaabccccc", "a4b1c5");
      testStringCompress("aaaabccccce", "a4b1c5e1");

   }
}
