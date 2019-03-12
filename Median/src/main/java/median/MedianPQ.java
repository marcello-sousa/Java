package median;

import java.util.Random;

public class MedianPQ <Key extends Comparable<Key>>{
  private MaxPq left;
  private MinPq right;
  private int v = 0;
  
  public MedianPQ(int N, int M) {
    left = new MaxPq(N);
    right = new MinPq(M);
  }
  
  private boolean less( int k, int v) {
    return k < v;
  }
  
  private boolean great( int k, int v) {
    return k > v;
  }
  
  public void insert(int k) {
    if( left.isEmpty() && right.isEmpty()) {
      right.insert(k);
      v = k;
    }  
    else {      
      if( less(k, v) && (left.size() < right.size() + 1)) {
        left.insert(k);
      }
      else if( great(k, v) && (right.size() < left.size() + 1)) {
        right.insert(k);
      }  
      else {
        if( left.size() == right.size() + 1) {
          right.insert(v);
          left.insert(k);
          v = (int)left.max();
          left.delMax();
        }
        else {
          left.insert(v);
          right.insert(k);
          v = (int)right.min();
          right.delMin();
        }
      }
    }
    System.out.println(k);
  }
  
  public void remove() {
    
  }
  
  public void printM() {
    left.print();
    right.print();
  }

  public static void main(String[] args) {
    MedianPQ median = new MedianPQ(100, 100);
    Random rnd = new Random();
    int n = rnd.nextInt(20);
    System.out.println(n);
    for( int i = 0; i < n; i++) {
      median.insert(rnd.nextInt(100));
    }
    median.printM(); 
   } 
 }
