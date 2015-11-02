package myjavatraining;

import static org.junit.Assert.*;

/*
There are just 3 rules to Sudoku.
Each row must have the numbers 1-9 occuring just once.
Each column must have the numbers 1-9 occuring just once.
    
And the numbers 1-9 must occur just once in each of the 9 sub-boxes of the grid.*/

public class SodukuSolution {

   static final boolean Debug = false;
   static final int SudokuMaxX = 9, SudokuMaxY = 9;

   static public boolean checkIsRowValid(char[] row) {

      boolean isValid = true;

      final int MaxNumber = 255;
      char[] mapNumbers = new char[MaxNumber];

      int x;
      for (x = 0; x < row.length; x++) {
         char value = row[x];
         // number appears
         // check number range

         if (value == '.') {

         } else if ((value >= '1' && value <= '9')) {
            // appear again!!!??
            if (mapNumbers[value] != 0) {
               isValid = false;
               break;
            } else
               mapNumbers[value] = 1;

         } else {
            isValid = false;
            break;
         }

      }

      if (Debug) if (!isValid) System.out.println("invalid, x =" + x);
      return isValid;

   }

   static public char getDataFromArray(char[][] array, int x, int y) {
      // thanks for the strange way how java organaize two dim array
      return array[y][x];

   }

   static public boolean checkIsColumValid(char[][] array, int colIndex) {

      boolean isValid = true;

      final int MaxNumber = 255;
      char[] mapNumbers = new char[MaxNumber];

      int y;
      for (y = 0; y < SudokuMaxY; y++) {
         char value = getDataFromArray(array, colIndex, y);
         // number appears
         // check number range

         if (value == '.') {

         } else if ((value >= '1' && value <= '9')) {
            // appear again!!!??
            if (mapNumbers[value] != 0) {
               isValid = false;
               break;
            } else
               mapNumbers[value] = 1;

         } else {
            isValid = false;
            break;
         }

      }

      if (Debug) {
         if (!isValid) System.out.println("invalid, y =" + y);
      }
      return isValid;

   }

   static public boolean isValidSudoku(char[][] board) {

      if (Debug)System.out.println();
      if (Debug) System.out.println("Checking ");

      boolean isValid = true;
      isValid = checkIsValidArraySizeForSudo(board);
      if (!isValid) return false;

      // rule 1 , row 1-9
      for (int i = 0; i < SudokuMaxY; i++) {
         if (!checkIsRowValid(board[i])) {
            if (Debug)System.out.println("invalid row: " + i);
            return false;
         }

      }

      // rule 2 column 1-9
      for (int col = 0; col < SudokuMaxX; col++) {
         if (!checkIsColumValid(board, col)) {
            if (Debug)System.out.println("invalid column: " + col);
            return false;
         }

      }

      // rule 3 each small box
      int x = 0, y = 0;

      for (y = 0; y < SudokuMaxY; y = y + 3)
         for (x = 0; x < SudokuMaxX; x = x + 3) {

            if (Debug)System.out.println("Small box :" + x + " " + y);
            if (!checkIsSmallBoxValid(board, x, y)) {
               return false;

            }
         }
      return isValid;
   }

   static boolean checkIsSmallBoxValid(char[][] board, int startX, int startY) {
      final int SmallBoxMaxX = 3, SmallBoxMaxY = 3;
      int x, y;
      boolean isValid = true;
      final int MaxNumber = 255;
      char[] mapNumbers = new char[MaxNumber];

      for (y = 0; y < SmallBoxMaxY; y++) {
         for (x = 0; x < SmallBoxMaxX; x++) {
            char value = getDataFromArray(board, startX + x, startY + y);
            if (value == '.') {

            } else if ((value >= '1' && value <= '9')) {
               // appear again!!!??
               if (mapNumbers[value] != 0) {
                  isValid = false;
                  break;
               } else
                  mapNumbers[value] = 1;

            } else {
               isValid = false;
               break;
            }
         }
      }
      return isValid;
   }

   static public boolean checkIsValidArraySizeForSudo(char[][] sudo) {

      int MaxX = sudo[0].length;
      int MaxY = sudo.length;

      boolean isValid = true;

      if (MaxX != SudokuMaxX) {
         isValid = false;
         if(Debug)System.out.println("Invalid MaxX for sudoku" + MaxX);
         return isValid;
      }

      if (MaxY != SudokuMaxY) {
         isValid = false;
         if (Debug)System.out.println("Invalid MaxY for sudoku" + MaxY);
         return isValid;
      }

      return isValid;

   }

   static public char[][] create2MArray(String[] lines) {
      if (lines.length != SudokuMaxY) return null;

      char[][] array = new char[SudokuMaxX][SudokuMaxY];

      int x = 0, y = 0;
      for (y = 0; y < lines.length; y++) {
         String line = lines[y];
         if (line.length() != SudokuMaxX) return null;
         for (x = 0; x < lines[y].length(); x++) {

            // each line must has SudokuMaxX size

            char charValue = line.charAt(x);
            array[y][x] = charValue;

         }
      }
      return array;

   }

   static public void testSudo() {
      char[][] array2mSudoku1 = { { '5', '3', '.', '.', '7', '.', '.', '.', '.', },
            { '6', '.', '.', '1', '9', '5', '.', '.', '.', }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
            { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
            { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
            { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' }

      };

      String[] array2Lines = { "....5..1.", ".4.3.....", ".....3..1", "8......2.", "..2.7....", ".15......",
            ".....2...", ".2.9.....", "..4......" };

      String[] array2mLines3 = { ".87654321", "2........", "3........", "4........", "5........", "6........",
            "7........", "8........", "9........" };

      char[][] sudo3 = create2MArray(array2mLines3);

      char[][] sudo2 = create2MArray(array2Lines);
      // new char[3][5];

      // printTwoDimArray(array2mSudoku1);

      print2DimArraySudo(sudo3);
      assertEquals(true, isValidSudoku(sudo3));

      print2DimArraySudo(array2mSudoku1);
      print2DimArraySudo(sudo2);

      // assertEquals(true, isValidSudoku(array2mSudoku1));
      assertEquals(false, isValidSudoku(sudo2));

      assertEquals(false, isValidSudoku(sudo2));

   }

   static public void print2DimArraySudo(char[][] sudo) {

      final int SudokuMaxX = 9, SudokuMaxY = 9;

      int MaxX = sudo[0].length;

      int MaxY = sudo.length;

      if (false == checkIsValidArraySizeForSudo(sudo)) return;

      System.out.println("Sudoku is");

      System.out.print("MaxX is " + MaxX);

      System.out.println(" ; MaxY is " + MaxY);

      for (int y = 0; y < MaxY; y++) {
         if (y % 3 == 0) {
            printLine(MaxX + 4);
            System.out.println();
         }

         for (int x = 0; x < MaxX; x++) {
            if (x % 3 == 0) System.out.print("|");
            System.out.print("" + (sudo[y][x]));
            if ((x + 1) == MaxX) System.out.print("|");

         }
         System.out.println();

         if (y + 1 == MaxY) {
            printLine(MaxX + 4);
         }

      }

   }

   static public void printLine(int maxX) {
      for (int x = 0; x < maxX; x++) {
         System.out.print("-");
      }
   }

   static public void printTwoDimArray(char[][] array2m) {
      System.out.println("two dim array is");

      int MaxX = array2m[0].length;
      System.out.print("MaxX is" + MaxX);

      int MaxY = array2m.length;
      System.out.println("; MaxY is" + MaxY);

      for (int y = 0; y < MaxY; y++) {
         for (int x = 0; x < MaxX; x++) {
            System.out.print(" " + (array2m[y][x]));
         }
         System.out.println();
      }

   }

}
