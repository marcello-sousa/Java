package Percolation;

public class WeightedQuickUnionUF {
  private int[] pai;
  private int[] sz;
  private int count;
  
  public WeightedQuickUnionUF( int n) {
    count = n;
    pai = new int[n];
    sz = new int[n];
    for( int i = 0; i < n; i++) {
      pai[i] = i;
      sz[i] = 1;
    }
  }
    
  public int count() {
    return count;
  }
  
  public boolean connect(int p, int q) {
    return find(p) == find(q);
  }
  
  public int find(int p) {
    while( p != pai[p]) {
      pai[p] = pai[pai[p]];
      p = pai[p];
    }
    return p;
  }
  
  public void union( int p, int q) {
    int pRoot = find(p);
    int qRoot = find(q);
    
    if( pRoot == qRoot) return;
    
    if( sz[pRoot] < sz[qRoot]) {
      pai[pRoot] = pai[qRoot];
      sz[qRoot] += sz[pRoot];
    }
    
    else {
      pai[qRoot] = pai[pRoot];
      sz[pRoot] += sz[qRoot];
    }
    count--;
  }
}
