package QuickUnion;

import java.util.Scanner;

public class Cliente {
  public static void main(String[] args) {
    int p = 0, q = 0;
    QuickUnion uf = new QuickUnion(3);
    Scanner l = new Scanner(System.in);
    while(p != -1) {
      p  = l.nextInt();
      q  = l.nextInt();
      uf.union(p, q);
      System.out.println(p+ " " +q);
    }
    System.out.println("Testando saida");
  }
}
