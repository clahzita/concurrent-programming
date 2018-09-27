package atomicreference;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceCounter {

  private static class Counter {
    final int value;

    public Counter(int value) {
      this.value = value;
    }
  }
  private final AtomicReference<Counter> stats =  new AtomicReference<Counter>(new Counter(0));
  
  public int getValue() { return stats.get().value; }
 
  public void incrementCounter() {
    Counter prev, newValue; 
    do { prev = stats.get(); 
         int nValue = prev.value + 1; 
         newValue = new Counter(nValue); 
    } while (!stats.compareAndSet(prev, newValue)); 

  }

}
