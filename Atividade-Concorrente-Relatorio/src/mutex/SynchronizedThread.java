package mutex;

public class SynchronizedThread extends Thread {
  private int pos;
  private SynchronizedCounter counter;
  private int counterCalls;
  
  
  public SynchronizedThread(int pos, SynchronizedCounter counter, int counterCalls) {
    this.pos = pos;
    this.counter = counter;
    this.counterCalls = counterCalls;
  }
  
  public void run() {
    for (int i = 0; i < counterCalls; i++) {
      System.out.println(this.pos+";"+this.getId()+";"+counter.getNext());
      try {
        
        Thread.sleep(100);
      } catch (InterruptedException e) {}
    }
  }
  
  
}
