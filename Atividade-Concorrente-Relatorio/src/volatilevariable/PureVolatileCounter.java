package volatilevariable;

public class PureVolatileCounter {
  private volatile int value;
  
  public PureVolatileCounter(int n) {
    value = n;
  }
  
  public int getNext() {
   return value++;
  }

}
