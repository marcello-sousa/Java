package median;

import java.util.Random;

public class MaxPq <Key extends Comparable <Key>>{
  private Key[] pq;
  private int N = 0;
  
  public MaxPq(int maxN) {
    pq = (Key[]) new Comparable[maxN + 1];
  }
  
  public boolean isEmpty() {
    return N == 0;
  }
  
  public int size() {
    return N;
  }
  
  public void insert( Key v) {
    pq[++N] = v;
    swin(N);
  }
  
  private boolean less( int i, int j) {
    return pq[i].compareTo(pq[j]) < 0;
  }
  
  private void exch(int i, int j) {
    Key t = pq[i]; pq[i] = pq[j]; pq[j] = t;
  }
  
  public void swin( int k) {
    while ( k > 1 && less(k/2, k)) {
      exch(k/2, k);
      k = k/2;
    }
  }
  
  public void sink( int k) {
    while( 2*k <= N) {
      int j = 2*k;
      if( j < N && less(j, j+1)) j++;
      if( !less( k, j)) break;
      exch(k, j);
      k = j;
    }
  }
  
  public Key delMax() {
    Key max = pq[1];
    exch(1, N--);
    pq[N+1] = null;
    sink(1);
    return max;
  }
  
  public Key max () {
    return pq[1];
  }
  
  public void print() {
    for( int i = 1; i <= size(); i++) {
      System.out.print(" " +pq[i]);
    }
    System.out.println();
  }
}
