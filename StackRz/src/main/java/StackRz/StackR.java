package StackRz;

public class StackR<Item> {
  
  private Item a[] = null;
  private int n = 0;
  
  public StackR() {
    a = (Item[]) new Object[1];
    n = 0;
  }
  
  public boolean isEmpty() {
    return n == 0;
  }
  
  public int size() {
    return n;
  }
  
  public void push(Item item) {
    if( n == a.length) resize(2*a.length);
    a[n++] = item;
  }
  
  public Item pop() {
    Item item = a[--n];
    a[n] = null;
    if (n > 0 && n == a.length/4) resize(a.length/2);
    return item;
  }
  
  public void resize(int max) {   
    Item[] tmp = (Item[]) new Object[max];
    for( int i = 0; i < n; i++) {
      tmp[i] = a[n-i-1];
    }
    a = tmp;
  }


}
