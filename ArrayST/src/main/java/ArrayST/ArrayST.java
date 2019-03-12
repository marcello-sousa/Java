package ArrayST;

public class ArrayST<Key, Value> {
  private static final int INIT_SIZE = 8;
  
  private Value[] vals;
  private Key[] keys;
  private int n = 0;
  
  public ArrayST() {
    keys = (Key[]) new Object[INIT_SIZE];
    vals = (Value[]) new Object[INIT_SIZE];
  }
  
  public int size() {
    return n;
  }
  
  public boolean isEmpty() {
    return size() == 0;
  }
  
  private void resize( int capacity) {
    Key[] tempk = (Key[]) new Object[INIT_SIZE];
    Value[] tempv = (Value[]) new Object[INIT_SIZE];
    for( int i = 0; i < n; i++) 
      tempk[i] = keys[i];
    for( int i = 0; i < n; i++) 
      tempv[i] = vals[i];
    keys = tempk;
    vals = tempv;
  }
  
  public void put( Key key, Value val) {
 //   delete(key);
    if( n >= vals.length) resize(2*n);
    vals[n] = val;
    keys[n] = key;
    n++;
  }
  
  public Iterable<Key> keys() {
   Stack<Key> queue = new Stack<Key>();
  }
  
 

  public static void main(String[] args) {
   
  }
}
