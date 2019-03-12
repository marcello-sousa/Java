package StackArray;

import java.util.Scanner;

public class Cliente {

  public static void main(String[] args) {
    StackOfString pilha;
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
