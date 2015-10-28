package mytestpackage;

public class MyMergeSort
{

   // sort the array in place
   static void mergeSort(int[] array, int startIndex, int endIndex)
   {
      // step 1 split , left , right
      // step 2 sort left, right
      // step 3 merge two sorted array

      // recurse base case,
      if (endIndex - startIndex <= 0)
      {
         return;
      }
      // 1-0/2=0 2-0 /2 = 1 3-0 /2= 1
      int midIndex = startIndex + (endIndex - startIndex) / 2;
      // left is from startIndex to midIndex (so size is mid+1), right is from
      // midIndex+1 to endIndex
      // mergeSort left
      mergeSort(array, startIndex, midIndex);
      mergeSort(array, midIndex + 1, endIndex);
      mergeTwoArrays(array, startIndex, midIndex, endIndex);

   }

   // merge two sorted arrays: array1: startIndex1 to endIndex1, array2:
   // startIndex2 to endIndex2
   static void mergeTwoArrays(int[] array, int startIndex1, int endIndex1, int endIndex2)
   {
      int[] arraySorted = new int[endIndex2 - startIndex1 + 1];
      int index1 = startIndex1, index2 = endIndex1 + 1, index3 = 0;
      do
      {
         // done

         if (index1 > endIndex1 || index2 > endIndex2)
         {
            break;
         }
         if (array[index1] < array[index2])
         {
            arraySorted[index3] = array[index1];
            index1++;
            index3++;
         } else
         {
            arraySorted[index3] = array[index2];
            index2++;
            index3++;
         }
      } while (true);

      if (index1 <= endIndex1)
      {
         for (int i = index1; i <= endIndex1; i++)
         {
            arraySorted[index3] = array[i];
            index3++;
         }
      }

      if (index2 <= endIndex2)
      {
         for (int i = index2; i <= endIndex2; i++)
         {
            arraySorted[index3] = array[i];
            index3++;
         }
      }

      // arraySorted is done, now move back to original array
      for (int i = 0; i < arraySorted.length; i++)
      {
         array[startIndex1 + i] = arraySorted[i];

      }

   }

   static void mergeSort(int[] array)
   {
      mergeSort(array, 0, array.length - 1);
   }

   static void test(int[] array)
   {
      // sort ! and done!
      mergeSort(array);

      printArray(array);
   }

   static void test()
   {
      int[] array1 = new int[1];
      array1[0] = 9;
      test(array1);

      int[] array2 = new int[2];
      array2[0] = 9;
      array2[1] = 8;
      test(array2);

      int[] array3 = new int[3];
      array3[1] = 1;
      array3[2] = 2;
      test(array3);

      int[] array4 = new int[4];
      array4[3] = 0;
      array4[2] = 1;
      array4[1] = 2;
      array4[0] = 3;

      test(array4);
      
      int[] array5 = new int[5];
      array5[4] = 9;
      array5[3] = 8;
      array5[2] = 1;
      array5[1] = 2;
      array5[0] = 3;
      test(array5);
      
      

   }

   static void printArray(int[] array)
   {
      System.out.println();
      for (int i = 0; i < array.length; i++)
      {
         System.out.print(array[i] + " ");
      }

   }

}
