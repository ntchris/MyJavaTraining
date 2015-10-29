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

public class MyMathFunctions {
   static final double Small = 0.0001;

   static public double sqrt(double x) {
      double result = 1.0;
      double testFrom = 1.0, testTo = x / 2.0;

      result = testFrom;
      final double Small = 0.00000001;
      double diff;
      do {
         diff = result * result - x;

         if (Math.abs(diff) < Small)
            break;
         result = (result + x / result) / 2;

      } while (true);

      return result;
   }

   public static void testSqrt() {
      System.out.println("4 sqrt is " + sqrt(4));
      System.out.println("9 sqrt is " + sqrt(9));

   }

   static public double getFactorial(double x) {
      if (x < 0)
         throw new IllegalArgumentException("Must not be negative");
      double result;
      if (x == 0)
         return 1;
      if (x == 1)
         return 1;

      result = x * getFactorial(x - 1.0);
      return result;
   }

   static public void testFactorial() {
      assertEquals(1.0, getFactorial(0), Small);
      assertEquals(1.0, getFactorial(1), Small);
      assertEquals(2.0, getFactorial(2), Small);
      assertEquals(2 * 3, getFactorial(3), Small);
      assertEquals(2 * 3 * 4 * 5, getFactorial(5), Small);
      assertEquals(2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10, getFactorial(10), Small);
      System.out.println("100! is " + getFactorial(100));
   }

   static public void testCheckIsPrimeNumber() {
      int i = 11;
      for (i = 2; i < 101; i++)
         System.out.println("" + i + ": " + isPrimeNumber(i));

   }

   static public boolean isPrimeNumber(int x) {

      if (x == 0 || x == 1 || x == 2 || x == 3 || x == 5) {
         return true;
      }

      int test = 2;
      int stopAt = x / 2 + 1;
      do {
         if (x % test == 0)
            return false;
         test++;

      } while (test <= stopAt);

      return true;
   }

   // al stores all prime numbers
   static public ArrayList<Integer> getPrimeFactor(int x) {
      ArrayList<Integer> answerAl = new ArrayList<Integer>();

      // Step1 get all Possible prime numbers for x ( so 2, 3.... to x/2 )
      // Step 2 check each of them, put the correct one to answerAl

      // Step1

      int tempPrime = 2;
      int tempx = x;
      System.out.print("" + x + ":  ");
      do {
         if (isPrimeNumber(tempPrime)) {
            do {
               // continue to add the prime if it contains more , ie. 100=10*10,
               // 27=3*3*3
               if (tempx % tempPrime == 0) {
                  answerAl.add(tempPrime);
                  System.out.print(" " + tempPrime + " ");

                  tempx = tempx / tempPrime;
               } else {

                  break;
               }
            } while (true);
         }
         tempPrime++;

         // stop when meat half x
      } while (tempPrime <= x / 2);

      return answerAl;
   }

   static public void getPrimeFactorRecurse(int x, ArrayList al) {

   }

   public static void testGetPrimeFactor(int x) {

      ArrayList<Integer> al = getPrimeFactor(x);

      System.out.println();

      // System.out.println(al.toString());
   }

   public static void test() {
      testGetPrimeFactor(2);
      testGetPrimeFactor(8);
      testGetPrimeFactor(10);
      testGetPrimeFactor(20);
      testGetPrimeFactor(100);
      testGetPrimeFactor(10002);

   }
}
