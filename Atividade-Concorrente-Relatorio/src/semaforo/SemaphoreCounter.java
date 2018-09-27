package semaforo;

import java.util.concurrent.Semaphore;

public class SemaphoreCounter {
  private int value;
  private final Semaphore available = new Semaphore(1,true);

  
  public SemaphoreCounter(int n) {
    value = n;
  }
  
  public int getNext() throws InterruptedException {
    available.acquire();
    return value++;
  }
  
  public void releaseCounter() {
    available.release();

  }

}
