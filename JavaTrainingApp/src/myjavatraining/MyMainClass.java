
package myjavatraining;

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

public class MyMainClass {

   public static void testBinTree() {

      MyBinaryTree bintree = new MyBinaryTree();
      bintree.makeDefaultBinTree1();

      bintree.traverseBreadthFirst(bintree.root);

      System.out.println();
      bintree.traverseDeepFirst(bintree.root);

   }

   void testBinSearch() {
      int[] testlist = MyQuickSort.generateDescList(1000);
      // int []testlist = MyQuickSort.generateRandomList(100);

      // testlist [2]=6;
      // testlist [1]=0;

      MyQuickSort.showList(testlist);
      MyQuickSort.quickSort(testlist);

      MyQuickSort.showList(testlist);

      int index = BinSearch.binSearch(testlist, 0);
      System.out.println("search 0, found index : " + index);

      index = BinSearch.binSearch(testlist, 1);
      System.out.println("search 1, found index : " + index);

      index = BinSearch.binSearch(testlist, 2);
      System.out.println("search 2, found index : " + index);
      index = BinSearch.binSearch(testlist, 5);
      System.out.println("search 5, found index : " + index);

      index = BinSearch.binSearch(testlist, -1);
      System.out.println("search -1, found index : " + index);

      index = BinSearch.binSearch(testlist, 6);
      System.out.println("search 6, found index : " + index);

      index = BinSearch.binSearch(testlist, 201);
      System.out.println("search 201, found index : " + index);

   }

   void testWordPattern() {

      WordPattern.testcaseWordPattern();

   }

   static void testGameOfLife() {
      GameOfLife.test();
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

   /**
    * @param args
    */
   public static void main(String[] args) {
      // TODO Auto-generated method stub

      System.out.println("Hello world!");
      // MedianOfTwoSortedArraysSolution.test();

      // MyStack.test();

      // MyMergeSort.test();

      // MyQuickSort.test();
      // MyBinSearchTree.test();
      // LinkList.test();

      // MyStack.test();
      // MyBinSearchTree.test();
      // MyHashMap.test();
      // SubStringFind.test();
      // BinSearch.test();
      // NestedListSumTest.test();
      // MyMathFunctions.test();
      // MyBinaryTree.testPrintByLevel();

      // StringQuestion.testLongestCommonPrefix();

      // TwoSumSolution.test();

      // LongestSubstringSolution.test();
      // LinkList.testMergeManyLinkList();
      // ParenthesesSolution.testGenerateParenthesis();

      // LinkList.testSwapPairs();

      //LinkList.testputKthNodeOnHead();
      LinkList.testReverse();
   }

}
