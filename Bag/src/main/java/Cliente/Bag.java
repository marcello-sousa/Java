

import java.util.Iterator;

public class Bag<Item> {
  private Node first;
  private int n;
  private Node current;
  
  public class Node {
    private Item item;
    private Node next;
  }
  
  public Bag() {
    first = null;
  }
  
  public void add(Item item) {
    Node oldfirst = first;
    first = new Node();
    first.item = item;
    first.next = oldfirst;
    n++;
  }
  
  public int size() {
    return n;
  }
  
  public boolean isEmpty() {
    return n == 0;
  }
  
  public void startIterator() {
    current = first;
  }
  
  public boolean hasNext() {
    return current != null;
  }
  
  public Item next() {
    Item item = current.item;
    current = current.next;
    return item;
    
  }
  
  public void remove() {
    throw new UnsupportedOperationException();
  }
  
  public static void main(String[] args) {
    Bag<Integer> bag = null;
    bag = new Bag<Integer>();
    for (int i = 10; i < 20; i++) {
      bag.add(i);
    }
    System.out.println(bag.size());
    bag.startIterator();
    while (bag.hasNext()) {
      Integer valor = bag.next();
      System.out.println("Item " + valor);
    }
    Bag<String> bagS = new Bag<String>();
    bagS.add("Como");
    bagS.add("eh");
    bagS.add("bom");
    bagS.add("estudar");
    bagS.add("mac0323");
    System.out.println(bagS.size());
    //   for(String s: bagS) {
    //     System.out.println(s+ " ");
    //   }
    bagS.startIterator();
    while (bagS.hasNext()) {
      String valor = bagS.next();
      System.out.println("Item " + valor);
    }

    System.out.println();
  }
}
