package purevolatilevariable;

public class VolatileCounter {
  private volatile int value;
  
  public VolatileCounter(int n) {
    value = n;
  }
  
  public int getNext() {
    int temp = 0;

    synchronized( this ) {
    temp = value;
    }
    temp++;
    synchronized( this ) {
      value = temp;
    }
    return value;
  }

}
