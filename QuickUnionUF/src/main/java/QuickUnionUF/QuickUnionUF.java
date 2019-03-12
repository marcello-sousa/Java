package QuickUnionUF;

import java.util.Scanner;

public class QuickUnionUF {
  private int[] pai;
  private int count;
  
  public QuickUnionUF( int n) {
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

  public static void main() {
    pilha = new StackOfString(30);
    Scanner scanner = new Scanner(System.in);
    while (scanner.nextLine() != null) {
      String str = scanner.nextLine();
      if (!str.equals("-")) 
        pilha.push(str);
      else if (!pilha.isEmpty()) 
        System.out.println(pilha.pop()+ " ");
    }
  }
}

  }
}
