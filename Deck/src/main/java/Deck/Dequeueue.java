package Deck;

import java.util.Iterator;

public class Dequeueue<Item> implements Iterable<Item> {
  private Node first;
  private Node last;
  private int n;
  
  private class Node {
    private Item item;
    private Node next;
    private Node prev;
  }
  
  public Dequeueue() {
    first = new Node();
    last  = new Node();
    first.next = last;
    last.prev = first;
  }
 
  
  public int size() {
    return n;
  }
  
  public void addFirst(Item item) {
    Node oldfirst = first;
    first = new Node();
    first.item = item;
    first.next = oldfirst;
    oldfirst.prev = first;
    if(n == 0) last = first;
    n++;
  }
  
  public void addLast(Item item) {
    if (n == 0) addFirst(item);
    else {
      Node newlast = new Node();
      newlast.item = item;
      last.next = newlast;  
      newlast.prev = last;
      last = newlast;   
      n++;
    }
  } 
  
  public Item removeFirst() {
    Item item = first.item;
    first = first.next;
    n--;
    return item;
  }
  
  public Item removeLast() {
    Item item = last.item;
    last = last.prev;
    n--;
    return item;
  }
    
  public Iterator<Item> iterator() {
    return new DequeIterator();
  }
  
  private class DequeIterator implements Iterator<Item> {
    private Node current = first;
    
    public boolean hasNext() {
      return current != last.next;
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

