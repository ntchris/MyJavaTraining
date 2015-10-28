package mytestpackage;

import static org.junit.Assert.*;

class LinkNode
{
   LinkNode nextNode;

   char data;
};

public class LinkList
{
   // LinkNode mToFirstNode;
   LinkNode mfirstNode;

   LinkList()
   {
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

   public void createALinkList(String text)
   {
      mfirstNode = null;
      LinkNode currentNode = mfirstNode;
      LinkNode previousNode = null;
      for (int i = 0; i < text.length(); i++)
      {
         currentNode = new LinkNode();
         if (this.mfirstNode == null)
         {
            mfirstNode = currentNode;
         }

         char tempc = text.charAt(i);
         currentNode.data = tempc;
         currentNode.nextNode = null;

         // prepare for next loop
         if (previousNode != null)
         {
            previousNode.nextNode = currentNode;
         }
         previousNode = currentNode;
      }

   }

   public void printLinkList()
   {
      LinkNode currentNode = mfirstNode;
      while (currentNode != null)
      {
         System.out.print(currentNode.data);
         currentNode = currentNode.nextNode;
      }
      System.out.println();
   }

   static public void printLinkList(LinkNode headNode)
   {
      LinkNode currentNode = headNode;
      while (currentNode != null)
      {
         System.out.print(currentNode.data);
         currentNode = currentNode.nextNode;
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
   public LinkNode insert(LinkNode node, char data)
   {
      LinkNode newNode = new LinkNode();
      newNode.data = data;
      // if insert after a null, meaning insert as the first char ? so no node
      // is before it
      if (node == null)
      {
         newNode.nextNode = this.mfirstNode;
         mfirstNode = newNode;
         return newNode;
      }

      newNode.nextNode = null;
      newNode.nextNode = node.nextNode;
      node.nextNode = newNode;
      return newNode;

   }

   /**
    * null means not found
    * 
    * @param data
    * @return
    */
   public LinkNode searchNode(char data)
   {
      LinkNode tempNode = this.mfirstNode;

      while (tempNode != null)
      {
         if (tempNode.data == data)
         {
            break;
         }
         tempNode = tempNode.nextNode;
      }
      return tempNode;
   }

   /**
    * 
    */
   public void deleteNode(char data)
   {
      LinkNode previousNode = null;
      LinkNode currentNode = this.mfirstNode;
      while (currentNode != null)
      {
         if (currentNode.data == data)
         {
            if (previousNode == null)
            {
               // this is the first node, just use 2nd node to replace the first
               // node
               mfirstNode = mfirstNode.nextNode;
            } else
            {
               previousNode.nextNode = currentNode.nextNode;
            }
            currentNode = null;
            return;
         }
         previousNode = currentNode;
         currentNode = currentNode.nextNode;
      }

   }

   static public void test1()
   {
      LinkList linklist = new LinkList();
      linklist.createALinkList("abcdef");

      System.out.println("the list is ");
      linklist.printLinkList();

      LinkNode foundNode = linklist.searchNode('c');
      System.out.println("Found " + foundNode.data);

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
      linklist.createALinkList("a");
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
   static public void partLinkList(LinkList origlist, int val)
   {

      LinkNode largeHead = null, smallHead = null;

      LinkNode tempNode = origlist.mfirstNode;

      LinkNode smallerListCurrentNode = null;
      LinkNode largerListCurrentNode = largeHead = null;

      while (tempNode != null)
      {
         LinkNode next = tempNode.nextNode;
         int nodeValue = Integer.parseInt("" + tempNode.data);
         if (nodeValue < val)
         {
            // move this node to smaller list
            if (smallHead == null)
            {
               smallHead = tempNode;
               smallerListCurrentNode = tempNode;
               // we null the tempNode.next here, but that's OK, next has
               // been remembered.
               smallerListCurrentNode.nextNode = null;
            } else
            {
               tempNode.nextNode = null;
               smallerListCurrentNode.nextNode = tempNode;
               smallerListCurrentNode = smallerListCurrentNode.nextNode;
            }
         } else
         {
            // move this node to larger list
            if (largerListCurrentNode == null)
            {
               largerListCurrentNode = tempNode;
               largeHead = largerListCurrentNode;
               tempNode.nextNode = null;
            } else
            {
               tempNode.nextNode = null;
               largerListCurrentNode.nextNode = tempNode;
               largerListCurrentNode = largerListCurrentNode.nextNode;
            }
         }
         tempNode = next;

      } // while (tempNode != null)

      if (smallerListCurrentNode != null)
      {
         smallerListCurrentNode.nextNode = largeHead;

         origlist.mfirstNode = smallHead;
      } else
      {
         origlist.mfirstNode = largeHead;

      }

   }

   static public void test3()
   {
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

   static int nodeToInt(LinkNode node)
   {
      if (node == null)
         return 0;
      return Integer.parseInt("" + node.data);
   }

   // a , b , stored in rev order, sum as well
   // a = 123, b=234.
   // so a list is 321, b list is 432
   // sum = 357 as list 753
   static LinkNode addition(LinkNode a, LinkNode b)
   {
      LinkNode sum1stDigit = null;
      boolean excess = false;
      LinkNode nodeA = a;
      LinkNode nodeB = b;
      LinkNode nodeSum = sum1stDigit;

      while (true)
      {
         int digitA = 0, digitB = 0;

         // get digitA,
         digitA = nodeToInt(nodeA);
         if (nodeA != null)
         {
            nodeA = nodeA.nextNode;
         }
         // get digitB
         digitB = nodeToInt(nodeB);
         if (nodeB != null)
         {
            nodeB = nodeB.nextNode;
         }

         int sum = digitA + digitB;
         if (excess)
         {
            sum++;
         }
         if (sum >= 10)
         {
            excess = true;
         } else
         {
            excess = false;
         }
         // set sumList.node value
         LinkNode newNode = new LinkNode();

         newNode.data = ("" + (sum % 10)).charAt(0);

         if (sum1stDigit == null)
         {
            sum1stDigit = newNode;
            nodeSum = sum1stDigit;
         } else
         {
            nodeSum.nextNode = newNode;
            nodeSum = nodeSum.nextNode;
         }

         // check if should end
         if (nodeA == null && nodeB == null && !excess)
            break;
      }

      return sum1stDigit;

   }

   static public void testAdd(int a, int b)
   {
      System.out.println();
      System.out.print(a + " + " + b + " = ");

      LinkList listA = new LinkList();
      listA.createALinkList("" + a);

      LinkList listB = new LinkList();
      listB.createALinkList("" + b);

      LinkNode sumNodeHead = addition(listA.mfirstNode, listB.mfirstNode);
      LinkList.printLinkList(sumNodeHead);

   }

   static public void testAdd()
   {
      testAdd(1, 2);
      testAdd(0, 3);
      testAdd(4, 0);
      testAdd(9, 1);
      testAdd(12, 34);
      testAdd(123, 345);
      testAdd(9876, 1234);
      testAdd(0, 0);
      testAdd(999999999, 1);



   }

   static public void test()

   {
      testAdd();

      System.out.println();

   }

};
