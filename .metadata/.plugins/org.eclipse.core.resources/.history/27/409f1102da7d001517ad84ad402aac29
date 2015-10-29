package mytestpackage;

public class MyStack
{
   StackNode mTopNode;

   class StackNode
   {
      String data;
      StackNode next;

      StackNode(String newItem)
      {
         data = newItem;
      }
   };

   public String peak()
   {
      return mTopNode.data;
   }

   public void push(String newItem)
   {
      StackNode newNode = new StackNode(newItem);
      newNode.next = mTopNode;
      mTopNode = newNode;

   }

   public String pop()
   {
      if (mTopNode == null)
      {
         return null;
      } else
      {
         String data = mTopNode.data;

         mTopNode = mTopNode.next;
         return data;

      }

   }

   public boolean isEMpty()
   {
      return mTopNode == null;
   }

   void printStack()
   {
      StackNode tempNode = mTopNode;
      while (tempNode != null)
      {
         System.out.print(tempNode.data);
         tempNode = tempNode.next;
      }
   }

   static public void testOperation()
   {
      MyStack stack = new MyStack();

      System.out.println("poping empty stack " + stack.pop());

      stack.push("AAA");
      System.out.println("poping AAA stack " + stack.pop());
      stack.push("AAA");

      stack.push("BBB");
      stack.push("CCC");

      System.out.println("poping stack: CCC " + stack.pop());
      System.out.println("poping stack: BBB " + stack.pop());
      System.out.println("poping stack: AAA " + stack.pop());

      System.out.println("poping empty stack " + stack.pop());
      System.out.println("poping empty stack " + stack.pop());

   }

   static public void twoStacksSort(MyStack origStk, MyStack destStk)
   {
      while (!origStk.isEMpty())
      {
         String toSort = origStk.peak();
         origStk.pop();

         while (!destStk.isEMpty() && (destStk.peak().compareTo(toSort) > 0))
         {
            origStk.push(destStk.peak());
            destStk.pop();
         }
         destStk.push(toSort);
      }
   }

   static public void testSort()
   {
      MyStack stack1 = new MyStack();
      stack1.push("1");
      stack1.push("4");
      stack1.push("3");
      stack1.push("2");


      stack1.printStack();
      MyStack stack2 = new MyStack();
      twoStacksSort(stack1, stack2);
      System.out.println();
      stack2.printStack();

   }

   static public void test()
   {
      testSort();
   }

}
