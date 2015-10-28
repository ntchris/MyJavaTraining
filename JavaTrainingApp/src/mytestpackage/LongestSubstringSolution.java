package mytestpackage;

public class LongestSubstringSolution
{
   static public void test()
   {
      String testString = "abcdefgg";
      int answer = lengthOfLongestSubstring(testString);
      System.out.println("Test string is " + testString + " answer is " + answer);

      String testString2 = "abcabcbb";
      int answer2 = lengthOfLongestSubstring(testString2);
      System.out.println("Test string is " + testString2 + " answer is " + answer2);

      
      answer = lengthOfLongestSubstringOn(testString);
      System.out.println("Test string is " + testString + " answer is " + answer);

      answer2 = lengthOfLongestSubstringOn(testString2);
      System.out.println("Test string is " + testString2 + " answer is " + answer2);

      
      
   }

   static public int lengthOfLongestSubstring(String str)
   {
      int len = 0;
      int fullLen = str.length();
      if (fullLen == 1)
      {
         return fullLen;
      }
      int i;
      for (i = 0; i < fullLen - 1; i++)
      {
         char ch = str.charAt(i);

         String subString = str.substring(i + 1);

         int dupIndex = subString.indexOf(ch);
         if (dupIndex != -1)
         {
            len = i + dupIndex + 1;
            break;
         }
      }

      return len;

   }

   static public int lengthOfLongestSubstringOn(String str)
   {
      int len = 0;
      int fullLen = str.length();
      if (fullLen == 1)
      {
         return fullLen;
      }

      int i;

      int[] storedIndex = new int[255];

      for (i = 0; i < 255; i++)
      {
         storedIndex[i] = -1;
      }

      for (i = 0; i < fullLen; i++)
      {
         char ch = str.charAt(i);

         if (storedIndex[ch] < 0)
         {
            storedIndex[ch] = i;
         }else
         {
            //found a dup ch.
            break;
         }

        
      }

      return i;

   }

}
