package Fifo;

import java.util.Iterator;
import java.util.Random;

public class Fifo {

  public static void main(String[] args) {
    Random gerador = new Random();
    FifoRand<Integer> test = null;
    test = new FifoRand<Integer>();
    for (int i = 1; i <= 10; i++) {
      test.enqueue(gerador.nextInt(26));
    }
    //   System.out.println(test.size());
    System.out.println("Sample = " + test.sample());
    System.out.println("Dequeue = " + test.dequeue());
    Iterator<Integer> it = test.iterator();
    while (it.hasNext()) {
      Integer valor = it.next();
      System.out.println("Valor " + valor);
    }
  }
}
