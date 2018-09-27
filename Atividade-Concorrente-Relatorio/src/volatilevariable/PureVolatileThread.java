package volatilevariable;
public class PureVolatileThread extends Thread {
  private int pos;
  private PureVolatileCounter counter;
  private int counterCalls;
  
  
  public PureVolatileThread(int pos, PureVolatileCounter counter, int counterCalls) {
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
