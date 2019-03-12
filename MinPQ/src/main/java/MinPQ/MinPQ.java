package MinPQ;

import java.util.Random;

public class MinPQ <Key extends Comparable <Key>> {
  private Key[] pq;
  private int N = 0;
  
  public MinPQ( int maxN) {
    pq = (Key[]) new Comparable[maxN+1];
  }
  
  public boolean isEmpty() {
    return N == 0;
  }
  
  public int size() {
    return N;
  }
  
  private boolean greater (int i, int j) {
    return pq[i].compareTo(pq[j]) > 0;
  }
  
  private void exch( int i, int j) {
    Key t = pq[i]; pq[i] = pq[j]; pq[j] = t;
  }
  
  public void insert( Key k) {
    pq[++N] = k;
    swim(N);
  }
  
  public void swim( int k) {
    while( k > 1 && greater(k/2, k)) {
      exch(k/2, k);
      k = k/2;
    }
  }
  
  public void sink( int p) {
    while( 2*p <= N) {
      int f = 2*p;
      if( f < N && greater(f, f+1)) f++;
      if( !greater(p, f)) break;
      exch(p, f);
      p = f;
    }
  }
  
  public Key delMin() {
    Key min = pq[1];
    exch(1, N--);
    sink(1);
    return min;
  }
  
  public void print() {
    for( int j = 1; j <= size(); j++) {
      System.out.print(" " +pq[j]);
    }
  }

  public static void main(String[] args) {
    MinPQ minPQ = new MinPQ(40);
    Random rnd = new Random();
    for( int i = 0; i < 10; i++) {
      minPQ.insert(rnd.nextInt(50));
    }
    minPQ.print();
    minPQ.delMin();
    System.out.println();
    minPQ.print();
   
  }
}
