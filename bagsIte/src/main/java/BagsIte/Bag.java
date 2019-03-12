package BagsIte;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {
  private Node first;
  private int n;
  private Node current;
  
  private class Node {
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
  
  //Metodo interador
  
  public Iterator<Item> iterator() {
    return new BagIterator();
  }
  
  // Classe que implementa interador
  
  private class BagIterator implements Iterator<Item> {
    private Node current = first;
    
   public boolean hasNext() {
     return current != null;
   }
   
   public Item next() {
     Item item = current.item;
     current = current.next;
     return item;
   }
   
   public void remove (){
     throw new UnsupportedOperationException();
   }
  }  
}
