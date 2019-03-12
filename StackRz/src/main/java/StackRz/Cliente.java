package StackRz;

public class Cliente {

  public static void main(String[] args) {
    StackR pilha = null;
    pilha = new StackR<String>();
    pilha.push("oi");
    pilha.push("mundo");
    pilha.push("doido");
    pilha.push("louco");
    pilha.push("maluco");
    pilha.pop();
    pilha.pop();
    pilha.pop();
    StackR<Integer> pilhaI = null;
    pilhaI = new StackR<Integer>();
    pilhaI.push(10);
    pilhaI.push(20);
    pilhaI.push(30);
    System.out.println(pilhaI.size());
    System.out.println(pilhaI.pop());
  }
}
