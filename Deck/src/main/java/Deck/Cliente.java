package Deck;

import java.util.Deque;
import java.util.Iterator;

public class Cliente {

  public static void main(String[] args) {
    Dequeueue<Integer> valor = null;
    valor = new Dequeueue<Integer>();
    valor.addLast(5);
    valor.addLast(3);
    valor.addLast(2);
    valor.addFirst(1);
    valor.addFirst(7);
    valor.addFirst(9);
       
//    valor.removeLast();
    valor.removeLast();
    valor.removeFirst();
    System.out.println(valor.size());
    Iterator <Integer> iterator = valor.iterator();
    while(iterator.hasNext()) {
      Integer v = iterator.next();
      System.out.println("Item: " +v);
    } 
    
   
  }
}
