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

class ListNode {
   ListNode next;

   int val;

   ListNode(int data) {
      val = data;
   }

   
};

public class LinkList {

   // LinkNode mToFirstNode;
   ListNode mfirstNode;

   LinkList() {
      // mToFirstNode = new LinkNode();
   }
   /*
    * public void createALinkList(String text) { // firstNode = new LinkNode();
    * // LinkNode currentNode = firstNode;
    * 
    * // LinkNode currentNode = firstNode;
    * 
    * LinkNode previousNode = mToFirstNode;
    * 
    * for (int i = 0; i < text.length(); i++) { LinkNode newNode = new
    * LinkNode(); char tempc = text.charAt(i); newNode.data = tempc;
    * newNode.nextNode = null; previousNode.nextNode = newNode;
    * 
    * // prepare for next loop previousNode = newNode; }
    * 
    * }
    */

   public void createALinkList(String text) {
      mfirstNode = null;
      ListNode currentNode = mfirstNode;
      ListNode previousNode = null;
      for (int i = 0; i < text.length(); i++) {
         char tempc = text.charAt(i);
         currentNode = new ListNode(  Integer.parseInt(""+tempc ) );
         currentNode.next = null;
         if (this.mfirstNode == null) {
            mfirstNode = currentNode;
         }

         // prepare for next loop
         if (previousNode != null) {
            previousNode.next = currentNode;
         }
         previousNode = currentNode;
      }

   }

   public void printLinkList() {
      ListNode currentNode = mfirstNode;
      while (currentNode != null) {
         System.out.print(currentNode.val);
         System.out.print(" ");
         currentNode = currentNode.next;
      }
      System.out.println();
   }

   static public void printLinkList(ListNode headNode) {
      ListNode currentNode = headNode;
      while (currentNode != null) {
         System.out.print(currentNode.val);
         System.out.print(" ");

         currentNode = currentNode.next;
      }
      System.out.println();
   }

   /**
    * 
    * @param node
    *           insert after this node
    * @param data
    * @return
    */
   public ListNode insert(ListNode node, int data) {
      ListNode newNode = new ListNode(data);
      
      // if insert after a null, meaning insert as the first char ? so no node
      // is before it
      if (node == null) {
         newNode.next = this.mfirstNode;
         mfirstNode = newNode;
         return newNode;
      }

      newNode.next = null;
      newNode.next = node.next;
      node.next = newNode;
      return newNode;

   }

   /**
    * null means not found
    * 
    * @param data
    * @return
    */
   public ListNode searchNode(int data) {
      ListNode tempNode = this.mfirstNode;

      while (tempNode != null) {
         if (tempNode.val == data) {
            break;
         }
         tempNode = tempNode.next;
      }
      return tempNode;
   }

   /**
    * 
    */
   public void deleteNode(int data) {
      ListNode previousNode = null;
      ListNode currentNode = this.mfirstNode;
      while (currentNode != null) {
         if (currentNode.val == data) {
            if (previousNode == null) {
               // this is the first node, just use 2nd node to replace the first
               // node
               mfirstNode = mfirstNode.next;
            } else {
               previousNode.next = currentNode.next;
            }
            currentNode = null;
            return;
         }
         previousNode = currentNode;
         currentNode = currentNode.next;
      }

   }

   static public void test1() {
      LinkList linklist = new LinkList();
      linklist.createALinkList("abcdef");

      System.out.println("the list is ");
      linklist.printLinkList();

      ListNode foundNode = linklist.searchNode('c');
      System.out.println("Found " + foundNode.val);

      System.out.println("insert z after c");
      linklist.insert(foundNode, 'z');
      linklist.printLinkList();

      System.out.println("testing delete,del c ");
      linklist.deleteNode('c');
      linklist.printLinkList();

      System.out.println("testing delete,del z ");
      linklist.deleteNode('z');
      linklist.printLinkList();

      System.out.println("testing insert c after b ");
      foundNode = linklist.searchNode('b');
      linklist.insert(foundNode, 'c');
      linklist.printLinkList();

      System.out.println("delete a");
      linklist.deleteNode('a');
      linklist.printLinkList();

      System.out.println("delete f");
      linklist.deleteNode('f');
      linklist.printLinkList();

      System.out.println("insert a at beginning");
      linklist.insert(null, 'a');
      linklist.printLinkList();

      System.out.println("delete a at beginning");
      linklist.deleteNode('a');
      linklist.printLinkList();

      System.out.println("delete a again but not exist");
      linklist.deleteNode('a');
      linklist.printLinkList();

      linklist = new LinkList();
      linklist.createALinkList("" + 'a');
      System.out.println("The list is ");
      linklist.printLinkList();

      linklist.deleteNode('a');
      System.out.println("delete a, the list is ");
      linklist.printLinkList();

      linklist.deleteNode('a');
      System.out.println("delete a from an empty list, the list is ");

      linklist = new LinkList();
      linklist.createALinkList("abcdef");
      System.out.println("delete a non-existing z, the list is ");
      linklist.deleteNode('z');
      linklist.printLinkList();

   }

   // work on origlist
   static public void partLinkList(LinkList origlist, int val) {

      ListNode largeHead = null, smallHead = null;

      ListNode tempNode = origlist.mfirstNode;

      ListNode smallerListCurrentNode = null;
      ListNode largerListCurrentNode = largeHead = null;

      while (tempNode != null) {
         ListNode next = tempNode.next;
         int nodeValue = Integer.parseInt("" + tempNode.val);
         if (nodeValue < val) {
            // move this node to smaller list
            if (smallHead == null) {
               smallHead = tempNode;
               smallerListCurrentNode = tempNode;
               // we null the tempNode.next here, but that's OK, next has
               // been remembered.
               smallerListCurrentNode.next = null;
            } else {
               tempNode.next = null;
               smallerListCurrentNode.next = tempNode;
               smallerListCurrentNode = smallerListCurrentNode.next;
            }
         } else {
            // move this node to larger list
            if (largerListCurrentNode == null) {
               largerListCurrentNode = tempNode;
               largeHead = largerListCurrentNode;
               tempNode.next = null;
            } else {
               tempNode.next = null;
               largerListCurrentNode.next = tempNode;
               largerListCurrentNode = largerListCurrentNode.next;
            }
         }
         tempNode = next;

      } // while (tempNode != null)

      if (smallerListCurrentNode != null) {
         smallerListCurrentNode.next = largeHead;

         origlist.mfirstNode = smallHead;
      } else {
         origlist.mfirstNode = largeHead;

      }

   }

   static public void test3() {
      LinkList origlist = new LinkList();
      origlist.createALinkList("123456");
      origlist.printLinkList();
      partLinkList(origlist, 4);
      origlist.printLinkList();

      origlist.createALinkList("456123");
      origlist.printLinkList();
      partLinkList(origlist, 4);
      origlist.printLinkList();

      origlist.createALinkList("123");
      origlist.printLinkList();
      partLinkList(origlist, 4);
      origlist.printLinkList();

      origlist.createALinkList("456");
      origlist.printLinkList();
      partLinkList(origlist, 4);
      origlist.printLinkList();

      origlist.createALinkList("1");
      origlist.printLinkList();
      partLinkList(origlist, 4);
      origlist.printLinkList();

      origlist.createALinkList("6");
      origlist.printLinkList();
      partLinkList(origlist, 4);
      origlist.printLinkList();

      origlist.createALinkList("615243");
      origlist.printLinkList();
      partLinkList(origlist, 4);
      origlist.printLinkList();

      origlist.createALinkList("6543217");
      origlist.printLinkList();
      partLinkList(origlist, 4);
      origlist.printLinkList();

      return;
   }

  /* static int nodeToInt(ListNode node) {
      if (node == null)
         return 0;
      return Integer.parseInt("" + node.val);
   }
   */

   // a , b , stored in rev order, sum as well
   // a = 123, b=234.
   // so a list is 321, b list is 432
   // sum = 357 as list 753
   static ListNode addition(ListNode l1, ListNode l2) {
      ListNode sum1stDigit = null;
      boolean excess = false;
      ListNode nodeA = l1;
      ListNode nodeB = l2;
      ListNode nodeSum = sum1stDigit;

      while (true) {
         int digitA = 0, digitB = 0;

         // get digitA,
        
         if (nodeA != null) {
            digitA = nodeA.val;
            nodeA = nodeA.next;
         }else digitA =0;
         // get digitB
        
         if (nodeB != null) {
            digitB = nodeB.val;
            nodeB = nodeB.next;
         }else digitB =0;

         int sum = digitA + digitB;
         if (excess) {
            sum++;
         }
         if (sum >= 10) {
            excess = true;
         } else {
            excess = false;
         }
         // set sumList.node value
         int digit = sum % 10;
         ListNode newNode = new ListNode(digit);
 

         if (sum1stDigit == null) {
            sum1stDigit = newNode;
            nodeSum = sum1stDigit;
         } else {
            nodeSum.next = newNode;
            nodeSum = nodeSum.next;
         }

         // check if should end
         if (nodeA == null && nodeB == null && !excess)
            break;
      }

      return sum1stDigit;

   }

   static public void testAdd(int a, int b) {
      System.out.println();
      System.out.print(a + " + " + b + " = ");

      LinkList listA = new LinkList();
      listA.createALinkList("" + a);

      LinkList listB = new LinkList();
      listB.createALinkList("" + b);

      ListNode sumNodeHead = addition(listA.mfirstNode, listB.mfirstNode);
      LinkList.printLinkList(sumNodeHead);

   }

   static public void testAdd() {
      testAdd(1, 2);
      testAdd(0, 3);
      testAdd(4, 0);
      testAdd(9, 1);
      testAdd(12, 34);
      testAdd(123, 345);
      testAdd(9876, 1234);
      testAdd(0, 0);
      testAdd(9999999, 1);

   }

   static public void test()

   {
      testAdd();

      System.out.println();

   }

   /**
    * Merge two sorted linked lists and return it as a new list. The new list
    * should be made by splicing together the nodes of the first two lists.
    * 
    */
   static public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      ListNode l3head = null, l3node = null;

      if (l1 == null)
         return l2;

      if (l2 == null)
         return l1;

      if (l1.val < l2.val) {
         l3head = l1;
         l1 = l1.next;
      } else {
         l3head = l2;
         l2 = l2.next;
      }

      l3node = l3head;

      do {
         if (l1 == null && l2 == null)
            return l3head;
         else if (l1 == null) {
            l3node.next = l2;
            return l3head;//
         } else if (l2 == null) {
            l3node.next = l1;
            return l3head;

         } else if (l1.val < l2.val) {

            l3node.next = l1;
            l1 = l1.next;
         } else {
            l3node.next = l2;
            l2 = l2.next;
         }

         l3node = l3node.next;

      } while (true);

   }

   //This is slow, why??  because one list could be extremely long
   static public ListNode mergeKListsFor(ListNode[] lists  ) {
 
      if (lists == null)
         return null;

      int listsCount = lists.length;

      if (listsCount == 0)
         return null;

      if (listsCount == 1)
         return lists[0];
      
      if (listsCount == 2) {
         return mergeTwoLists(lists[0], lists[1]);
      } 
      

      ListNode resultListNode = null;

      for (int i = 0; i < lists.length; i++) {
         resultListNode = mergeTwoLists(lists[i], resultListNode);
      }

    return resultListNode;

   }

   static public ListNode mergeKLists(ListNode[] lists) {

      return mergeKLists(lists, 0, lists.length - 1);
     
   }

   static public ListNode mergeKLists(ListNode[] lists, int fromlist, int tolist) {

      if (lists == null)
         return null;

      if (lists.length == 0)
         return null;

      if (fromlist == tolist)
         return lists[fromlist];

      ListNode resultListNode = null;

      //base case
      if ((fromlist + 1) == tolist) {
         return mergeTwoLists(lists[fromlist], lists[tolist]);
      } else {
         int mid = (fromlist + tolist) / 2;
         if ((mid + 1) <= tolist) {
            return mergeTwoLists(mergeKLists(lists, fromlist, mid), mergeKLists(lists, mid + 1, tolist));
         } else {
            return mergeTwoLists(mergeKLists(lists, fromlist, mid),  lists [ tolist]);

         }
      }

   }

   public static void testMerge2LinkList() {
      ListNode l1_a = new ListNode('2');
      ListNode l1_b = new ListNode('4');
      ListNode l1_c = new ListNode('6');
      ListNode l1_d = new ListNode('8');

      l1_a.next = l1_b;
      l1_b.next = l1_c;
      l1_c.next = l1_d;

      ListNode l2_a = new ListNode('1');
      ListNode l2_b = new ListNode('3');
      ListNode l2_c = new ListNode('5');
      ListNode l2_d = new ListNode('9');
      l2_a.next = l2_b;
      l2_b.next = l2_c;
      l2_c.next = l2_d;

      System.out.println("LinkList a is ");
      printLinkList(l1_a);

      System.out.println("LinkList b is ");
      printLinkList(l2_a);

      ListNode l3_a = mergeTwoLists(l1_a, l2_a);
      printLinkList(l3_a);
   }

   public static void testMergeManyLinkList() {
      ListNode l1_a = new ListNode('1');
      ListNode l1_b = new ListNode('4');
      ListNode l1_c = new ListNode('7');

      l1_a.next = l1_b;
      l1_b.next = l1_c;

      ListNode l2_a = new ListNode('0');
      ListNode l2_b = new ListNode('3');
      ListNode l2_c = new ListNode('6');

      l2_a.next = l2_b;
      l2_b.next = l2_c;

      ListNode l3_a = new ListNode('2');
      ListNode l3_b = new ListNode('5');
      ListNode l3_c = new ListNode('8');
      ListNode l3_d = new ListNode('9');
      l3_a.next = l3_b;
      l3_b.next = l3_c;
      l3_c.next = l3_d;

      System.out.println("LinkList a is ");
      printLinkList(l1_a);

      System.out.println("LinkList b is ");
      printLinkList(l2_a);

      System.out.println("LinkList c is ");
      printLinkList(l3_a);

      ListNode[] lists = new ListNode[4];

      // new ListNode[3];
      lists[0] = l1_a;
      lists[1] = l2_a;
      lists[2] = l3_a;

      ListNode listd = mergeKLists(lists);
      System.out.println("linklist d is ");
      printLinkList(listd);

  

      ListNode l1_short = new ListNode('1');
      ListNode l2_short = new ListNode('4');
      ListNode l3_short = new ListNode('7');
      ListNode l4_short = new ListNode('9');
      lists[0] = l1_short;
      lists[1] = l2_short;
      lists[2] = l3_short;
      lists[3] = l4_short;

      listd = mergeKLists(lists);

      System.out.println("linklist d is ");
      printLinkList(listd);

      
  

   }

   
   public static void testMergeManyLinkListFor() {
      ListNode l1_a = new ListNode('1');
      ListNode l1_b = new ListNode('4');
      ListNode l1_c = new ListNode('7');

      l1_a.next = l1_b;
      l1_b.next = l1_c;

      ListNode l2_a = new ListNode('0');
      ListNode l2_b = new ListNode('3');
      ListNode l2_c = new ListNode('6');

      l2_a.next = l2_b;
      l2_b.next = l2_c;

      ListNode l3_a = new ListNode('2');
      ListNode l3_b = new ListNode('5');
      ListNode l3_c = new ListNode('8');
      ListNode l3_d = new ListNode('9');
      l3_a.next = l3_b;
      l3_b.next = l3_c;
      l3_c.next = l3_d;

      System.out.println("LinkList a is ");
      printLinkList(l1_a);

      System.out.println("LinkList b is ");
      printLinkList(l2_a);

      System.out.println("LinkList c is ");
      printLinkList(l3_a);

      ListNode[] lists = new ListNode[4];

      // new ListNode[3];
      lists[0] = l1_a;
      lists[1] = l2_a;
      lists[2] = l3_a;

      ListNode   
      
      listd = mergeKListsFor(lists);

      
      System.out.println("linklist d is ");
      printLinkList(listd);

      ListNode l1_short = new ListNode('1');
      ListNode l2_short = new ListNode('4');
      ListNode l3_short = new ListNode('7');
      ListNode l4_short = new ListNode('9');
      lists[0] = l1_short;
      lists[1] = l2_short;
      lists[2] = l3_short;
      lists[3] = l4_short;

  
      
      listd = mergeKListsFor(lists);
      System.out.println("linklist d is ");
      printLinkList(listd);

   }
   
   
};
