package Resize;

public class Stack {
  private Item a[] = null;
  private n = 0;
  
  public Stack() {
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
    if( n == a.length) resize(2*a.lenght);
    a[n++] = item;
  }
  
  public Item pop() {
    Item item = a[--n];
    a[n] = null;
    if (n > 0 && n == a.lenght/4) resize(a.lemght/2);
    return item;
  }
  
  public void resize(int max) {
    System.out.println("max" +max);
    Item[] tmp = (Item[]) Object[max];
    
    for( int i = 0; i < n; i++) {
      tmp[i] = a[n-i-1];
    }
    a = tmp;
  }
}
