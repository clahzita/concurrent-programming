package atomicreference;
public class AtomicReferenceThread extends Thread {
  private int pos;
  private AtomicReferenceCounter counter;
  private int counterCalls;
  
  
  public AtomicReferenceThread(int pos, AtomicReferenceCounter counter, int counterCalls) {
    this.pos = pos;
    this.counter = counter;
    this.counterCalls = counterCalls;
  }
  
  public void run() {
    for (int i = 0; i < counterCalls; i++) {
      counter.incrementCounter();
      System.out.println(this.pos+";"+this.getId()+";"+counter.getValue());
      try {
        Thread.sleep(1);
      } catch (InterruptedException e) {}
    }
  }
  
  
}
