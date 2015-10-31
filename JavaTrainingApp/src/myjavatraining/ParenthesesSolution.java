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
         generateParenthesisRecurse(n-1, al);

        //append the whole al list in two way,  add ()old   old()  (unless it's the same ()()  , and add (old)
        for(int i=0;i<al.size();i++)
        {
           String n_1 = al.get(i);
           
        }
           
        
      
         
      }

   }

   return;

   }

   static public void testGenerateParenthesis() {
      System.out.println(generateParenthesis(1));
      System.out.println(generateParenthesis(2));
   }
}
