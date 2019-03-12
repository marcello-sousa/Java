package Deck;

import java.util.Iterator;

public class Deque<Item> implements Iterable<Item>{
  private Node first;
  private Node current;
  private Node last;
  private int n;
  
  private class Node {
    private Item item;
    private Node next;
  }
  
  public Deque() {
    first = null;
    last  = null;
  }
  
  public boolean hasNext() {
    return current != last;
  }
  
  public int size() {
    return n;
  }
  
  public void addFirst(Item item) {
    Node oldfirst = first;
    first = new Node();
    first.item = item;
    first.next = oldfirst;
    n++;
  }
  
  public void addLast(Item item) {
    newLast = new Node();
    newLast.item = item;
    last.next = newLast;
    last = newLast;
    n++;
  }
  
}