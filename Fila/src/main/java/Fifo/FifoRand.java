package Fifo;

import java.util.Iterator;
import java.util.Random;

public class FifoRand<Item> implements Iterable<Item>{
  private Node first;
  private Node last;
  private int n;
  private Node actual;
  private Node prev;
  
  private class Node {
    private Item item;
    private Node next;
  }
  
  public FifoRand() {
    first = null;
  }
  
  public int size() {
    return n;
  }
  
  public boolean isEmpty() {
    return n == 0;
  }
  
  public void enqueue(Item item) {
    Node oldlast = last;
    last = new Node();
    last.item = item;  
    if (isEmpty()) first = last;
    else oldlast.next = last;
    n++;
  }
  
  public Item dequeue() {
    Random gerador = new Random();
    int rand = gerador.nextInt(n), i = 0;
    prev = null;
    actual = first;
    while (i != rand) {
      prev = actual;
      actual = actual.next;
      i++;
    } 
    Item item = actual.item;
    prev.next = actual.next;
    n--;
    return item; 
  }
  
  public Item sample() {
    Random gerador = new Random();
    int rand = gerador.nextInt(n), i = 0;
    actual = first;
    while (i != rand) {
      actual = actual.next;
      i++;
    } 
    Item item = actual.item;
    return item; 
  }
  
  public Iterator<Item> iterator() {
    return new FifoIterator();
  }
  
  private class FifoIterator implements Iterator<Item> {
    private Node current = first;
    
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
  }
}
