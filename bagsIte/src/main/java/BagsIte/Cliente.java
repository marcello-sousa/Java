package BagsIte;

import java.util.Iterator;
import java.util.Random;

public class Cliente {

  public static void main(String[] args) {
    Bag<Integer> bag = null;
    Random gerador = new Random();
    bag = new Bag<Integer>();
    for (int i = 0; i < 10; i++) {
      bag.add(gerador.nextInt(100));
    }
    System.out.println(bag.size());
    Iterator<Integer> it = bag.iterator();
    while(it.hasNext()) {
      Integer valor = it.next();
      System.out.println("Item " +valor);
    }
    Bag<String> bagS = new Bag<String>();
    bagS.add("Testando");
    bagS.add("numeros");
    bagS.add("aleatorios");
    System.out.println(bagS.size());
    for(String s: bagS) {
      System.out.println(s+ " ");
    }
    
  }
}
