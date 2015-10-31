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
    * () A , (()) B 1 pair A
    * 
    * 2 pairs (()) ()() (A) , A A B B, AA
    * 
    * 
    * 3 (B), (AA), BA, AAA, AB
    * 
    * 
    * 3 pairs "((()))", "(()())", "(())()","()(())", "()()()" (B) (AA) B A A B
    * AAA C
    * 
    * C , AAA, BA, AB (AA)
    * 
    * 4 pairs .... (()) (()) (())*(()) BB
    * 
    * @param n
    * 
    * @return
    * 
    *         my current output: 2 (()), ()() 3 ((())), (())(), ()(()), (()()),
    *         ()()() sorted : ((())), (()()), (())(), ()(()), ()()() 4 :
    *         (((()))), ((()())), ((())()), ((()))(), (()(())), (()()()),
    *         (()())(), (())()(), ()((())), ()(()()), ()(())(), ()(())(),
    *         ()()(()), ()()()()]
    * 
    *         correct order : (((()))), ((()())), ((())()), ((()))() (()(()))
    *         (()()()) (()())()
    *         (())(())","(())()()","()((()))","()(()())","()(())()","()()(())","
    *         ()()()()"]
    */

   static public List<String> generateParenthesis(int n) {

      ArrayList<String> al;
      al = new ArrayList<String>();

      String stringExp = "(";
      int left = n - 1;
      int right = 1;
      generateParenthesisRecurse(stringExp, left, right, al);

      return al;
   }

   static public void generateParenthesisRecurse(String exp, int left, int right, ArrayList al) {
      if (left == 0 && right == 0) {
         al.add(exp);
         return;
      }

      if (left > 0) generateParenthesisRecurse(exp + "(", left - 1, right + 1, al);

      if (right > 0) generateParenthesisRecurse(exp + ")", left, right - 1, al);

   }

   static public List<String> generateParenthesis2(int n) {
      ArrayList<String> al;
      al = new ArrayList<String>();
      String stringExp = "(";

      return al;
   }

   static public List<String> generateParenthesisz(int n) {

      ArrayList<String> al;
      al = new ArrayList<String>();
      String stringExp = "(";
      generateParenthesisRecurse(stringExp, n - 1, 1, al);
      return al;
   }

   static public void generateParenthesisRecursez(String exp, int leftP, int rightP, ArrayList al) {
      // base case , no more left or right to add. done. (balanced already)
      if (leftP == 0 && rightP == 0) {
         al.add(exp);
         return;
      }

      if (leftP > 0) generateParenthesisRecurse(exp + "(", leftP - 1, rightP + 1, al);

      if (rightP > 0) generateParenthesisRecurse(exp + ")", leftP, rightP - 1, al);

   }

   static public void generateParenthesisRecurseNotWorking2(int n, List<String> al) {

      if (n <= 0) return;
      // the only well-formed for one pair is only (); while )( is wrong.
      if (n == 1) {
         al.add("()");
         return;
      } else

         // step1 , generate the n-1 all cases, and append the new n cases
         generateParenthesisRecurseNotWorking2(n - 1, al);

      // step 2 append the new n cases
      ArrayList<String> baseAl = new ArrayList<String>();
      baseAl.addAll(al);

      al.clear();
      // append the whole al list in two way, add ()old old() (unless it's the
      // same ()() , and add (old)

      // for each n-1 item, add ( and )
      for (int i = 0; i < baseAl.size(); i++) {
         // for each base case, append two new: ()+base, and (base) and base+()
         String tempBaseString = baseAl.get(i);

         al.add("(" + tempBaseString + ")");

      }

      // for each n-1 item, add to the right ()
      for (int i = 0; i < baseAl.size(); i++) {
         String tempBaseString = baseAl.get(i);
         // case 1
         String newCase1 = tempBaseString + "()";
         al.add(newCase1);
      }

      // for each n-1 item, add to the left ()
      for (int i = 0; i < baseAl.size(); i++) {
         String tempBaseString = baseAl.get(i);

         // case 2
         String newCase2 = "()" + tempBaseString;
         String newCase1 = tempBaseString + "()";
         // do not add again if ()x == x() (ie ()() and ()()
         if (!newCase1.equals(newCase2)) {
            al.add(newCase2);

            // case 3
         }
      }
      return;

   }

   // note: missing 4pairs : (()) (())
   static public void generateParenthesisRecurseNotWorking1(int n, List<String> al) {

      if (n <= 0) return;
      // the only well-formed for one pair is only (); while )( is wrong.
      if (n == 1) {
         al.add("()");
         return;
      } else

         // step1 , generate the n-1 all cases, and append the new n cases
         generateParenthesisRecurseNotWorking1(n - 1, al);

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
