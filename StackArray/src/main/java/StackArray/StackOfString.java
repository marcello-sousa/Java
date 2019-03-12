package StackArray;

public class StackOfString {
  private String[] a = null;
  private int n;
  
  public StackOfString( int cap) {
    a = new String[cap];
  }
  
  public boolean isEmpty() {
    return n == 0;
  }
  
  public int size() {
    return n;
  }
  
  void push( String item) {
    a[n++] = item;
  }
  
  public String pop() {
    return a[--n];
  }
  
}
