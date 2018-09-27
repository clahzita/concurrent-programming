package atomic;
import java.util.concurrent.atomic.AtomicInteger;

public class Contador {
  
  private AtomicInteger count = new AtomicInteger(0);
  
  public void incrementCounter() {
    
    count.incrementAndGet();

  }

  public int getCount() {
    return count.get();
  }
  
  public void zerarContador() {
    count.set(0);
  }
}
