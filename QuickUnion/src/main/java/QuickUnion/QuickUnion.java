package QuickUnion;

import java.util.Scanner;

public class QuickUnion {
  private int[] pai;
  private int count;
  
  public QuickUnion( int n) {
    count = n;
    pai = new int[n];
    for (int i = 0; i < n; i++) {
      pai[i] = i;
    }
  } 
  public int count() {
    return count;
  }
    
  public boolean connect(int p, int q) {
    return find(p) == find(q);
  }
  
  public int find( int p) {
    while( p != pai[p]) p = pai[p];
    return p;
  }
  
  public void union( int p, int q) {
    int pRoot = find(p);
    int qRoot = find(q);
    
    if (pRoot == qRoot) return;
    
    
    pai[pRoot] = pai[qRoot];
    count--;
  }
}
