package Puzzle;

import java.util.Stack;

public class Board {
  private int[][] goal;
  private int[][] tile;
  private int n;
  
 
  public Board(int[][] tiles) {
    n = tiles.length; 
    
    tile = new int[n][n];
    for( int row = 0; row < n; row++) 
      for( int col = 0; col < n; col++) 
        tile[row][col] = tiles[row][col];
        
    goal = new int[n][n];
    int count = 1;
    for( int row = 0; row < n; row++) {
      for( int col = 0; col < n; col++) {
        if( n*n == count) goal[row][col] = 0;
        else goal[row][col] = count++;
      }
    }
  }
                              
  public String toString() {
    StringBuilder s = new StringBuilder(); 
    s.append(n + "\n"); 
    for (int row = 0; row < n; row++) { 
      for (int col = 0; col < n; col++) { 
        s.append(String.format("%2d ", tileAt(row, col))); 
      } 
      s.append("\n"); 
    } 
    return s.toString();
  }
  
  int tileAt(int row, int col) {
    return tile[row][col];
  }
  
  public int size() {
    return n;
  
  }
  
  public int hamming() {
    int hamming = 0;
    for( int row = 0; row < n; row++) 
      for( int col = 0; col < n; col++) 
        if( tile[row][col] != goal[row][col] && tile[row][col] != 0) 
          hamming++;         
    return hamming;  
  } 
  
  public int manhattan() {
    int manhattan = 0;
    for( int row = 0; row < n; row++) 
      for( int col = 0; col < n; col++) 
        if( tile[row][col] != 0) {
          int value = tile[row][col];
          int i = (value - 1) / n;
          int j = (value - 1) % n;
          manhattan += Math.abs(row - i) + Math.abs(col - j);
        }  
     return manhattan; 
  }
  
  public boolean isGoal() {
    for( int row = 0; row < n; row++) 
      for( int col = 0; col < n; col++) 
        if( tile[row][col] != goal[row][col]) 
          return false;
    return true;
  } 
  
  public void swap( int i, int j, int x, int y) {
    int temp = tile[i][j];
    tile[i][j] = tile[x][y];
    tile[x][y] = temp;
  }
  
//  public boolean equals(Object y) {
//    return y;
//  }
  
  public Iterable<Board> neighbors() {
    Stack<Board> boards = new Stack<>();
    int i = 0, j = 0;
    for( int row = 0; row < n; row++) 
      for( int col = 0; col < n; col++) 
        if( tile[row][col] == 0) {
          i = row; j = col;
          break;
        }
         
    if( i - 1 >= 0) {
      Board neig = new Board(tile);
      neig.swap(i, j, i-1, j);
      boards.push(neig);
    }
    
    if( i + 1 < n) {
      Board neig = new Board(tile);
      neig.swap(i, j, i+1, j);
      boards.push(neig);
    }
    
    if( j - 1 >= 0) {
      Board neig = new Board(tile);
      neig.swap(i, j, i, j-1);
      boards.push(neig);
    }  
    
    if( j + 1 < n) {
      Board neig = new Board(tile);
      neig.swap(i, j, i, j+1);
      boards.push(neig);
    }  
      
   return boards;
  }
  
  public boolean isSolvable() {
    int inv = 0, blankRow = 0;
    for( int i = 0; i < n*n; i++) {
      int row = i / n;
      int col = i % n;
      if( tile[row][col] == 0) blankRow = row;
      for( int j = i; j < n*n; j++) {
        int r = j / n;
        int c = j % n;
        if( tile[row][col] > tile[r][c] && tile[row][col] != 0 && tile[r][c] != 0) 
              inv++;   
      }
    }
   
    if( inv % 2 == 1 && n % 2 == 1) return false;
    if( n % 2 == 0 && (blankRow + inv) % 2 == 0) return false;
    
    return true;
  } 
 
  public void print() {
    for( int row = 0; row < n; row++) {
      for( int col = 0; col < n; col++) {
        System.out.print(" " +goal[row][col]);
      }
      System.out.println();
    }
  }

/*public class Solver { 
  public Solver(Board initial) 
  public int moves() 
  public Iterable<Board> solution()  
  public static void main(String[] args) 
} */


  public static void main(String[] args) {
    
   int tiles[][] = {{1, 2, 3}, {4, 5, 6}, {8, 7, 0}};
//   int tiles[][] = {{0, 1, 3}, {4, 2, 5}, {7, 8, 6}};
    Board brd = new Board(tiles);
    brd.print();
    System.out.println(brd.hamming());
    System.out.println(brd.manhattan());
    System.out.println(brd.toString());
    Stack ver = new Stack();
    System.out.println(brd.neighbors());
    for( string s: brd.neighboard()) 
      
    
    System.out.println(brd.isSolvable());
    
  }
}
