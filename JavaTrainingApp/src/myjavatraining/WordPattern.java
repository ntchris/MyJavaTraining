package myjavatraining;

import java.util.HashMap;

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

public class WordPattern {

   public static void testcaseWordPattern() {
      wordPattern("abc", "cat dog pig");
      wordPattern("a", "cat");
      wordPattern("ab", "cat dog");
      wordPattern("abcd", "cat dog bird monkey");
      wordPattern("abcc", "cat dog bird bird");

      wordPattern("abb", "cat dog bird");
      wordPattern("abc", "cat dog dog");
      wordPattern("abc", "   ");

   }

   static public boolean wordPattern(String pattern, String str) {
      System.out.println("testing pattern " + pattern + " , string : " + str);

      String[] words = str.split(" ");

      // if length are different then clearly pattern not match
      if (words.length != pattern.length()) {
         System.out.println("false");

         // aba cat dog cat dog
         return false;
      }

      // 1 put pattern char[i] as key, and words[i] as value into a hashmap.
      // 2 retrieve later, if match then the pattern matches.

      HashMap<Character, String> hashMap1 = new HashMap<Character, String>();
      HashMap<String, Character> hashMap2 = new HashMap<String, Character>();

      for (int i = 0; i < pattern.length(); i++) {
         char ch = pattern.charAt(i);
         String word = words[i];

         if (hashMap1.containsKey(ch)) {
            if (!hashMap1.get(ch).equals(words[i])) {
               System.out.println("1 False");
               return false;
            }

         } else {
            hashMap1.put(ch, words[i]);
         }

         if (hashMap2.containsKey(word)) {
            if (!hashMap2.get(word).equals(ch)) {
               System.out.println("2 False");
               return false;
            }
         } else {
            hashMap2.put(word, ch);
         }

      }
      System.out.println("True!");
      return true;
   }

}