package LinkListST;

import java.util.Queue;


public class LinkListST<Key, Value> {
  private Node first;
  private int n;
  
  public class Node {
    private Value vals;
    private Key key;
    private Node next;
    
    public Node( Key key, Value vals, Node next) {
      this.key = key;
      this.vals = vals;
      this.next = next;
    }
  }
  
  public LinkListST() { }
  
  public int size() {
    return n;
  }
  
  public boolean isEmpty() {
    return size() == 0;
  }
  
  public Value get(Key key) {
    if( key == null) throw new IllegalArgumentException("Key is null");
    for( Node x = first; x != null; x = x.next) {
      if( key.equals(x.key)) return x.vals;
    }
    return null;
  }
  
  public void put( Key key, Value vals) {
    if( key == null) throw new IllegalArgumentException("Key is null");
    if( vals == null) {
      delete (key);
      return;
    }
    
    for( Node x = first; x != null; x = x.next) 
      if(key.equals(x.key)) {
        x.vals = vals;
        return;
      }
    first = new Node(key, vals, first);
  }
  
  public void delete( Key key) {
    if( key == null) throw new IllegalArgumentException("Key is null");
    first = delete (first, key); 
  }
  
  private Node delete( Node x, Key key) {
    if( x == null) return null;
    if( key.equals(x.key)) {
      n--;
      return x.next;
    }
    
    x.next = delete( x.next, key);
    return x;
  }
  
  public Iterable<Key> keys() {
    Queue<Key> queue = new Queue<Key>();
  }

  public static void main(String[] args) {
   
  }
}
