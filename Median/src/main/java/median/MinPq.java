package median;

public class MinPq <Key extends Comparable <Key>> {
  private Key[] pq;
  private int N = 0;
  
  public MinPq( int maxN) {
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
  
  public Key min() {
    return pq[1];
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
    for( int i = 1; i <= size(); i++) {
      System.out.print(" " +pq[i]);
    }
    System.out.println();
  }
}
