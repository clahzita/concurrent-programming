package atomicvariable;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
  private AtomicInteger value = new AtomicInteger(0);
  
  public synchronized int getNext() {
    return value.incrementAndGet();
  }
}
