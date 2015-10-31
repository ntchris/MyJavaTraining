package myjavatraining;

import java.util.ArrayList;
import java.util.List;

public class ParenthesesSolution {

   /**
    * Given n pairs of parentheses, write a function to generate all
    * combinations of well-formed parentheses. For example, given n = 3, a
    * solution set is: "((()))", "(()())", "(())()", "()(())", "()()()" Note,
    * N=1 means 1 pair (so 2), not 1.
    * 
    * 1 pair () 2 pairs (()) , ()() 3 pairs ()()() , (()()) ()(()) ((())) (())()
    * 4 pairs ....
    * 
    * @param n
    * @return
    */
   static public List<String> generateParenthesis(int n) {

      ArrayList<String> al;
      al = new ArrayList<String>();

      generateParenthesisRecurse(n, al);

       return al;
   }

   static public void generateParenthesisRecurse(int n, List<String> al) {

      if (n <= 0) return;
      // the only well-formed for one pair is only (); while )( is wrong.
      if (n == 1) {
         al.add("()");
         return;
      } else

         // step1 , generate the n-1 all cases, and append the new n cases
         generateParenthesisRecurse(n - 1, al);

      // step 2 append the new n cases
      ArrayList<String> baseAl = new ArrayList<String>();
      baseAl.addAll(al);
      al.clear();
      // append the whole al list in two way, add ()old old() (unless it's the
      // same ()() , and add (old)
      for (int i = 0; i < baseAl.size(); i++) {
         // for each base case, append two new: ()+base, and (base) and base+()
         String tempBaseString = baseAl.get(i);

         al.add("(" + tempBaseString + ")");

         // case 1
         String newCase1 = tempBaseString + "()";
         al.add(newCase1);

         // case 2
         String newCase2 = "()" + tempBaseString;

         // do not add again if ()x == x() (ie ()() and ()()
         if (!newCase1.equals(newCase2)) {
            al.add(newCase2);
         }
         // case 3
      }

      
      return;

   }

   static public void testGenerateParenthesis() {
      System.out.println(generateParenthesis(1));
      System.out.println(generateParenthesis(2));
      System.out.println(generateParenthesis(3));
      System.out.println(generateParenthesis(4));

   }
}
