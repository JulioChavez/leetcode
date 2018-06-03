/**
  There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.

  Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.

  The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.

  Example 1

  Input 1: a maze represented by a 2D array

  0 0 1 0 0
  0 0 0 0 0
  0 0 0 1 0
  1 1 0 1 1
  0 0 0 0 0

  Input 2: start coordinate (rowStart, colStart) = (0, 4)
  Input 3: destination coordinate (rowDest, colDest) = (4, 4)

  Output: true
  Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.


  Example 1 -
    Input:
      [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]]
      [0,4]
      [4,4]
    Expected output: true

  Example 2 -
    Input:
      [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]]
      [0,4]
      [4,4]
    Expected output: true

 */


 class TheMaze {

     enum Direction {
         UP, DOWN, LEFT, RIGHT;
     }

     public boolean hasPath(int[][] maze, int[] start, int[] destination) {
         int rows = maze.length;
         int columns = maze[0].length;
         boolean[][] visited = new boolean[rows][columns];

         return hasPath(maze, visited, start[0], start[1], destination[0], destination[1]);
     }

     private boolean hasPath(int[][] maze, boolean[][] visited, int rowCurrent, int colCurrent, int rowDest, int colDest) {

         if (rowCurrent == rowDest && colCurrent == colDest)
             return true;

         if (!isInbounds(maze, rowCurrent, colCurrent) || visited[rowCurrent][colCurrent])
             return false;

         visited[rowCurrent][colCurrent] = true;

         // Go up
         if (checkNext(maze, visited, rowCurrent, colCurrent, rowDest, colDest, Direction.UP))
             return true;
         // Go down
         if (checkNext(maze, visited, rowCurrent, colCurrent, rowDest, colDest, Direction.DOWN))
             return true;
         // Go left
         if (checkNext(maze, visited, rowCurrent, colCurrent, rowDest, colDest, Direction.LEFT))
             return true;
         // Go right
         if (checkNext(maze, visited, rowCurrent, colCurrent, rowDest, colDest, Direction.RIGHT))
             return true;

         // No path found
         return false;
     }

     private boolean checkNext(int[][] maze, boolean[][] visited, int rowCurrent, int colCurrent, int rowDest, int colDest,
                             Direction dir) {
         int rowOld = rowCurrent;
         int colOld = colCurrent;

         // Move up
         if (dir == Direction.UP) {
             while(isInbounds(maze, rowCurrent + 1, colCurrent) && maze[rowCurrent + 1][colCurrent] == 0) {
                 rowCurrent++;
             }
         }
         // Move down
         else if (dir == Direction.DOWN) {
             while(isInbounds(maze, rowCurrent - 1, colCurrent) && maze[rowCurrent - 1][colCurrent] == 0) {
                 rowCurrent--;
             }
         }
         // Move left
         else if (dir == Direction.LEFT) {
             while(isInbounds(maze, rowCurrent, colCurrent - 1) && maze[rowCurrent][colCurrent - 1] == 0) {
                 colCurrent--;
             }
         }
         // Move right
         else if (dir == Direction.RIGHT) {
             while(isInbounds(maze, rowCurrent, colCurrent + 1) && maze[rowCurrent][colCurrent + 1] == 0) {
                 colCurrent++;
             }
         }

         // If we did not move, return false
         if (rowCurrent == rowOld && colCurrent == colOld) {
             return false;
         }

         // Call hasPath with the new row and column indices
         return hasPath(maze, visited, rowCurrent, colCurrent, rowDest, colDest);
     }

     private boolean isInbounds(int[][] maze, int rowCurrent, int colCurrent) {
         int rows = maze.length;
         int columns = maze[0].length;

         return rowCurrent >= 0 && colCurrent >= 0 && rowCurrent < rows && colCurrent < columns;
     }
 }
