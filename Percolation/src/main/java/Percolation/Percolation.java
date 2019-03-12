package Percolation;

import java.util.Scanner;
import java.util.Random;

public class Percolation { 	
   private int count; 	
   private int[][] Open; 
   private int N; 	
   private int size;
   private WeightedQuickUnionUF UF; 	 
  
  	public Percolation(int n) { 		
  	  count = 0; 		
  	  N = n*n+2; 
  	  size = n;	
  	  Open = new int [n][n]; 		
  	  UF = new WeightedQuickUnionUF(N); 		
  	  
  	  for( int i = 0; i < n; i++) 			
  	    for( int j = 0; j < n; j++) 				
  	      Open[i][j] = 0;
  	  
  	  for( int k = 1; k <= n; k++) 		
  	    UF.union (0, k);
  	    		
   }
  	     
  	public void open(int row, int col) { 		
  	  if( Open[row][col] == 1) return;
  	  Open[row][col] = 1; 		
  	  count++;
  	  
  	  if( (row + 1 < size) && isOpen(row+1, col)) 
  	    UF.union(size*(row)+col+1, size*(row+1)+col+1); 
  	  
  	   if( (row - 1 >= 0) && isOpen(row-1, col)) 
  	    UF.union(size*(row-1)+col+1, size*row+col+1); 
  	        				
  
  	  if( (col - 1 >= 0) && isOpen(row, col-1)) 
  	    UF.union(size*row+col, size*row+col+1); 		
  	 
     if( (col + 1 < size) && isOpen(row, col+1)) 
  	    UF.union(size*row+col+2, size*row+col+1); 
  	   	  
  	  if( row == size - 1) 
  	    UF.union( N-1, size*row+col+1);
  	  
 //   	  if( row == 0) UF.union(0, size*row+col+1);
   }
  	 
  	public boolean isOpen(int row, int col) { 	
  	  return Open[row][col] == 1; 	
  	}
  	  
  	public boolean isFull(int row, int col) { 		
  	  int p = size*row + col + 1; 		
  	  return UF.connect(p, 0); 	
  	} 	 	
  	  
  	public int numberOfOpenSites() { 		
  	  return count; 	
  	}
  	  
  	public boolean percolates() { 		
  	  return UF.connect(N-1, 0); 	
   }
   
   public void printM() {
     for( int i = 0; i < size; i++) {
  	    for( int j = 0; j < size; j++) 	{		
  	      System.out.print(" " +Open[i][j]);
  	    }
  	    System.out.println("");
  	  }
   }
   	 
  	public static void main(String[] args) { 	
  	   	// TODO Auto-generated method stub 	   		
  	   	Percolation perc = new Percolation(4);
       Random dates = new Random();
  	   	while( !perc.percolates())  {
  	   	  int row = dates.nextInt(4);
  	   	  int col = dates.nextInt(4);
  	   	  perc.open(row, col);
  	   	  perc.printM();
  	      System.out.println(" ");
       }
  	} 
}

  
