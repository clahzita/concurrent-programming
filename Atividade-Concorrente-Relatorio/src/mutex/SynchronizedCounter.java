package mutex;

public class SynchronizedCounter {
  private int value;
  
  public SynchronizedCounter(int n) {
    value = n;
  }
  
  public synchronized int getNext() {
    return value++;
  }

}
