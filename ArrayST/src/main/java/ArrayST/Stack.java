package ArrayST;

public class Stack<Item> {
  private int n = 0;
  private Item[] a = null;
  
  public Stack( int cap) {
    a = (Item[]) new Object[cap];
  }
  
  public boolean isEmpty() {
    return n == 0;
  }
  
  public int size() {
    return n;
  }
  
  public void push (Item item) {
    a[n++] = item;
  }
  
  public Item pop() {
    return a[--n];
  }
}

