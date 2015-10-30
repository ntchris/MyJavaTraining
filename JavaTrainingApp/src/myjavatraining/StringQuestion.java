package myjavatraining;

import static org.junit.Assert.*;
import java.util.ArrayList;

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

   // Question: Longest Palindromic Substring
   // Given a string S, find the longest palindromic substring in S.
   // You may assume that the maximum length of S is 1000,
   // and there exists one unique longest palindromic substring.
   public String longestPalindrome(String longstr) {
      // Step1 find the candidate mid point
      // step2 check if its.
      return "";

   }

   // Question: Compress a string.
   // Ask : No space at head or end or in between ?
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

   /**
    * Reverse digits of an integer. Example1: x = 123, return 321 Example2: x =
    * -123, return -321
    */

   static public int reverseInt(int x) {

      int revX = 0;
      StringBuffer revXstr = new StringBuffer();
      Integer integer = new Integer(x);
      String xstr = integer.toString();

      // reverse xstr;
      int startindex = 0;
      if (xstr.charAt(0) == '-' | xstr.charAt(0) == '+') {
         startindex = 1;
         revXstr.append(xstr.charAt(0));
      }

      for (int i = xstr.length() - 1; i >= startindex; i--) {
         revXstr.append(xstr.charAt(i));
      }
      try {
         revX = Integer.parseInt(revXstr.toString());
      } catch (Exception e) {
         System.out.println("wrong format or int out of range " + revXstr.toString());
         return 0;
      }
      return revX;
   }

   static void testReverseInt() {
      assertEquals(0, reverseInt(0));
      assertEquals(1, reverseInt(1));
      assertEquals(21, reverseInt(12));
      assertEquals(1, reverseInt(10));
      assertEquals(1, reverseInt(+1));
      assertEquals(-1, reverseInt(-1));
      assertEquals(-321, reverseInt(-123));
      assertEquals(-321, reverseInt(-12300));
      assertEquals(300000001, reverseInt(1000000003));

   }

   /**
    * Write a function to find the longest common prefix string amongst an array
    * of strings.
    */
   static public String longestCommonPrefix(String[] strs) {

      // must return immediately if strs has no string at all.

      if (strs == null)
         return "";
      if (strs.length == 0)
         return "";

      StringBuffer sbuffer = new StringBuffer();
      int charindex = 0;
      boolean done = false;
      while (!done) {
         int index = 0;
         char tempchar;
         if (charindex < strs[0].length()) {
            tempchar = strs[0].charAt(charindex);
         } else {
            // hit the end of the string0 already
            done = true;
            break;
         }
         boolean isCommon = true;
         // loop each string
         for (int stringindex = 0; stringindex < strs.length; stringindex++) {

            if (charindex >= strs[stringindex].length()) {
               // meet a short string, means the common string ends here
               done = true;
               isCommon = false;
               break;
            }
            if (tempchar == strs[stringindex].charAt(charindex)) {
               // good, match
            } else {
               // no good, not match stop everything, and it's the end.
               done = true;
               isCommon = false;
               break;
            }
         }
         charindex++;
         if (isCommon)
            sbuffer.append(tempchar);
      }

      return sbuffer.toString();
   }

   static public void testLongestCommonPrefix() {
      String[] strs = new String[5];
      strs[0] = "abcdefgh";
      strs[4] = "abcd";
      strs[1] = "abcde";
      strs[2] = "abcdef";
      strs[3] = "abcdefg";

      assertEquals("abcd", longestCommonPrefix(strs));

      strs[0] = "abcdefgh";
      strs[1] = "abcde";
      strs[2] = "abcdef";
      strs[3] = "abcdefgzzzz";
      strs[4] = "zabcde";
      assertEquals("", longestCommonPrefix(strs));

      strs[0] = "abcdefgh";
      strs[1] = "abcde";
      strs[2] = "abcdf";
      strs[3] = "abcdefgzzzz";
      strs[4] = "abcde";
      assertEquals("abcd", longestCommonPrefix(strs));

   }

   // Can not break word, can not break http url.
   static public ArrayList longStringToArrayList(String longString, int maxSizeEachPiece) throws Exception {
      ArrayList<String> al = new ArrayList<String>();

      StringBuffer sbuffer = new StringBuffer();

      String subStrings[] = longString.split(" ");
      int index = 0;
      while (true) {
         if (index >= subStrings.length) {
            // do something before break and send. ??
            break;
         }

         if(subStrings[index].length()> maxSizeEachPiece) throw new Exception("Word size too large "+subStrings[index] );
         
         if ((sbuffer.length() + subStrings[index].length() + 1)< maxSizeEachPiece) {
            // this buffer is not full, append
            if(sbuffer.length()!=0) sbuffer.append(" ");
            sbuffer.append(subStrings[index]);

         } else {
            al.add(sbuffer.toString());
            sbuffer.setLength(0);
            sbuffer.append(subStrings[index]);

         }
         
         index++;
      }
      if (sbuffer.length() > 0) {
         al.add(sbuffer.toString());
      }
      return al;
   }

   static public void testLongStringToArrayList()     {

      String inputMessage = "Hi , I’m using this amazing http://ggooddgooow.com/service/?help, come and check it out ! awesome !! very good!!!";
      ArrayList <String>al=null;
      try {
         al = longStringToArrayList(inputMessage, 20);
      } catch (Exception e) {
         System.out.println("Exception " + e);
           
      }

      System.out.println("Output is " + al);

   }

}
