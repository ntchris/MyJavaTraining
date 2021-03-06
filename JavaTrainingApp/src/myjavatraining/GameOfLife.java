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

public class GameOfLife {

   static final int IsLive = 1;
   static final int IsNextDead = 0b10;

   static final int MaskStatus = 0b01;
   static final int MaskNextStatus = 0b10;

   static public void printBoard(int[][] board) {
      int maxSizeX, maxSizeY;
      maxSizeX = board.length;
      maxSizeY = board[0].length;

      System.out.println("maxSizeX: " + maxSizeX);
      System.out.println("maxSizeY: " + maxSizeY);

      int size = board.length;

      for (int y = 0; y < maxSizeY; y++) {
         for (int x = 0; x < maxSizeX; x++) {
            System.out.print(board[x][y] + " ");

         }
         System.out.println();
      }

   }

   static public void createBoard1(int[][] board) {
      int maxSizeX, maxSizeY;
      maxSizeX = board.length;
      maxSizeY = board[0].length;
      board[0][0] = 1;
      board[1][0] = 1;
      board[2][0] = 1;

   }

   static public void createBoardAllLive(int[][] board) {
      int maxSizeX, maxSizeY;
      maxSizeX = board.length;
      maxSizeY = board[0].length;
      for (int y = 0; y < maxSizeY; y++) {
         for (int x = 0; x < maxSizeX; x++) {
            board[x][y] = IsLive;
         }

      }

      board[4][4] = 0;
      board[4][5] = 0;
      board[4][6] = 0;
      board[5][4] = 0;
      board[5][5] = 0;
      board[5][6] = 0;
   }

   static public void createBoardOscillators(int[][] board) {
      board[2][1] = IsLive;
      board[2][2] = IsLive;
      board[2][3] = IsLive;

   }

   static public void test() {

      System.out.println(MaskStatus);
      System.out.println(MaskNextStatus);

      int[][] board = new int[5][5];
      createBoardOscillators(board);// createBoard1(board);
      printBoard(board);

      for (int i = 0; i < 22; i++) {
         gameOfLife(board);
         printBoard(board);
      }
   }

   static int getNeighborLiveCellCount(int[][] board, int x, int y) {
      int count = 0;
      int maxSizeX, maxSizeY;
      maxSizeX = board.length;
      maxSizeY = board[0].length;
      int neighborLiveCount = 0;
      for (int iy = y - 1; iy <= y + 1; iy++) {
         for (int ix = x - 1; ix <= x + 1; ix++) {
            // skip self

            if (ix >= 0 && ix < maxSizeX && iy >= 0 && iy < maxSizeY) {
               if (ix == x && iy == y) {
                  // ignore itself
                  continue;
               }

               int status = board[ix][iy];
               if ((status & MaskStatus) == IsLive) {
                  neighborLiveCount++;
               }
            }
         }
      }

      // System.out.print(neighborLiveCount);

      return neighborLiveCount;

   }

   static int getNextStateByRule(int state, int neighborlivecell) {
      // System.out.println();
      int nextState = state;
      // logic
      if ((state & MaskStatus) == IsLive) {
         System.out.print(" It's a live cell   ");

         if (neighborlivecell < 2 || neighborlivecell > 3) {
            // next state is dead
            System.out.print("set next dead");
            // nextState = nextState& ~(IsNextDead);
            nextState = nextState | (IsNextDead);

            System.out.print(" next is nextState " + nextState);

         } else {
            // next state is live, no change

         }
      } else {
         // System.out.print(" It's a dead cell ");
         if (3 == neighborlivecell) {
            nextState = nextState & ~(IsNextDead);
            System.out.print(" next is nextState live " + nextState);

         } else {
            // next turn it should still be dead cell
            nextState = nextState | IsNextDead;
         }

      }

      return nextState;
   }

   // traverse the whole board and set the next status
   static public void traverseBoard(int[][] board) {
      int maxSizeX, maxSizeY;
      maxSizeX = board.length;
      maxSizeY = board[0].length;
      for (int iy = 0; iy < maxSizeY; iy++) {
         for (int ix = 0; ix < maxSizeX; ix++) {
            int thisState = board[ix][iy];
            int count = getNeighborLiveCellCount(board, ix, iy);
            int nextState = getNextStateByRule(thisState, count);
            board[ix][iy] = nextState;
         }

      }
   }

   static public void nextTurn(int[][] board) {
      int maxSizeX, maxSizeY;
      maxSizeX = board.length;
      maxSizeY = board[0].length;
      for (int iy = 0; iy < maxSizeY; iy++) {
         for (int ix = 0; ix < maxSizeX; ix++) {
            int state = board[ix][iy];
            if ((state & MaskNextStatus) == IsNextDead) {
               state = 0;
            } else {
               state = IsLive;
            }

            board[ix][iy] = state;
         }

      }

   }

   static public void gameOfLife(int[][] board) {
      traverseBoard(board);
      nextTurn(board);

   }

}