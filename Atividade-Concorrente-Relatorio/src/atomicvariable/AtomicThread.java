package atomicvariable;
public class AtomicThread extends Thread {
  private int pos;
  private AtomicCounter counter;
  private int counterCalls;
  
  
  public AtomicThread(int pos, AtomicCounter counter, int counterCalls) {
    this.pos = pos;
    this.counter = counter;
    this.counterCalls = counterCalls;
  }
  
  public void run() {
    for (int i = 0; i < counterCalls; i++) {
      System.out.println(this.pos+";"+this.getId()+";"+counter.getNext());
      try {
        Thread.sleep(1);
      } catch (InterruptedException e) {}
    }
  }
  
  
}
